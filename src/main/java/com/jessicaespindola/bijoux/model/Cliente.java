package com.jessicaespindola.bijoux.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;


@Entity
@Table(name = "clientes")
@SequenceGenerator(name = "clientes_seq", sequenceName = "CLIENTES_SEQ", allocationSize = 1)
public class Cliente implements Entidade {
    
    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(generator = "clientes_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @NotNull(message = "{Cliente.nome.NotNull}")
    @Size(min = 5, max = 80, message = "{Cliente.nome.Size}")
    @Column(name = "nome", length = 80)
    private String nome;
    
    @Email(message = "{Cliente.email.Email}")
    @NotNull(message = "{Cliente.email.NotNull}")
    @Size(max = 100, message = "{Cliente.email.Size}")
    @Column(name = "email", length = 80)
    private String email;

    
    @Size(min = 8, max = 20, message = "{Cliente.telefone.Size}")
    @Column(name = "telefone", length = 20)
    private String telefone;
    
    @Column(name = "documento", length = 20)
    @NotNull(message = "{Cliente.documento.NotNull}")
    @Size(min = 5, max = 18, message = "{Cliente.documento.Size}")
    private String documento;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.email);
        hash = 67 * hash + Objects.hashCode(this.telefone);
        hash = 67 * hash + Objects.hashCode(this.documento);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.documento, other.documento)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
     
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", documento=" + documento + '}';
    }
}
    
    
    
