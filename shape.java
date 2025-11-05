abstract class shape{
    int a;
    int b;

    abstract void printArea();
}
class rectangle extends shape{
    rectangle(int a,int b){
        this.a=a;
        this.b=b;
    }
    void printArea(){
        int r1=a*b;
        System.out.println("the are of rectangle:"+r1);

    }
}
class triangle extends shape{
    triangle(int a,int b){
        this.a=a;
        this.b=b;

    }
    void printArea(){
        double r2=0.5*a*b;
        System.out.println("the are of triangle:"+r2);
    }
}
class circle extends shape{
    circle(int a){
        this.a=a;
    }
    void printArea(){
        double r3=3.14*a*a;
        System.out.println("the area of circle:"+r3);
    }
}
class demo{
    public static void main(String[] args) {
        rectangle r=new rectangle(10,2);
        triangle t=new triangle(5,6);
        circle c=new circle(3);
        r.printArea();
        t.printArea();
        c.printArea();
        
    }}
