import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {

    final static Double sueldo = (Double) 2000.0;

    public static void main(String[] args) throws JSONException {


        Coleccion<String, Jugador> tablaColorOjos = new Coleccion<>("Tabla Ojos");
        Coleccion<String, Jugador> tablaPosicion = new Coleccion<>("Tabla Posiciones");

        ArrayList<Jugador>jugadores=null;
        ArrayList<Jugador>jugadoresxSueldo=new ArrayList<>();
        try{
          jugadores =Jugador.FromJson("jugadores");

          for(Jugador j: jugadores){
              tablaColorOjos.agregar(j.getOjosColor(),j);
              tablaPosicion.agregar(j.getPosicion(),j);

              String balance2=j.getSueldo().trim();
              Double balance= (Double) Double.parseDouble(balance2);

              if(balance>sueldo){

                    jugadoresxSueldo.add(j);
              }
          }
        }
        catch (JSONException e){
            System.out.println("hay un error");
            e.printStackTrace();
        }


        Iterator <Map.Entry<String, List<Jugador>>>iterator = tablaPosicion.obtener().entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, List<Jugador>> entry = iterator.next();
            System.out.printf("Clave: %s Valor: %s%n", entry.getKey(), entry.getValue().toString());
        }

       try{
            int cantidad=tablaPosicion.contar2(Posicion.tanque.toString(),4);

           System.out.println("cantidad de jugadores con dicho color "+cantidad);
       }catch (ExceedLimitException e){
           System.out.println(e.getMessage());
       }

       ControladoraArchivos.grabar(jugadoresxSueldo);

       ArrayList<Jugador>listaNueva=ControladoraArchivos.leer();
        System.out.println(listaNueva);
    }
}