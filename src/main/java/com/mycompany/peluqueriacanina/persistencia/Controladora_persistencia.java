
package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controladora_persistencia {
    
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascoJpa = new MascotaJpaController();

    //Altas
    public void guardar(Duenio duenio, Mascota masco) {
        //Crear en la BD el dueño
        duenioJpa.create(duenio);
        
        //Crear en la BD la mascota
        mascoJpa.create(masco);
    }
    
    //Recupera todos los registros de mascotas de la BD para las consultas
    public List<Mascota> traerMascotas() {
        
        return mascoJpa.findMascotaEntities();
        
    }
    
    //Bajas
    public void borrarMascota(int num_cliente) {
        
        try {
            mascoJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controladora_persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public Mascota traerMascota(int num_cliente) {
        
        return mascoJpa.findMascota(num_cliente);
        
    }
    
    //Editar registro
    public void modificarMascota(Mascota masco) {
        
        try {
            mascoJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(Controladora_persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Duenio traerDuenio(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio duenio) {
        try {
            duenioJpa.edit(duenio);
        } catch (Exception ex) {
            Logger.getLogger(Controladora_persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
