#include <iostream>
#include <fstream>
#include <string>
#include <ctime>
#include <limits>
#include <iomanip>
#include <algorithm>
#include <cstring>
#include <conio.h>
#include <windows.h>
#include <stdio.h>
#include <thread>
#include <chrono>

using namespace std;

typedef struct {
    int accountNumber;
    string name;
    string birthday;
    string phoneNumber;
    double balance;
    int pin;
} Account;


class List {
private:
    Account* accounts;
    int accountCount;
    int capacity;

public:
    List() {
        capacity = 10;
        accounts = new Account[capacity];
        accountCount = 0;
    }

    ~List() {
        delete[] accounts;
    }

    void addAccount(const Account& newAccount) {
        if (accountCount < capacity) {
            accounts[accountCount] = newAccount;
            accountCount++;
        } else {
            int newCapacity = capacity * 2;
            Account* newAccounts = new Account[newCapacity];

            for (int i = 0; i < capacity; i++) {
                newAccounts[i] = accounts[i];
            }

            delete[] accounts;
            accounts = newAccounts;
            capacity = newCapacity;

            accounts[accountCount] = newAccount;
            accountCount++;
        }
    }

    int getAccountCount() const {
        return accountCount;
    }

    const Account& getAccount(int index) const {
        if (index >= 0 && index < accountCount) {
            return accounts[index];
        }
        throw out_of_range("Invalid account index");
    }

    int findAccount(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].accountNumber == accountNumber) {
                return i;
            }
        }
        return -1;
    }

    void modifyAccount(int accountNumber, const Account& modifiedAccount) {
        int index = findAccount(accountNumber);
        if (index != -1) {
            accounts[index] = modifiedAccount;
        } else {
            cout << "Account not found." << endl;
        }
    }

    void printAccountList() {
        for (int i = 0; i < accountCount; i++) {
            cout << "Account Number: " << accounts[i].accountNumber << endl;
            cout << "Name: " << accounts[i].name << endl;
            cout << "Birthday: " << accounts[i].birthday << endl;
            cout << "Phone Number: " << accounts[i].phoneNumber << endl;
            cout << fixed << setprecision(2) << "Balance: " << accounts[i].balance << " pesos" << endl;
            cout << "PIN: " << accounts[i].pin << endl;
            cout << "============================" << endl;
        }
    }
};

//files in program (account_data) magagamit lang sa specific device, (pin.code) sa usb lang magagamit
const string accountDataPath = "D:\\Downloads\\account_data.txt";
const string usbPINFilePath = "E:\\pin.code.txt";

void loadAccountDataFromFile(List& accountList) {
    ifstream accountFile(accountDataPath);
    if (accountFile.is_open()) {
        string line;
        while (getline(accountFile, line)) {
            if (line.find("Account Number: ") != string::npos) {
                int accountNumber = stoi(line.substr(16));
                if (accountNumber > 0) {
                    string name, birthday, phoneNumber;
                    double balance;
                    int pin;
                    if (getline(accountFile, line) && line.find("Name: ") != string::npos) {
                        name = line.substr(6);
                    }
                    if (getline(accountFile, line) && line.find("Birthday: ") != string::npos) {
                        birthday = line.substr(10);
                    }
                    if (getline(accountFile, line) && line.find("Phone Number: ") != string::npos) {
                        phoneNumber = line.substr(14);
                    }
                    if (getline(accountFile, line) && line.find("Balance: ") != string::npos) {
                        balance = stod(line.substr(9));
                    }
                    if (getline(accountFile, line) && line.find("PIN: ") != string::npos) {
                        pin = stoi(line.substr(5));
                    }
                    Account newAccount{ accountNumber, name, birthday, phoneNumber, balance, pin };
                    accountList.addAccount(newAccount);
                }
            }
        }
        accountFile.close();
    } else {
        cout << "Account data file not found. A new file will be created." << endl;
    }
}

void saveAccountDataToFile(const List& accountList) {
    ofstream accountFile(accountDataPath);
    if (accountFile.is_open()) {
        for (int i = 0; i < accountList.getAccountCount(); i++) {
            const Account& account = accountList.getAccount(i);
            accountFile << "Account Number: " << account.accountNumber << endl;
            accountFile << "Name: " << account.name << endl;
            accountFile << "Birthday: " << account.birthday << endl;
            accountFile << "Phone Number: " << account.phoneNumber << endl;
            accountFile << fixed << setprecision(2) << "Balance: " << account.balance << " pesos" << endl;
            accountFile << "PIN: " << account.pin << endl;
            accountFile << "============================" << endl;
        }
        accountFile.close();
    } else {
        cout << "Error: Unable to save account data to a file." << endl;
    }
}

