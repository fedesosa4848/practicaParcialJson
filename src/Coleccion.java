import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coleccion  <K,V>{

    private String nombre;
    private Map<K, List<V>> coleccion;

    public  Coleccion(String nombre)
    {
        this.nombre = nombre;
        this.coleccion=new HashMap<>();
    }

    public void agregar(K clave, V valor) {
        if (!coleccion.containsKey(clave)){
            coleccion.put(clave,new ArrayList<>());
        }
        coleccion.get(clave).add(valor);
    }

    public Map<K,List<V>> obtener() {
        return coleccion;
    }



    // Cuenta el número de valores asociados con cada clave
   public Map<K, Integer> contar() {
        Map<K, Integer> conteo = new HashMap<>();
        for (Map.Entry<K, List<V>> entry : coleccion.entrySet()) {
            conteo.put(entry.getKey(), Integer.valueOf(entry.getValue().size()));
        }
        return conteo;
    }



    public int  contar2(String clave,int cantidad) throws ExceedLimitException {

        int dif=0;
        int contadora=0;
        List<V> jugadores=new ArrayList<>();

        for (Map.Entry<K, List<V>> entry : coleccion.entrySet()) {
            String dato=entry.getKey().toString();
            if(dato.equalsIgnoreCase(clave)){
                jugadores=entry.getValue();
                contadora=jugadores.size();

            }
        }
       if(jugadores.size()<cantidad)
       {

           dif=cantidad-jugadores.size();
           throw new ExceedLimitException("La diferencia entre la cantidad enviada por parametro (" +cantidad+ ") es superior a la real ("+jugadores.size()+ ") de jugadores de la tabla: "+nombre+" , la clave a analizar es "+clave+". La diferencia es de "+ dif);
       }

        return contadora;
    }

    public void addPlayer(K key, V player) {
        coleccion.computeIfAbsent(key, k -> new ArrayList<>()).add(player);
    }


}
