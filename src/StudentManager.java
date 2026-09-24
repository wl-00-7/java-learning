import java.util.ArrayList;
import java.util.HashMap;

public class StudentManager {

    //hashmap和链表一起用，保持数据同步
    // 名单目录 负责顺序，快速列出全部
    private ArrayList<Student> list=new ArrayList<>();
    // 索引 学号->具体学生，快速查找
    private HashMap<String,Student> map=new HashMap<>();

    //增加学生
    public boolean add(Student s){
        if(map.containsKey(s.getId())){
            return false;       //新增时首先判断是否已经含有
        }
        list.add(s);
        map.put(s.getId(),s);
        return true;
    }
    //按照学号查询
    public Student findById(String id){
        return map.get(id);
    }
    //列出全部学生
    public boolean showAll(){
        if(list.isEmpty()){     //先判断空
            System.out.println("暂无学生");
            return false;
        }
        for(Student s:list){
            System.out.println(s);
        }
        return true;
    }
    //删除
    public boolean delete(String id){
        Student s=map.remove(id);   //remove方法有返回值？
        if(s==null){
            return false;
        }
        list.remove(s);
        return true;
    }

}
