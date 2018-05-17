class PokemonObject
{
    int number
    String name
    int maxHatch
    int maxCatch
    int maxCp

    PokemonObject(int passNumber, String passName, int passMaxHatch, int passMaxCatch, int passMaxCp)
    {
        this.number = passNumber
        this.name = passName
        this.maxHatch = passMaxHatch
        this.maxCatch = passMaxCatch
        this.maxCp = passMaxCp
    }
    void pokeToString()
    {
        println "${name} will have a MAX-HATCH CP of ${maxHatch}, a MAX-CATCH-LVL-30 of ${maxCatch}, and a MAXCP-LVL-40 of ${maxCp}"
    }
}
