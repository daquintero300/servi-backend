package sena.servi.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Inmueble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idInmueble;
    String estado;
    Integer idCliente;
    String pais;
    String departamento;
    String ciudad;
    String direccion;

    @Override
    public String toString() {
        return "Inmueble{" +
                "idInmueble=" + idInmueble +
                ", estado='" + estado + '\'' +
                ", idCliente=" + idCliente +
                ", pais='" + pais + '\'' +
                ", departamento='" + departamento + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
