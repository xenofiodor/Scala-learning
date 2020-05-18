# Password Generator
Simple generator of random passwords for given logins.

## Tech used
The whole project is written in Scala.

## How does it work
The program reads logins from given file and for each of them generates a random password using allowed characters, which are: \[-A-Za-z.\_]

  
The program also counts the length of the longest login to write all new passwords from the same position of line (for better formating) and writes these passwords to a file.

## How to use it
- Firstly compile [main.scala](https://github.com/xenofiodor/PasswordGenerator/blob/master/main.scala) and [PasswordGen.scala](https://github.com/xenofiodor/PasswordGenerator/blob/master/PasswordGen.scala) files:  
`scalac main.scala PasswordGen.scala`
- Then run the program with 3 arguments:  
  1. the name of the **file with logins**  
  2. the name of the **file with passwords** (where new passwords will written to)  
  3. the **length of passwords**
  
If the second file doesn't exist the new file will be created. The file containing logins must exist, so if the first file doesn't exist the program informs about exception.  
  
Example of using:  
`scala Appl logins.txt passwords.txt 25`  
  
Result of execution of this program using file [logins.txt](https://github.com/xenofiodor/PasswordGenerator/blob/master/logins.txt) you can see in the file [passwords.txt](https://github.com/xenofiodor/PasswordGenerator/blob/master/passwords.txt).
