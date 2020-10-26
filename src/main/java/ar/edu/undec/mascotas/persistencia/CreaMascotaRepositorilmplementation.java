package ar.edu.undec.mascotas.persistencia;

import ar.edu.undec.mascotas.core.doamain.Mascota;
import ar.edu.undec.mascotas.persistencia.crud.ICrearMascotaCRUD;
import ar.edu.undec.mascotas.persistencia.entity.MascotaEntity;
import ar.edu.undec.mascotas.core.repositorio.ICrearMascotaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreaMascotaRepositorilmplementation implements ICrearMascotaRepositorio {

    @Autowired
    ICrearMascotaCRUD crearMascotaCRUD;

    @Override
    public boolean existe(String nombreMascota) {
        return false;
    }


    @Override
    public boolean guardarMascota(Mascota laMascota) {
        MascotaEntity mascotaBD = new MascotaEntity();
        mascotaBD.setNombre(laMascota.getNombre());
        mascotaBD.setFechaNacimiento(laMascota.getFechaNacimiento());
        mascotaBD.setRaza(laMascota.getRaza());

        return this.crearMascotaCRUD.save(mascotaBD).getIdMascota()!=null;
    }
}