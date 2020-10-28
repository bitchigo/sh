package icu.bitchigo.sh.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;

import java.util.Calendar;
import java.util.Map;

public class JwtUtil {
   // @Value("${icu.jwt.secret}")
    private static String secret="bitchigo";


    public static String getToken(Map<String,String> map){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE,10);
        JWTCreator.Builder builder=JWT.create();
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        String token=builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(secret));
        return token;
    }

    public static DecodedJWT verify(String token){
        try {
            return JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
        }catch (Exception e){
            return null;
        }
    }


}