bool isRegistered(const List& accountList, const string& name) {
    string lowercaseName = name;
    transform(lowercaseName.begin(), lowercaseName.end(), lowercaseName.begin(), ::tolower);

    for (int i = 0; i < accountList.getAccountCount(); i++) {
        string accountName = accountList.getAccount(i).name;
        transform(accountName.begin(), accountName.end(), accountName.begin(), ::tolower);

        if (accountName == lowercaseName) {
            return true;
        }
    }
    return false;
}

int generateAccountNumber(const List& accountList) {
    int accountNumber;
    bool accountNumberExists;

    do {
        accountNumberExists = false;
        accountNumber = rand() % 90000 + 10000;
        for (int i = 0; i < accountList.getAccountCount(); i++) {
            if (accountList.getAccount(i).accountNumber == accountNumber) {
                accountNumberExists = true;
                break;
            }
        }
    } while (accountNumberExists);

    return accountNumber;
}

int maskInput(bool showAsterisk, int minLength, int maxLength) {
    const char BACKSPACE = 8;
    const char RETURN = 13;

    string input = "";
    char ch = 0;

    while (true) {
        ch = _getch();
        if (ch == RETURN) {
            if (input.length() >= minLength && input.length() <= maxLength) {
                break;
            }
        } else if (ch == BACKSPACE) {
            if (input.length() > 0) {
                if (showAsterisk) {
                    cout << "\b \b";
                }
                input = input.substr(0, input.length() - 1);
            }
        } else if (isdigit(ch)) {
            if (input.length() < maxLength) {
                input += ch;
                if (showAsterisk) {
                    cout << '*';
                }
            }
        } else {
            cout << "Invalid input. Please enter digits only." << endl;
        }
    }
    cout << endl;

    return stoi(input);
}

//dapat numeric value ang input ni user
bool isNumeric(const string& str) {
    for (char ch : str) {
        if (!isdigit(ch)) {
            return false;
        }
    }
    return true;
}

//chinecheck kung meron numbers or symbols sa names
bool isNameValid(const string& name) {
    if (!isalpha(name[0])) {
        return false;
    }

    for (char ch : name) {
        if (!isalpha(ch)) {
            return false;
        }
    }

    return true;
}


void gotoxy(int x, int y) {
    COORD coord;
    coord.X = x;
    coord.Y = y;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}

void displayBox(int x, int y, int width, int height) {
    for (int i = 0; i < height; i++) {
        gotoxy(x, y + i);
        if (i == 0 || i == height - 1) {
            for (int j = 0; j < width; j++) {
                cout << "-";
            }
        } else {
            cout << "|";
            for (int j = 0; j < width - 2; j++) {
                cout << " ";
            }
            cout << "|";
        }
    }
}

void displayField(int x, int y, const string& fieldName) {
    displayBox(x, y, 60, 3);
    gotoxy(x + 2, y + 1);
    cout << " " << fieldName << " ";
    gotoxy(x + 2, y + 2);
    cout << "";
}

void clearField(int x, int y, int width, int height) {
    for (int i = 0; i < height; i++) {
        gotoxy(x, y + i);
        cout << string(width, ' ');
    }
}

const int COLOR_BLACK = 0;
const int COLOR_RED = 12;
const int COLOR_GREEN = 10;
const int COLOR_YELLOW = 14;
const int COLOR_WHITE = 15;
const int COLOR_BLUE = 9;
const int COLOR_DARK_GRAY = 8;
const int COLOR_LIGHT_GRAY = 7;

void setTextColor(int textColor, int backgroundColor) {
    SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), (textColor + (backgroundColor << 4)));
}

