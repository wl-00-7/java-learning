import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    static StudentManager manager=new StudentManager();
    public static void main(String[] args){
        while(true){        //主页面
            System.out.println( "\n===== 学生成绩管理系统 =====" );
            System.out.println( "1.添加学生  2.删除学生  3.修改姓名" );
            System.out.println( "4.查询学生  5.添加成绩  6.列出全部  7.退出" );
            System.out.print( "请选择：" );

            int choice=readInt();

            switch(choice){
                case 1 : addStudent(); break ;
                case 2 : deleteStudent(); break ;
                case 3 : updateName(); break ;
                case 4 : queryStudent(); break ;
                case 5 : addScore(); break ;
                case 6 : manager.showAll(); break ;
                case 7 :
                    System.out.println( "再见！" );
                    return ;
                default :
                    System.out.println( "没有这个选项" );
            }

        }
    }
    public static int readInt(){
        while(true){
            try{
                int n=sc.nextInt();
                return n;
            }catch(Exception e){
                System.out.println("请输入数字");
                sc.next();   //清除错误的输入 else死循环
            }
        }
    }
    public static void addStudent(){
        System.out.println("请输入学号");
        String id=sc.next();
        System.out.println("请输入姓名");
        String name=sc.next();
        if(manager.add(new Student(id,name))){
            System.out.println("添加成功");
        }else{
            System.out.println("学生已存在");
        }
    }
    public static void deleteStudent(){
        System.out.println("请输入要删除的学生学号");
        String id=sc.next();
        if(manager.delete(id)){
            System.out.println("删除成功");
        }else{
            System.out.println("学生已不存在");
        }
    }
    public static void updateName(){
        System.out.println("请输入学号");
        String id=sc.next();
        Student s=manager.findById(id);
        if(s==null){
            System.out.println("没有此学生");
            return;
        }
        System.out.print( "新姓名：" );
        s.setName(sc.next());
        System.out.println( "修改成功" );
    }
    // query 查询
    public static void queryStudent(){
        System.out.println("请输入学号");
        Student s=manager.findById(sc.next());
        System.out.println(s==null?"没有此学生":s);
    }
    public static void addScore(){
        System.out.println("请输入学号");
        Student s=manager.findById(sc.next());
        if (s == null ) {
            System.out.println( "没有这个学生" ); return ;
        }
        System.out.println("课程名");
        String course=sc.next();
        System.out.println("分数");
        int score=sc.nextInt();
        s.addScore(course,score);
        System.out.println( "成绩已保存" );
    }
}
