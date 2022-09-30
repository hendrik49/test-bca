package com.ouhamza.crup_app.service;

import com.ouhamza.crup_app.dao.NasabahRepo;
import com.ouhamza.crup_app.model.Nasabah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="https://github.com/ouhamzalhss"> Lhouceine OUHAMZA </a>
 */

@Service
public class NasabahService {

    @Autowired
    private NasabahRepo nasabahRepo;

    public List<Nasabah> getAll(){
        return nasabahRepo.findAll();
    }

    public void save(Nasabah nasabah){
        nasabahRepo.save(nasabah);
    }


    public Nasabah get(long id) {
        return nasabahRepo.findById(id).get();
    }

    public void delete(long id) {
        nasabahRepo.deleteById(id);
    }
}
