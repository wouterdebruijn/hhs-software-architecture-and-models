# Java code
For the software / code aspect of this course, I decided to move the code from the existing NetBeans project to a more generic java project (created in vscode)

## Lab1A
I have added a "SnelheidServer" interface to move the user input (currently provided using scanner) to the presentation layer. The interface is implemented as the class "SnelheidInvoerPanel" which provides user input using the JOptionPane provided by javax. Then the Car class is changed to use the provided SnelheidServer and ask it for the new speed or "Snelheid".

## Lab1B
Currently, the user interface calls an "snelheid" update method after asking for user input. This works when that is the only way to change the given "snelheid", but when the car's speed is changed by something else, the update method is skipped. To mitigate this problem we implement the Observer design pattern. The "Snelheid" class is a subject and the Digital and Analog meters are observers of that subject. Using the update() and notifyObservers() method the update is propagated to the presentation layer.