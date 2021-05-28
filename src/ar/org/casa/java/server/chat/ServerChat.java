package ar.org.casa.java.server.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;

public class ServerChat implements Runnable{
    private JTextArea txa;
    private static String ip;
    private static String user;
    
    public ServerChat(JTextArea txa){
        this.txa = txa;
    }
    
    @Override
    public void run() {
        try ( ServerSocket ss = new ServerSocket(6000);) {
            while(true){
            try (
                     Socket so = ss.accept();  
                    BufferedReader in = 
                            new BufferedReader(
                                    new InputStreamReader(so.getInputStream()));) {
                ip = "";
                user = "";
                    
                try {
                    ip = so.getInetAddress().getHostAddress();
                } catch (Exception exx) {
                    exx.printStackTrace();
                }

                String mensaje = in.readLine();
                MapaDirecciones.getMapa().forEach((k, v) -> {
                    if (v.equals(ip)) {
                        user = k;
                    }
                });
                txa.append(user + ": " + mensaje + "\n");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
