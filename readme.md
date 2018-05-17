# Groovy Notes:

---

---

---
## General Not-Notes:
[Sorry about the mess](https://www.sideshowtoy.com/wp-content/uploads/2014/07/hansolo.jpg) the notes will eventually be clean

One of my new favorite things is the "Code Runner" extension which allows it to run on VS Code which is great

---

---


## General:
 * methods are the same in Groovy as in Java, can take 0 or infinity amount of parameters
* can have a method return any type including the typeless 'def'
* can have global variables in classes that can be accessed from any method just like java
* do not need semicolons but so help me I'm going to anyways
* if you have a method it must be contained in a class
* classes and methods are pretty much the same as in Java as far as I can tell
* Groovy also automatically handles exceptions bassed on types it's working with. You also don't have to worry about null variables
* just like in Java, all ints are objects of type Integer. _int x, int y_ will automatically **box** itself into _Integer x, Integer y_. An example of **unboxing** is _x + y_ which automatically unboxes the Integer objects into primitive ints
* you can concatonate strings just like in Java
* can use try/catch blocks
* can use and define objects same as in Java

Since Groovy is untyped, if you're going to use **def** make sure to use _duck typing_ as shown below
```java
def c = 100.10 /*this could lead to problems since you don't really know what type it is along the line*/
def cFloat = 100.10 /*This is much better because when you're coding past the declaration of the variable you can remember what type it was originally supposed to be*/
```


To compile
```
groovyc <file>.groovy
```
To look at methods and such,
```
javap -private <filename w/out extension>
```


Something that I think it pretty cool about the above, a hello world program in both languages look like 
```java
//in java
public class HelloWorld 
{
  public static void main(String[] args) 
  {
    System.out.println("Hello World" );
  }
}


//in Groovy
println "Hello World"
```
 but each one, given the javap command below, gives off something along the lines of
 ```
 public HelloWorld();
 public HelloWorld(groovy.lang.Binding);
 public static void main(java.lang.String...);
 ```

---

---

## If/Else Switch
* if and if/else and switch statements are the exact same as in Java and C++ and Javascript

There is something called a continue statement which is the opposite of the break command
```java
for( String myObj in myList )
{
  if( something ) continue
  doTheRest()
}
```

---

---

## Loops:
* there are while, for, and for-in statements
* for loops have the same syntax
### For Loops:
Example of for-in loops
```java
class Example { 
   static void main(String[] args) { 
      int[] array = [0,1,2,3]; 
		
      for(int i in array) { 
         println(i); 
      } 
   } 
}
```

The for-in loop can also look like this
```java 
class Example {
   static void main(String[] args) {
      def employee = ["Ken" : 21, "John" : 25, "Sally" : 22];
		
      for(emp in employee) {
         println(emp);
      }
   }
}
```
which will say something along the lines of 
```
Ken = 21 
Jon = 25
Sally = 22
```

### While Loops:
The exact same thing as in any other language I know except for MIPS Assembly
```java
while(isTrue)
{
    //do something
}
```
---

---

## GStrings
* GStrings are designated by quotation marks while normal strings are designated by apostrophes (e.g. "Hello, World" is a gstring while 'Hello World' is a simple string);
* GStrings have a cool idea where you can have a variable inside of the gstring without having to concatonate like in LaTeX. It could look like:
```java
for(int i = 0; i < 2; i++)
{
  for(int j = 0; j < 2; j++)
  {
    simpleGstringMethod(i, j)
  }
}

static void simpleGstringMethod(int a, int b)
{
  System.out.println("The summation of $a and $b is ${a+b}")
}

/*
the above would print:
The summation of 0 and 0 is 0
The summation of 0 and 1 is 1
The summation of 1 and 0 is 1
The summation of 1 and 1 is 2
*/
```
A String object in Groovy is pretty much the same as in C++ as far as I can tell. Just like you can access a specific char by doing *char c = oldString[x]*, the following code is totally valid
```java
String sample = "Hello world"; 
println(sample[4]); // Print the fifth character in the string
println(sample[-1]); /*Print the 1st character in the string starting from the back */
println(sample[1..2]);/*Prints a string starting from Index 1 to 2 (remember that the x..y means it defines a Range from x to y*/
println(sample[4..2]);/*Prints a string starting from Index 4 back to 2*/

/*
will print
o 
d
el
oll
*/
```

---

---

## File I/O:
* I really have no idea how to get some of this file working without some experimentation. The biggest issue I've found is finding the correct path to a file. This is one example of how to read from a file:
```Java
static void printFromFile()
{
    new File("[parent directory]\\*.txt").eachLine
    {
        String line -> println("\n$line");
    }
}
```

* the **delete()** method for the File class returns a boolean. For example the below code is valid

```groovy
File newFile = new File("*.txt")
if(newFile.delete()) 
    println("success!")
```
* occasionally the delete() method won't work unless you use the **createNewFile()** method. I haven't figured out when it's needed or not, but sometimes I've needed it for the **delete()** to work and other times I haven't. That being said it's not like I've used it all that much so far

* making a directory appears to be just as simple as in a linux shell
```java
/*even though it's of class File, it can still be a directory*/
File file = new File("/Directory")  
/*just like the linux shell command, easy as blue milk*/
file.mkdir()
```

* to test if a file is a directory or a file is pretty simple too
```java
File trueFile = new File("trueFile.txt")
File trueDirectory = new File("/trueDir")
println("File? ${trueFile.isFile()}")
println("File? ${trueDirectory}")
println("Directory? ${trueDirectory.isDirectory()}")
println("Directory? ${trueFile.isDirectory()}")
```
will print
```
File? true
File? false
Directory? true
Directory? false
```
to copy file
```java
def src = new File("E:/Example.txt")
def dst = new File("E:/Example1.txt")
dst << src.text //copies src to dst
```
to get directory contents
```java
def rootFiles = new File("test").listRoots() 
rootFiles.each { file -> println file.absolutePath }
```
will print
```
C:\ 
D:\
```
to print all the files in a particular directory
```java
/*apparently automatically checks the .isDirectory() method for us*/
new File("E:/Temp").eachFile() 
{ file->println file.getAbsolutePath() }
```

 to print all the files in a particular directory and it's subdirectories

```java
/*this is starting to look more and more like Java tbh*/
new File("E:/Temp").eachFileRecurse() 
{ file->println file.getAbsolutePath() }
```

---

---

## Classes:

can also use the keyword **extends**, same as in Java, for example...
```java
class Person {
  //stuff goes here
} 

class Student extends Person {
  //stuff goes here
} 
```

can have nested classes
```java
class Example
{
    Outer out = new Outer()
    out.callInnerMethod() //is valid
}
class Outer
{
    //stuff
    def callInnerMethod()
    {
      new Inner().innerMethod();
    }
  class Inner
    {
      def innerMethod()
    }
}
```

can also have abstract classes
```java
abstract class Person 
{ 
    abstract void DisplayMarks();
}
 
class Student extends Person 
{ 
    void DisplayMarks()
    {
        println("here!")
    }
} 
```
---

---

## Miscellaneous Unsorted Notes:
Date objects are a thing, just fyi
```java
Date currDate = Date() /*Will allocate a date object containing the current type. Can also be printed with millisecond precision*/
Date oldDate = Date(0) /*will print the epoch date of January 1, 1970, 00:00:00 GMT*/
Date oldDatePlus = Date()  /*Will print the epoch date plus the milliseconds specified in the constructor of "Thu Jan 01 04:00:00 GST 1970*/
```

can use Regex in Groovy with the **~** operator
```java
def regex = ~'Groovy' /*base object*/
//below are just new values
'Groovy' =~ 'oo' 
'Groovy' ==~ 'Groovy' 
'Groovy' ==~ 'oo' 
'Groovy' =~ '∧G' 
'Groovy' =~ 'G$' 
'Groovy' =~ 'Gro*vy' 'Groovy' =~ 'Gro{2}vy'
```

Groovy has something similar to Java's ArrayList<Type> except it's just List<Type> but is also an ArrayList? I don't get it, really. It has similar methods too.
```java
List<String> list = new ArrayList<String>()
list.add("first");
list.add("second");
```
Something I still don't get is Closures and Variables. Like, I get the idea of it, but the idea of it is odd. Like, it works but still.The below is apparently valid code?
```groovy
class Example {     
   static void main(String[] args) 
   {
      def str1 = "Hello";
      def clos = {param -> println "${str1} ${param}"}
      clos.call("World");
		
      /* We are now changing the value of the String str1 which is referenced in the closure
      str1 = "Welcome"*/
      clos.call("World");
   } 
}
```
---

---

## Website For More Notes:
[Groovy Tutorials](https://www.tutorialspoint.com/groovy/groovy_xml.htm)
 


