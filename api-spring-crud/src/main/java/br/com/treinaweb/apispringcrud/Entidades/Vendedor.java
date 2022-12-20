package br.com.treinaweb.apispringcrud.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVendedor;

    @Column(nullable = false, length = 100)
    private String nomeVendedor;

    @Column(nullable = false, unique = true)
    private String vendasRealizadas;

    public Vendedor() {
    }

    public String getNome() {
        return nomeVendedor;
    }

    public Long getIdVendedor(Long idVendedor) {
        return idVendedor;
    }

    public void SetIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public Long getVendasRealizadas(Long vendasRealizadas) {
        return vendasRealizadas;
    }

    public void setVendasRealizadas(Long vendasRealizadas) {
        this.vendasRealizadas = vendasRealizadas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idVendedor == null) ? 0 : idVendedor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vendedor other = (Vendedor) obj;
        if (idVendedor == null) {
            if (other.idVendedor != null)
                return false;
        } else if (!idVendedor.equals(other.idVendedor))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Vendedor [id do Vendedor=" + idVendedor + ", Nome do Vendedor=" + nomeVendedor + "]";
    }

}
