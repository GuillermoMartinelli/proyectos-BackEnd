package clinica.odontologica.service.impl;

import clinica.odontologica.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
public class AppUserService implements UserDetailsService {

    private final clinica.odontologica.repositorio.UserRepository userRepository;

    @Autowired
    public AppUserService(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    public UserDetails loadUserByUsername(String email) {return userRepository.findByEmail(email).get();}
}
