package com.jessicaespindola.bijoux.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "material")
@SequenceGenerator(name = "material_seq", sequenceName = "material_seq", allocationSize = 1)
public class Material implements Entidade {
    
    @Id
    @Column(name = "id_material")
    @GeneratedValue(generator = "material_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @NotNull(message = "{Material.codigo.NotNull}")
    @Size(min = 2, max = 20, message = "{Material.codigo.Size}")
    @Column(name = "codigo", length = 20, unique = true)
    private String codigo;
    
    @NotNull
    @Size(max = 255, message = "{Material.descricao.Size}")
    @Column(name = "descricao", length = 255)
    private String descricao;
    
    
    @NotNull
    @Size(max = 255, message = "{Material.tipo.Size}")
    @Column(name = "tipo", length = 255)
    private String tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.codigo);
        hash = 89 * hash + Objects.hashCode(this.descricao);
        hash = 89 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Material other = (Material) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Material{" + "id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + ", tipo=" + tipo + '}';
    }

}