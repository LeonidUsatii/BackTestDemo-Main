package de.ait.todo.security.details;

import de.ait.todo.models.User;
import de.ait.todo.repositories.UsersRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 22.06.2022
 * 26. Spring Boot REST
 *
 * @author Sidikov Marsel (Akvelon)
 * @version v1.0
 */
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        System.out.println(email);

        System.out.println("Leo-User-Auto");

        User user = usersRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User <" + email + "> not found"));
        System.out.println("Получаем юзера");
        System.out.println(user);
        System.out.println(user.getUserName());

        AuthenticatedUser user1 = new AuthenticatedUser(user);

        System.out.println(user1);
        user1.isAuthenticated();

        //user1.getAuthorities(user1.)

        System.out.println(user1.isAuthenticated());

        System.out.println(user1.getAuthorities());



        return new AuthenticatedUser(user);
    }
}
