import java.io.*;
import java.util.*;
public class NoteApp {

    public static void main(String[]args){
        System.out.println("Welcome TO Note App");
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("MENU");
            System.out.println("1.Write Notes.");
            System.out.println("2.Read Notes.");
            System.out.println("3. Exit");

            System.out.print("Chose the Option : ");
            choice = sc.nextInt();


            if(choice == 1){
                sc.nextLine();
                System.out.print("Type Your Note Here --> ");
                String note = sc.nextLine();
                try(FileWriter fw = new FileWriter("Notes.txt",true)) {
                    fw.write(note+"\n");
                } catch (IOException e) {
                    System.out.println("Error While Writing!");
                }
            }

            if (choice == 2) {
                try(BufferedReader br = new BufferedReader(new FileReader("Notes.txt"))){
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println("_ "+line);
                    }
                }catch(IOException e){
                    System.out.println("Error While Reading!");
                }
            }

            if(choice == 3){
                System.out.println("Exiting..");
                System.exit(0);
            }
        }while(choice !=3);
    }
}