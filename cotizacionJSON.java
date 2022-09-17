import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class cotizacionJSON {


    public static void main(String[] args) throws Exception {
    	
    }
    
    public static String objetoString(cotizacion p) {	
    	
		JSONObject obj = new JSONObject();
        obj.put("Empresa", p.getEmpresa());
        obj.put("Dolar", p.getDolar());
        obj.put("Euro", p.getEuro());
        obj.put("Libra", p.getLibra());
        obj.put("Real", p.getReal());
        obj.put("Pesos Argentinos", p.getArg());
        obj.put("Pesos Chilenos", p.getChi());
        return obj.toJSONString();
    }
    
    
    public static cotizacion stringObjeto(String str) throws Exception {
    	cotizacion p = new cotizacion();
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(str.trim());
        JSONObject jsonObject = (JSONObject) obj;
        p.setEmpresa((String)jsonObject.get("Empresa"));
        p.setDolar((String)jsonObject.get("Dolar"));
        p.setEuro((String)jsonObject.get("Euro"));
        p.setLibra((String)jsonObject.get("Libra"));
        p.setArg((String)jsonObject.get("Real"));
        p.setChi((String)jsonObject.get("Pesos Argentinos"));
        p.setReal((String)jsonObject.get("Pesos Chilenos"));
        
        return p;
	}

}
