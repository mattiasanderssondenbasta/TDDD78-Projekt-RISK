package RISK;


public class World
{
    private static Continent[] world = null;

    public static Continent[] getWorld() {
	return world;
    }

    public static Continent createAfrica() {
	String[] southAfricaNeighbours = new String[3];
	southAfricaNeighbours[0] = "Central Africa";
        southAfricaNeighbours[1] = "Madagascar";
	southAfricaNeighbours[2] = "East Africa";

	String[] eastAfricaNeighbours = new String[6];
	eastAfricaNeighbours[0] = "North Africa";
        eastAfricaNeighbours[1] = "Central Africa";
        eastAfricaNeighbours[2] = "South Africa";
	eastAfricaNeighbours[3] = "Egypt";
	eastAfricaNeighbours[4] = "Middle East";
	eastAfricaNeighbours[5] = "Madagascar";

	String[] egyptNeighbours = new String[4];
	egyptNeighbours[0] = "North Africa";
	egyptNeighbours[1] = "East Africa";
	egyptNeighbours[2] = "Southern Europe";
	egyptNeighbours[3] = "Middle East";

	String[] northAfricaNeighbours = new String[6];
	northAfricaNeighbours[0] = "East Africa";
        northAfricaNeighbours[1] = "Central Africa";
	northAfricaNeighbours[2] = "Egypt";
	northAfricaNeighbours[3] = "Brazil";
	northAfricaNeighbours[4] = "Western Europe";
	northAfricaNeighbours[5] = "Southern Europe";

	String[] centralAfricaNeighbours = new String[3];
	centralAfricaNeighbours[0] = "North Africa";
	centralAfricaNeighbours[1] = "East Africa";
	centralAfricaNeighbours[2] = "South Africa";

	String[] madagascarNeighbours = new String[2];
	madagascarNeighbours[0] = "East Africa";
	madagascarNeighbours[1] = "South Africa";

	ContinentTerritory northAfrica = new ContinentTerritory("North Africa", northAfricaNeighbours);
	ContinentTerritory southAfrica = new ContinentTerritory("South Africa", southAfricaNeighbours);
        ContinentTerritory eastAfrica = new ContinentTerritory("East Africa", eastAfricaNeighbours);
        ContinentTerritory centralAfrica = new ContinentTerritory("Central Africa", centralAfricaNeighbours);
	ContinentTerritory egypt = new ContinentTerritory("Egypt", egyptNeighbours);
	ContinentTerritory madagascar = new ContinentTerritory("Madagascar", madagascarNeighbours);

	ContinentTerritory[] africaTerritorys = new ContinentTerritory[6];
	africaTerritorys[0] = northAfrica;
	africaTerritorys[1] = southAfrica;
	africaTerritorys[2] = eastAfrica;
	africaTerritorys[3] = centralAfrica;
	africaTerritorys[4] = egypt;
	africaTerritorys[5] = madagascar;

	Continent africa = new Continent("Africa", africaTerritorys);

	return africa;
    }

