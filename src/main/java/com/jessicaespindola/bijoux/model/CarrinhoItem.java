package com.jessicaespindola.bijoux.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "carrinho_item")
@SequenceGenerator(name = "carrinho_item_seq", sequenceName = "carrinho_item_seq", allocationSize = 1)
public class CarrinhoItem implements Entidade {
    
    @Id
    @Column(name = "id_carrinho_item")
    @GeneratedValue(generator = "carrinho_item_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_peca")
    private Peca peca;

    @NotNull
    @Digits(integer = 10, fraction = 5)
    @Column(name = "valorUnitario", precision = 15, scale = 5)
    private BigDecimal valorUnitario;
    
    @NotNull
    @Digits(integer = 10, fraction = 5)
    @Column(name = "quantidade", precision = 15, scale = 5)
    private BigDecimal quantidade;

    @NotNull
    @Digits(integer = 10, fraction = 5)
    @Column(name = "valorTotal", precision = 15, scale = 5)
    private BigDecimal valorTotal;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.peca);
        hash = 13 * hash + Objects.hashCode(this.valorUnitario);
        hash = 13 * hash + Objects.hashCode(this.quantidade);
        hash = 13 * hash + Objects.hashCode(this.valorTotal);
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
        final CarrinhoItem other = (CarrinhoItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.peca, other.peca)) {
            return false;
        }
        if (!Objects.equals(this.valorUnitario, other.valorUnitario)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.valorTotal, other.valorTotal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CarrinhoItem{" + "id=" + id + ", peca=" + peca + ", valorUnitario=" + valorUnitario + ", quantidade=" + quantidade + ", valorTotal=" + valorTotal + '}';
    }

    
    
    
    
    
}
