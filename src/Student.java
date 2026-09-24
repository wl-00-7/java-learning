import java.util.HashMap;

public class Student {
    private String id;                 //学号
    private String name;            //姓名
    //学生有多门成绩
    private HashMap<String,Integer> scores=new HashMap<>();

    //构造器  构造器没有类型void等
    public Student(String id,String name){
        setName(name);
        setId(id);
    }
    //增加/修改成绩   course 课程
    public void addScore(String course,int score){
        scores.put(course,score);
    }
    //查询成绩  没有就返回null（是自动返回null吗）
    public int getScore(String course){
        return scores.get(course);
    }

    public void setName(String name){this.name=name;}
    public String getName(){return name;}
    public String getId(){return id;}
    public void setId(String id){this.id=id;}

    // toString方法的重写
    @Override  //@的检查是怎么检查的  检查是每一种都要记一个吗，想异常名字一样？
    public String toString(){   //scores直接打印出来是什么
        return "学号:"+id+"名字:"+name+"成绩:"+scores;
    }
}
