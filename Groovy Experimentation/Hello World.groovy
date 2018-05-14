class Example
{
    static void simpleMethod()
    {
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
        println("The summation of $a and $b is ${a+b}")
    }

    //main method
    static void main(String[] args)
    {
        simpleMethod()
    }
}