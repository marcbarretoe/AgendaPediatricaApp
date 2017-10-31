package py.fpuna.com.agendapediatricaapp;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import py.fpuna.com.agendapediatricaapp.dto.UsuarioDTO;

/**
 * Created by marceloe on 29/10/17.
 */

public class MostrarHijos extends LinearLayout{

    private TextView nombre;
    private TextView edad;

    private TextView sexo;


    public MostrarHijos(Context context) {
        super(context);
        inflate(context, R.layout.tivity_hijos , this);

        /**
         * Es muy importante guardar las direcciones de los elementos
         * que vayamos a cambiar pues el findViewById requiere mucho tiempo
         * y si cada vez que hacemos scroll tenemos que buscar todos los elementos
         * cargaremos inecesariamente el terminal y perderemos fluidez
         */

        nombre        = (TextView) findViewById(R.activity_hijos.nombre);
        edad        = (TextView) findViewById(R.activity_hijos.edad);
        sexo      = (TextView) findViewById(R.activity_hijos.sexo);
        //perimetro   = (TextView) findViewById(R.rectangulo.perimetro);
    }

    /**
     * Este método nos permitirá asignar los valores a los diferentes
     * componéntes gráficos según el objeto que queramos ver.
     * @param rectangulo
     */
    public void setHijos(UsuarioDTO user) {
        nombre.setText(""+user.getNombre());
        edad.setText(""+user.);
        sexo.setText(""+rectangulo.getAltura());
        //perimetro.setText(""+rectangulo.getPerimetro());
    }

}
}
