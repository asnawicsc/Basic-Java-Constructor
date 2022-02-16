package com.gl.hcl.MagicOfBooks;

import java.util.*;

public class MagicOfBooks {

  static Map < Integer, Book > books = new HashMap < Integer, Book > ();

  static void showMenu() {
    System.out.println("----------Menu--------------");
    System.out.println("Enter A to add new book");
    System.out.println("Enter B display all book");
    System.out.println("Enter C to update your book to (New/Favourite/Completed) section");
    System.out.println("Enter D to display your (New/Favourite/Completed) book section");
    System.out.println("Enter E to exit");
    System.out.println();
  }

  public static void main(String[] args) {

    //create default pojo
    User user = new User();
    user.createPojo();
    
    //create default book
    addingNewBook("Life of Shrimp", "Ahmad", "Monster", 1);
    addingNewBook("Life of Tiger", "Ali", "Monster", 2);
    addingNewBook("Life of Lion", "Kumar", "Monster", 3);
    addingNewBook("Life of Snail", "Siti", "Monster", 4);
    addingNewBook("Life of Panda", "Mohd", "Monster", 5);
    addingNewBook("Life of Bird", "Firdaus", "Monster", 6);
    
    //create default new section
    for (Map.Entry < Integer, Book > set: books.entrySet()) {
        if (set.getKey() == 1) {
          user.addNewBooks(set.getValue());
        }
        if (set.getKey() == 2) {
            user.addNewBooks(set.getValue());
          }
      }
    
    //create default favorite section
    for (Map.Entry < Integer, Book > set: books.entrySet()) {
        if (set.getKey() == 3) {
          user.addFavourite(set.getValue());
        }
        if (set.getKey() == 4) {
            user.addFavourite(set.getValue());
          }
      }
    
    //create default completed section
    for (Map.Entry < Integer, Book > set: books.entrySet()) {
        if (set.getKey() == 5) {
          user.addCompleted(set.getValue());
        }
        if (set.getKey() == 6) {
            user.addCompleted(set.getValue());
          }
      }

    

  
    //validate user access
    if (user.login()) {
      System.out.println(); 	
      System.out.println(user);

      char option = '\0';
      Scanner scanner = new Scanner(System.in);

      do {
        //display menu recursively
        System.out.println();
        showMenu();
        //ask user to choose the menu
        System.out.println();
        System.out.println("Enter your option: ");
        char option1 = scanner.next().charAt(0);
        option = Character.toUpperCase(option1);

        System.out.println();
        switch (option) {

        case 'A':
          System.out.println("------------Adding New Book Function------------");
          //entering the book
          System.out.println();
          Scanner scn_bk = new Scanner(System.in);
          System.out.println("Enter the book name: ");
          String bk_name = scn_bk.nextLine();
          Scanner scn_bk1 = new Scanner(System.in);
          System.out.println("Enter the book author: ");
          String bk_author = scn_bk1.nextLine();
          Scanner scn_bk2 = new Scanner(System.in);
          System.out.println("Enter the book description: ");
          String bk_desc = scn_bk2.nextLine();
          Scanner scn_bk3 = new Scanner(System.in);
          // validate book id as integer
          while (true) {
              System.out.println("Enter the book id: ");
              String bk_id = scn_bk3.next();
              int intInputValue = 0;
              try {
                  intInputValue = Integer.parseInt(bk_id);
                  
                  
                  ArrayList<Integer> num = new ArrayList<Integer>();
                  
                  for (Map.Entry < Integer, Book > set: books.entrySet()) {
                 
                  	num.add(set.getKey());
                	  
                    }
                  
                  if(num.contains(intInputValue)) {
                	  
                	  System.out.println("This book id already exist,please enter new book id");
                	  break;
                  }else {
                	  
                	  addingNewBook(bk_name, bk_author, bk_desc, intInputValue);
                      break;  
                  }
   
              } catch (NumberFormatException ne) {
                  System.out.println("This is not an integer number, book id should only be an integer number");
              }
  

          }
          
      

       
          System.out.println();
          break;

        case 'B':
          //display all book 
          System.out.println("--------------------List of Existing Book---------------------------\n");
          System.out.println("Book ID\t\tBook Name\tAuthor\t\tDescription\n");
          for (Map.Entry < Integer, Book > set: books.entrySet()) {
            System.out.println(set.getValue());
          }

          break;

        case 'C':
          System.out.println("------------Please enter key [N=New|F=Favourite|C=Completed] for Update------------");
          char key = '\0';
          char option2 = scanner.next().charAt(0);
          key = Character.toUpperCase(option2);

          System.out.println();
          switch (key) {

          case 'N':

            //list book for references
            System.out.println("--------------------List of Existing Book---------------------------\n");
            System.out.println("Book ID\t\tBook Name\tAuthor\t\tDescription\n");
            for (Map.Entry < Integer, Book > set: books.entrySet()) {
              System.out.println(set.getValue());
            }

            //select book by id  and added to user new category
            System.out.println("Enter Book ID  to added into New category: ");
            Scanner scn1 = new Scanner(System.in);
            int bookid = scn1.nextInt();
            for (Map.Entry < Integer, Book > set: books.entrySet()) {
              if (set.getKey() == bookid) {
                user.addNewBooks(set.getValue());
              }
            }
            break;

          case 'F':

            //list book for references
            System.out.println("--------------------List of Existing Book---------------------------\n");
            System.out.println("Book ID\t\tBook Name\tAuthor\t\tDescription\n");
            for (Map.Entry < Integer, Book > set: books.entrySet()) {
              System.out.println(set.getValue());
            }

            //select book by id  and added to user new Favorite
            System.out.println("Enter Book ID to added into Favorite category : ");
            Scanner scn2 = new Scanner(System.in);
            int bookid2 = scn2.nextInt();
            for (Map.Entry < Integer, Book > set: books.entrySet()) {
              if (set.getKey() == bookid2) {
                user.addFavourite(set.getValue());
              }
            }

            break;

          case 'C':

            //list book for references
            System.out.println("--------------------List of Existing Book---------------------------\n");
            System.out.println("Book ID\t\tBook Name\tAuthor\t\tDescription\n");
            for (Map.Entry < Integer, Book > set: books.entrySet()) {
              System.out.println(set.getValue());
            }

            //select book by id  and added to user new Completed
            System.out.println("Enter Book ID : ");
            Scanner scn3 = new Scanner(System.in);
            int bookid3 = scn3.nextInt();
            for (Map.Entry < Integer, Book > set: books.entrySet()) {
              if (set.getKey() == bookid3) {
                user.addCompleted(set.getValue());
              }
            }

            break;

          default:
            System.out.println("Error: invalid option, please enter valid value either N,F,C");
            break;
          }

          break;

        case 'D':
          System.out.println("------------Please enter key [N=New|F=Favourite|C=Completed|A=All] for Display------------");
          char key2 = '\0';
          char option3 = scanner.next().charAt(0);
          key2 = Character.toUpperCase(option3);

          System.out.println();
          switch (key2) {

          case 'N':

            //display new category book
            System.out.println("--------------------List of My Book in New section---------------------------\n");
            System.out.println("Book ID\t\tBook Name\tAuthor\t\tDescription\n");

            String listString = "";
            for (Book s: user.getNewBooks()) {
              listString += s + "\n";
            }
            System.out.println(listString);

            break;

          case 'F':

            //display Favorite category book
            System.out.println("--------------------List of My Book in Favorite section---------------------------\n");
            System.out.println("Book ID\t\tBook Name\tAuthor\t\tDescription\n");

            String listString2 = "";
            for (Book s: user.getFavourite()) {
              listString2 += s + "\n";
            }
            System.out.println(listString2);

            break;

          case 'C':

            //display Completed category book
            System.out.println("--------------------List of My Book in Completed section---------------------------\n");
            System.out.println("Book ID\t\tBook Name\tAuthor\t\tDescription\n");

            String listString3 = "";
            for (Book s: user.getCompleted()) {
              listString3 += s + "\n";
            }
            System.out.println(listString3);

            break;
            
          case 'A':

              //display Completed category book
              System.out.println("--------------------List of My Book split by section---------------------------\n");
              System.out.println("Book ID\t\tBook Name\tAuthor\t\tDescription\n");

              String listString_all = "";
              for (Book s: user.getNewBooks()) {
            	  listString_all += s + "\n";
              }
              System.out.println("=================New=====================================");
              System.out.println(listString_all);
              
              String listString_all2 = "";
              for (Book s: user.getFavourite()) {
            	  listString_all2 += s + "\n";
              }
              System.out.println("=================Favourite================================");
              System.out.println(listString_all2);
              
              String listString_all3 = "";
              for (Book s: user.getCompleted()) {
            	  listString_all3 += s + "\n";
              }
              System.out.println("=================Completed===============================");
              System.out.println(listString_all3);

              break;

          default:
            System.out.println("Error: invalid option, please enter valid value either N,F,C");
            break;
          }

          break;
        case 'E':
          System.out.println("Thanks for using MagicOfBooks Application!");
          break;

        default:
          System.out.println("Error: invalid option, please enter valid value either A,B,C,D,E");
          break;

        }

      } while (option != 'E');

    }

  }

  private static void addingNewBook(String bk_name, String bk_author, String bk_desc, int bk_id) {
    Book b = new Book(bk_name, bk_author, bk_desc, bk_id);
    books.put(bk_id, b);

  }

}