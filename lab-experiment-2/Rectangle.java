class Rect{
    int length;
    int width;

    void getdata(int a,int b){
        length=a;
        width=b;
    }

    int area(){
        return length*width;
    }
}

class Rectangle{
    public static void main(String[] args){
        Rect obj = new Rect();
        obj.getdata(5,6);
        System.out.println ("The area of the rectangle is " + obj.area());
    }
}
