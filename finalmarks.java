import CIE.*;
import SEE.*;
import java.util.Scanner;
public class finalmarks{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no.of students");
        int n=sc.nextInt();
        externals[] students=new externals[n];
        internals[] Internls=new internals[n];
        for(int i=0;i<n;i++){
            sc.nextLine();
            System.out.println("Enter details of student"+(i+1));
            System.out.println("USN:");
            String usn=sc.nextLine();
            System.out.println("Name:");
            String name=sc.nextLine();
            System.out.println("Sem");
            int sem=sc.nextInt();
            students[i]=new externals(usn,name,sem);
            Internals[i]=new internals();
            int[] internalMarks=new it[5];
            int[] seeMarks=new int[5];
            System.out.println("enter 5 external marks");
            for(int j=0;j<5;j++)
            seeMarks[j]=sc.nextInt();
            Internals[i].setMarks(internalMarks);
            students[i].setseeMarks(seeMarks);


            



        }
        System.out.println("\n Final marks");
        for(int i=0;i<n;i++){
            students[i].display();
            int[] total =new int[5];
            System.out.println("final marks");
            for(int j=0;j<5;j++){
                total[j]=Internals[i].internalMarks[j]+(students[i].seeMarks[j]/2);
                
            }
            System.out.println("\n");
        }
        sc.close();

    }
}