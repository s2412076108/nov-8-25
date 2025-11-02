/*
class Keyword
This tells the Java compiler that you are declaring a class.
A class is a blueprint for creating objects. It can contain:
Fields (variables/data)
Methods (functions)
Constructors
Nested classes
Blocks of code

AnyClassName
This is the name of the class.
It must follow Java naming rules:
Starts with a letter or underscore (_)
Cannot be a Java keyword
By convention, camel case with capital first letter is used, e.g., Student, BankAccount


{} (Curly Braces)
These define the body of the class.
Inside the braces, you write the properties (variables) and behaviors (methods) of the class.
*/


/*public
Access modifier — means this method can be accessed from anywhere.
The Java Virtual Machine (JVM) needs to access this method to start your program, so it must be public.

static
Means this method belongs to the class, not to an object of the class.
The JVM calls main() without creating an object of the class, so it must be static.

void
Return type — means this method does not return any value.
main() is used to start the program, not to return anything.

main
This is the name of the method.
The JVM looks for this exact name as the starting point of the program.

(String[] args)
This is an array of String objects.
It’s an array of strings.
It holds the command-line arguments passed to the program when it is executed.
It is used to receive input from the command line when the program starts.

args -stands for arguments (command-line arguments). we can name this variable freely anything.
It is a convention — easy to understand and widely recognized. 
*/

/*System
A built-in class in the java.lang package.
It provides access to system-level resources and utilities.

out
A static member (object) of the System class.
It is an instance of PrintStream, which has methods to output data to the console.

println()
A method of the PrintStream class.
It prints the given argument and then moves the cursor to a new line.
*/

class Basic {
    public static void main(String[] args) {
        // This line prints "Hello, world!" followed by a new line
        System.out.println("Hello, world!");
    }
}
