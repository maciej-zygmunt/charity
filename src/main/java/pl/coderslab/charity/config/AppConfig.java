package pl.coderslab.charity.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@ComponentScan("pl.coderslab")
public class AppConfig implements WebMvcConfigurer {


        @Bean
        @Description("Thymeleaf template resolver serving HTML 5")
        public ClassLoaderTemplateResolver templateResolver() {

            var templateResolver = new ClassLoaderTemplateResolver();

            templateResolver.setPrefix("templates/");
            templateResolver.setCacheable(false);
            templateResolver.setSuffix(".html");
            templateResolver.setTemplateMode("HTML5");
            templateResolver.setCharacterEncoding("UTF-8");

            return templateResolver;
        }

        @Bean
        @Description("Thymeleaf template engine with Spring integration")
        public SpringTemplateEngine templateEngine() {

            var templateEngine = new SpringTemplateEngine();
            templateEngine.setTemplateResolver(templateResolver());

            return templateEngine;
        }

        @Bean
        @Description("Thymeleaf view resolver")
        public ViewResolver viewResolver() {

            var viewResolver = new ThymeleafViewResolver();

            viewResolver.setTemplateEngine(templateEngine());
            viewResolver.setCharacterEncoding("UTF-8");

            return viewResolver;
        }

        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/").setViewName("index");
        }

}
