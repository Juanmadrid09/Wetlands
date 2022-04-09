package model;

public class Specie{
	
	
	private static final int MAXHABITAT=10;
	
	private String name;
	private String cientificName;
	private String migration;
	private String [] habitats;
	private int numHabitats;
    private Type typeSpecie;
	
	
	
	
	public Specie(String name, String cientificName, Type typeSpecie, String migration,String habitat){
		
		this.name=name;
		this.cientificName=cientificName;
		this.typeSpecie=typeSpecie;
		this.migration=migration;
		habitats= new String [MAXHABITAT];
		habitats[0]=habitat;
		numHabitats=1;
	}
	
	/**
	*this method add a new habitat of the species the user ask
	*@param habitat String 
	*/
	
 public String addHabitat(String habitat){
	 
	 String out="";
	 boolean flag=true;
	 
	 for(int i=0;i<MAXHABITAT && flag==false;i++){
		 if(habitats[i].equals(habitat)){
			 flag=false;
		 }
	 }
	 
	 
	 
	 
	 if (numHabitats<MAXHABITAT && flag==true){
		 habitats[numHabitats]=habitat;
		 numHabitats++;
	 } else if(numHabitats>=MAXHABITAT){
		 out="disculpe la especie no puede registrarse en mas habitats";
	 } else if(flag=false){
		 out= "disculpe esta especie ya se registro a ese habitat";
	 }
	 
	 
	 return out;
	 
	 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getName(){
		return name;
	}
	
	public String getCientificName(){
		return cientificName;
	}
	
	public String getMigration(){
		return migration;
	}
	
	public void setName(String pname){
		name=pname;
	}
	
	public void setCientificName(String pcname){
		cientificName=pcname;
	}
	
	public void setMigration(String m){
		migration=m;
	}
	
	
	public String getHabitats(){
		String out="son: ";
		for(int i=0;i<MAXHABITAT;i++){
			if(habitats[i]!=null){
			out=out+"-"+habitats[i];
			}
		}
		return out;
	
	}
	
	
	
	
	
}