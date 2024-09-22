#include <iostream>
#include <fstream>
#include <cstring>
#include <cmath>
#include <ctime>
#include <windows.h>
#define MAX_CHAR 256

using namespace std;

char codes[MAX_CHAR][256];

struct Node {
    char Character;
    int Freq;
    struct Node *Left, *Right;
};

typedef struct Node *NodeData;

void delay(unsigned int secs) {
    clock_t interval = clock() + secs * CLOCKS_PER_SEC;
    while (interval > clock());
}

void loading() {
    system("cls");
    system("Color E");
    cout << "\n\n\n\n";
    cout << "\n\n\n\n\n\tTime flies when you are having fun... Please wait\n\n";
    for (int i = 1; i <= 120; i++) {
        Sleep(10);
        cout << static_cast<char>(219);
    }
    cout << "\n\n\t\t\t\t Compressed File Complete. Thank You for Using Our Program \n\n\n\n\n\n\n\n\n  ";

}

class FileCompression {
private:
    NodeData createLeaf(char c, int f) {
        NodeData temp = new Node;
        temp->Character = c;
        temp->Freq = f;
        temp->Left = NULL;
        temp->Right = NULL;
        return temp;
    }

    NodeData createNode(int f) {
        NodeData temp = new Node;
        temp->Character = 0;
        temp->Freq = f;
        temp->Left = NULL;
        temp->Right = NULL;
        return temp;
    }

    void adjustDown(NodeData *nodes, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && nodes[left]->Freq < nodes[smallest]->Freq)
            smallest = left;

        if (right < n && nodes[right]->Freq < nodes[smallest]->Freq)
            smallest = right;

        if (smallest != i) {
            NodeData temp = nodes[i];
            nodes[i] = nodes[smallest];
            nodes[smallest] = temp;

            adjustDown(nodes, n, smallest);
        }
    }

    void buildStruct(NodeData *structArray, int n) {
        for (int i = n / 2 - 1; i >= 0; i--)
            adjustDown(structArray, n, i);
    }

    NodeData removeLow(NodeData *structArray, int &n) {
        NodeData minNode = structArray[0];
        structArray[0] = structArray[n - 1];
        n--;
        adjustDown(structArray, n, 0);
        return minNode;
    }

    void insertNode(NodeData *structArray, int &n, NodeData newNode) {
        n++;
        int i = n - 1;
        structArray[i] = newNode;

        while (i > 0 && structArray[(i - 1) / 2]->Freq > structArray[i]->Freq) {
            NodeData temp = structArray[i];
            structArray[i] = structArray[(i - 1) / 2];
            structArray[(i - 1) / 2] = temp;

            i = (i - 1) / 2;
        }
    }

    void buildTree(NodeData *structArray, int &n) {
        while (n > 1) {
            NodeData leftChild = removeLow(structArray, n);
            NodeData rightChild = removeLow(structArray, n);

            int freqSum = leftChild->Freq + rightChild->Freq;
            NodeData internalNode = createNode(freqSum);
            internalNode->Left = leftChild;
            internalNode->Right = rightChild;

            insertNode(structArray, n, internalNode);
        }
    }

    void assignCharCodes(NodeData root, string str) {
        if (!root->Left && !root->Right) {
            strcpy(codes[root->Character], str.c_str());
        } else {
            assignCharCodes(root->Left, str + "0");
            assignCharCodes(root->Right, str + "1");
        }
    }

    void writeCodesToFile(ofstream &outputFile) {
        for (int i = 0; i < MAX_CHAR; i++) {
            if (codes[i][0] != '\0') {
                outputFile.put(i);
                outputFile.write(codes[i], strlen(codes[i]));
                outputFile.put('\0');
            }
        }
    }

public:
    void compressFile(char *inputFilePath, char *outputFilePath) {
        ifstream inputFile(inputFilePath, ios::binary);
        ofstream outputFile(outputFilePath, ios::binary);

        string fileContents = "";
        int numOfUniqueChars = 0;

        string fileType = "txt";
        char num = fileType.length() + '0';
        outputFile.put(num);
        outputFile.write(fileType.c_str(), fileType.length());

        int Freq[MAX_CHAR] = {0};
        char ch;

        while (inputFile.get(ch)) {
            if (!Freq[ch])
                numOfUniqueChars++;
            Freq[ch]++;
        }
        inputFile.clear();
        inputFile.seekg(0, ios::beg);

        NodeData *structArray = new NodeData[numOfUniqueChars];
        int structSize = 0;

        for (int i = 0; i < MAX_CHAR; i++) {
            if (Freq[i]) {
                structArray[structSize] = createLeaf(i, Freq[i]);
                structSize++;
            }
        }

        buildStruct(structArray, structSize);
        buildTree(structArray, structSize);
        assignCharCodes(structArray[0], "");

        writeCodesToFile(outputFile);

        while (inputFile.get(ch)) {
            if (ch != '\n') {
                fileContents += codes[ch];
            }
        }

        int padding = 0;
        if (fileContents.length() % 8 != 0)
            padding = 8 - (fileContents.length() % 8);
        for (int i = 0; i < padding; i++) {
            fileContents = "0" + fileContents;
        }

        char null = '\0';
        char pad = padding + '0';
        outputFile.put(null);
        outputFile.put(pad);
        outputFile.put(null);
        outputFile.put(null);

        char tmpBin[9];
        int decimal, w;
        for (size_t j = 0; j < fileContents.length(); j += 8) {
            strncpy(tmpBin, &fileContents[j], 8);
            decimal = 0;
            int i = 7;
            while (i > -1) {
                w = tmpBin[i] == '1' ? 1 : 0;
                decimal += ((int)pow(2, 7 - i)) * w;
                i--;
            }
            outputFile.put(decimal);
        }

        loading();
        delay(0);
        delete[] structArray;
        inputFile.close();
        outputFile.close();
    }
};

int main() {
    char inputFilePath[] = "D:\\Downloads\\testingcode.txt";
    char outputFilePath[] = "D:\\Downloads\\testingcompressed.bin";

    FileCompression huffman;
    huffman.compressFile(inputFilePath, outputFilePath);

    return 0;
}
