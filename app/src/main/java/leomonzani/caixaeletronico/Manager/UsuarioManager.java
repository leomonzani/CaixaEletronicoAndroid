package leomonzani.caixaeletronico.Manager;

import android.content.Context;

import java.util.ArrayList;

import leomonzani.caixaeletronico.Bean.Usuario;
import leomonzani.caixaeletronico.Utils.DSSharePreferenceUtility;

/**
 * Created by araga on 04/10/2016.
 */

public class UsuarioManager {
    private final String KEY_USUARIOS="usuarios";

    public ArrayList<Usuario> getListaUsuarios(Context context){
        ArrayList<Usuario> listaUsuarios = ((ArrayList<Usuario>) DSSharePreferenceUtility.readObjectFromFile(context, KEY_USUARIOS));
        if(listaUsuarios==null){
            listaUsuarios = new ArrayList<Usuario>();
        }
        return listaUsuarios;
    }

    public boolean addNewUsuario(Usuario usuario, Context context){
        try{
            ArrayList<Usuario> listaUsuarios = getListaUsuarios(context);
            listaUsuarios.add(usuario);
            DSSharePreferenceUtility.writeObjectToFile(context,listaUsuarios,KEY_USUARIOS);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
