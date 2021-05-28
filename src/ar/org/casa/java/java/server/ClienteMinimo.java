package ar.org.casa.java.java.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

//primero iniciar la clase ServerMinimo y luego esta ClienteMinimo
public class ClienteMinimo {
    public static void main(String[] args){
        try(    //Establecemos la conexion con el servidor 
                //Socket so = new Socket("localhost", 5000);
                //flujo de entrada del servidor
                //InputStream in = so.getInputStream();
                
                //conetamos y leemos el flujo de entrada del servidor
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                new Socket("localhost", 5000).getInputStream()));
            ){
            //obetenemos el vector del mensaje y lo almacenamos en bytes
            //byte[] bytes = in.readAllBytes();
            //recorremos el vector de bytes y lo pasamos a caracter
            //for(byte b:bytes){System.out.print(Character.toString(b));}
            
            //con BufferedReader
            //utilizando lines() me devuelve un Stream (jdk 8)o mas. Recorremos el flujo de entrada del servidor
            //in.lines().forEach(System.out::println);
            
            //filtramos todas las palabras que contengan lu
            //in.lines().filter(l->l.toLowerCase().contains("lu")).forEach(System.out::println);
            
            //ordenamos alfabeticamente
            in.lines().sorted().forEach(System.out::println);
        }catch(Exception e){e.printStackTrace();}
    
    }
}
