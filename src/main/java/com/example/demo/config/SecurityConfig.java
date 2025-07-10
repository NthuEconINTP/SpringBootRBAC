package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 關閉 CSRF（API 用）
            .csrf(csrf -> csrf.disable())
            // 設定授權規則
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/register", "/swagger-ui/**", "/v3/api-docs/**").permitAll() // 註冊與Swagger放行
                .anyRequest().authenticated() // 其他路徑都需驗證
            )
            // 設定 session 為無狀態（JWT）
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            // 你可能還會加入 JWT Filter，這邊就先不示範了
            ;
        return http.build();
    }

    // 如果需要 AuthenticationManager，可寫下面這段
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}

