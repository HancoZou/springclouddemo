package pers.hanco.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Hanco on 2019/6/18
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
