package lpz.api;

import com.baomidou.mybatisplus.extension.service.IService;
import lpz.entity.Day;
import lpz.entity.DayAdd;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface DayService  extends IService<Day> {


    public List<Day> getAllDays();

    public boolean delDay(Integer id);

    /**
     * 根据指定用户编号，获得用户信息
     *
     * @param id 用户编号
     * @return 用户信息
     */
    Day get(@NotNull(message = "用户编号不能为空") Integer id)
            throws ConstraintViolationException;

    /**
     * 添加新用户，返回新添加的用户编号
     *
     * @param addDTO 添加的用户信息
     * @return 用户编号
     */
    Integer add(DayAdd addDTO)
            throws ConstraintViolationException;

}
