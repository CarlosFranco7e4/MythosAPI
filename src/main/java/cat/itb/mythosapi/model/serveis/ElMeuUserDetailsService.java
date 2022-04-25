package cat.itb.mythosapi.model.serveis;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ElMeuUserDetailsService implements UserDetailsService {
    private final ServeiUsuari serveiUsuarisUserDetails;

    public ElMeuUserDetailsService(ServeiUsuari serveiUsuarisUserDetails) {
        this.serveiUsuarisUserDetails = serveiUsuarisUserDetails;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return serveiUsuarisUserDetails.consultarPerUsername(username);
    }}
