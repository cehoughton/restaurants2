import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class RestaurantTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
      assertEquals(Restaurant.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Restaurant firstRestaurant = new Restaurant("Biwa", 1);
    Restaurant secondRestaurant = new Restaurant("Biwa", 1);
    assertTrue(firstRestaurant.equals(secondRestaurant));
  }
}
