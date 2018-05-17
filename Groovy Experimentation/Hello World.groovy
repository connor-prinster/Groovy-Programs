class Example
{
    static void simpleMethod()
    {
        def darthPlagueisText = "Groovy Experimentation\\darthPlagueis.txt"
        def fileToWrite = "fileToWriteTo.txt"
        println("Hello, World")

        //just a simple println function, like the most simple one I could think of
        int a = 5
        int A = 3
        String b = '\nThe result of ' + a + '%' + A + ' equals ' + a%3
        println("$b\n")

        //defines a range from -1 to 10 and prints it
        def range = -10..10
        for(int i = 0; i < range.size(); i++)
        {
            print("${range.get(i)} ")
        }
        print("\n")

        //prints from a void function
        println("\nPrinting from simpleMethodWithParameters")
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                simpleMethodWithParameters(i, j)
            }
        }

        //prints output from a method
        println("\nPrinting from simpleIntMethod")
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                println("The summation of " + j + " + " + i + " = " + simpleIntMethod(i, j))
            }
        }

        //prints method dealing with a Gstring
        println("\nPrinting from simpleGstringMethod ")
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                simpleGstringMethod(i, j)
            }
        }
        
        printFromFileLineByLine(darthPlagueisText)
        printFileAsString(darthPlagueisText)

        //println "\n---Attempting to print to and check size of $fileToWrite---"
        printStringCheckSizeFile(fileToWrite)
        createAndDeleteFile()
        
        
(fileToWrite)
    }

    //can return typeless 'def'
    static def simpleMethodWithParameters(int a, int b)
    {
        int summation = a+b
        String dataToPrint = "The summation of " + a + " + " + b + " = " + summation
        println(dataToPrint)
    }

    //can return int
    static int simpleIntMethod(int a, int b)
    {
        return a + b
    }

    //prints a GString
    static void simpleGstringMethod(int a, int b)
    {
        print("The summation of $a and $b is ${a+b}\n")
    }

    //prints each individual line
    static void printFromFileLineByLine(String darthPlagueisText)
    {
        println("\nfilename to print from is \"$darthPlagueisText\"")
        println("---PRINTING EACH LINE SEPARATELY---")
        new File(darthPlagueisText).eachLine
        {
            String line -> println("$line");
        }
        print("---DONE PRINTING EACH LINE---\n")
    }

    static void printFileAsString(String darthPlagueisText)
    {
        println("\nfilename to print from is \"$darthPlagueisText\"")
        println("---PRINTING FILE AS A STRING---")
        File file = new File(darthPlagueisText)
        println(file.text);
        print("---DONE PRINTING STRING---\n")
    }

    static void printStringCheckSizeFile(String fileToWrite)
    {
        new File(fileToWrite).withWriter('utf-8')
        {
            writer -> writer.writeLine "This string is useless but it needs to be there for a sec\n"
            print("\nThe (now deleted) file -$fileToWrite- has ${fileToWrite.length()} bytes\n")
        }
        File fileToDelete = new File(fileToWrite)
        fileToDelete.delete()
    }

    static void createAndDeleteFile()
    {
        println("\n---Creating a file---")
        File newFile = new File("deleteAttempt.txt")
        println("---Creating File With Pause for Dramatic Effect---")
        newFile.createNewFile()
        sleep(2000)
        println("---Attempting to Delete the File---")
        if(newFile.delete())
        {
            println("---File Was Successfully Deleted---")
        }
    }

    //main method
    static void main(String[] args)
    {
        simpleMethod()
    }
}