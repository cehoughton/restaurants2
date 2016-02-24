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
 }
