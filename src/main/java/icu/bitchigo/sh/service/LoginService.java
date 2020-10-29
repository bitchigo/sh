package icu.bitchigo.sh.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import icu.bitchigo.sh.Utils.JwtUtil;
import icu.bitchigo.sh.mapper.StudentMapper;
import icu.bitchigo.sh.mapper.TeacherMapper;
import icu.bitchigo.sh.pojo.po.Student;
import icu.bitchigo.sh.pojo.po.Teacher;
import icu.bitchigo.sh.pojo.to.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    public Map login(LoginUser loginUser) {
        String number=loginUser.getNumber();
        String password=loginUser.getPassword();
        HashMap<String, String> resMap = new HashMap<String, String>();
        QueryWrapper<Student> sWrapper = new QueryWrapper<>();
        sWrapper.select("id").eq("number", number).eq("password", password);
        Student student = studentMapper.selectOne(sWrapper);

        if (student != null) {
            HashMap<String, String> sTokenMap = new HashMap<>();
            sTokenMap.put("id", String.valueOf(student.getId()));
            sTokenMap.put("role", "student");
            resMap.put("status", "200");
            resMap.put("role","student");
            resMap.put("msg", "登录成功");
            resMap.put("token", JwtUtil.getToken(sTokenMap));
        } else {
            QueryWrapper<Teacher> tWrapper = new QueryWrapper<>();
            tWrapper.select("id").eq("number", number).eq("password", password);
            Teacher teacher = teacherMapper.selectOne(tWrapper);
            if (teacher != null) {
                HashMap<String, String> tTokenMap = new HashMap<>();
                tTokenMap.put("id", String.valueOf(student.getId()));
                tTokenMap.put("role", "teacher");
                resMap.put("status", "200");
                resMap.put("role","teacher");
                resMap.put("msg", "登录成功");
                resMap.put("token", JwtUtil.getToken(tTokenMap));
            } else {
                resMap.put("status", "403");
                resMap.put("msg", "用户名或密码错误");
            }
        }
        return resMap;
    }
}
