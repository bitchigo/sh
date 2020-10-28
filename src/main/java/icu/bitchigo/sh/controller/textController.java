package icu.bitchigo.sh.controller;

import icu.bitchigo.sh.pojo.po.Direction;
import icu.bitchigo.sh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class textController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/")
    public List<Direction> student(){
        return studentService.getDirections();
    }
}
