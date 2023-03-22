# Java code
For the software / code aspect of this course, I decided to move the code from the existing NetBeans project to a more generic java project (created in vscode)

## Lab1A
I have added a "SnelheidServer" interface to move the user input (currently provided using scanner) to the presentation layer. The interface is implemented as the class "SnelheidInvoerPanel" which provides user input using the JOptionPane provided by javax. Then the Car class is changed to use the provided SnelheidServer and ask it for the new speed or "Snelheid".