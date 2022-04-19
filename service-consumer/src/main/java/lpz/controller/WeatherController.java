package lpz.controller;

import com.alibaba.fastjson.JSONObject;
import lpz.api.DayService;
import lpz.api.WeatherService;
import lpz.entity.Day;
import lpz.entity.Weather;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日期 Controller
 */
@RestController
@RequestMapping("/weathers")
public class WeatherController {

    @Resource
    private DayService dayService;

    @Resource
    private WeatherService weatherService;

    /**
     * 添加天气
     *
     * @param data 添加天气列表 Day
     * @return 是否添加成功
     */
    @PostMapping("/add")
    public boolean add(@RequestBody JSONObject data) {
        System.out.println(data);
        Weather temp = new Weather().setDayId(data.getInteger("dayId"))
                .setName(data.getString("name"))
                .setTime(data.getString("time"))
                .setDetail(data.getString("detail"))
                .setType(data.getString("type"))
                .setDeleted(0);
        boolean save = weatherService.save(temp);
        return save;
    }

    /**
     * 删除指定编号的天气
     *
     * @param id 天气编号
     * @return 是否删除成功
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        // 删除天气记录
        Boolean success = weatherService.removeById(id);
        // 返回是否更新成功
        return success;
    }

    /**
     * 更新指定编号的天气
     *
     * @param data 天气编号
     * @return 是否修改成功
     */
    @PutMapping("/update")
    public Boolean update(@RequestBody JSONObject data) {
        // 将 id 设置到 updateDTO 中
        Weather temp = new Weather().setId(data.getInteger("id"))
                .setDayId(data.getInteger("dayId"))
                .setName(data.getString("name"))
                .setTime(data.getString("time"))
                .setDetail(data.getString("detail"))
                .setType(data.getString("type"))
                .setDeleted(0);
        // 更新天气记录
        Boolean success = weatherService.updateById(temp);
        // 返回更新是否成功
        return success;
    }

    /**
     * 查询所有天气列表
     *
     * @return 天气列表
     */
    @GetMapping("")
    public List<Weather> list() {
        // 查询列表
        List<Weather> result;
        result=weatherService.list();
//        result=weatherService.getAllDetails(1);
        // 返回列表
        return result;
    }

    /**
     * 获得指定日期编号的天气列表
     *
     * @param id 日期编号
     * @return 天气列表
     */
    @GetMapping("/{id}")
    public List<Weather> get(@PathVariable("id") Integer id) {
        // 查询并返回天气列表
        return weatherService.getAllDetails(id);
    }


}
