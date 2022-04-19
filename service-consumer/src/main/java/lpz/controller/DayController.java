package lpz.controller;

import com.alibaba.fastjson.JSONObject;
import lpz.api.DayService;
import lpz.entity.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日期 Controller
 */
@RestController
@RequestMapping("/days")
public class DayController {

    @Resource
    private DayService dayService;

    /**
     * 添加日期
     *
     * @param data 添加日期信息 Day
     * @return 添加成功的日期编号
     */
    @PostMapping("/add")
    public boolean add(@RequestBody JSONObject data) {
        System.out.println(data);
        Day temp = new Day().setName(data.getString("name"))
                .setStatus(data.getString("status"))
                .setDeleted(0);
        boolean save = dayService.save(temp);
        return save;
    }

    /**
     * 删除指定日期编号的日期
     *
     * @param id 日期编号
     * @return 是否删除成功
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        // 删除用户记录
        Boolean success = dayService.delDay(id);
        // 返回是否更新成功
        return success;
    }

    /**
     * 更新指定日期编号的用户
     *
     * @param data 日期编号
     * @return 是否修改成功
     */
    @PutMapping("/update")
    public Boolean update(@RequestBody JSONObject data) {
        // 将 id 设置到 updateDTO 中
        Day temp = new Day().setId(data.getInteger("id")).setName(data.getString("name"))
                .setStatus(data.getString("status"))
                .setDeleted(0);
        // 更新用户记录
        Boolean success = dayService.updateById(temp);
        // 返回更新是否成功
        return success;
    }

    /**
     * 查询日期列表
     *
     * @return 日期列表
     */
//    @GetMapping("")
//    public String list() {
//        System.out.println("----------------controller-------------------");
//        String temp="1111";
//        return temp;
//    }
    @GetMapping("")
    public List<Day> list() {
        // 查询列表
        List<Day> result;
        result=dayService.getAllDays();
        System.out.println(result.get(0).getName());
        // 返回列表
        return result;
    }

    /**
     * 获得指定日期编号的日期
     *
     * @param id 日期编号
     * @return 日期
     */
    @GetMapping("/{id}")
    public Day get(@PathVariable("id") Integer id) {
        // 查询并返回日期
        return dayService.getById(id);
    }


}
