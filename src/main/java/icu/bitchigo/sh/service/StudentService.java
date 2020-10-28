package icu.bitchigo.sh.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import icu.bitchigo.sh.mapper.DirectionMapper;
import icu.bitchigo.sh.mapper.SelectMapper;
import icu.bitchigo.sh.pojo.po.Direction;
import icu.bitchigo.sh.pojo.po.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private DirectionMapper directionMapper;
    @Autowired
    private SelectMapper selectMapper;


    public List<Direction> getDirections(){
        return directionMapper.selectList(null);
    }

    public String setDirection(int studentId,int directionId){
        QueryWrapper<Select> wrapper = new QueryWrapper<>();
        wrapper.select("id").eq("student_id", studentId);
        Select select = selectMapper.selectOne(wrapper);
        if(select==null){
            Select insertSelect = new Select();
            insertSelect.setDirectionId(directionId);
            insertSelect.setStudentId(studentId);
            insertSelect.setLastTime(new Timestamp(new Date().getTime()));
            selectMapper.insert(insertSelect);
        }else{
            Select updateSelect = new Select();
            updateSelect.setDirectionId(directionId);
            updateSelect.setStudentId(studentId);
            QueryWrapper<Select> updateWrapper = new QueryWrapper<>();
            updateWrapper.eq("id",select.getId());
            selectMapper.update(updateSelect,updateWrapper);
        }
        return "OK";
    }

    public String getDirection(int studentId){
        QueryWrapper<Select> wrapper = new QueryWrapper<>();
        wrapper.select("direction_id").eq("student_id", studentId);
        Select select = selectMapper.selectOne(wrapper);
        if (select==null){
            return "还没有选择方向";
        }else{
            QueryWrapper<Direction> directionWrapper = new QueryWrapper<>();
            wrapper.select("name").eq("id", select.getDirectionId());
            return "已选择方向"+directionMapper.selectOne(directionWrapper).getName();
        }
    }
}
