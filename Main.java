## Code

  import java.util.*;


class Student{

    private int id;
    private String name;
    private int age;
    private String course;


    //constructor

    public Student(int id,String name, int age, String course){
        this.id = id;
        this.name = name;
        this.age =  age;
        this.course = course;
    }



    //getters - value return

    public int getID(){
        return id;
    }
    public String getName(){
        return name ;
    }
    public int  getAge(){
        return age;
    }
    public String getCourse(){
        return course;
    }


    //setters - value update

    public void setName (String name){
        this.name = name;
    }

    public void setAge( int age){
        this.age =age;

    }

    public void setCourse(String course){
        this.course = course;

    }


    public void display(){
        System.out.println("ID:" + id + "Name:" + name + "Age:"+ age + "Course: "+ course);

    }

}

class StudentManagement{
    private List<Student> students = new ArrayList<>();


    public void addstudent(Student s ){
        students.add(s);
        System.out.println("Student Added Successfully!");


    }

    public void displayStudent(){
        if(students .isEmpty()){
            System.out.println("no Student found!");

        } else {
            for( Student s : students){
                s.display();
            }
        }
    }

    public void updatestudent( int id ,String  newName ,int newAge, String newCourse){
        for (Student s : students){
            if(s.getID() == id){
                s.setName(newName);
                s.setAge(newAge);
                s.setCourse(newCourse);
                System.out.println("student updated!");
                return;
            }
        }
        System.out.println("Student Not Found!");
    }

    public void deleteStudent(int id){
        Iterator <Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it .next();
            if ((s.getID()==id)) {
                it.remove();
                System.out.println("Student Deleted");
                return;
                
            }
            
            
        }

        System.out.println("student Not Found");

    }


}




public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System .in);

        StudentManagement sm = new StudentManagement();


        while (true) {
            System.out.println("\n === Student Management System===");

            System.out.println("1.Add Student");
            System.out.println("2. Display Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5.Exit");
            System.out.println("Enter your choice ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID");
                    int id = sc.nextInt();

                    sc.nextLine();//buffer clean

                    System.out.print("Enter Name");
                    String name = sc.nextLine();

                    System.out.print("Enter Age");
                    int age = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Course");
                    String Course = sc. nextLine();

                    Student s = new Student(id, name, age, Course);
                    sm.addstudent(s);
                    
                    break;

                case 2:
                    sm.displayStudent();
                    break;

                case 3 :
                    System.out.println("Enter ID to update");
                    int uid =sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter new name");
                    String newName = sc.nextLine();

                    System.out.println("Enter new age");
                    int Newage= sc.nextInt();

                    sc.nextLine();

                    System.out.println("Enter new course");
                    String newCourse = sc.nextLine();

                    sm.updatestudent(uid, newName, Newage, newCourse);

                    break;


                case 4:
                    System.out.println("Enter ID to Delete");
                    int did = sc.nextInt();

                    sm.deleteStudent(did);
                    break;

                case 5:
                System.out.println("Exiting.... Thank You");
                sc.close();
                return;


            
                default:
                    System.out.println(" ooo.. Invalide choice!");
            }
            
        }
        
    }
    
}
