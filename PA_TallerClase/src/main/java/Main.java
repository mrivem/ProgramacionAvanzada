import com.mrivem.pa_tallerclase.controlador.ControladorP00;
import com.mrivem.pa_tallerclase.modelo.Conexion;
import com.mrivem.pa_tallerclase.modelo.OperacionUsuarios;
import com.mrivem.pa_tallerclase.modelo.Usuario;
import com.mrivem.pa_tallerclase.vista.P00_InicioSesion;

public class Main extends Conexion{
    public static void main(String[] args) {
        Usuario mod = new Usuario(0, "", "");
        OperacionUsuarios operacionesUsuario = new OperacionUsuarios();
        P00_InicioSesion frame = new P00_InicioSesion();
        
        ControladorP00 ctrl = new ControladorP00(mod,operacionesUsuario,frame);
        ctrl.iniciar();        
    }
}
