import json.JsonUtiles;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Jugador implements Serializable {

    private String nombre;
    private String apellido;
    private int edad;
    private  String email;
    private String posicion;
    private boolean isActive;
    public String sueldo;



    public String ojosColor;

    public Jugador(String nombre, String apellido, int edad, String email, String posicion,String sueldo,String ojosColor) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
        this.posicion = posicion;
        this.sueldo=sueldo;
        this.isActive=true;
        this.ojosColor=ojosColor;
    }


    public String getOjosColor() {
        return ojosColor;
    }

    public String getPosicion() {
        return posicion;
    }

    public String getSueldo() {
        return sueldo;
    }



    public static ArrayList<Jugador> FromJson(String archivo) throws JSONException {

        JSONArray jsonArray=new JSONArray(JsonUtiles.leer(archivo));

        ArrayList<Jugador>jugadores=new ArrayList<>();

        for(int i=0;i<jsonArray.length();i++){

            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

            int age=(jsonObject1.getInt("age"));
            String email=(jsonObject1.getString("email"));
            String ojosColor=(jsonObject1.getString("eyeColor"));
            boolean isActivo=(jsonObject1.getBoolean("isActive"));
            String sueldo=(jsonObject1.getString("balance"));
            String posicion=(jsonObject1.getString("position"));

            JSONObject jsonObject2=(jsonObject1.getJSONObject("name"));

            String nombre=(jsonObject2.getString("first"));
            String apellido=(jsonObject2.getString("last"));
            Jugador jugador=new Jugador(nombre,apellido,age,email,posicion,sueldo,ojosColor);

            jugadores.add(jugador);
        }
        return jugadores;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", email='" + email + '\'' +
                ", posicion='" + posicion + '\'' +
                ", isActive=" + isActive +
                ", sueldo='" + sueldo + '\'' +
                ", ojosColor='" + ojosColor + '\'' +
                '}';
    }



    public String infoAcotada(){
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido ;
    }
}
