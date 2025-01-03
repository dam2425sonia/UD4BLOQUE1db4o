
import com.db4o.*;
import com.db4o.query.Query;

public class Borrar3 
{
    public static void main(String[] args) 
    {
        Jefe j;
        Hijo h;
        ObjectContainer baseDatos=Db4oEmbedded.openFile("BDJefeHijo");

        //Consulta SODA que muestra los jefes que tienen mas de 6 años de antigüedad
        Query cons= baseDatos.query();
        cons.constrain(Jefe.class);
        cons.descend("antiguedad").constrain(6).greater();
        ObjectSet res=cons.execute();
        while (res.hasNext())
        {
            j = (Jefe)res.next();
            System.out.println("Se eliminará el jefe:" );
            j.DatosJefe();
            //Elimina los jefes
            baseDatos.delete(j);
        }
       
        System.out.println("\nInformacion de los jefes:");
        //Consulta SODA de los jefes
        cons = baseDatos.query();
        cons.constrain(Jefe.class);
        
        res = cons.execute();
        while (res.hasNext())
        {
            j = (Jefe)res.next();
            j.visDatosEmpleados();
        }
       
        System.out.println("Informacion de los hijos:");
        //Consulta SODA de los hijos
        cons = baseDatos.query();
        cons.constrain(Hijo.class);
            
        res = cons.execute();
        while (res.hasNext())
        {
            h = (Hijo)res.next();
            h.visualHijo();
        }
       
        baseDatos.close();
    }
}
