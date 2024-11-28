package hiber;//package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User masha = new User("Masha", "Orlova", "masha@mail.ru");
      User dima = new User("Dima", "Rostov", "dima@mail.ru");
      User max = new User("Max", "Petrov", "max@mail.ru");
      User inna  = new User("Inna", "Rosina", "inna@mail.ru");

      Car kia = new Car("KIA",111);
      Car audi = new Car("AUDI",222);
      Car ford = new Car("FORD",333);
      Car honda = new Car("HONDA",444);

      userService.add(masha.setCar(kia).setUser(masha));
      userService.add(inna.setCar(audi).setUser(inna));
      userService.add(max.setCar(ford).setUser(max));
      userService.add(dima.setCar(honda).setUser(dima));

         List<User> users = userService.listUsers();
         for (User user : users) {
            System.out.println("_________________________________ ");
            System.out.println(user);

         }

      System.out.println("_________________________________ ");
      try {
      System.out.println(" CAR  KIA  111 ?");
      System.out.println(userService.getUserByCar("KIA",111));
      System.out.println("_________________________________ ");
      System.out.println(" CAR  AUDI  222 ?");
      System.out.println(userService.getUserByCar("AUDI",222));
      System.out.println("_________________________________ ");
      System.out.println(" CAR  KIA  333 ?");

         User nemo = userService.getUserByCar("KIA",333);

      } catch (Exception e) {
         System.out.println("THERE IS NO SUCH CAR IN THE DATABASE");
      }
      System.out.println("_________________________________ ");
      context.close();
   }
}