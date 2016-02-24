import org.sql2o.*;
import java.util.List;

public class Cuisine {
  private int cuisine_id;
  private String type;

  public Cuisine (String type) {
    this.type = type;
  }

  public int getId() {
    return cuisine_id;
  }

  public String getType() {
    return type;
  }

  @Override
  public boolean equals(Object otherCuisine){
    if (!(otherCuisine instanceof Cuisine)) {
      return false;
    } else {
      Cuisine newCuisine = (Cuisine) otherCuisine;
      return this.getType().equals(newCuisine.getType()) &&
        this.getId() == newCuisine.getId();
    }
  }

  //CREATE
  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO Cuisine(type) VALUES (:type)";
      this.cuisine_id = (int) con.createQuery(sql, true)
        .addParameter("type", this.type)
        .executeUpdate()
        .getKey();
/******************************************************
        Students: TODO: Create sql query and execute update
      *******************************************************/
    }
  }

  //READ
  public static List<Cuisine> all() {
    String sql = "SELECT cuisine_id, type FROM Cuisine";
    try (Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Cuisine.class);
      /******************************************************
        Students: TODO: Create sql query and execute update
      *******************************************************/
    }
  }

  //UPDATE
  public void update(String newType) {
    this.type = newType;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE cuisine SET type = :type WHERE cuisine_id = :cuisine_id";
     con.createQuery(sql)
      .addParameter("type", type)
      .addParameter("cuisine_id", cuisine_id)
      .executeUpdate();
      /******************************************************
        Students: TODO: Create sql query and execute update
      *******************************************************/
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      /******************************************************
        Students: TODO: Create sql query and execute update
      *******************************************************/
    }
  }

  /******************************************************
    Students:
    TODO: Create find method
    TODO: Create method to get restaurants
  *******************************************************/

}