void registerAccount(List& accountList) {
    Account newAccount;
    string name;
    string birthday = "MM/DD/YYYY";
    string phoneNumber;
    string accountNumber;
    double balance = 0.00;
    bool validBirthdate = false;
    int pin = -1;
    int confirmPin = -1;

    while (true) {
        system("cls");
        displayField(10, 4, "Full Name:");

        gotoxy(24, 5);
        getline(cin, name);
        newAccount.name = name;

        while (name.empty()) {
            displayField(10, 4, "Full Name:");
            gotoxy(12, 5);
            cout << "\n\n\t\tName cannot be empty.";
            gotoxy(12, 6);
            cout << "\n\n\t\tEnter Full Name: ";
            getline(cin, name);
        }

        bool validName = true;
        for (char c : name) {
            if (!isalpha(c) && c != ' ') {
                validName = false;
                break;
            }
        }

        if (validName) {
            newAccount.name = name;
            if (isRegistered(accountList, name)) {
                setTextColor(COLOR_GREEN, COLOR_WHITE);
                cout << "\n\n\t\tYou are already registered." << endl;
                return;
            } else {
                break;
            }
        } else {
            displayField(10, 4, "Full Name:");
            gotoxy(12, 5);
            cout << "\n\n\t\tName should only contain letters (case-sensitive) and spaces. ";
            system("pause");
        }
    }

    string month = "MM";
    string day = "DD";
    string year = "YYYY";
    system("cls");
    while (!validBirthdate) {
        displayField(10, 4, "Enter Month of Birth (Numerical only): ");
        gotoxy(52, 5);
        getline(cin, month);

        if (month.empty() || !isNumeric(month)) {
            cout << "\n\n\t\tInvalid input. Please enter a numerical value for the month." << endl;
            continue;
        }

        int monthInt = stoi(month);
        if (monthInt < 1 || monthInt > 12) {
            cout << "\n\n\t\tInvalid input. Enter Month (Numerical only and between 1 and 12): ";
            continue;
        }

        system("cls");
        displayField(10, 4, "Enter Day (Numerical only): ");
        gotoxy(41, 5);
        getline(cin, day);

        if (day.empty() || !isNumeric(day)) {
            cout << "\n\n\t\tInvalid input. Please enter a numerical value for the day." << endl;
            continue;
        }

        int dayInt = stoi(day);
        if (dayInt < 1 || dayInt > 31) {
            cout << "\n\n\t\tInvalid input. Enter Day (Numerical only and between 1 and 31): ";
            continue;
        }

        system ("cls");
        displayField(10, 4, "Enter Year (Numerical only): ");
        gotoxy(42, 5);
        getline(cin, year);

        if (year.empty() || !isNumeric(year) || year.length() != 4 || stoi(year) < 1900 || stoi(year) > 2005) {
            cout << "\n\n\t\tInvalid input.";
            continue;
        }

        validBirthdate = true;
    }

    newAccount.birthday = month + "/" + day + "/" + year;

    displayField(10, 4, "Enter your phone number (11 digit): ");
    gotoxy(49, 5);
    cin >> phoneNumber;
    newAccount.phoneNumber = phoneNumber;

    while (cin.fail() || phoneNumber.length() != 11 || !isNumeric(phoneNumber)) {
        displayField(10, 16, "Phone No.:");
        gotoxy(12, 17);
        cout << "11-digit number only, e.g. 09xxxxxxxxx: ";
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cin >> phoneNumber;
    }

    newAccount.phoneNumber = phoneNumber;

system("cls");
displayField(10, 4, "Enter your initial deposit: ");
gotoxy(41, 5);

bool balanceValid = false;

while (!balanceValid) {
    if (cin >> newAccount.balance) {
        if (newAccount.balance >= 5000) {
            balanceValid = true;
        } else {
            cout << "\n\n\t\tInvalid input. The initial deposit must be at least 5000 pesos: ";
        }
    } else {
        cout << "Invalid input. Please enter a numeric value." << endl;
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }
}

cin.ignore(numeric_limits<streamsize>::max(), '\n');


    system("cls");
    displayField(10, 4,"Create your PIN (4-6 digits): ");
    gotoxy(43, 5);
    newAccount.pin = maskInput(true, 4, 6);

    while (newAccount.pin < 1000 || newAccount.pin > 999999) {
        displayField(10, 28, "Create pin:");
        gotoxy(12, 29);
        cout << "Invalid PIN. Please enter a valid PIN (4-6 digits): ";
        newAccount.pin = maskInput(true, 4, 6);
    }

    string pinString = to_string(newAccount.pin);
    int pinLength = pinString.length();

    displayField(10, 4, "Confirm your PIN: ");
    gotoxy(31, 5);
    confirmPin = maskInput(true, 4, 6);

    while (newAccount.pin != confirmPin) {
        system("pause");
        displayField(10, 34, "Confirm pin:");
        gotoxy(12, 35);
        cout << "PINs do not match. Please try again.";
        gotoxy(12, 36);
        cout << "Confirm your PIN: ";
        confirmPin = maskInput(true, 4, 6);
    }

    newAccount.pin = confirmPin;
    newAccount.accountNumber = generateAccountNumber(accountList);
    accountList.addAccount(newAccount);
    saveAccountDataToFile(accountList);

    ofstream pinCodeFile(usbPINFilePath);
    if (pinCodeFile.is_open()) {
        pinCodeFile << "Account Number: " << newAccount.accountNumber << endl;
        pinCodeFile << "PIN: " << newAccount.pin << endl;
        pinCodeFile.close();
    } else {
        cout << "Error: Unable to save PIN data to 'pin.code' file." << endl;
    }

    system("cls");

int textWidth = 48;
 setTextColor(COLOR_GREEN, COLOR_WHITE);
string pinMessage = "CONGRATULATIONS!";
int paddingPin = (textWidth - pinMessage.length()) / 2;
displayField(10, 2, string(paddingPin, ' ') + pinMessage);


}

