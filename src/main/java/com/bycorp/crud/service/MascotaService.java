package com.bycorp.crud.service;

import com.bycorp.crud.entity.Mascota;

import java.util.List;

public interface MascotaService {
    List<Mascota> obtenerTodas();
    Mascota crearMascota(Mascota mascota);
    Mascota editarMascota(Mascota mascota, Long id);
    Mascota buscarMascotaPorId(Long id);
    void eliminarMascota(Long id);
    int contadorMascotas();
}
