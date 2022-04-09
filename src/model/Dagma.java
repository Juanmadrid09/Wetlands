package model;

public class Dagma{
	
	public static final int MAXWETLAND = 80;
	
	
	
	//associations
	private Wetland [] wetlands;
	
	
	public Dagma(){
		
		wetlands= new Wetland[MAXWETLAND];
		
	}
	
	
	
	/**
	* the method find the empty position in the array wetlands[]
	*/
	public int getEmptyPosition(){
		
		int position= -1;
		boolean emptyposition= false;
		for (int i=0; i<MAXWETLAND && !emptyposition;i++){
			
			if (wetlands[i]==null){
	    position=i;
		emptyposition= true;
			}
		}
		return position;
	}
	
	/** 
	* the method find the position in the array of a wetland, using the name of them
	*@param name String
	@return foundwetlands int
	*/
    public int foundWetland(String nameWetland){
		
		
		int foundWetlands=-1;
		
		
		for(int i=0;i<MAXWETLAND;i++){
			
		if (wetlands[i]!=null && wetlands[i].getName().equals(nameWetland)){
			
			foundWetlands=i;
		}
		}
	return foundWetlands;
	}
	
	/** 
	* this method create the object wetland using the requested parameters
	* @param name String 
	*@ param type String
	*@param space int
	*@param url String
	*@ param protect String
	*@param nameubication String
	*@param nummanagement int
	*/
	public String addWetland(String name,String ubication,String type, int space, String url,String protect, String nameubication,int nummanagement) {
		
		String out="";
		
		int emptyPos= getEmptyPosition(); //search first position empty

		// if the array is complete

		if(emptyPos == -1){ // is complete

			//you cannot add
			out = "no se pueden almacenar mas humedales";


		}else{ //it is not complete
		
		
		wetlands[emptyPos]= new Wetland(name,ubication,type,space,url,protect,nameubication,nummanagement);
         out="se agrego un nuevo humedal";
	

		}

		return out;

		
	}
	/** 
	* this method create the object Specie using the requested parameters
	* @param name String 
	*@ param cientificname String
	*@param typeSpecie int
	*@param migration String 
	*@ param habitat String 
	*/
	public String addSpecie(String name,String cientificname,int typeSpecie, String migration, String habitat){
		
		
		String out="";
		Type type=null;
	     int Specie=0;
		
		switch(typeSpecie){
			
			case 1:
			
			type=Type.GROUND_FLORA;
			Specie=1;
			break;
			
			case 2:
			
			type=Type.AQUATIC_FLORA;
			Specie=2;
			break;
			
			case 3: 
			
			type=Type.AVE;
			Specie=3;
			break;
			
			case 4:
			
		type= Type.MAMIFERO;	
			Specie=4;
		
			break;
			
			case 5:
			
			type= Type.AQUATIC;
			Specie=5;
			
			break;
	
		}
		
		
		Specie newSpecie= new Specie(name,cientificname,type,migration,habitat);
		int wetlandposition=foundWetland(habitat);
		
		
		if(wetlandposition!=-1){
			
	wetlands[wetlandposition].addSpecie(newSpecie,Specie);
	
		} else
			out= "disculpe, el humedal al cual quiere registrar esta especie no existe";
		
		return out;
	}
	
	/** 
	* this method create the object Event using the requested parameters
	* @param realizer String 
	*@ param description String
	*@param day int
	*@param month int
	*@param year int
	*@ param habitat String 
	*/
	public String addEvent(String realizer,double value, String description, int day, int month, int year,String habitat){
		
		
		String out="";
		
		
		Date newDate= new Date(day,month,year);
		Event newEvent= new Event(realizer,value,description,newDate);
		
		int wetlandposition=foundWetland(habitat);
		
		
		if(wetlandposition!=-1){
			
	wetlands[wetlandposition].addEvent(newEvent);
	
	out="el evento se registro correctamente";
	
		} else
			out= "disculpe, el humedal al cual quiere registrar este evento no existe";
		
		return out;
	}
		/**
        * this method using the parameter name, show the number of managements in a year of a wetland
         */		
		public String ShowNumManagement(String name){

       String out=""; 
	   int wetlandposition= foundWetland(name);
 
       if(wetlandposition!=-1){
		   
		 out=" el numero de mantenimientos dados al humedal "+ wetlands[wetlandposition].getName()+" es de: "+ wetlands[wetlandposition].getNumManagement();	
	   } else
		   out=" Disculpe, ese humedal no esta registrado";
		
		return out;
		}		
		/**
		* this method using method of the class wetland show the wetland with lowest flora
		*/
	public String showWetlandLowestFlora(){
		
		String out="";
		if(wetlands[0]!=null){
			int lessFlora=wetlands[0].calculateNumFlora();
			out="el humedal con menos especies de flora es "+ wetlands[0].getName()+ " con " + lessFlora + " especies";
			for(int i=1;i<MAXWETLAND;i++){
			if(wetlands[i]!=null){
				if(wetlands[i].calculateNumFlora()<lessFlora){
			lessFlora=wetlands[i].calculateNumFlora();
			out="el humedal con menos especies de flora es "+ wetlands[i].getName()+ " con " + lessFlora + " especies";
		}
		}
		}
		
			
			
		} else
			out="ingrese un humedal primero";
		
		return out;
	}
	
	/**
	* this method show the habitats were a specie lives, using his name
	*@param name String 
	*/
	public void ShowSpecieWetland(String name){
		
		
		for(int i=0;i<MAXWETLAND;i++){
			if(wetlands[i]!=null){
			if(wetlands[i].searchSpecie(name)==true){
			System.out.println(wetlands[i].showHabitatSpecie(name));
			}
			}
		}
	}
	
	/**
	* this method using method of the class wetland show the wetland with highest fauna
	*/
	public String showWetlandHighestFauna(){
		
		String out="";
		if(wetlands[0]!=null){
			
		int highestFauna=wetlands[0].calculateNumFauna();
		out="el humedal con mayor numero de animales  es "+ wetlands[0].getName()+ " con " + highestFauna + " animales";
		
		
		for(int i=1;i<MAXWETLAND;i++){
			if(wetlands[i]!=null){
		if( wetlands[i].calculateNumFauna()>highestFauna){
			highestFauna=wetlands[i].calculateNumFauna();
			out="el humedal con mayor numero de animales  es "+ wetlands[i].getName()+ " con " + highestFauna + " animales";
		}
		}
		}
		
		}else 
			out="ingrese un humedal primero";
		return out;
	}
	
	/**
	* this method add a new habitat of the species the user ask
	*@param namew String
	*@param names String 
	*@param habitat String
	*/
	public String addWetlandSpecie(String namew,String names,String habitat){
		
		String out="";
		
		int wetlandposition=foundWetland(namew);
		
		
		
		if(wetlandposition!=-1){
			
	wetlands[wetlandposition].addSpecieHabitat(names,habitat);
	out=" se registro el habitat correctamente";
	
	
		} else
			out= "disculpe, el humedal al cual fue registrada la especie no existe";
		
		return out;
		
	}
    /**
	* this method show the information of all wetland that have been registered
	*/
    public void ShowInfoWetlands(){

		for(int i=0;i<MAXWETLAND ;i++){
			
		if (wetlands[i]!=null){
			
			System.out.println(wetlands[i].toString());
		}
			
			
		}
	}
		
	
}
   