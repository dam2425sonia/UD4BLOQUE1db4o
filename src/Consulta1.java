import com.db4o.*;
import com.db4o.query.Query;

public class Consulta1 
{
    public static void main(String[] args) 
    {
       Query cons;
       ObjectSet res;
       Jefe j;
       ObjectContainer baseDatos=Db4oEmbedded.openFile("BDJefeHijo");
       System.out.println("\n\nVamos a visualizar los datos de todos los jefes de + de 55 años con la informacion de los hijos");
       
       //Consulta SODA
       cons=baseDatos.query();
       cons.constrain(Jefe.class);
       cons.descend("edad").constrain(55).greater();
       
       res = cons.execute();
       while (res.hasNext())
       {
           j = (Jefe)res.next();
           j.visDatosEmpleados();
       }
        baseDatos.close();
    }
}
