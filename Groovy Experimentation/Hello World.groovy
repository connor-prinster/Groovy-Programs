class Example
{
    static def simpleMethod()
    {
        System.out.println("I made it inside the method!")

        System.out.println("Hello, World")

        def a = 5;
        def A = 3;
        String b = 'The result of ' + a + '%' + A + ' equals ' + a%3;
        System.out.println(b)

        def range = 5..10
        System.out.println(range)

        for(int i = 0; i < range.size(); i++)
        {
            System.out.println(range.get(i))
        }

        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                simpleMethodWithParameters(i, j)
            }
        }
            
    }

    static def simpleMethodWithParameters(int a, int b)
    {
        int summation = a+b
        String dataToPrint = "The summation of " + a + " + " + b + " = " + summation
        System.out.println(dataToPrint);
    }

    static void main(String[] args)
    {
        simpleMethod();
    }
}