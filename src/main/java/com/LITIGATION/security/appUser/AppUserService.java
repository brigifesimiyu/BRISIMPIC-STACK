package com.LITIGATION.security.appUser;

import com.LITIGATION.security.registration.token.ConfirmationToken;
import com.LITIGATION.security.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;
    private final static  String USER_NOT_FOUND_MSG = "user with email %s not found";
    private  final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public  String signUpUser(AppUser appUser){
        boolean userExists = appUserRepository.findByEmail((appUser.getEmail()))
                .isPresent();
        if (userExists){
            throw new IllegalStateException("Email already taken");
        }

        String encryptedPassword =  bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encryptedPassword);

        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();
        // TODO: Send confirmation token

        ConfirmationToken confirmtoken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(confirmtoken);

        // TODO SEND EMAIL

        return token;
    }

}