    public static Continent createAsia() {
	String[] middleEastNeighbours = new String[6];
	middleEastNeighbours[0] = "Afghanistan";
	middleEastNeighbours[1] = "India";
	middleEastNeighbours[2] = "Egypt";
	middleEastNeighbours[3] = "East Africa";
	middleEastNeighbours[4] = "Russia";
	middleEastNeighbours[5] = "Southern Europe";

	String[] afghanistanNeighbours = new String[5];
	afghanistanNeighbours[0] = "India";
	afghanistanNeighbours[1] = "Middle East";
	afghanistanNeighbours[2] = "Ural";
	afghanistanNeighbours[3] = "China";
	afghanistanNeighbours[4] = "Russia";

	String[] indiaNeighbours = new String[4];
	indiaNeighbours[0] = "Middle East";
	indiaNeighbours[1] = "Afghanistan";
	indiaNeighbours[2] = "China";
	indiaNeighbours[3] = "Southern Asia";

	String[] uralNeighbours = new String[4];
	uralNeighbours[0] = "Siberia";
	uralNeighbours[1] = "Afghanistan";
	uralNeighbours[2] = "China";
	uralNeighbours[3] = "Russia";

	String[] chinaNeighbours = new String[6];
	chinaNeighbours[0] = "India";
	chinaNeighbours[1] = "Afghanistan";
	chinaNeighbours[2] = "Ural";
	chinaNeighbours[3] = "Siberia";
	chinaNeighbours[4] = "Mongolia";
	chinaNeighbours[5] = "Southern Asia";

	String[] southernAsiaNeighbours = new String[3];
	southernAsiaNeighbours[0] = "India";
	southernAsiaNeighbours[1] = "China";
	southernAsiaNeighbours[2] = "Indonesia";

	String[] mongoliaNeighbours = new String[5];
	mongoliaNeighbours[0] = "China";
	mongoliaNeighbours[1] = "Japan";
	mongoliaNeighbours[2] = "Irkutsk";
	mongoliaNeighbours[3] = "Siberia";
	mongoliaNeighbours[4] = "Kamtjatka";

	String[] kamtjatkaNeighbours = new String[5];
	kamtjatkaNeighbours[0] = "Yakutia";
	kamtjatkaNeighbours[1] = "Irkutsk";
	kamtjatkaNeighbours[2] = "Mongolia";
	kamtjatkaNeighbours[3] = "Japan";
	kamtjatkaNeighbours[4] = "Alaska";

	String[] yakutiaNeighbours = new String[3];
	yakutiaNeighbours[0] = "Siberia";
	yakutiaNeighbours[1] = "Kamtjatka";
	yakutiaNeighbours[2] = "Irkutsk";

	String[] irkutskNeighbours = new String[4];
	irkutskNeighbours[0] = "Siberia";
	irkutskNeighbours[1] = "Yakutia";
	irkutskNeighbours[2] = "Kamtjatka";
	irkutskNeighbours[3] = "Mongolia";


	String[] siberiaNeighbours = new String[5];
	siberiaNeighbours[0] = "Ural";
	siberiaNeighbours[1] = "Yakutia";
	siberiaNeighbours[2] = "Irkutsk";
	siberiaNeighbours[3] = "China";
	siberiaNeighbours[4] = "Mongolia";

	ContinentTerritory middleEast = new ContinentTerritory("Middle East", middleEastNeighbours);
	ContinentTerritory afghanistan = new ContinentTerritory("Afghanistan", afghanistanNeighbours);
	ContinentTerritory india = new ContinentTerritory("India", indiaNeighbours);
	ContinentTerritory ural = new ContinentTerritory("Ural", uralNeighbours);
	ContinentTerritory china = new ContinentTerritory("China", chinaNeighbours);
	ContinentTerritory southernAsia = new ContinentTerritory("Southern Asia", southernAsiaNeighbours);
	ContinentTerritory mongolia = new ContinentTerritory("Mongolia", mongoliaNeighbours);
	ContinentTerritory kamtjatka = new ContinentTerritory("Kamtjatka", kamtjatkaNeighbours);
	ContinentTerritory yakutia = new ContinentTerritory("Yakutia", yakutiaNeighbours);
	ContinentTerritory irkutsk = new ContinentTerritory("Irkutsk", irkutskNeighbours);
	ContinentTerritory siberia = new ContinentTerritory("Siberia", siberiaNeighbours);

	ContinentTerritory[] asiaTerritorys = new ContinentTerritory[11];
	asiaTerritorys[0] = middleEast;
	asiaTerritorys[1] = afghanistan;
	asiaTerritorys[2] = india;
	asiaTerritorys[3] = ural;
	asiaTerritorys[4] = china;
	asiaTerritorys[5] = southernAsia;
	asiaTerritorys[6] = mongolia;
	asiaTerritorys[7] = kamtjatka;
	asiaTerritorys[8] = yakutia;
	asiaTerritorys[9] = irkutsk;
	asiaTerritorys[10] = siberia;

	Continent asia = new Continent("Asia", asiaTerritorys);

	return asia;

    }


