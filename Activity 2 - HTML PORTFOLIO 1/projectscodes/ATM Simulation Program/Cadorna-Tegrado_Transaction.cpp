#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>
#include <iomanip>
#include <conio.h>
#include <windows.h>
#include <stdio.h>


using namespace std;

#define MAX 100
#define MAX_TRANSACTIONS 100


typedef struct {
    string description;
    double amount;
} Transaction;


struct TransactionList {
    Transaction transactions[MAX_TRANSACTIONS];
    int count = 0;
};


typedef struct {
    int accountNumber[MAX];
    string name[MAX];
    string birthday[MAX];
    string phoneNumber[MAX];
    double balance[MAX];
    int pin[MAX];
    int count = 0;
    TransactionList transactionHistory[MAX];
} Account;

class ATM {
private:
    Account accounts;
    int currentAccountIndex = -1;
    string localDataFile;
    string usbPINFile;


    void Makenull(TransactionList& list) {
        list.count = 0;
    }

    void Enqueue(TransactionList& list, const Transaction& transaction) {
        if (list.count < MAX_TRANSACTIONS) {
            list.transactions[list.count] = transaction;
            list.count++;
        }
    }

    void Dequeue(TransactionList& list) {
        if (list.count > 0) {
            for (int i = 0; i < list.count - 1; i++) {
                list.transactions[i] = list.transactions[i + 1];
            }
            list.count--;
        }
    }

    void Display(const TransactionList& list) {
        for (int i = 0; i < list.count; i++) {
            // Display each transaction
            cout << "Description: " << list.transactions[i].description << ", Amount: " << list.transactions[i].amount << " pesos" << endl;
        }
    }

    bool IsFull(const TransactionList& list) {
        return list.count >= MAX_TRANSACTIONS;
    }

    bool IsEmpty(const TransactionList& list) {
        return list.count == 0;
    }

    Transaction Front(const TransactionList& list) {
        return list.transactions[0];
    }

    Transaction Rear(const TransactionList& list) {
        return list.transactions[list.count - 1];
    }

    void addTransaction(int accountIndex, const string& description, double amount) {
        Transaction& transaction = accounts.transactionHistory[accountIndex].transactions[accounts.transactionHistory[accountIndex].count];
        transaction.description = description;
        transaction.amount = amount;
        accounts.transactionHistory[accountIndex].count++;
    }

     bool loadAccountDataFromFile() {
        ifstream accountFile(localDataFile);

        if (accountFile.is_open()) {
            string line;
            int i = 0;
            while (getline(accountFile, line)) {
                if (line.find("Account Number: ") != string::npos) {
                    accounts.accountNumber[i] = stoi(line.substr(16));
                    if (getline(accountFile, line) && line.find("Name: ") != string::npos) {
                        accounts.name[i] = line.substr(6);
                    }
                    if (getline(accountFile, line) && line.find("Birthday: ") != string::npos) {
                        accounts.birthday[i] = line.substr(10);
                    }
                    if (getline(accountFile, line) && line.find("Phone Number: ") != string::npos) {
                        accounts.phoneNumber[i] = line.substr(14);
                    }
                    if (getline(accountFile, line) && line.find("Balance: ") != string::npos) {
                        accounts.balance[i] = stod(line.substr(9));
                    }
                    if (getline(accountFile, line) && line.find("PIN: ") != string::npos) {
                        accounts.pin[i] = stoi(line.substr(5));
                    }
                    accounts.count++;
                    i++;
                }
            }
            accountFile.close();
            return true;
        } else {
            cout << "Account data file not found." << endl;
            return false;
        }
    }

    bool loadLatestUserPINFromUSB() {
        ifstream usbPINFile("E:\\pin.code.txt");

        if (usbPINFile.is_open()) {
            int usbAccountNumber = -1;
            int usbPIN = -1;
            string line;

            while (getline(usbPINFile, line)) {
                if (line.find("Account Number: ") != string::npos) {
                    usbAccountNumber = stoi(line.substr(16));
                } else if (line.find("PIN: ") != string::npos) {
                    usbPIN = stoi(line.substr(5));
                }
            }

            if (usbAccountNumber != -1 && usbPIN != -1) {
                for (int i = 0; i < accounts.count; i++) {
                    if (accounts.accountNumber[i] == usbAccountNumber && accounts.pin[i] == usbPIN) {
                        currentAccountIndex = i;
                        return true;
                    }
                }
            }

            cout << "Invalid PIN from USB. Exiting." << endl;
            return false;
        } else {
            cout << "USB PIN file not found. Exiting." << endl;
            return false;
        }
    }

