package sena.servi.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idServicio;
    Integer niu;
    String tipoServicio;
    String prestador;
    String estado;
    String fechaGeneracion;
    String fechaLimite;
    String valor;
    Integer idInmueble;
    Integer IdCliente;

    @Override
    public String toString() {
        return "Servicio{" +
                "idServicio=" + idServicio +
                ", niu=" + niu +
                ", tipoServicio='" + tipoServicio + '\'' +
                ", prestador='" + prestador + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaGeneracion='" + fechaGeneracion + '\'' +
                ", fechaLimite='" + fechaLimite + '\'' +
                ", valor='" + valor + '\'' +
                ", idInmueble=" + idInmueble +
                ", IdCliente=" + IdCliente +
                '}';
    }

    public Integer getNiu() {
        return niu;
    }

    public void setNiu(Integer niu) {
        this.niu = niu;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(String fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Integer getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Integer idCliente) {
        IdCliente = idCliente;
    }
}
