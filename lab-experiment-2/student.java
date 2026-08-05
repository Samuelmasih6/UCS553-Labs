class s{
    int Rollno;
    String name;
    String course;
    float marks;

    s(){
        Rollno=44;
        name="Samuel";
        course="web enterprise";
        marks=100;
    }

    s(int r, String s, String c, float m){
        Rollno=r;
        name=s;
        course=c;
        marks=m;
    }

    void print(){
        System.out.println("name: "+ name);
        System.out.println("Roll no.:" + Rollno);
        System.out.println("course:" + course);
        System.out.println("marks:" + marks);
    }
}

public class student{
    public static void main(String[] args){
        s s1 = new s();
        s s2 = new s(1,"Tony","BCA",90);

        s1.print();
        s2.print();
    }
}
