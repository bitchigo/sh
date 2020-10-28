package icu.bitchigo.sh.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import icu.bitchigo.sh.mapper.StudentMapper;
import icu.bitchigo.sh.pojo.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private StudentMapper studentMapper;
    public String login(String username,String password){
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.select("id").eq("number", username).eq("password",password);
        Student student = studentMapper.selectOne(wrapper);
        if (student==null){
            return "用户名或密码不正确";  //json
        }else{
            //jwt
        }
        //老师部分
        return null;
    }
}
