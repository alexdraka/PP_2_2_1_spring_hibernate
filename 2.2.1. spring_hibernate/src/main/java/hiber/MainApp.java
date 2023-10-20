package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User5", "Lastname5", "user5@mail.ru", new Car("model1", 1234567890)));
      userService.add(new User("User6", "Lastname6", "user6@mail.ru", new Car("model2", 1234567891)));
      userService.add(new User("User7", "Lastname7", "user7@mail.ru", new Car("model3", 1234567892)));
      userService.add(new User("User8", "Lastname8", "user8@mail.ru", new Car("model4", 1234567893)));

      System.out.println(userService.listUsers());
      System.out.println(userService.getUserByCar("model2", 1234567891));

      context.close();
   }
}
