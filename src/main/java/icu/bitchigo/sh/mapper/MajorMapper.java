package icu.bitchigo.sh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.bitchigo.sh.pojo.po.Major;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MajorMapper extends BaseMapper<Major> {
}
