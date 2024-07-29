
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.Controladora_persistencia;
import java.util.List;


public class Controladora_logica {
    
    Controladora_persistencia controlPersis = new Controladora_persistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String cellDuenio) {
        
        //Creamos dueño y asignamos sus valores recibidos por el constructor
        Duenio duenio = new Duenio();
   
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(cellDuenio);
        
        //Creamos mascota y asignamos sus valores
        Mascota masco = new Mascota();
        
        masco.setNombre(nombreMasco);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setRaza(raza);
        
        //Asignamos dueño a la mascota
        masco.setUnDuenio(duenio);
        
        //Enviamos a la controladora de persistencia ambos objetos
        
        controlPersis.guardar(duenio, masco);
    }

    public List<Mascota> traerMascotas() {
        
        return controlPersis.traerMascotas();
         
        
    }

    public void borrarMascota(int num_cliente) {
        
        controlPersis.borrarMascota(num_cliente);
        
    }

    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String cellDuenio) {
        
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color); 
        masco.setObservaciones(observaciones);
        masco.setAtencion_especial(atenEsp);
        masco.setAlergico(alergico);
        
        //Modificamos mascota
        controlPersis.modificarMascota(masco);
        
        //Identificamos al dueño
        
        Duenio duenio = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        duenio.setCelDuenio(cellDuenio);
        duenio.setNombre(nombreDuenio);
        
        this.modificarDuenio(duenio);
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
        
        controlPersis.modificarDuenio(duenio);
    }
}
