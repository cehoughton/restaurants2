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
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("cuisine_id", this.cuisine_id)
      .executeUpdate()
      .getKey();
      /******************************************************
        Students: TODO: Display all restaurants on main page
      *******************************************************/
    }
  }

  //READ
  public static List<Restaurant> all() {
    String sql = "SELECT id, name, cuisine_id FROM Restaurants";
    try (Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Restaurant.class);
      /******************************************************
        Students: TODO: Display all restaurants on main page
      *******************************************************/
    }
  }

  public static Restaurant find(int id) {
  try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM Restaurants where id=:id";
    Restaurant restaurant = con.createQuery(sql)
     .addParameter("id", id)
     .executeAndFetchFirst(Restaurant.class);
   return restaurant;
  }
}

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
  public void deleteRestaurant() {
    try(Connection con = DB.sql2o.open()) {
    String sql = "DELETE FROM restaurants WHERE cuisine_id = :cuisine_id;";
    con.createQuery(sql)
      .addParameter("cuisine_id", cuisine_id)
      .executeUpdate();
  }
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
