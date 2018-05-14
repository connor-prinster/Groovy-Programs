# Groovy Notes:
* for loops have the same syntax
* do not need semicolons but so help me I'm going to anyways
* if you have a method it must be contained in a class
* classes and methods are pretty much the same as in Java as far as I can tell
* there are while, for, and for-in statements, example below
```groovy
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
```groovy
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
```groovy
for( String myObj in myList )
{
  if( something ) continue
  doTheRest()
}
```