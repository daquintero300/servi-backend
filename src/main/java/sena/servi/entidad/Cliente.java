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
@Data
@ToString
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCliente;
    String estado;
    String tipo_documento;
    Integer numero_documento;
    String nombre;
    String apellido;
    String fecha_nacimiento;
    String telefono;
    String email;
    String contrasena;

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", estado='" + estado + '\'' +
                ", tipo_documento='" + tipo_documento + '\'' +
                ", numero_documento=" + numero_documento +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public Integer getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(Integer numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
