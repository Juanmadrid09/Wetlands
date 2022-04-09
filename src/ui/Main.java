package ui;


 import model.Dagma;
 import java.util.Scanner;


/**
 * principal class of proyect wetlands
 * @author Juan Felipe Madrid
 * @version 1.0
 * @since April 2022
 */

public class Main{
	
	
	private Dagma sis;
    private Scanner lector;
	
	public Main(){
		
		lector= new Scanner(System.in);
		sis= new Dagma();
	
	}
	
	public static void main(String[] args){
		
		Main sp=new Main();
		int option=0;
		
		do{
	option= sp.menu();
	sp.actions(option);
	} while (option!=0);
	
	
}
		
/** 
* Method that show the menu of options to the user
*/
	
public int menu(){
	
int answer=0;

System.out.println("\n\nHumedales del municipio, digite una opciOn\n"+ 
		                    "(1) Crear un humedal\n" +
		                    "(2) Registrar una nueva especie en el humedal\n" +
							"(3) Registrar un evento en el humedal\n" +
							"(4) Mantenimientos dados al humedal\n" +
		                    "(5) Humedal con menos especies de flora\n"+
		                    "(6) Habitats de una especie \n"+
		                    "(7) Mostrar los datos de los humedales\n"+
							"(8) Mostrar humedal con mayor cantidad de animales\n"+
		                    "(0) Para salir"
	
		);
	
answer=lector.nextInt();

return answer;

}		
		/** 
		* method that depends of the answer of the user, do a different action, like create a wetland
		*/
	public void actions(int option){
	
	switch(option){
		
		case 0:
		
		break;
		
		
		case 1:
		
		createWetland();
		
		break;
		
		case 2:
		
		registSpecie();
		
		break;
		
		 case 3:
		 
		 registEvent();
		 
		break;
		
		case 4: 
		
		showManagement();
		
		break;
		
		case 5:
	  
	    lowestSpecies();
	  
        break;
		
		case 6:
		
		specieHabitat();
		
		break;
		
		case 7:
		
		infoWetland();
		
		break;
		
		case 8:
		
		highestAnimals();
		
		break;
	
	
	}



}	
		/**
		* this method ask the parameters to create a wetland, then used the methods of dagma and the parameters to create the wetland
		*/
		public void createWetland(){
			
    System.out.println("\n\nPor favor ingrese el nombre del humedal");
    String name=lector.nextLine();
	name=lector.nextLine();
		
     System.out.println("\n¿el humedal se encuentra en una zona rural(1) o urbana(2)?");
	 int ubi=lector.nextInt();
	 String ubication="";
	 while(ubi<1 || ubi>2){
		  System.out.println("disculpe, ingrese uno de los numeros mostrados en las opciones");
		  ubi=lector.nextInt();
	 }
		 if(ubi==1){
			 ubication="RURAL";
		 }else
			 ubication="URBANA";
		
		
	 System.out.println("\n¿el humedal es publico(1) o privado(2)?");	
		 int ti=lector.nextInt();
	 String Type="";
	 while(ti<1 || ti>2){
		  System.out.println("disculpe, ingrese uno de los numeros mostrados en las opciones");
		  ti=lector.nextInt();
	 }
		 if(ti==1){
			 Type="PUBLICO";
		 }else
			 Type="PRIVADO";
		 
		 
	System.out.println("\nIngrese el numero de kilometros que tiene el humedal");
	int space=lector.nextInt();
	
	
	System.out.println("\n¿el humedal es un area protegida?(Si(1)/No(2))");	
		 int pro=lector.nextInt();
		 String protect="";
	 while(pro<1 || pro>2){
		  System.out.println("disculpe, ingrese uno de los numeros mostrados en las opciones");
		  pro=lector.nextInt();
	 }
		 if(ti==1){ 
			protect="Si";
		 }else
			protect="No";
		
		
		System.out.println("\nIngrese el url de una foto del humedal");
		String url=lector.next();
		
		
		
		String nameubication="";
		if(ubi==1){
		System.out.println("\nIngrese el nombre del corregimiento");
		nameubication=lector.nextLine();
		nameubication=lector.nextLine();
		}else {
			System.out.println("\nIngrese el nombre del barrio");
			nameubication=lector.nextLine();
		    nameubication=lector.nextLine();
		}
		
		System.out.println("\n¿Cuantos mantenimientos tiene este humedal por año?");
		int numManagement=lector.nextInt();
		
		sis.addWetland(name,ubication,Type,space,url,protect,nameubication,numManagement);
		
		}
		
