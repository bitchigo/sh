package icu.bitchigo.sh.controller;

import icu.bitchigo.sh.pojo.po.Direction;
import icu.bitchigo.sh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("directions")
    public List<Direction> getDirections(){
        return studentService.getDirections();
    }

    @PutMapping("dirction/{student_id}/direction_id")  //学生信息应当从jwt获取
    public String setDirection(@PathVariable("student_id")int studentId,@PathVariable("direction_id")int directionId){
        return studentService.setDirection(studentId,directionId);
    }

    @GetMapping("dirction")
    public String getDirection(int studenId){ //学生信息应当从jwt获取
        return studentService.getDirection(studenId);
    }


}
