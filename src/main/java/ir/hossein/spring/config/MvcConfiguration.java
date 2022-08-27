package ir.hossein.spring.config;

import ir.hossein.spring.repository.BookRepo;
import ir.hossein.spring.repository.UserRepo;
import ir.hossein.spring.repository.BorrowRepo;
import ir.hossein.spring.repository.impl.BookRepoImpl;
import ir.hossein.spring.repository.impl.BorrowRepoImpl;
import ir.hossein.spring.repository.impl.UserRepoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = "ir.hossein.*")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurationSupport {

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/full_lms");
        dataSource.setUsername("root");
        dataSource.setPassword("Hossein9090");

        return dataSource;
    }


    //why it work like that but did not work with @repo in bookRepoImpl ?!!

    @Bean
    public BookRepo getContactDAO() {
        return new BookRepoImpl(getDataSource());
    }

    @Bean
    public UserRepo getContactDAO1() {return new UserRepoImpl(getDataSource());}

    @Bean
    public BorrowRepo getContactDAO2() {return new BorrowRepoImpl(getDataSource());}

}

