#include<iostream>
#include<map>
#include <ctime>
#include <windows.h>
using namespace std;

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
    cout << "\n\n\t\t\t\t Decompressed File Complete. Thank You for Using Our Program \n\n\n\n\n\n\n\n\n  ";

}
class FileDecompression {
private:
    FILE *file;
    string inputFilePath;
    string outputFilePath;
    map<string, char> decodeMap;
    int uniqueCharsCount;

    string toBinary(int num) {
        string binStr = "";
        for (int i = 7; i >= 0; i--) {
            if (num >> i & 1) binStr += '1';
            else binStr += '0';
        }
        return binStr;
    }

public:
    FileDecompression(string input, string output)
        : inputFilePath(input), outputFilePath(output), uniqueCharsCount(0) {}

    bool openFile() {
        file = fopen(inputFilePath.c_str(), "rb");
        if (file == NULL) {
            cout << "Error opening input file\n";
            return false;
        }
        return true;
    }

    void closeFile() {
        fclose(file);
    }

    bool decompressFile() {
        char buffer[1];

        fread(buffer, 1, 1, file);
        int fileSize = buffer[0] - '0';
        while (fileSize--) {
            fread(buffer, 1, 1, file);
        }

        FILE *outputFile = fopen(outputFilePath.c_str(), "wt");
        if (outputFile == NULL) {
            cout << "Error creating output file\n";
            return false;
        }

        string currentStr = "";
        int flag = 0;

        while (fread(buffer, 1, 1, file)) {
            if (buffer[0] != '\0') {
                flag = 0;
                currentStr += buffer[0];
            }
            else {
                uniqueCharsCount++;
                flag++;
                if (flag == 2) break;
                decodeMap[currentStr.substr(1, currentStr.length() - 1)] = currentStr[0];
                currentStr = "";
            }
        }

        fread(buffer, 1, 1, file);
        int padding = buffer[0] - '0';
        fread(buffer, 1, 1, file);
        fread(buffer, 1, 1, file);

        int decimal;
        string binStr = "";
        while (fread(buffer, 1, 1, file)) {
            decimal = buffer[0];
            binStr = binStr + toBinary(decimal);
        }

        int startIndex;
        if (padding == 0) {
            binStr = "0" + binStr;
            startIndex = 1;
        }
        else startIndex = padding;
        for (int i = 1; binStr[startIndex] != '\0'; i++) {
            if (decodeMap.find(binStr.substr(startIndex, i)) != decodeMap.end()) {
                fwrite(&(decodeMap[binStr.substr(startIndex, i)]), 1, 1, outputFile);
                startIndex = startIndex + i;
                i = 0;
            }
        }
        loading();
        delay(0);
        fclose(outputFile);
        return true;
    }
};

int main() {
    string inputFilePath = "D:\\Downloads\\testingcompressed.bin";
    string outputFilePath = "D:\\Downloads\\testingdecompressed.txt";

    FileDecompression decompressor(inputFilePath, outputFilePath);

    if (decompressor.openFile()) {
        decompressor.decompressFile();
        decompressor.closeFile();
    }

    return 0;
}
