import java.io.*;
import java.util.ArrayList;

public class ControladoraArchivos implements Serializable{

    public static void crearArchivoSiNoExiste(String archivo) {
        File file = new File(archivo + ".json");
        if (!file.exists()) {
            try {
                file.createNewFile();
                FileWriter writer = new FileWriter(file);
                writer.write("[]"); // Crear un JSON vacío
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void grabar(ArrayList<Jugador> listaJugadores)
    {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try
        {
            fileOutputStream = new FileOutputStream("listajugadores.dat");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Jugador j : listaJugadores)
            {
                objectOutputStream.writeObject(j);
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally {
            try {
                if (fileOutputStream != null)
                    fileOutputStream.close();

                if (objectOutputStream != null)
                    objectOutputStream.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    public static ArrayList<Jugador> leer()
    {
        ArrayList<Jugador>listaJugadorest = new ArrayList<>();

        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try
        {
            fileInputStream = new FileInputStream("listajugadores.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);

            while (true)
            {
                Jugador aux = (Jugador) objectInputStream.readObject();
                listaJugadorest.add(aux);
            }
        }
        catch (EOFException ex)
        {
            System.out.println("FIN de ARCHIVO");
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            try
            {
                if (fileInputStream!=null)
                    fileInputStream.close();

                if (objectInputStream!=null)
                    objectInputStream.close();
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }

        }

        return listaJugadorest;
    }

}