    public static Continent createEurope() {
	String[] russiaNeighbours = new String[6];
	russiaNeighbours[0] = "Scandinavia";
	russiaNeighbours[1] = "Northern Europe";
	russiaNeighbours[2] = "Southern Europe";
	russiaNeighbours[3] = "Middle East";
	russiaNeighbours[4] = "Afghanistan";
	russiaNeighbours[5] = "Ural";

	String[] scandinaviaNeighbours = new String[4];
	scandinaviaNeighbours[0] = "Russia";
	scandinaviaNeighbours[1] = "Northern Europe";
	scandinaviaNeighbours[2] = "Iceland";
	scandinaviaNeighbours[3] = "Great Britain";

	String[] icelandNeighbours = new String[3];
	icelandNeighbours[0] = "Greenland";
	icelandNeighbours[1] = "Scandinavia";
	icelandNeighbours[2] = "Great Britain";

	String[] greatBritainNeighbours = new String[3];
	greatBritainNeighbours[0] = "Iceland";
	greatBritainNeighbours[1] = "Scandinavia";
	greatBritainNeighbours[2] = "Northern Europe";

	String[] westernEuropeNeighbours = new String[4];
	westernEuropeNeighbours[0] = "North Africa";
	westernEuropeNeighbours[1] = "Great Britain";
	westernEuropeNeighbours[2] = "Northern Europe";
	westernEuropeNeighbours[3] = "Southern Europe";

	String[] northernEuropeNeighbours = new String[5];
	northernEuropeNeighbours[0] = "Scandinavia";
	northernEuropeNeighbours[1] = "Russia";
	northernEuropeNeighbours[2] = "Southern Europe";
	northernEuropeNeighbours[3] = "Western Europe";
	northernEuropeNeighbours[4] = "Great Britain";

	String[] southernEuropeNeighbours = new String[5];
	southernEuropeNeighbours[0] = "Egypt";
	southernEuropeNeighbours[0] = "North Africa";
	southernEuropeNeighbours[0] = "Middle East";
	southernEuropeNeighbours[0] = "Russia";
	southernEuropeNeighbours[0] = "Northern Europe";
	southernEuropeNeighbours[0] = "Western Europe";

	ContinentTerritory russia = new ContinentTerritory("Russia", russiaNeighbours);
	ContinentTerritory scandinavia = new ContinentTerritory("Scandinavia", scandinaviaNeighbours);
	ContinentTerritory iceland = new ContinentTerritory("Iceland", icelandNeighbours);
	ContinentTerritory greatBritain = new ContinentTerritory("Great Britain", greatBritainNeighbours);
	ContinentTerritory westernEurope = new ContinentTerritory("Western Europe", westernEuropeNeighbours);
	ContinentTerritory northernEurope = new ContinentTerritory("Northern Europe", northernEuropeNeighbours);
	ContinentTerritory southernEurope = new ContinentTerritory("Southern Europe", southernEuropeNeighbours);

	ContinentTerritory[] europeTerritorys = new ContinentTerritory[7];
	europeTerritorys[0] = russia;
	europeTerritorys[1] = scandinavia;
	europeTerritorys[2] = iceland;
	europeTerritorys[3] = greatBritain;
	europeTerritorys[4] = westernEurope;
	europeTerritorys[5] = northernEurope;
	europeTerritorys[6] = southernEurope;

	Continent europe = new Continent("Europe", europeTerritorys);

	return europe;

    }