    void updatePinInAccountData() {
        ofstream accountFile(localDataFile);

        if (accountFile.is_open()) {
            for (int i = 0; i < accounts.count; i++) {
                accountFile << "Account Number: " << accounts.accountNumber[i] << endl;
                accountFile << "Name: " << accounts.name[i] << endl;
                accountFile << "Birthday: " << accounts.birthday[i] << endl;
                accountFile << "Phone Number: " << accounts.phoneNumber[i] << endl;
                accountFile << "Balance: " << std::fixed << std::setprecision(2) << accounts.balance[i] << " pesos" << endl;
                accountFile << "PIN: " << accounts.pin[i] << endl;
                accountFile << "============================" << endl;
            }
            accountFile.close();

            if (currentAccountIndex != -1) {
                ofstream usbPINFile("E:\\pin.code.txt");
                if (usbPINFile.is_open()) {
                    usbPINFile << "Account Number: " << accounts.accountNumber[currentAccountIndex] << endl;
                    usbPINFile << "PIN: " << accounts.pin[currentAccountIndex] << endl;
                    usbPINFile.close();
                } else {
                    cout << "Error updating USB PIN file." << endl;
                }
            } else {
                cout << "Current account not found. Cannot update USB PIN file." << endl;
            }
        } else {
            cout << "Error updating account data file." << endl;
        }
    }

