
package Principal;
import Modelo.*;
import Controlador.*;
import Vista.*;

public class Inicio {

    public static void main(String[] args) {
        
     Consultas Consulta=new Consultas();
     Aplicacion_Vista Vista=new Aplicacion_Vista();
      
     Controller Control=new Controller(Consulta, Vista);
     Control.Iniciar();
     Vista.setVisible(true);
    }
    
}
