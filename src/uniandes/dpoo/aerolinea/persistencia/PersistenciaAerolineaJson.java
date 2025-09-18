package uniandes.dpoo.aerolinea.persistencia;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import uniandes.dpoo.aerolinea.modelo.*;

public class PersistenciaAerolineaJson implements IPersistenciaAerolinea{
	
	@Override
    public void cargarAerolinea(String archivo, Aerolinea aerolinea) {
        try (FileReader reader = new FileReader(archivo)) {
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject raiz = new JSONObject(tokener);


            aerolinea.setNombre(raiz.getString("nombre"));



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvarAerolinea(String archivo, Aerolinea aerolinea) {
        try (FileWriter writer = new FileWriter(archivo)) {
            JSONObject raiz = new JSONObject();

            raiz.put("nombre", aerolinea.getNombre());

            writer.write(raiz.toString(4)); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
	
