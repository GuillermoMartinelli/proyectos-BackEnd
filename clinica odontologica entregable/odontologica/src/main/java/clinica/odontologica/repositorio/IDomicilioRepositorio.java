package clinica.odontologica.repositorio;


import clinica.odontologica.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicilioRepositorio extends JpaRepository<Domicilio, Integer> {
}
