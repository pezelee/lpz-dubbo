package lpz.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lpz.entity.Day;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface DayMapper extends BaseMapper<Day> {
    default Day selectByName(@Param("name") String name) {
        return selectOne(new QueryWrapper<Day>().eq("name", name));
    }

    List<Day> selectByIds(@Param("ids") Collection<Integer> ids);

    default IPage<Day> selectPageByCreateTime(IPage<Day> page, @Param("createTime") Date createTime) {
        return selectPage(page,
                new QueryWrapper<Day>().gt("create_time", createTime)
//                new QueryWrapper<UserDO>().like("username", "46683d9d")
        );
    }
}
