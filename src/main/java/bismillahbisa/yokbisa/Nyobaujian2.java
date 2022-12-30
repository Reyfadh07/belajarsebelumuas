/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bismillahbisa.yokbisa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author raiha
 */
@Entity
@Table(name = "nyobaujian2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nyobaujian2.findAll", query = "SELECT n FROM Nyobaujian2 n"),
    @NamedQuery(name = "Nyobaujian2.findById", query = "SELECT n FROM Nyobaujian2 n WHERE n.id = :id"),
    @NamedQuery(name = "Nyobaujian2.findByNama", query = "SELECT n FROM Nyobaujian2 n WHERE n.nama = :nama"),
    @NamedQuery(name = "Nyobaujian2.findByJumlah", query = "SELECT n FROM Nyobaujian2 n WHERE n.jumlah = :jumlah")})
public class Nyobaujian2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nama")
    private String nama;
    @Column(name = "jumlah")
    private Integer jumlah;

    public Nyobaujian2() {
    }

    public Nyobaujian2(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
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
        if (!(object instanceof Nyobaujian2)) {
            return false;
        }
        Nyobaujian2 other = (Nyobaujian2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bismillahbisa.yokbisa.Nyobaujian2[ id=" + id + " ]";
    }
    
}