    void handleSubMenu() {
                string newPhoneNumber;
                int subChoice = 0;
                bool exitFlagSubMenu = false;

                while (!exitFlagSubMenu) {
                    subMenu(subChoice);

                    char userInput = ' ';
                    while (true) {
                        char keyPressed = _getch();
                        if (keyPressed == '\r') {  // Enter key
                            break;
                        } else if (isdigit(keyPressed)) {
                            userInput = keyPressed;
                            subChoice = userInput - '0';
                            subMenu(subChoice);
                        }
                    }

            switch (subChoice) {
                case 1:
                        if (currentAccountIndex != -1) {
                        double balance = accounts.balance[currentAccountIndex];


                        std::stringstream balanceStream;
                        balanceStream << std::fixed << std::setprecision(2) << balance;
                        std::string balanceString = balanceStream.str();
                    displayCenteredText("-------------------------------------------------------------", 11);
                    displayCenteredText("|                                                           |", 12);
                    displayCenteredText("|             A c c o u n t   S t a t e m e n t             |", 13);
                    displayCenteredText("|                                                           |", 14);
                    displayCenteredText("-------------------------------------------------------------", 15);

                    displayCenteredText("-------------------------------------------------------------", 16);
                    displayCenteredText("Account Number: " + to_string(accounts.accountNumber[currentAccountIndex]), 17);
                    displayCenteredText("Name: " + accounts.name[currentAccountIndex], 18);
                    displayCenteredText("Birthday: " + accounts.birthday[currentAccountIndex], 19);
                    displayCenteredText("Phone Number: " + accounts.phoneNumber[currentAccountIndex], 20);
                    displayCenteredText("Balance: " + balanceString + " pesos", 21);

                    displayCenteredText("-------------------------------------------------------------", 22);

                    displayCenteredText("-------------------------------------------------------------", 23);
                    displayCenteredText("|                                                           |", 24);
                    displayCenteredText("|                                                           |", 25);
                    displayCenteredText("|                                                           |", 26);
                    displayCenteredText("-------------------------------------------------------------", 27);
                    gotoxy(25, 25);
                    system("pause");
                    system("cls");

                        }

                    break;

                case 2:

                    while (true) {
                            displayCenteredText("-------------------------------------------------------------", 11);
                            displayCenteredText("|                                                           |", 12);
                            displayCenteredText("|                                                           |", 13);
                            displayCenteredText("|                                                           |", 14);
                            displayCenteredText("-------------------------------------------------------------", 15);
                            displayCenteredText("-------------------------------------------------------------", 16);
                            displayCenteredText("|                                                           |", 17);
                            displayCenteredText("|         C H A N G E    P H O N E    N U M B E R           |", 18);
                            displayCenteredText("|                                                           |", 19);
                            displayCenteredText("-------------------------------------------------------------\n", 20);
                            gotoxy(20, 13);
                        cout << "Enter your new phone number: ";
                        cin >> newPhoneNumber;

                        if (newPhoneNumber.length() == 11 && all_of(newPhoneNumber.begin(), newPhoneNumber.end(), ::isdigit)) {
                            accounts.phoneNumber[currentAccountIndex] = newPhoneNumber;
                            updatePinInAccountData();
                            displayCenteredText("-------------------------------------------------------------", 11);
                            displayCenteredText("|                                                           |", 12);
                            displayCenteredText("|                                                           |", 13);
                            displayCenteredText("|                                                           |", 14);
                            displayCenteredText("-------------------------------------------------------------", 15);
                            gotoxy(20, 13);
                            cout << "Phone number changed successfully." << endl;
                            gotoxy(50, 30);
                            system("pause");
                            system("cls");
                            break;
                        } else {
                            displayCenteredText("-------------------------------------------------------------", 11);
                            displayCenteredText("|                                                           |", 12);
                            displayCenteredText("|                                                           |", 13);
                            displayCenteredText("|                                                           |", 14);
                            displayCenteredText("-------------------------------------------------------------", 15);
                            gotoxy(20, 13);
                            cout << "Invalid 11 Digits Only For Phone Number" << endl;
                            gotoxy(50, 25);
                            system("pause");

                        }
                    }
                    break;

                case 3:


                    if (currentAccountIndex != -1) {
                            displayCenteredText("-------------------------------------------------------------", 11);
                            displayCenteredText("|                                                           |", 12);
                            displayCenteredText("|                                                           |", 13);
                            displayCenteredText("|                                                           |", 14);
                            displayCenteredText("|                                                           |", 15);
                            displayCenteredText("|                                                           |", 16);
                            displayCenteredText("-------------------------------------------------------------", 17);
                            gotoxy(20, 13);


                        cout << "Transaction History:" << endl;
                        if (!IsEmpty(accounts.transactionHistory[currentAccountIndex])) {
                            for (int i = 0; i < accounts.transactionHistory[currentAccountIndex].count; i++) {
                                const Transaction& transaction = accounts.transactionHistory[currentAccountIndex].transactions[i];
                                std::ostringstream stream;
                                stream << "Description: " << transaction.description << ", Amount: " << std::fixed << std::setprecision(2) << transaction.amount << "pesos";
                                std::string transactionLine = stream.str();
                                displayCenteredText(transactionLine, i + 13);
                            }
                            displayCenteredText("-------------------------------------------------------------", 18);
                            displayCenteredText("|                                                           |", 19);
                            displayCenteredText("|         T R A N S A C T I O N   H I S T O R Y             |", 20);
                            displayCenteredText("|                                                           |", 21);
                            displayCenteredText("-------------------------------------------------------------\n", 22);
                            gotoxy(50, 25);


                        } else {
                            displayCenteredText("-------------------------------------------------------------", 11);
                            displayCenteredText("|                                                           |", 12);
                            displayCenteredText("|                                                           |", 13);
                            displayCenteredText("|                                                           |", 14);
                            displayCenteredText("|                                                           |", 15);
                            displayCenteredText("|                                                           |", 16);
                            displayCenteredText("-------------------------------------------------------------", 17);
                            gotoxy(25, 13);
                            cout << "No transaction history to display." << endl;
                        }
                        gotoxy(50, 25);
                        system("pause");
                        system("cls");

                    } else {
                        cout << "Current account not found." << endl;
                        system("pause");
                        system("cls");
                    }
                    break;



                case 4:

                    if (currentAccountIndex != -1) {
                        if (!IsEmpty(accounts.transactionHistory[currentAccountIndex])) {
                            Makenull(accounts.transactionHistory[currentAccountIndex]);
                            updatePinInAccountData();
                            displayCenteredText("-------------------------------------------------------------", 11);
                            displayCenteredText("|                                                           |", 12);
                            displayCenteredText("|                                                           |", 13);
                            displayCenteredText("|                                                           |", 14);
                            displayCenteredText("-------------------------------------------------------------", 15);
                            displayCenteredText("-------------------------------------------------------------", 16);
                            displayCenteredText("|                                                           |", 17);
                            displayCenteredText("|   D E L E T E   T R A N S A C T I O N   H I S T O R Y     |", 18);
                            displayCenteredText("|                                                           |", 19);
                            displayCenteredText("-------------------------------------------------------------\n", 20);
                            gotoxy(13, 13);
                            cout << "Transaction history deleted successfully." << endl;
                            gotoxy(50, 25);
                            system("pause");
                            system("cls");
                        } else {
                            displayCenteredText("-------------------------------------------------------------", 11);
                            displayCenteredText("|                                                           |", 12);
                            displayCenteredText("|                                                           |", 13);
                            displayCenteredText("|                                                           |", 14);
                            displayCenteredText("-------------------------------------------------------------", 15);
                            gotoxy(25, 13);
                            cout << "Transaction history is already empty." << endl;
                            gotoxy(50, 25);
                            system("pause");
                            system("cls");
                        }
                    } else {
                        cout << "Current account not found." << endl;
                        system("pause");
                        system("cls");
                    }
                    break;

                case 5:

                    if (currentAccountIndex != -1) {
                            displayCenteredText("-------------------------------------------------------------", 11);
                            displayCenteredText("|                                                           |", 12);
                            displayCenteredText("|                                                           |", 13);
                            displayCenteredText("|                                                           |", 14);
                            displayCenteredText("-------------------------------------------------------------", 15);
                            displayCenteredText("-------------------------------------------------------------", 16);
                            displayCenteredText("|                                                           |", 17);
                            displayCenteredText("|                C L O S E    A C C O U N T                 |", 18);
                            displayCenteredText("|                                                           |", 19);
                            displayCenteredText("-------------------------------------------------------------\n", 20);
                            gotoxy(15, 13);
                        cout << "Are you sure you want to close your account? (Y/N): ";
                        string confirmation;
                        cin >> confirmation;
                        if (confirmation == "Y" || confirmation == "y" || confirmation == "yes" || confirmation == "Yes") {



                            accounts.count--;


                            updatePinInAccountData();
                            displayCenteredText("-------------------------------------------------------------", 11);
                            displayCenteredText("|                                                           |", 12);
                            displayCenteredText("|                                                           |", 13);
                            displayCenteredText("|                                                           |", 14);
                            displayCenteredText("-------------------------------------------------------------", 15);
                            gotoxy(15, 13);
                            cout << "Account closed successfully." << endl;
                            currentAccountIndex = -1;


                            ofstream pinCodeFile("E:\\pin.code.txt", ofstream::trunc);
                            if (pinCodeFile.is_open()) {
                                pinCodeFile.close();
                            displayCenteredText("-------------------------------------------------------------", 11);
                            displayCenteredText("|                                                           |", 12);
                            displayCenteredText("|                                                           |", 13);
                            displayCenteredText("|                                                           |", 14);
                            displayCenteredText("-------------------------------------------------------------", 15);
                            gotoxy(10, 13);
                                cout << "The 'pin.code' file content has been removed." << endl;
                            } else {
                                gotoxy(10, 13);
                                cout << "Error removing 'pin.code' file content." << endl;
                            }


                            exit(0);
                        } else if (confirmation == "N" || confirmation == "n" || confirmation == "no" || confirmation == "No") {
                            displayCenteredText("-------------------------------------------------------------", 11);
                            displayCenteredText("|                                                           |", 12);
                            displayCenteredText("|                                                           |", 13);
                            displayCenteredText("|                                                           |", 14);
                            displayCenteredText("-------------------------------------------------------------", 15);
                            gotoxy(27, 13);
                            cout << "Account closure canceled." << endl;
                            gotoxy(50, 25);
                            system("pause");
                            system("cls");
                        } else {
                            displayCenteredText("-------------------------------------------------------------", 11);
                            displayCenteredText("|                                                           |", 12);
                            displayCenteredText("|                                                           |", 13);
                            displayCenteredText("|                                                           |", 14);
                            displayCenteredText("-------------------------------------------------------------", 15);
                            gotoxy(15, 13);
                            cout << "Invalid input. Please enter 'Y' or 'N' Only" << endl;
                            gotoxy(50, 25);
                            system("pause");
                            system("cls");
                        }
                    } else {
                        cout << "Current account not found." << endl;
                    }
                    system("pause");
                    system("cls");
                    break;

                case 6:
                    exitFlagSubMenu = true;
                    system("cls");
                    break;



                default:
                    displayCenteredText("-------------------------------------------------------------", 11);
                    displayCenteredText("|                                                           |", 12);
                    displayCenteredText("|                                                           |", 13);
                    displayCenteredText("|                                                           |", 14);
                    displayCenteredText("-------------------------------------------------------------", 15);
                    gotoxy(10, 13);
                    cout << "Invalid choice. Please enter a valid option." << endl;
                    gotoxy(50, 25);
                    system("pause");
                    system("cls");
                    break;
            }
        }
    }

public:
    ATM(const string& localDataFilePath, const string& usbPINFilePath) : localDataFile(localDataFilePath), usbPINFile(usbPINFilePath) {

        for (int i = 0; i < MAX; i++) {
            Makenull(accounts.transactionHistory[i]);
        }
    }


void gotoxy(int x, int y) {
            COORD coord;
            coord.X = x;
            coord.Y = y;
            SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
        }

