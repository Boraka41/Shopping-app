package com.example.shopping.Service;

import com.example.shopping.Entity.Authorities;
import com.example.shopping.Entity.User;
import com.example.shopping.Repository.AuthoritiesRepository;
import com.example.shopping.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthoritiesRepository authoritiesRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, AuthoritiesRepository authoritiesRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authoritiesRepository = authoritiesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(User user) {
        // Şifreyi encode et
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);

        // Kullanıcıyı kaydet
        userRepository.save(user);

        // Kullanıcıyı authorities tablosuna ekle
        Authorities authority = new Authorities();
        authority.setUsername(user.getUsername());
        authority.setAuthority("ROLE_USER"); // Varsayılan yetki
        authority.setUser(user);

        authoritiesRepository.save(authority);
    }
}
