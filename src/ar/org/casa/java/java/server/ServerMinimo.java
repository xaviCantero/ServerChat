package ar.org.casa.java.java.server;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//primero iniciar la clase ServerMinimo y luego la clase ClienteMinimo
public class ServerMinimo {
    public static void main(String[] args){
        
        //String mensaje = "<h1>Hola soy Javier</h1>";
        //cumplimos con el protocolo http para poder reenderizar en el mensaje navegador
        //mensaje = "HTTP/1.1 200 OK/n"+
        //        "Content-Length: "+mensaje.length()+"\n\n"+
        //        mensaje;
        String mensaje = "";
        mensaje += "Lunes\n";
        mensaje += "Martes\n";
        mensaje += "Miercoles\n";
        mensaje += "Jueves\n";
        mensaje += "Viernes\n";
        mensaje += "Lunes\n";
        mensaje += "Lunes\n";
        mensaje += "Primavera\n";
        mensaje += "Verano\n";
        
        //creamos la coneccion en el servidor
        try(ServerSocket ss = new ServerSocket(5000)){
            //para escuchar un mensaje de conexion constantemente, 
            //asi evitamos que una caida en el Socket apage el servidor
            while(true){
                System.out.println("Esperando coneccion...");
                
                try(    //abrimos el servidor con Socket y con el metodo accept()
                        //detenemos el hilo de ejecucion esperando
                        //hasta que un cliente establesca una conexion.
                        //Una vez establecida octenemos el objeto Socket de ese cliente.
                        Socket so = ss.accept();
                        //flujo de salida hacia el cliente
                        OutputStream out = so.getOutputStream();
                        ){
                    System.out.println("Se conecto "+so.getInetAddress());
                    //enviamos el mensaje
                    out.write(mensaje.getBytes());
                }catch(Exception ex){ex.printStackTrace();}
            }
        }catch(Exception e){e.printStackTrace();}
    
    }
}
