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

  @Test
  public void save_returnsTrueIfDescriptionsAretheSame() {
    Restaurant myRestaurant = new Restaurant("Biwa", 1);
    myRestaurant.save();
    assertTrue(Restaurant.all().get(0).equals(myRestaurant));
  }

  @Test
  public void save_assingsIdToObject() {
    Restaurant myRestaurant = new Restaurant("Biwa", 1);
    myRestaurant.save();
    Restaurant savedRestaurant = Restaurant.all().get(0);
    assertEquals(myRestaurant.getId(), savedRestaurant.getId());
  }

  @Test
  public void find_findsRestaurantInDatabase_true() {
    Restaurant myRestaurant = new Restaurant("Biwa", 1);
    myRestaurant.save();
    Restaurant savedRestaurant = Restaurant.find(myRestaurant.getId());
    assertTrue(myRestaurant.equals(savedRestaurant));
  }

  // @Test
  // public void delete_deleteRestaurantInDatabase_true() {
  //   Restaurant myRestaurant = new Restaurant("Biwa", 1);
  //   myRestaurant.save();
  //   myRestaurant.deleteRestaurant();
  //   assertEquals(Restaurant.all().size(), 0);
  // }
}
