package pl.coderslab.charity.security;



import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dao.RoleDao;
import pl.coderslab.charity.dao.UserDao;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userRepository;
    private final RoleDao roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userRepository, RoleDao roleRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findByUserName(String name) {
        return userRepository.findByName(name);
    }


    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setPassword2(user.getPassword());
//        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
}