    void displayCenteredText(const std::string& text, int row) {
    int width = 80;  // Adjust the width as needed
    int textLength = text.length();
    int x = (width - textLength) / 2;

    gotoxy(x, row);
    std::cout << text;
}

void subMenu(int subChoice){

    gotoxy(22, 0);
    cout <<           " O T H E R   T R A N S A C T I O N" << endl;
    cout << " ---------------------------------------------------------------------------" << endl;
    cout << "|                       |                                                  |" << endl;
    cout << "|                       | 1. View Account Statement      5. Close Account  |" << endl;
    cout << "|                       |                                                  |" << endl;
    cout << "|  Option: [" << subChoice << "]          | 2. Change Phone Number    6. Return To Main Menu |" << endl;
    cout << "|                       |                                                  |" << endl;
    cout << "|                       | 3. View Transaction History                      |" << endl;
    cout << "|                       |                                                  |" << endl;
    cout << "|                       | 4. Delete Transaction History                    |" << endl;
    cout << " ---------------------------------------------------------------------------" << endl;
}

void displayMenu(int choice) {

    gotoxy(30, 0);
    cout <<                               "T R A N S A C T I O N" << endl;
    cout << " ---------------------------------------------------------------------------" << endl;
    cout << "|                       |                                                  |" << endl;
    cout << "|                       | 1. Balance Inquiry        5. Change PIN Code     |" << endl;
    cout << "|                       |                                                  |" << endl;
    cout << "|  Option: [" << choice << "]          | 2. Withdraw               6. Other Transactions  |" << endl;
    cout << "|                       |                                                  |" << endl;
    cout << "|                       | 3. Deposit                7. Exit                |" << endl;
    cout << "|                       |                                                  |" << endl;
    cout << "|                       | 4. Fund Transfer                                 |" << endl;
    cout << " ---------------------------------------------------------------------------" << endl;
}

