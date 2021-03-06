
package java12;

/**
 *
 * @author Fredo
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;


public class AddressBook {
    
    HashMap<String, String> addressBook = new HashMap<>();
    File file = new File("D:\\Archivo.txt");
    
    public void save(){
        String phone;
        String name;
        String contacts="";
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            
            
            if(!addressBook.entrySet().isEmpty()){
                for(Map.Entry<String,String> entry:addressBook.entrySet()){
                    phone = entry.getKey();
                    name = entry.getValue();
                    contacts+= phone+","+name+"\r\n";
                }
            }
            
            BufferedWriter fileToSave = new BufferedWriter(
                    new OutputStreamWriter
                        (new FileOutputStream(file, false),"utf-8"));
           
            fileToSave.write(contacts);
            
            fileToSave.close();
            
        } catch(Exception e){
            System.out.println("save(): " + e.getMessage());
        } 
    }
    
    public void load(){
        try{
            if(file.exists()){
              
                BufferedReader loadedFile = new BufferedReader(new FileReader(file));
                String lineaActual;
                
                while((lineaActual = loadedFile.readLine())!=null){
                    String[]contacto = lineaActual.split(",");
                    addressBook.put(contacto[0], contacto[1]);
                }
              
                loadedFile.close();
            }
            
        } catch (Exception e){
            System.out.println("load(): " + e.getMessage());
        }
    }

    public AddressBook() {
    }
    
    public void create(String phone, String name){
        if (!addressBook.containsKey(phone)){
            addressBook.put(phone, name);
            System.out.printf("\n%s%s%s", "Se agreg?? a ", name,
                    " a los contactos");
        } else {
            System.out.println("\nYa existe ese contacto");
        }
    }
    
    public void list(){
        if(addressBook.entrySet().isEmpty()){
            System.out.println("\nNo tienes contactos agregados");
        } else {
            System.out.println("Contactos: ");
            for(Map.Entry<String,String> entry:addressBook.entrySet()){
                System.out.printf("\n%s%s%s", entry.getKey(),
                        ": ",entry.getValue());
            }
        }
    }
    
    public void delete(String phone){
        if(addressBook.containsKey(phone)){
            System.out.printf("\n%s%s%s","Se ha eliminado a ",
                    addressBook.get(phone), " de tus contactos");
            addressBook.remove(phone);
        } else if (addressBook.entrySet().isEmpty()){
            System.out.println("\nNo tienes contactos agregados");
        } else {
            System.out.println("\nEse n??mero no est?? en tus contactos");
        }
    }
    
}
