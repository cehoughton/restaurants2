import org.sql2o.*;
import java.util.List;

public class Restaurant {
  private int cuisine_id;
  private int id;
  private String name;

  public Restaurant (String name, int cuisine_id) {
    this.name = name;
    this.cuisine_id = cuisine_id;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object otherRestaurant){
    if (!(otherRestaurant instanceof Restaurant)) {
      return false;
    } else {
      Restaurant newRestaurant = (Restaurant) otherRestaurant;
      return this.getName().equals(newRestaurant.getName()) &&
        this.getId() == newRestaurant.getId();
    }
  }

  //CREATE
  public void save() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO restaurants (name, cuisine_id) VALUES (:name, :cuisine_id)";

      /******************************************************
        Students: TODO: Display all restaurants on main page
      *******************************************************/
    }
  }

  // //READ
  // public static List<Restaurant> all() {
  //   try (Connection con = DB.sql2o.open()) {
  //     /******************************************************
  //       Students: TODO: Display all restaurants on main page
  //     *******************************************************/
  //   }
  // }
  //
  // //UPDATE
  // public void update(String newName) {
  //   this.name = newName;
  //   try(Connection con = DB.sql2o.open()) {
  //     /******************************************************
  //       Students: TODO: Display all restaurants on main page
  //     *******************************************************/
  //     }
  // }

  //DELETE
  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      /******************************************************
        Students: TODO: Display all restaurants on main page
      *******************************************************/
    }
  }

  /******************************************************
    Students:
    TODO: Create find method
    TODO: Create method to get cuisine type
  *******************************************************/

}
