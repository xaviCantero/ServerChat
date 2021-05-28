package ar.org.casa.java.server.chat;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapaDirecciones {
    
    public static Map<String,String>getMapa(){
        Map<String,String> map = new LinkedHashMap();
        map.put("Javier", "192.168.100.2");
        map.put("Lourdes", "192.168.100.50");
        //introdusca su nombre y su ip
        map.put("Yo", "127.0.0.1");
        
        return map;
    }
}
