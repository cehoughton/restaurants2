import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

public class CuisineTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
      assertEquals(Cuisine.all().size(), 0);
  }


@Test
 public void equals_returnsTrueIfNamesAretheSame() {
   Cuisine firstCuisine = new Cuisine("fusion");
   Cuisine secondCuisine = new Cuisine("fusion");
   assertTrue(firstCuisine.equals(secondCuisine));
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Cuisine myCuisine = new Cuisine("fusion");
    myCuisine.save();
    assertTrue(Cuisine.all().get(0).equals(myCuisine));
  }

  @Test
  public void find_findCuisineInDatabase_true() {
    Cuisine myCuisine = new Cuisine("fusion");
    myCuisine.save();
    Cuisine savedCuisine = Cuisine.find(myCuisine.getId());
    assertTrue(myCuisine.equals(savedCuisine));
  }

  @Test
  public void delete_deleteCuisineInDatabase_true() {
    Cuisine myCuisine = new Cuisine("fusion");
    myCuisine.save();
    myCuisine.delete();
    assertEquals(Cuisine.all().size(), 0);
  }

  // @Test
  // public void getRestaurants_retrievesAllRestaurantsFromDatabase_restaurantsList() {
  //   Cuisine myCuisine = new Cuisine("Household chores");
  //   myCuisine.save();
  //   Restaurant firstRestaurant = new Restaurant("Mow the lawn", myCuisine.getId());
  //   firstRestaurant.save();
  //   Restaurant secondRestaurant = new Restaurant("Do the dishes", myCuisine.getId());
  //   secondRestaurant.save();
  //   Restaurant[] restaurants = new Restaurant[] { firstRestaurant, secondRestaurant };
  //   assertTrue(myCuisine.getRestaurants().containsAll(Arrays.asList(restaurants)));
  // }
}
