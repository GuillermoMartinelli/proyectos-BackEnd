package clinica.odontologica.repositorio;


import clinica.odontologica.entidades.Odontologo;
import clinica.odontologica.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepositorio extends JpaRepository<Paciente, Integer> {
}
