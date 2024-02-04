package com.LITIGATION.security.registration;

import com.LITIGATION.security.appUser.AppUser;
import com.LITIGATION.security.appUser.AppUserRole;
import com.LITIGATION.security.appUser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserService appUserService;
    public String register(RegistrationRequest request) {

        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email is not valid");
        }
        String token = appUserService.signUpUser(

                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER

                )
        );
        return token;
    }
}
