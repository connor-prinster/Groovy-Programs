# Groovy Notes:

---
## General Data I've Found:
[Sorry about the mess](https://www.sideshowtoy.com/wp-content/uploads/2014/07/hansolo.jpg) the notes will eventually be clean

One of my new favorite things is the "Code Runner" extension, it allows it to run on VS Code which is great

----

## Notes on the Language:
* for loops have the same syntax
* do not need semicolons but so help me I'm going to anyways
* if you have a method it must be contained in a class
* classes and methods are pretty much the same as in Java as far as I can tell
* there are while, for, and for-in statements, example below
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
the for-in loop can also look like this which will say something along the lines of Ken = 21 \n Jon = 25 \n Sally = 22 which is pretty lit. It's apparently called a map?
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

* if and if/else statements are the exact same as in Java and C++ and Javascript
* there is something called a continue statement which is the opposite of the break command
```java
for( String myObj in myList )
{
  if( something ) continue
  doTheRest()
}
```
* you can have nested switch statements as well as nested if statements
* methods are the same in Groovy as in Java, can take 0 or infinity amount of parameters
* can have a method return any type including the typeless 'def'
* can have global variables in classes that can be accessed from any method just like java
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
&nbsp; &nbsp; &nbsp; &nbsp; It's actually pretty cool and makes life a lot simpler. It's just simpler, honestly.

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