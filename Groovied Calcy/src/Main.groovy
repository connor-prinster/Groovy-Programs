class Main
{
    ArrayList<PokemonObject> pokeList = new ArrayList<>()


    static void main(String[] args)
    {
        Main mainObj = new Main()
        mainObj.fillPokeList("resources/pokemon.txt")
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        String firstResponse = " "
        String pokeFragment = " "
        while(firstResponse != "q" || firstResponse != "quit")
        {
            println "Type q to quit, else press enter"
            firstResponse = br.readLine()
            println "Type in fragment of Pokemon name"
            pokeFragment = br.readLine()
        }
    }

    void fillPokeList(String filename)
    {
        Scanner scan = new Scanner(new FileReader(filename))
        scan.useDelimiter("\\t")
        while(scan.hasNext()) {
            int readNumber = Integer.parseInt(scan.next())
            String readName = scan.next()
            int readMaxHatch = Integer.parseInt(scan.next())
            int readMaxCatch = Integer.parseInt(scan.next())
            int readMaxCp = Integer.parseInt(scan.next())

            pokeList.add(new PokemonObject(readNumber, readName, readMaxHatch, readMaxCatch, readMaxCp))
        }
    }

    void searchPokeList(String stringFragment)
    {

    }
}
