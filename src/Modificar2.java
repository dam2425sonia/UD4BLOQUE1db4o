import com.db4o.*;
import com.db4o.query.Query;

public class Modificar2 
{

    public static void main(String[] args) 
    {
        Jefe j;
        ObjectSet res;
        ObjectContainer baseDatos=Db4oEmbedded.openFile("BDJefeHijo");
        
        //Consulta SODA para seleccionar al jefe Miguel
        Query cons= baseDatos.query();
        cons.constrain(Jefe.class);
        cons.descend("nombre").constrain("Miguel");
        
        res = cons.execute();
        while (res.hasNext())
        {
            j = (Jefe)res.next();
            //Actualización del jefe
            j.cumpleAños();
            baseDatos.store(j);
        }
       
        //Consulta SODA para sacar información de los jefes
        System.out.println("Información de los jefes:");
        cons = baseDatos.query();
        cons.constrain(Jefe.class);
        
        res = cons.execute();
        while (res.hasNext())
        {
            j = (Jefe)res.next();
            j.visDatosEmpleados();
        }
        baseDatos.close();
    }
}