		/**
		* this method regist a new specie in a wetland or add an new habitat to an existent specie
		*/
		public void registSpecie(){
			
			System.out.println("\n Desea registrar una especie nueva en un humedal(1) o desea agregar un habitat a una especie ya registrada(2)");
		int option=lector.nextInt();
		
		 while(option<1 || option>2){
		  System.out.println("\ndisculpe, ingrese uno de los numeros mostrados en las opciones");
		  option=lector.nextInt();
		 }
		 
		if(option==1){
			
			System.out.println("\nPor favor ingrese el nombre de la especie");
			String name=lector.nextLine();
			name=lector.nextLine();
			
			System.out.println("\nAhora el nombre cientifico de la especie");
		    String cientificName=lector.nextLine();
			
			
			
			System.out.println("\nIngrese el tipo de la especie: Flora terrestre(1), Flora acuatica(2), Ave(3), Mamifero(4), Acuatico(5)");
			int typeSpecie=lector.nextInt();
			
			 while(option<1 || option>5){
		  System.out.println("disculpe, ingrese uno de los numeros mostrados en las opciones");
		  option=lector.nextInt();
		 }
		
		 System.out.println("\n ¿La especie es migratoria?(Si(1)/No(2))");
          int mi=lector.nextInt();
		  String migration="";
		  
          while(mi<1 || mi>2){
		  System.out.println("disculpe, ingrese uno de los numeros mostrados en las opciones");
		  mi=lector.nextInt();
	      }
		 if(mi==1){ 
			migration="Si";
		 }else
			migration="No";
		
		System.out.println("\n Ingrese el habitat de la especie");
		String habitat=lector.nextLine();
		habitat=lector.nextLine();
		
		sis.addSpecie(name,cientificName,typeSpecie,migration,habitat);
		
		}  else{
			
			System.out.println("\n Cual es el nombre de la especie");
			String nameS=lector.nextLine();
			nameS=lector.nextLine();
			
			System.out.println("\n En que humedal fue registrado por primera vez");
			String nameW=lector.nextLine();
			
			
			System.out.println("\n En que otro humedal se encuentra");
			String habitat=lector.nextLine();
			
			
			System.out.println(sis.addWetlandSpecie(nameW,nameS,habitat));
		}
		
		}
		
		/**
		* this method regist an event in a wetland
		*/
		public void registEvent(){
			
		System.out.println("\n Quien realizara el evento");
		String realizer=lector.nextLine();
		realizer=lector.nextLine();
		
		System.out.println("\n Cual es el costo del evento");
	    double value=lector.nextDouble();
		
		System.out.println("\n De una breve descripcion del evento");
		String description=lector.nextLine();
		description=lector.nextLine();
		
		System.out.println("\n Que dia sera el evento");
		int day=lector.nextInt();
		
		System.out.println("\n En que mes sera el evento");
		int month=lector.nextInt();
		
		System.out.println("\n En que año sera el evento");
		int year=lector.nextInt();
		
		System.out.println("\n Ingrese el humedal del evento");
		String habitat=lector.nextLine();
		habitat=lector.nextLine();
		
		
		
		System.out.println(sis.addEvent(realizer,value,description,day,month,year,habitat));
		
		}
		
		/**
		* this method show the number of magements in a year of a wetland, asking the name of the wetland
		*/
		public void showManagement(){
			
		System.out.println("\n Ingrese el nombre del humedal de cual quiere saber los mantenimientos dados");
         String name=lector.nextLine();
		 name=lector.nextLine();
		 
		 System.out.println(sis.ShowNumManagement(name));
		}
		
		/**
		* this method show the name of the wetland with lowest species of flora, using methods of the controler class
		*/
		public void lowestSpecies(){
			
			System.out.println(sis.showWetlandLowestFlora());
			
		}
		
		/**
		* asking the name of the specie, the method found the habitats were he lives
		*/
		public void specieHabitat(){
			
		System.out.println("\n Ingrese el nombre de la especie del cual quiere saber sus habitats");
  
         String name=lector.nextLine();
		 name=lector.nextLine();
		 
		 sis.ShowSpecieWetland(name);
		 
		}
		/** 
		* the method show all the information of wetlands that have been registered
		*/
       public void infoWetland(){
		   
		   sis.ShowInfoWetlands();
		   
	   }
 /**
 * this method show the name of the wetland with highest number of animals
 */
       public void highestAnimals(){
		   
		  System.out.println( sis.showWetlandHighestFauna());
		   
	   }
	   
	   
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
}     