        void run() {
            int choice = 0;
        if (loadAccountDataFromFile() && loadLatestUserPINFromUSB()) {
            while (true) {
            displayMenu(choice);
            char userInput = ' ';
            while (true) {
                char keyPressed = _getch();
                if (keyPressed == '\r') {
                    break;
                } else if (isdigit(keyPressed)) {
                    userInput = keyPressed;
                    choice = userInput - '0';
                    displayMenu(choice);
                }
            }

                switch (choice) {
                    case 1:
                        if (currentAccountIndex != -1) {

                            double balance = accounts.balance[currentAccountIndex];
                            std::stringstream balanceStream;
                            balanceStream << std::fixed << std::setprecision(2) << balance;
                            std::string balanceString = balanceStream.str();

                            displayCenteredText("-------------------------------------------------------------", 11);
                            displayCenteredText("|                                                           |", 12);
                            displayCenteredText("       |                    Amount: " +balanceString+  " pesos                  |        ", 13);
                            displayCenteredText("|                                                           |", 14);
                            displayCenteredText("-------------------------------------------------------------", 15);

                            displayCenteredText("-------------------------------------------------------------", 16);
                            displayCenteredText("|                                                           |", 17);
                            displayCenteredText("|             B A L A N C E       I N Q U I R Y             |", 18);
                            displayCenteredText("|                                                           |", 19);
                            displayCenteredText("-------------------------------------------------------------\n", 20);

                            system("pause");
                            system("cls");
                        } else {
                            cout << "Current account not found." << endl;
                            system("pause");
                            system("cls");
                        }
                        break;

                  case 2:
                            displayCenteredText("-------------------------------------------------------------", 11);
                            displayCenteredText("|                                                           |", 12);
                            displayCenteredText("|                                                           |", 13);
                            displayCenteredText("|                                                           |", 14);
                            displayCenteredText("-------------------------------------------------------------", 15);

                            displayCenteredText("-------------------------------------------------------------", 16);
                            displayCenteredText("|                                                           |", 17);
                            displayCenteredText("|      E N T E R   A M O U N T   T O   W I T H D R A W      |", 18);
                            displayCenteredText("|                                                           |", 19);
                            displayCenteredText("-------------------------------------------------------------", 20);

                            double amount;
                            gotoxy(25, 13);
                            cout << "Enter the withdrawal amount: ";
                            while (!(cin >> amount) || amount < 0 || cin.peek() != '\n') {
                                displayCenteredText("-------------------------------------------------------------", 11);
                                displayCenteredText("|                                                           |", 12);
                                displayCenteredText("|                                                           |", 13);
                                displayCenteredText("|                                                           |", 14);
                                displayCenteredText("-------------------------------------------------------------", 15);

                                gotoxy(18, 13);
                                cout << "Invalid input. Please Enter For Withdrawal: ";
                                cin.clear();
                                cin.ignore(numeric_limits<streamsize>::max(), '\n');
                            }

                            if (currentAccountIndex != -1) {
                                if (amount <= accounts.balance[currentAccountIndex]) {
                                    accounts.balance[currentAccountIndex] -= amount;

                                    addTransaction(currentAccountIndex, "Withdraw", amount);
                                    updatePinInAccountData();
                                    displayCenteredText("-------------------------------------------------------------", 11);
                                    displayCenteredText("|                                                           |", 12);
                                    displayCenteredText("|                                                           |", 13);
                                    displayCenteredText("|                                                           |", 14);
                                    displayCenteredText("-------------------------------------------------------------", 15);
                                    gotoxy(15, 13);
                                    cout << "Withdrawal successful. New balance: " << std::fixed << std::setprecision(2) << accounts.balance[currentAccountIndex] << " pesos" << endl;
                                    gotoxy(50, 25);
                                    system("pause");
                                    system("cls");
                                } else {
                                    displayCenteredText("-------------------------------------------------------------", 11);
                                    displayCenteredText("|                                                           |", 12);
                                    displayCenteredText("|                                                           |", 13);
                                    displayCenteredText("|                                                           |", 14);
                                    displayCenteredText("-------------------------------------------------------------", 15);
                                    gotoxy(22, 13);
                                    cout << "Insufficient balance for withdrawal." << endl;
                                    gotoxy(50, 25);
                                    system("pause");
                                    system("cls");
                                }
                            } else {
                                cout << "Current account not found." << endl;
                                system("pause");
                                system("cls");
                            }
                            break;



                    case 3:
                            displayCenteredText("-------------------------------------------------------------", 11);
                            displayCenteredText("|                                                           |", 12);
                            displayCenteredText("|                                                           |", 13);
                            displayCenteredText("|                                                           |", 14);
                            displayCenteredText("-------------------------------------------------------------", 15);

                            displayCenteredText("-------------------------------------------------------------", 16);
                            displayCenteredText("|                                                           |", 17);
                            displayCenteredText("|      E N T E R   A M O U N T   T O   D E P O S I T        |", 18);
                            displayCenteredText("|                                                           |", 19);
                            displayCenteredText("-------------------------------------------------------------", 20);

                            double depositAmount;
                            gotoxy(25, 13);
                            cout << "Enter the deposit amount: ";
                            while (!(cin >> depositAmount) || depositAmount < 0 || cin.peek() != '\n') {
                                displayCenteredText("-------------------------------------------------------------", 11);
                                displayCenteredText("|                                                           |", 12);
                                displayCenteredText("|                                                           |", 13);
                                displayCenteredText("|                                                           |", 14);
                                displayCenteredText("-------------------------------------------------------------", 15);
                                gotoxy(18, 13);
                                cout << "Invalid input. Please Enter For Deposit: ";
                                cin.clear();
                                cin.ignore(numeric_limits<streamsize>::max(), '\n');
                            }

                            if (currentAccountIndex != -1) {
                                accounts.balance[currentAccountIndex] += depositAmount;
                                addTransaction(currentAccountIndex, "Deposit", depositAmount);
                                displayCenteredText("-------------------------------------------------------------", 11);
                                displayCenteredText("|                                                           |", 12);
                                displayCenteredText("|                                                           |", 13);
                                displayCenteredText("|                                                           |", 14);
                                displayCenteredText("-------------------------------------------------------------", 15);
                                updatePinInAccountData();
                                gotoxy(15, 13);
                                cout << "Deposit successful. New balance: " << std::fixed << std::setprecision(2) << accounts.balance[currentAccountIndex] << " pesos" << endl;
                                gotoxy(50, 25);
                                system("pause");
                                system("cls");
                            } else {
                                cout << "Current account not found." << endl;
                                system("pause");
                                system("cls");
                            }
                            break;

                    case 4:
                            displayCenteredText("-------------------------------------------------------------", 11);
                            displayCenteredText("|                                                           |", 12);
                            displayCenteredText("|                                                           |", 13);
                            displayCenteredText("|                                                           |", 14);
                            displayCenteredText("-------------------------------------------------------------", 15);

                            displayCenteredText("-------------------------------------------------------------", 16);
                            displayCenteredText("|                                                           |", 17);
                            displayCenteredText("|                F U N D   T R A N S F E R                  |", 18);
                            displayCenteredText("|                                                           |", 19);
                            displayCenteredText("-------------------------------------------------------------", 20);

                            if (currentAccountIndex != -1) {
                                if (accounts.count < 2) {
                                    gotoxy(20, 13);
                                    cout << "At least two accounts are required for fund transfer." << endl;
                                    system("pause");
                                    system("cls");
                                    break;
                                }

                                int recipientAccountNumber;
                                displayCenteredText("-------------------------------------------------------------", 11);
                                displayCenteredText("|                                                           |", 12);
                                displayCenteredText("|                                                           |", 13);
                                displayCenteredText("|                                                           |", 14);
                                displayCenteredText("-------------------------------------------------------------", 15);
                                gotoxy(20, 13);
                                cout << "Enter the recipient's account number: ";
                                while (!(cin >> recipientAccountNumber) || cin.peek() != '\n') {
                                    displayCenteredText("-------------------------------------------------------------", 11);
                                    displayCenteredText("|                                                           |", 12);
                                    displayCenteredText("|                                                           |", 13);
                                    displayCenteredText("|                                                           |", 14);
                                    displayCenteredText("-------------------------------------------------------------", 15);
                                    gotoxy(15, 13);
                                    cout << "Invalid. Valid Recipient's Account Number Only: ";
                                    cin.clear();
                                    cin.ignore(numeric_limits<streamsize>::max(), '\n');
                                }

                                int recipientIndex = -1;
                                for (int i = 0; i < accounts.count; i++) {
                                    if (accounts.accountNumber[i] == recipientAccountNumber) {
                                        recipientIndex = i;
                                        break;
                                    }
                                }

                                if (recipientIndex == -1) {
                                    displayCenteredText("-------------------------------------------------------------", 11);
                                    displayCenteredText("|                                                           |", 12);
                                    displayCenteredText("|                                                           |", 13);
                                    displayCenteredText("|                                                           |", 14);
                                    displayCenteredText("-------------------------------------------------------------", 15);
                                    gotoxy(25, 13);
                                    cout << "Recipient's account not found." << endl;
                                    gotoxy(50, 25);
                                    system("pause");
                                    system("cls");
                                    break;
                                }

                                if (currentAccountIndex == recipientIndex) {
                                    displayCenteredText("-------------------------------------------------------------", 11);
                                    displayCenteredText("|                                                           |", 12);
                                    displayCenteredText("|                                                           |", 13);
                                    displayCenteredText("|                                                           |", 14);
                                    displayCenteredText("-------------------------------------------------------------", 15);
                                    gotoxy(20, 13);
                                    cout << "Cannot transfer funds to the same account." << endl;
                                    gotoxy(50, 25);
                                    system("pause");
                                    system("cls");
                                    break;
                                }
                                double transferAmount;
                                displayCenteredText("-------------------------------------------------------------", 11);
                                displayCenteredText("|                                                           |", 12);
                                displayCenteredText("|                                                           |", 13);
                                displayCenteredText("|                                                           |", 14);
                                displayCenteredText("-------------------------------------------------------------", 15);
                                gotoxy(25, 13);
                                cout << "Enter the transfer amount: ";
                                    while (!(cin >> transferAmount) || transferAmount < 0 || cin.peek() != '\n') {
                                    gotoxy(15, 13);
                                    cout << "Invalid. Numeric Value For Fund Transfer Only: ";
                                    cin.clear();
                                    cin.ignore(numeric_limits<streamsize>::max(), '\n');
                                }

                                if (transferAmount <= accounts.balance[currentAccountIndex]) {
                                    accounts.balance[currentAccountIndex] -= transferAmount;
                                    accounts.balance[recipientIndex] += transferAmount;

                                    addTransaction(currentAccountIndex, "Transfer to Account " + to_string(recipientAccountNumber), transferAmount);
                                    addTransaction(recipientIndex, "Transfer from Account " + to_string(accounts.accountNumber[currentAccountIndex]), transferAmount);

                                    updatePinInAccountData();
                                    displayCenteredText("-------------------------------------------------------------", 11);
                                    displayCenteredText("|                                                           |", 12);
                                    displayCenteredText("|                                                           |", 13);
                                    displayCenteredText("|                                                           |", 14);
                                    displayCenteredText("-------------------------------------------------------------", 15);
                                    gotoxy(15, 13);
                                    cout << "Fund transfer successful. New balance: " << std::fixed << std::setprecision(2) << accounts.balance[currentAccountIndex] << " pesos" << endl;
                                    gotoxy(50, 25);
                                    system("pause");
                                    system("cls");
                                } else {
                                    displayCenteredText("-------------------------------------------------------------", 11);
                                    displayCenteredText("|                                                           |", 12);
                                    displayCenteredText("|                                                           |", 13);
                                    displayCenteredText("|                                                           |", 14);
                                    displayCenteredText("-------------------------------------------------------------", 15);
                                    gotoxy(20, 13);
                                    cout << "Insufficient balance for fund transfer." << endl;
                                    gotoxy(50, 25);
                                    system("pause");
                                    system("cls");
                                }
                            } else {
                                cout << "Current account not found." << endl;
                                system("pause");
                                system("cls");
                            }
                            break;



                    case 5:

                        if (currentAccountIndex != -1) {
                            int newPIN;
                            int confirmPIN;
                            int currentPIN;

                            char c;
                            string currentPINStr, newPINStr, confirmPINStr;
                            displayCenteredText("-------------------------------------------------------------", 11);
                            displayCenteredText("|                                                           |", 12);
                            displayCenteredText("|                                                           |", 13);
                            displayCenteredText("|                                                           |", 14);
                            displayCenteredText("-------------------------------------------------------------", 15);

                            displayCenteredText("-------------------------------------------------------------", 16);
                            displayCenteredText("|                                                           |", 17);
                            displayCenteredText("|                C H A N G E        P I N                   |", 18);
                            displayCenteredText("|                                                           |", 19);
                            displayCenteredText("-------------------------------------------------------------", 20);
                            gotoxy(20, 13);
                            cout << "Enter your current PIN (4 to 6 digits): ";

                            currentPINStr = "";
                            while (true) {
                                c = _getch();
                                if (c == 13) {
                                    if (currentPINStr.length() >= 4 && currentPINStr.length() <= 6) {
                                        break;
                                    }
                                } else if (c == 8) {
                                    if (!currentPINStr.empty()) {
                                        cout << "\b \b";
                                        currentPINStr.pop_back();
                                    }
                                } else if (isdigit(c) && currentPINStr.length() < 6) {
                                    currentPINStr += c;
                                    cout << "*";
                                }
                        }
                        cout << endl;

                        currentPIN = stoi(currentPINStr);


                        displayCenteredText("-------------------------------------------------------------", 11);
                        displayCenteredText("|                                                           |", 12);
                        displayCenteredText("|                                                           |", 13);
                        displayCenteredText("|                                                           |", 14);
                        displayCenteredText("-------------------------------------------------------------", 15);
                        gotoxy(20, 13);
                        cout << "Enter new PIN (4 to 6 digits): ";
                        newPINStr = "";
                        while (true) {
                            c = _getch();
                            if (c == 13) {
                                if (newPINStr.length() >= 4 && newPINStr.length() <= 6) {
                                    break;
                                }
                            } else if (c == 8) {
                                if (!newPINStr.empty()) {
                                    cout << "\b \b";
                                    newPINStr.pop_back();
                                }
                            } else if (isdigit(c) && newPINStr.length() < 6) {
                                newPINStr += c;
                                cout << "*";
                            }
                        }
                        cout << endl;
                        displayCenteredText("-------------------------------------------------------------", 11);
                        displayCenteredText("|                                                           |", 12);
                        displayCenteredText("|                                                           |", 13);
                        displayCenteredText("|                                                           |", 14);
                        displayCenteredText("-------------------------------------------------------------", 15);
                        gotoxy(30, 13);
                        cout << "Confirm new PIN: ";
                        confirmPINStr = "";
                        while (true) {
                            c = _getch();
                            if (c == 13) {
                                if (confirmPINStr.length() >= 4 && confirmPINStr.length() <= 6) {
                                    break;
                                }
                            } else if (c == 8) {
                                if (!confirmPINStr.empty()) {
                                    cout << "\b \b";
                                    confirmPINStr.pop_back();
                                }
                            } else if (isdigit(c) && confirmPINStr.length() < 6) {
                                confirmPINStr += c;
                                cout << "*";
                            }
                        }
                        cout << endl;

                        newPIN = stoi(newPINStr);
                        confirmPIN = stoi(confirmPINStr);


                        if (currentPIN == accounts.pin[currentAccountIndex]) {

                            if (confirmPIN == newPIN) {

                                accounts.pin[currentAccountIndex] = newPIN;


                                updatePinInAccountData();
                                displayCenteredText("-------------------------------------------------------------", 11);
                            displayCenteredText("|                                                           |", 12);
                            displayCenteredText("|                                                           |", 13);
                            displayCenteredText("|                                                           |", 14);
                            displayCenteredText("-------------------------------------------------------------", 15);
                                gotoxy(25, 13);
                                cout << "PIN changed successfully." << endl;
                                gotoxy(50, 25);
                                system("pause");
                                system("cls");
                            } else {
                                displayCenteredText("-------------------------------------------------------------", 11);
                            displayCenteredText("|                                                           |", 12);
                            displayCenteredText("|                                                           |", 13);
                            displayCenteredText("|                                                           |", 14);
                            displayCenteredText("-------------------------------------------------------------", 15);
                                gotoxy(20, 13);
                                cout << "PINs do not match. PIN change failed." << endl;
                                gotoxy(50, 25);
                                system("pause");
                                system("cls");
                            }
                        } else {
                        displayCenteredText("-------------------------------------------------------------", 11);
                        displayCenteredText("|                                                           |", 12);
                        displayCenteredText("|                                                           |", 13);
                        displayCenteredText("|                                                           |", 14);
                        displayCenteredText("-------------------------------------------------------------", 15);

                            gotoxy(20, 13);
                            cout << "Incorrect current PIN. PIN change failed." << endl;
                            gotoxy(50, 25);
                            system("pause");
                            system("cls");
                        }
                    } else {

                        cout << "Current account not found." << endl;
                    }
                        break;

                    case 6:

                        handleSubMenu();
                        break;

                    case 7:

                        displayCenteredText("-------------------------------------------------------------", 11);
                        displayCenteredText("|                                                           |", 12);
                        displayCenteredText("|                                                           |", 13);
                        displayCenteredText("|                                                           |", 14);
                        displayCenteredText("-------------------------------------------------------------", 15);
                        gotoxy(20, 13);
                        cout << "Thank you for using this ATM. Goodbye!" << endl;
                        gotoxy(50, 25);
                        exit(0);
                        break;

                    default:
                        displayCenteredText("-------------------------------------------------------------", 11);
                        displayCenteredText("|                                                           |", 12);
                        displayCenteredText("|                                                           |", 13);
                        displayCenteredText("|                                                           |", 14);
                        displayCenteredText("-------------------------------------------------------------", 15);
                        gotoxy(20, 13);
                        cout << "Invalid choice. Please enter a valid option." << endl;
                        gotoxy(50, 25);
                        system("pause");
                        system("cls");
                        break;
                }
            }
        }
    }
};


void clearInputBuffer() {
    std::cin.clear();
    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
}


void gotoxy(int x, int y) {
            COORD coord;
            coord.X = x;
            coord.Y = y;
            SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
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


void createLoadingScreen() {
    setTextColor(COLOR_GREEN, COLOR_WHITE);
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
    std::cout << "PProcessing Transaction....";
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

    string localDataFile = "D:\\Downloads\\account_data.txt";
    string usbPINFilePath = "E:\\pin.code.txt";

    ATM atm(localDataFile, usbPINFilePath);
    createLoadingScreen();
    cout << "\n\n\t\t";
    system("pause");
    system("cls");
    atm.run();

    return 0;
}

