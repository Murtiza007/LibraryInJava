import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       
       Scanner sc =new Scanner(System.in);
       System.out.println("Welcome to library");
       Librarian l=new Librarian("aqib", 101);
       Member m=new Member("ahmad", 1001);
        while (true) {
            System.out.println("Press 1 to add the book"); 
            System.out.println("Press 2 to view the books");
            System.out.println("Press 3 to remove the book"); 
            System.out.println("Press 4 to borrow the book"); 
            System.out.println("Press 5 to return the book"); 
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter name of the book");
                    String book_title=sc.next();
                    System.out.println("Enter id of the book");
                    String book_id=sc.next();
                    System.out.println("Enter Author of the book");
                    String book_author=sc.next();
                    System.out.println("Enter Availibiy of the book");
                    boolean book_avail=sc.nextBoolean();
                   
                    Book bk1=new Book(book_title,book_id,book_author,book_avail);
                    l.addBook(bk1);
                    break;
                case 2:
                    l.view_catalog();
                    break;
                case 3:
                    l.RemoveBook(null);
                case 4:
                System.out.println("-----------------------------");
                    System.out.println("Enter id of the book");
                    String id=sc.next();
                    for(Book book : l.catlog){
                        System.out.println(book.get_bookID()+"----"+book.getTitle()+ "by "+book.get_author());
                        if(book.get_bookID().equals(id) && book.get_Availablilty()==true){
                            m.add_borrow_books(book);
                           
                        
                        }
                        else{
                            System.out.println("this book is not available = "+book.getTitle());
                        }
                    }
                            for(Book buk:m.Borrwed_books){
                                System.out.println("borrowed book= "+buk.getTitle());
                            }
                
                    
                    break;
                case 5:
                System.out.println("-----------------------------");
                    System.out.println("Enter id of the book");
                    String id1=sc.next();
                    for(Book book2:m.Borrwed_books){
                        if(book2.get_bookID().equals(id1)){
                            m.Borrwed_books.remove(book2);
                            System.out.println("book"+book2.getTitle()+" has been removed");
                          
                            
                    
                        }
                        for (Book book3:m.Borrwed_books){
                            System.out.println("-----------------------------");
                            System.out.println("Borrowed books= "+book3.getTitle());
                   
                        }
                    }
                    
                    

                default:
                    break;
            }

        }
    }
}

class Book {

    private String title;
    private String book_id;
    private String Author;
    private boolean isAvailable;
    
    public Book(String title,String book_id,String Author,boolean isAvailable){
        this.title=title;
        this.Author=Author;
        this.book_id=book_id;
        this.isAvailable=isAvailable;
       
    }
    
    public void set_availability(boolean avail){
        this.isAvailable=avail;
    }

    public String getTitle(){
        return this.title;
    }
    public String get_bookID(){
        return this.book_id;
    
    }
    public String get_author(){
        return this.Author;
    }
    public boolean get_Availablilty(){
        return this.isAvailable;
    }
}
abstract class User{

    private String user_name;
    private int user_id;

    public User(String user_name,int user_id){
        this.user_name=user_name;
        this.user_id=user_id;
    }

    
    public void set_userId(int userID){
        this.user_id=userID;
    }
    public int get_userId(){
        return this.user_id;
    }



}

class Librarian extends User{
    
    

    public Librarian(String user_name,int user_id){
        super(user_name,user_id);
    }

    public List<Book>catlog = new ArrayList<>();
    

    public void addBook(Book book){



        catlog.add(book);
        System.out.println(book.getTitle()+" has been added to catalog");
    }
    
    public void RemoveBook(Book book){
        catlog.remove(book);
        System.out.println(book+" has been removed to catalog");
    }

    public void view_catalog(){
        for(Book book : catlog){
            System.out.println(book.get_bookID()+"----"+book.getTitle()+ "by "+book.get_author());
        }
    }

}

class Member extends User{

   

    public Member(String userName,int user_id){
        super(userName,user_id);
    }

    public List<Book> Borrwed_books= new ArrayList<>();

    public void add_borrow_books(Book book){
        Borrwed_books.add(book);

    }
    public void view_borrowBooks(){
        for (Book book:Borrwed_books){
            System.out.println(book);
        }
    }
}


