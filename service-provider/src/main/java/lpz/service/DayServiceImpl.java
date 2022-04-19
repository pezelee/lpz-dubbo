package lpz.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lpz.api.DayService;
import lpz.core.ServiceException;
import lpz.core.ServiceExceptionEnum;
import lpz.entity.Day;
import lpz.mapper.DayMapper;
import lpz.entity.DayAdd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DayServiceImpl extends ServiceImpl<DayMapper, Day> implements DayService {

    @Override
    public List<Day> getAllDays() {

//        LambdaQueryWrapper<Day> queryWrapper = new LambdaQueryWrapper<>();
//        List<Day> result = list(queryWrapper);

        //    显示端口号和权重     如  8071，权重1:     ------1,1------
        Day temp=new Day().setName("---------------------2,1-------------------");
        List<Day> result=new ArrayList<>();
        result.add(temp);
        return result;
    }

    @Override
    public boolean delDay(Integer id) {

//        LambdaQueryWrapper<Day> queryWrapper = new LambdaQueryWrapper<>();
        boolean result = removeById(id);
        return result;
    }

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Day get(Integer id) {

        logger.info("day id =1");

        return new Day().setId(id)
                .setName("路人甲：" + id); // 1 - 男；2 - 女
    }

    @Override
    public Integer add(DayAdd addDTO) {
//         这里，模拟用户已经存在的情况
        if ("yudaoyuanma".equals(addDTO.getName())) {
            throw new ServiceException(ServiceExceptionEnum.USER_EXISTS);
        }
        return (int) (System.currentTimeMillis() / 1000); // 嘿嘿，随便返回一个 id
    }
}
