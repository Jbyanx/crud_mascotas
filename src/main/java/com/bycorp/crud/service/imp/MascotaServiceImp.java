package com.bycorp.crud.service.imp;

import com.bycorp.crud.entity.Mascota;
import com.bycorp.crud.repository.MascotaRepository;
import com.bycorp.crud.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImp implements MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;
    @Override
    public List<Mascota> obtenerTodas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota crearMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public Mascota editarMascota(Mascota mascota, Long id) {
        Mascota mascotaBD = buscarMascotaPorId(id);
        if(mascotaBD != null){
            mascotaBD.setAnimal(mascota.getAnimal());
            mascotaBD.setRaza(mascota.getRaza());
            mascotaBD.setNombre(mascota.getNombre());
            mascotaBD.setEdad(mascota.getEdad());
            return mascotaRepository.save(mascotaBD);
        }
        return null;
    }

    @Override
    public Mascota buscarMascotaPorId(Long id) {
        return mascotaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarMascota(Long id) {
        mascotaRepository.deleteById(id);
    }

    @Override
    public int contadorMascotas() {
        return (int) mascotaRepository.count();
    }
}
