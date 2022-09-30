package com.ouhamza.crup_app.dao;

import com.ouhamza.crup_app.model.Nasabah;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Hendrik
 */
@Repository
public interface NasabahRepo extends JpaRepository<Nasabah, Long> {

    Page<Nasabah> findByNameContains(String name, Pageable pageable);

}
