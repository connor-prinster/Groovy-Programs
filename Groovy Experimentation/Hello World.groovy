class Example
{
    static def simpleMethod()
    {
        System.out.println("Hello, World" as Object)

        int a = 5
        int A = 3
        String b = '\nThe result of ' + a + '%' + A + ' equals ' + a%3
        System.out.println(b as Object)

        //defines a range from -1 to 10
        def range = -10..10

        print("\n")
        for(int i = 0; i < range.size(); i++)
        {
            System.out.print("${range.get(i)} ")
        }
        print("\n")

        System.out.println("\nPrinting from simpleMethodWithParameters" as Object)
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                simpleMethodWithParameters(i, j)
            }
        }

        System.out.println("\nPrinting from simpleIntMethod" as Object)
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                System.out.println("The summation of " + j + " + " + i + " = " + simpleIntMethod(i, j) as Object)
            }
        }

        System.out.println("\nPrinting from simpleGstringMethod " as Object)
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
        System.out.println(dataToPrint as Object)
    }

    //can return int
    static int simpleIntMethod(int a, int b)
    {
        return a + b
    }

    static void simpleGstringMethod(int a, int b)
    {
        System.out.println("The summation of $a and $b is ${a+b}" as Object)
    }

    static void main(String[] args)
    {
        simpleMethod()
    }
}