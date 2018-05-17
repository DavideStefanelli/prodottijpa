/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author web4e
 */
@Entity
@Table(name = "negozio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Negozio.findAll", query = "SELECT n FROM Negozio n"),
    @NamedQuery(name = "Negozio.findById", query = "SELECT n FROM Negozio n WHERE n.id = :id"),
    @NamedQuery(name = "Negozio.findByNome", query = "SELECT n FROM Negozio n WHERE n.nome = :nome"),
    @NamedQuery(name = "Negozio.findByDescrizione", query = "SELECT n FROM Negozio n WHERE n.descrizione = :descrizione"),
    @NamedQuery(name = "Negozio.findByDatacreazione", query = "SELECT n FROM Negozio n WHERE n.datacreazione = :datacreazione")})
public class Negozio implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descrizione")
    private String descrizione;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datacreazione")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datacreazione;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "negozio")
    private Collection<Proprietarionegozio> proprietarionegozioCollection;

    @PrePersist
    public void onCreate(){
        datacreazione = Date.from(Instant.now());
    }
    
    public Negozio() {
    
    }

    public Negozio(Integer id) {
        this.id = id;
    }

    public Negozio(String nome, String descrizione) {
        this.nome = nome;
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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getDatacreazione() {
        return datacreazione;
    }

    public void setDatacreazione(Date datacreazione) {
        this.datacreazione = datacreazione;
    }

    @XmlTransient
    public Collection<Proprietarionegozio> getProprietarionegozioCollection() {
        return proprietarionegozioCollection;
    }

    public void setProprietarionegozioCollection(Collection<Proprietarionegozio> proprietarionegozioCollection) {
        this.proprietarionegozioCollection = proprietarionegozioCollection;
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
        if (!(object instanceof Negozio)) {
            return false;
        }
        Negozio other = (Negozio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Negozio[ id=" + id + " ]";
    }
    
}
