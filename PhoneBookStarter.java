/*Edwin Mak
 * This class contains the console-based user interface of the phonebook application 
 */

package phonebook;
import java.util.*;


public class PhoneBookStarter {

	public static void main(String[] args) throws Exception {
		Scanner console = new Scanner(System.in);
		Phonebook p = new Phonebook();
		
		System.out.println("Welcome to the phonebook!");
		int x = 0;
		while(x == 0){
			System.out.println("Would you like to Add, Search, Delete, List, or Exit?");
			String choice = console.next().toUpperCase();
			console.nextLine();
			if(choice.equals("ADD")){
				System.out.println("What is the name of the person?");				
				String name = console.nextLine();
				System.out.println("What is the person's telephone number (XXX-XXX-XXXX) ?");
				String telenumber = console.next();
				try{
					p.add(new PhonebookEntry(name.toUpperCase(), telenumber));
				}catch(IllegalArgumentException e){
					System.out.println("Please type in a name (A-Z) and 10 digit phone number");
				}
			}else if(choice.equals("SEARCH")){
				System.out.println("What is the name of the person you'd like to search for?");
				String name = console.nextLine();
				p.search(name.toUpperCase());
			}else if(choice.equals("DELETE")){
				System.out.println("What is the name of the person you'd like to delete from the phonebook?");
				String name = console.nextLine();
				p.delete(name.toUpperCase());
			}else if(choice.equals("LIST")){
				p.printAll();
			}else if(choice.equals("EXIT")){
				console.close();
				System.out.println("Exitted");
				x = 1;
			}else{
				System.out.println("Please type add, search, delete, list, or exit");
			}
		}
	}


}