void createLoadingScreen() {
    setTextColor(COLOR_YELLOW, COLOR_DARK_GRAY);
    system("cls");
    printf("\e[?251");

    SetConsoleCP(437);
    SetConsoleOutputCP(437);

    int barLength = 50;
    char bar1 = 177, bar2 = 219;
    int delay = 20;

    int screenWidth = 80;
    int screenHeight = 24;
    int centerY = (screenHeight - 3) / 2;
    gotoxy((screenWidth - 26) / 2, centerY);
    std::cout << "PProcessing REGISTRATION....";
    gotoxy((screenWidth - barLength) / 2, centerY + 1);

    for (int i = 0; i < barLength; i++) {
        std::cout << bar1;
    }

    for (int i = 0; i <= 100; i++) {
        gotoxy((screenWidth - barLength) / 2, centerY + 1);
        for (int j = 0; j < barLength; j++) {
            if (j <= (i * barLength / 100)) {
                std::cout << bar2;
            } else {
                std::cout << bar1;
            }
        }

        std::cout << " " << i << "%";
        Sleep(delay);

        if (i < 100) {
            gotoxy((screenWidth - barLength) / 2, centerY + 1);
            std::cout << "        ";
        }
    }
}

int main() {
    srand(static_cast<unsigned>(time(NULL )));

    ifstream usbPINFile(usbPINFilePath);

    if (usbPINFile.is_open()) {
        List accountList;
        loadAccountDataFromFile(accountList);
        createLoadingScreen();
        setTextColor(COLOR_GREEN, COLOR_BLACK);

        system("cls");
        int boxX = 10;
        int boxY = 5;
        int boxWidth = 60;
        int boxHeight = 8;

        gotoxy(boxX, boxY);
        for (int i = 0; i < boxWidth; i++) {
            std::cout << "=";
        }

        for (int i = 1; i < boxHeight - 1; i++) {
            gotoxy(boxX, boxY + i);
            if (i == 1) {
                std::cout << "|      =========      ==============    =====   =====      |";
            } else if (i == 2) {
                std::cout << "|     =         =           =           =  ==   ==  =      |";
            } else if (i == 3) {
                std::cout << "|     =         =           =           =    = =    =      |";
            } else if (i == 4) {
                std::cout << "|     ===========           =           =     =     =      |";
            } else if (i == 5) {
                std::cout << "|     =         =           =           =           =      |";
            } else if (i == 6) {
                std::cout << "|     =         =           =           =           =      |";
            } else {
                for (int j = 0; j < boxWidth; j++) {
                    std::cout << " ";
                }
            }
            gotoxy(boxX, boxY + i + 1);
        }

        gotoxy(boxX, boxY + boxHeight - 1);
        for (int i = 0; i < boxWidth; i++) {
            std::cout << "=";
        }
        cout << "\n\n\t\t";
        system("pause");
        setTextColor(COLOR_RED, COLOR_WHITE);
        registerAccount(accountList);
        setTextColor(COLOR_GREEN, COLOR_WHITE);
        cout << "\n\n\t\tPlease go to the transaction program, and use your ATM." << endl;
    } else {
        cout << "USB drive or required file not detected. Please insert the USB drive with the necessary file." << endl;
    }

    return 0;
}
