class Example
{
    static def simpleMethod()
    {
        System.out.println("I made it inside the method!");

        System.out.println("Hello, World");

        def a = 5;
        def A = 3;
        String b = 'The result of ' + a + '%' + A + ' equals ' + a%3;
        System.out.println(b);

        def range = 5..10;
        System.out.println(range);

        for(int i = 0; i < range.size(); i++)
        {
            System.out.println(range.get(i));
        }

        System.out.println("\nPrinting from simpleMethodWithParameters");
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                simpleMethodWithParameters(i, j);
            }
        }

        System.out.println("\nPrinting from simpleIntMethod");
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                System.out.println("The summation of " + j + " + " + i + " = " + simpleIntMethod(i, j));
            }
        }
            
    }

    //can return typeless 'def'
    static def simpleMethodWithParameters(int a, int b)
    {
        int summation = a+b;
        String dataToPrint = "The summation of " + a + " + " + b + " = " + summation;
        System.out.println(dataToPrint);
    }

    //can return int
    static int simpleIntMethod(int a, int b)
    {
        return a + b;
    }

    static void main(String[] args)
    {
        simpleMethod();
    }
}