    public static Continent createOceania() {
	String[] indonesiaNeighbours = new String[3];
	indonesiaNeighbours[0] = "Southern Asia";
	indonesiaNeighbours[1] = "New Guinea";
	indonesiaNeighbours[2] = "Western Australia";

	String[] newGuineaNeighbours = new String[3];
	newGuineaNeighbours[0] = "Indonesia";
	newGuineaNeighbours[1] = "Western Australia";
	newGuineaNeighbours[2] = "Eastern Australia";

	String[] easternAustraliaNeighbours = new String[2];
	easternAustraliaNeighbours[0] = "New Guinea";
	easternAustraliaNeighbours[1] = "Western Australia";

	String[] westernAustraliaNeighbours = new String[3];
	westernAustraliaNeighbours[0] = "Eastern Australia";
	westernAustraliaNeighbours[1] = "New Guinea";
	westernAustraliaNeighbours[2] = "Indonesia";

	ContinentTerritory indonesia = new ContinentTerritory("Indonesia", indonesiaNeighbours);
	ContinentTerritory newGuinea = new ContinentTerritory("New Guinea", newGuineaNeighbours);
	ContinentTerritory easternAustralia = new ContinentTerritory("Eastern Australia", easternAustraliaNeighbours);
	ContinentTerritory westernAustralia = new ContinentTerritory("Western Australia", westernAustraliaNeighbours);

	ContinentTerritory[] oceaniaTerritorys = new ContinentTerritory[4];
	oceaniaTerritorys[0] = indonesia;
	oceaniaTerritorys[1] = newGuinea;
	oceaniaTerritorys[2] = easternAustralia;
	oceaniaTerritorys[3] = westernAustralia;

	Continent oceania = new Continent("Oceania", oceaniaTerritorys);

	return oceania;

    }
    public static Continent createNorthAmerica() {

        String[] alaskaNeighbours = new String[3];
        alaskaNeighbours[0] = "Northwest Territory";
        alaskaNeighbours[1] = "Alberta";
        alaskaNeighbours[2] = "Kamtjatka";
        ContinentTerritory alaska = new ContinentTerritory("Alaska", alaskaNeighbours);

        String[] northWestTerritoryNeighbours = new String[4];
        northWestTerritoryNeighbours[0] = "Alaska";
        northWestTerritoryNeighbours[1] = "Alberta";
        northWestTerritoryNeighbours[2] = "Ontario";
        northWestTerritoryNeighbours[3] = "Greenland";
        ContinentTerritory northWestTerritory = new ContinentTerritory("North West Territory", northWestTerritoryNeighbours);

        String[] albertaNeighbours = new String[4];
        albertaNeighbours[0] = "Alaska";
        albertaNeighbours[1] = "NorthWestTerritory";
        albertaNeighbours[2] = "Ontario";
        albertaNeighbours[3] = "Western United States";
        ContinentTerritory alberta = new ContinentTerritory("Alberta", albertaNeighbours);

        String[] ontarioNeighbours = new String[6];
        ontarioNeighbours[0] = "Alberta";
        ontarioNeighbours[1] = "NorthWestTerritory";
        ontarioNeighbours[2] = "Western United States";
        ontarioNeighbours[3] = "Eastern United States";
        ontarioNeighbours[4] = "Eastern Canada";
        ontarioNeighbours[5] = "Greenland";
        ContinentTerritory ontario = new ContinentTerritory("Ontario", ontarioNeighbours);

        String[] easternCanadaNeighbours = new String[3];
        easternCanadaNeighbours[0] = "Ontario";
        easternCanadaNeighbours[1] = "Eastern United States";
        easternCanadaNeighbours[2] = "Greenland";
        ContinentTerritory easternCanada = new ContinentTerritory("Eastern Canada", easternCanadaNeighbours);

        String[] greenlandNeighbours = new String[4];
        greenlandNeighbours[0] = "NorthWestTerritory";
        greenlandNeighbours[1] = "Ontario";
        greenlandNeighbours[2] = "Eastern Canada";
        greenlandNeighbours[3] = "Iceland";
        ContinentTerritory greenland = new ContinentTerritory("Greenland", greenlandNeighbours);

        String[] westernUnitedStatesNeighbours = new String[4];
        westernUnitedStatesNeighbours[0] = "Alberta";
        westernUnitedStatesNeighbours[1] = "Ontario";
        westernUnitedStatesNeighbours[2] = "Eastern United States";
        westernUnitedStatesNeighbours[3] = "Central America";
        ContinentTerritory westernUnitedStates = new ContinentTerritory("Western United States", westernUnitedStatesNeighbours);

        String[] easternUnitedStatesNeighbours = new String[4];
        easternUnitedStatesNeighbours[0] = "Ontario";
        easternUnitedStatesNeighbours[1] = "Central America";
        easternUnitedStatesNeighbours[2] = "Eastern Canada";
        easternUnitedStatesNeighbours[3] = "Western United States";
        ContinentTerritory easternUnitedStates = new ContinentTerritory("Eastern United States", easternUnitedStatesNeighbours);

        String[] centralAmericaNeighbours = new String[3];
        centralAmericaNeighbours[0] = "Western United States";
        centralAmericaNeighbours[1] = "Eastern United States";
        centralAmericaNeighbours[2] = "Venezuela";
        ContinentTerritory centralAmerica = new ContinentTerritory("Central America", centralAmericaNeighbours);

        ContinentTerritory[] northAmericaTerritorys = new ContinentTerritory[9];
        northAmericaTerritorys[0] = alaska;
        northAmericaTerritorys[1] = northWestTerritory;
        northAmericaTerritorys[2] = alberta;
        northAmericaTerritorys[3] = ontario;
        northAmericaTerritorys[4] = easternCanada;
        northAmericaTerritorys[5] = greenland;
        northAmericaTerritorys[6] = westernUnitedStates;
        northAmericaTerritorys[7] = easternUnitedStates;
        northAmericaTerritorys[8] = centralAmerica;

        Continent northAmerica = new Continent("North America", northAmericaTerritorys);

	return northAmerica;

    }

