package lpz.api;

import com.baomidou.mybatisplus.extension.service.IService;
import lpz.entity.Weather;

import java.util.List;

/**
 * <p>
 * Weather Service
 * </p>
 *
 * @author lpz
 * @date Created in 2022-04-07
 */
public interface WeatherService extends IService<Weather>   {

    public List<Weather> getAllDetails(Integer dayId);
}
