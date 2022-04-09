package model;


public class Wetland{
	
	private static final int MAXEVENTS=10;
	private static final int MAXSPECIES=10;
	
	
	
	
	private String name;
	private String ubication;
	private String type;
	private int space;
	private String url;
	private String protect;
	private String nameUbication;
	private int numManagement;
	private int numSpecies;
	private int numEvents;
	private int numGround_Flora;
	private int numAquatic_Flora;
	private int numAve;
	private int numMamifero;
	private int numAquatic;
	
	//associations
private Specie [] species;
private Event [] events;
	
    

	
	
	
	
	public Wetland (String name, String ubication, String type, int space, String url,String protect, String nameUbication, int numManagement){
		
		
		this.name= name;
		this.ubication=ubication;
		this.type=type;
		this.space=space;
		this.url=url;
		this.protect=protect;
		this.nameUbication=nameUbication;
		this.numManagement=numManagement;
		species= new Specie[MAXSPECIES];
		events= new Event[MAXEVENTS];
		numSpecies=0;
		numEvents=0;
		numGround_Flora=0;
	    numAquatic_Flora=0;
	    numAve=0;
	    numMamifero=0;
	    numAquatic=0;
	}
	
	
	/**
	* this method add the object event in the arrays of events
	*@param event Event
	*/
	public void addEvent(Event event){
		if (numEvents<MAXEVENTS){
			events[numEvents]=event;
			numEvents++;
		}
	}
	/**
	* this method add the object Specie in the array of events and register the type of that specie
	*@param specie Specie
	*@param typeSpecie int
	*/
	
	public void addSpecie(Specie specie, int typespecie){
		if(numSpecies<MAXSPECIES){
		species[numSpecies]=specie;
		numSpecies++;
	
		}	
		
      switch(typespecie){
		  
		  case 1:
		  
       numGround_Flora++;
	   
	   break;
	   
	   case 2:
	   
	   numAquatic_Flora++;
	   break;
	   
	   
	   case 3:
	   
	   numAve++;
	   break;
	   
	   case 4:
	   numMamifero++;
	   break;
	   
	   
	   case 5:
	   numAquatic++;
	   break;
	  }
			
	}
	/**
	* this method add a new habitat of the species the user ask
	*@param name String
	*@param habitat String
	*/
	public String addSpecieHabitat(String name,String habitat){
		
		String out="";
		
		boolean isfound=false;
		for(int i=0; i < MAXSPECIES && !isfound; i++){
		
		if (species[i] != null && species[i].getName().equals(name)){
			isfound=true;
			species[i].addHabitat(habitat);
			
		}else
			out="disculpe la especie no ha sido registrada previamente";
		}
	
		return out;
	}
	/** 
	* the method search an specie in the array os species using the parameter name
	*@param name String
	*/
	public boolean searchSpecie(String name){
		
		boolean flag=false;
		for(int i=0; i < MAXSPECIES && !flag; i++){
		
		if (species[i] != null && species[i].getName().equals(name)){
			flag=true;
			}
		}
		return flag;
		
	}
	
	/**
	* this method show the habitats were a specie lives, using his name
	*@param name String 
	*/
	public String showHabitatSpecie(String name){
	String 	out="";
		boolean flag=false;
		for(int i=0; i < MAXSPECIES && !flag; i++){
		
		if (species[i] != null && species[i].getName().equals(name)){
			flag=true;
			out="las habitats en las que se encuentra "+name+species[i].getHabitats();
			
		} else
			out="esa especie no ha sido registrada";
		}
		
		return out;
	}


   /**
   * this method calculate the number of species of flora in the wetland
   */
	public int  calculateNumFlora(){
	
	int numFlora=numGround_Flora+numAquatic_Flora;
	
	return numFlora;
	
	}
	
	/**
	 this method calculate the number of species of fauna  in the wetland
	 */
	public int calculateNumFauna(){
		
	int	numFauna=numAve+numMamifero+numAquatic;
		
		return numFauna;
		
	}
	
	
	
	
	
	
	
	
	public String getName(){
		return name;
	}
	
	public String getUbication(){
		return ubication;
	}
	
	public String getType(){
		return type;
	}
	
	public int getSpace(){
		return space;
	}
	
	public String getUrl(){
		return url;
	}
	
	public String getNameUbication(){
		return nameUbication;
	}
	
	public void setName(String pname){
		name=pname;
	}
	
	public void setUbication(String pubication){
		ubication=pubication;
	}
	
	public void setType(String ptype){
		type=ptype;
	}
	
	public void setSpace(int pspace){
		space=pspace;
	}
	
	public void setUrl(String purl){
		url=purl;
	}
	
	public void setNameUbication(String pnameu){
		nameUbication=pnameu;
	}
	
    public int getNumManagement(){
		return numManagement;
	}
	
	

	
	
	public String toString(){
		String out="";
		
		if (ubication.equals("RURAL")){
			
			out="*** datos del humedal ***\n"+
		"Nombre: " + name + "\n" +
		"Zona de ubicacion: "+ ubication+ "\n" +
		"Tipo: "+ type + "\n" +
		"Cantidad de kilometros: "+ space + "\n" +
		"Url de la foto: "+url + "\n" +
		"El area es protegida: "+protect+"\n"+
		"Nombre del corregimiento: "+nameUbication+ "\n"+
		"Mantenimientos dados en un año: " +numManagement+"\n"+
		"Numero de especies: " + numSpecies+"\n"+
		"Numero de flora terreste: "+ numGround_Flora+"\n"+
		"Numero de flora acuatica: "+numAquatic_Flora+"\n"+
		"Numero de aves: "+numAve+"\n"+
		"Numero de mamiferos: "+numMamifero+"\n"+
		"Numero de seres acuaticos: "+numAquatic+"\n";
		} else 
			out="*** datos del humedal ***\n"+
		"Nombre: " + name + "\n" +
		"Zona de ubicacion: "+ ubication+ "\n" +
		"Tipo: "+ type + "\n" +
		"Cantidad de kilometros: "+ space + "\n" +
		"Url de la foto: "+url + "\n" +
		"El area es protegida: "+protect+"\n"+
		"Nombre del barrio: "+nameUbication+ "\n"+
		"Mantenimientos dados en un año: " +numManagement+"\n"+
		"Numero de especies: " + numSpecies+"\n"+
		"Numero de flora terreste: "+ numGround_Flora+"\n"+
		"Numero de flora acuatica: "+numAquatic_Flora+"\n"+
		"Numero de aves: "+numAve+"\n"+
		"Numero de mamiferos: "+numMamifero+"\n"+
		"Numero de seres acuaticos: "+numAquatic+"\n";
			
	




	return out;
		
		
		
		
		
	}
		
	
	
	
	
	
	
	
	
}