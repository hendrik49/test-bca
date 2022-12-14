package com.ouhamza.crup_app.model;

import lombok.Data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author <a href="https://github.com/ouhamzalhss"> Lhouceine OUHAMZA </a>
 */
@Entity
@Data
public class Nasabah {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "name field can't be empty")
    @Size(min = 4, max = 30, message = "{Size.Nasabah.name}")
    private String name;

    @NotEmpty(message = "noRekening field can't be empty")
    private String noRekening;
    private float saldo;
    private boolean status;

    @OneToMany(mappedBy="nasabah")
    private List<Transaksi> transaksi;

}
