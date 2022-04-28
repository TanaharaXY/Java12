/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java12;

import java.util.Scanner;

/**
 *
 * @author Fredo
 */
public class Java12 {

        public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        boolean end = false;
        AddressBook addressBook = new AddressBook();
        addressBook.load();
        while (!end){
            System.out.printf("\n\n%s\n%s\n%s\n%s\n%s\n\n%s",
                    "======== MENÚ ========","1. Mostrar todos los contactos",
                    "2. Crear nuevos contactos", "3. Borrar un contacto",
                    "4. Salir", "¿Qué deseas hacer? ");
            switch(s.nextInt()){
                case 1:
                    addressBook.list();
                    break;
                case 2:
                    System.out.print("\nIngresa el teléfono: ");
                    String phone = s.next();
                    System.out.print("Ingresa el nombre: ");
                    String name = s.next();
                    addressBook.create(phone, name);
                    break;
                case 3:
                    System.out.print("\nIngresa el teléfono: ");
                    String contact = s.next();
                    addressBook.delete(contact);
                    break;
                case 4:
                    System.out.println("\nCerrar");
                    addressBook.save();
                    end = true;
                    break;
                default:
                    System.out.println("Opcion incorrecta, intente de nuevo");
                    break;
            }
        }
        
    }
    
}
