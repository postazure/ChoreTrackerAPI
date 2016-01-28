//package com.postazure.models.user;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by postazure on 1/27/16.
// */
//
//@Transactional(readOnly = true)
//public class CustomUserDetailsService implements UserDetailsService {
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        UserDetails springUser;
//
//        try {
//            User dbUser = userRepository.findFirstByEmail(email);
//            List<SimpleGrantedAuthority> authorities = getAuthorities(dbUser.getAccessLevel());
//            springUser = new User(dbUser.getEmail(), dbUser.getPassword(), authorities);
//
//        } catch (Exception e) {
//            throw new UsernameNotFoundException("Error finding existing user with email: " + email);
//        }
//
//        return springUser;
//    }
//
//    public List<SimpleGrantedAuthority> getAuthorities(int accessLevel) {
//        List<SimpleGrantedAuthority> authList = new ArrayList<SimpleGrantedAuthority>(1);
//        // All users are granted with ROLE_USER access
//        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
//
////        if ( accessLevel > 0 ) {
////            authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
////        }
//
//        return authList;
//    }
//}
