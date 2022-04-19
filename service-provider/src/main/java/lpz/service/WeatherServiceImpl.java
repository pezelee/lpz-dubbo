package lpz.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lpz.entity.Weather;
import lpz.mapper.WeatherMapper;
import lpz.api.WeatherService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * Weather Service
 * </p>
 *
 * @author lpz
 * @date Created in 2022-04-07
 */
@Service
public class WeatherServiceImpl extends ServiceImpl<WeatherMapper, Weather> implements WeatherService {

    @Override
    public List<Weather> getAllDetails(Integer dayId) {

            LambdaQueryWrapper<Weather> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Weather::getDayId, dayId);
            List<Weather> details = list(queryWrapper);
            return details;
    }
}
