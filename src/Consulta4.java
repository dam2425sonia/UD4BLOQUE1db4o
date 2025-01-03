

import com.db4o.*;
import com.db4o.query.Query;


public class Consulta4 
{

    public static void main(String[] args) 
    {
       Query con;
       Hijo h;
       ObjectSet cons;
       ObjectContainer baseDatos=Db4oEmbedded.openFile("BDJefeHijo");
       
       System.out.println("\n\nVamos a visualizar los datos de todos los jefes(con la informacion de los hijos):");
       //Consulta QBE
       ObjectSet res = baseDatos.queryByExample(new Jefe (null,0,0,null));
       while (res.hasNext())
       {
           Jefe j = (Jefe)res.next();
           j.visDatosEmpleados();
       }
       
        System.out.println("Visualizacion de los hijos de los jefes:");
        ////Consulta con el API SODA
        con = baseDatos.query();
        con.constrain(Hijo.class);
        cons=con.execute();
        while (cons.hasNext())
        {
            h=(Hijo)cons.next();
            h.visualHijo();
        }
        baseDatos.close();
    }
}
