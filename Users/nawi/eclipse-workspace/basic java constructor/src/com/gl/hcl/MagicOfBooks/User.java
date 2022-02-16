package com.gl.hcl.MagicOfBooks;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
  private String userName;
  private int userID;
  private String emailID;
  private String password;
  private ArrayList < Book > newBooks = new ArrayList < Book > ();
  private ArrayList < Book > favourite = new ArrayList < Book > ();
  private ArrayList < Book > Completed = new ArrayList < Book > ();;

  public User() {};

  public User(String userName, int userID, String emailID, String password, ArrayList < Book > newBooks,
    ArrayList < Book > favourite, ArrayList < Book > Completed) {
    super();
    this.userName = userName;
    this.userID = userID;
    this.emailID = emailID;
    this.password = password;
    this.newBooks = newBooks;
    this.favourite = favourite;
    this.Completed = Completed;
  }

  public String getUserName() {
    return userName;

  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public int getUserID() {
    return userID;
  }
  private void setUserID(int userID) {
    this.userID = userID;
  }

  public String getEmailID() {

    return emailID;
  }

  public void setEmailID(String emailID) {
    this.emailID = emailID;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public ArrayList < Book > getNewBooks() {

    return newBooks;
  }

  public void setNewBooks(ArrayList < Book > newBooks) {
    this.newBooks = newBooks;
  }

  public ArrayList < Book > getFavourite() {
    return favourite;
  }

  public void setFavourite(ArrayList < Book > favourite) {
    this.favourite = favourite;
  }

  public ArrayList < Book > getCompleted() {
    return Completed;
  }

  public void setCompleted(ArrayList < Book > Completed) {
    this.Completed = Completed;
  }

  public void addFavourite(Book n) {
    favourite.add(n);
  }

  public void addNewBooks(Book n) {
    newBooks.add(n);
  }

  public void addCompleted(Book n) {
    Completed.add(n);
  }

  public String toString() {
    return "--------------------User Detail---------------------------\n" +
      "User Name\tUserID\t\tEmailID\t\tPassword\n" +
      userName + "\t\t" + userID + "\t\t" + emailID + "\t" + password;
  }

  public void createPojo() {

    setUserName("pojo");
    setUserID(1);
    setEmailID("pojo@gmail.com");
    setPassword("123456");

  }

  public boolean login() {

    Scanner scn = new Scanner(System.in);

    System.out.println("------Login to MagicOfBook Application--------");

    System.out.println("Enter your username");
    String username = scn.nextLine();
    System.out.println();
    System.out.println("Enter your password");
    String password = scn.nextLine();

    //verify user login
    if (username.equals(getUserName()) && password.equals(getPassword())) {

      System.out.println("==========Welcome to Magic Of Books Application===========");
      return true;
    } else {
      System.out.println("Invalid login, please try again/contact the admin.");

      return false;
    }

  }

}