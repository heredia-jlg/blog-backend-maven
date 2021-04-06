package com.jlgh.blog;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;




@Configuration
@EnableMongoRepositories
public class AppConfig{

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create( System.getenv("BLOG_MONGO_URI") );
    }

    @Configuration
    public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.cors().and().csrf().disable().authorizeRequests()
                    .antMatchers(HttpMethod.GET,"/posts/showAll").permitAll()
                    .antMatchers(HttpMethod.POST, "/posts/insertPost").permitAll();
        }
        
    }




}


