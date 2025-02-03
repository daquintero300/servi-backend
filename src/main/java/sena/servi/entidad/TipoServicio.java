package sena.servi.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class TipoServicio {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer idTipoServicio;
    String tipoServicio;
    String prestador;
    String niu;
    Integer idInmueble;
    Integer idCliente;

    @Override
    public String toString() {
        return "TipoServicio{" +
                "idTipoServicio=" + idTipoServicio +
                ", tipoServicio='" + tipoServicio + '\'' +
                ", prestador='" + prestador + '\'' +
                ", niu='" + niu + '\'' +
                ", idInmueble=" + idInmueble +
                ", idCliente=" + idCliente +
                '}';
    }

    public Integer getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getPrestador() {
        return prestador;
    }

    public void setPrestador(String prestador) {
        this.prestador = prestador;
    }

    public String getNiu() {
        return niu;
    }

    public void setNiu(String niu) {
        this.niu = niu;
    }

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
}
