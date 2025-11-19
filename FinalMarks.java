import java.util.*;
import CIE.*;
import SEE.*;

public class FinalMarks {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Internals internal[] = new Internals[n];
        External external[] = new External[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of student " + (i + 1));

            System.out.print("USN: ");
            String usn = sc.next();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Semester: ");
            int sem = sc.nextInt();

            System.out.println("Enter 5 Internal Marks:");
            int inMarks[] = new int[5];
            for (int j = 0; j < 5; j++)
                inMarks[j] = sc.nextInt();

            System.out.println("Enter 5 SEE Marks:");
            int seeMarks[] = new int[5];
            for (int j = 0; j < 5; j++)
                seeMarks[j] = sc.nextInt();

            internal[i] = new Internals(inMarks);
            external[i] = new External(usn, name, sem, seeMarks);
        }

        // Display final marks
        System.out.println("\n---------------------------");
        System.out.println(" FINAL MARKS OF STUDENTS ");
        System.out.println("---------------------------");

        for (int i = 0; i < n; i++) {
            external[i].display();
            System.out.println("Final Marks in 5 Courses:");

            for (int j = 0; j < 5; j++) {
                int finalMarks = internal[i].internalMarks[j] + (external[i].seeMarks[j] / 2);
                System.out.println("Course " + (j + 1) + ": " + finalMarks);
            }

            System.out.println("---------------------------");
        }

        sc.close();
    }
}