    public static Continent createSouthAmerica() {

        String[] venezuelaNeighbours = new String[3];
        venezuelaNeighbours[0] = "Central America";
        venezuelaNeighbours[1] = "Brazil";
        venezuelaNeighbours[2] = "Peru";
        ContinentTerritory venezuela = new ContinentTerritory("Venezuela", venezuelaNeighbours);

        String[] brazilNeighbours = new String[4];
        brazilNeighbours[0] = "Venezuela";
        brazilNeighbours[1] = "Peru";
        brazilNeighbours[2] = "Argentina";
        brazilNeighbours[3] = "North Africa";
        ContinentTerritory brazil = new ContinentTerritory("Brazil", brazilNeighbours);

        String[] peruNeighbours = new String[3];
        peruNeighbours[0] = "Venezuela";
        peruNeighbours[1] = "Brazil";
        peruNeighbours[2] = "Argentina";
        ContinentTerritory peru = new ContinentTerritory("Peru", peruNeighbours);

        String[] argentinaNeighbours = new String[2];
        argentinaNeighbours[0] = "Peru";
        argentinaNeighbours[1] = "Brazil";
        ContinentTerritory argentina = new ContinentTerritory("Argentina", argentinaNeighbours);

        ContinentTerritory[] southAmericaTerritorys = new ContinentTerritory[4];
        southAmericaTerritorys[0] = venezuela;
        southAmericaTerritorys[1] = brazil;
        southAmericaTerritorys[2] = peru;
        southAmericaTerritorys[3] = argentina;

        Continent southAmerica = new Continent("South America", southAmericaTerritorys);

	return southAmerica;
    }

    public static void initializeWorld() {
	Continent[] toBeWorld = new Continent[6];
	for (int i = 0; i < 6; i++) {
	    switch (i) {
		case 0:
		    toBeWorld[0] = createAfrica();
		    break;
		case 1:
		    toBeWorld[1] = createAsia();
		    break;
		case 2:
		    toBeWorld[2] = createEurope();
		    break;
		case 3:
		    toBeWorld[3] = createOceania();
		    break;
		case 4:
		    toBeWorld[4] = createNorthAmerica();
		    break;
		case 5:
		    toBeWorld[5] = createSouthAmerica();
		    break;
		default:
		    break;
	    }
	}
	world = toBeWorld;
    }


}
