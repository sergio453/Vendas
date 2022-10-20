package io.github.dougllasfps;

import io.github.dougllasfps.domain.entity.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtService {

    @Value("${security.jwt.expiracao}")
    private String expiracao;

    @Value("${security.jwt.chave-assinatura}")
    private String chaveAssinatura;

    public String gerarToken(Usuario usuario){
        long expString = Long.valueOf(expiracao);
        LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(expString);
        Instant instant =  dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant();
        Date data = Date.from(instant);

        HashMap<String, Object> claims = new HasMap<>();
        claims.put("emaildousuario", "usuario@email.com");
        claims.put("roles", "ADMIN");


        return Jwts
                .builder()
                .setSubject(usuario.getLogin())         //Pegando  login do usuário...
                .setExpiration(data)
                .setClaims(claims)                      //Para inserir mais informações no token...
                .signWith(SignatureAlgorithm.HS512, chaveAssinatura)
                .compact();

    }


    public static void main(String[] args){
        ConfigurableApplicationContext contexto = SpringApplication.run(VendasApplication.class);
        JwtService service = contexto.getBean(JwtService.class);
        Usuario usuario = Usuario.builder().login("fulanolira").build();
        String token = service.gerarToken(usuario);
        System.out.println(token);

    }
}
