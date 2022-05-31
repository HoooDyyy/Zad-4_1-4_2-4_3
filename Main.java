import java.io.IOException;
import java.util.Scanner;


class WrongStudentName extends Exception { }
class WrongStudentAge extends Exception { }
class WrongStudentData extends Exception { }

class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
          aplikacja:
            try {
                int ex = menu();
              if (ex==1 ||ex==2 || ex==3 || ex==0   )
                switch(ex) {
                    case 1: exercise1(); break;
                    case 2: exercise2(); break;
                    case 3: exercise3(); break;
                    default: return;
                  }
            else 
              
                break aplikacja;
                

              
            } catch(IOException e) {

            } catch(WrongStudentName e) {
                System.out.println("Błędne imie studenta!");
              }catch(WrongStudentData e) {
                System.out.println("Bledna data!");
              
            } catch(WrongStudentAge e) {
                System.out.println("Zły wiek!");
            }
          
        }
    }

    public static int menu() {
        System.out.println("Wciśnij:");
        System.out.println("1 - aby dodać studenta");
        System.out.println("2 - aby wypisać wszystkich studentów");
        System.out.println("3 - aby wyszukać studenta po imieniu");
        System.out.println("0 - aby wyjść z programu");
        return scan.nextInt();
    }

    public static String ReadName() throws WrongStudentName, WrongStudentAge,WrongStudentData {
        scan.nextLine();
        System.out.println("Podaj imie: ");
        String name = scan.nextLine();
        if(name.contains(" "))
            throw new WrongStudentName();

        return name;
    }

    public static void exercise1() throws IOException, WrongStudentName, WrongStudentAge,WrongStudentData {
        var name = ReadName();
        System.out.println("Podaj wiek: ");
        var age = scan.nextInt();
        scan.nextLine();
      if(age>100 || age<0)
            throw new WrongStudentAge();
        System.out.println("Podaj datę urodzenia DD-MM-YYYY");
        var date = scan.nextLine();
         if(date.charAt(2) == '-' && date.charAt(5) == '-'){
                
      throw new WrongStudentData();
          }
        
        
      else
        
        (new Service1()).addStudent(new Student(name, age, date));
    }

    public static void exercise2() throws IOException {
        var students = (new Service1()).getStudents();
        for(Student current : students) {
            System.out.println(current.ToString());
        }
    }

    public static void exercise3() throws IOException {
        scan.nextLine();
        System.out.println("Podaj imie: ");
        var name = scan.nextLine();
        var wanted = (new Service1()).findStudentByName(name);
        if(wanted == null)
            System.out.println("Nie znaleziono...");
        else {
            System.out.println("Znaleziono: ");
            System.out.println(wanted.ToString());
        }
    }
}