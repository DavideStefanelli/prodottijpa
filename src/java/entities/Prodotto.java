/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author web4e
 */
@Entity
@Table(name = "prodotto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prodotto.findAll", query = "SELECT p FROM Prodotto p"),
    @NamedQuery(name = "Prodotto.findById", query = "SELECT p FROM Prodotto p WHERE p.id = :id"),
    @NamedQuery(name = "Prodotto.findByNome", query = "SELECT p FROM Prodotto p WHERE p.nome = :nome")})
public class Prodotto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome")
    private String nome;
    @Lob
    @Size(max = 65535)
    @Column(name = "descrizione")
    private String descrizione;
    @Lob
    @Size(max = 65535)
    @Column(name = "immagine")
    private String immagine;
    @JoinColumn(name = "cat_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categoria catId;

    public Prodotto() {
    }

    public Prodotto(Integer id) {
        this.id = id;
    }

    public Prodotto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public Prodotto(String nome, String descrizione, Categoria c) {
        this.nome = nome;
        this.catId = c;
    }

    public Prodotto(String nome, String descrizione, Categoria c, String immagine) {
        this.nome = nome;
        this.catId = c;
        this.immagine = immagine;
        this.descrizione = descrizione;
    }
     
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCatId() {
        return catId;
    }

    public void setCatId(Categoria catId) {
        this.catId = catId;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prodotto)) {
            return false;
        }
        Prodotto other = (Prodotto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Prodotto[ id=" + id + " ]";
    }
    
}
