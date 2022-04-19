package lpz.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT;
import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT_UPDATE;

/**
 * <p>
 * 气候实体类
 * </p>
 *
 * @author lpz
 * @date Created in 2022-04-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "weather")
public class Weather implements Serializable {
    /**
     * 天气编号
     */
    private Integer id;
    /**
     * 日期id
     */
    private Integer dayId;
    /**
     * 名称
     */
    private String name;
    /**
     * 时间
     */
    private String time;
    /**
     * 详情
     */
    private String detail;
    /**
     * 类型
     */
    private String type;
    /**
     * 创建时间
     */
    @TableField(fill = INSERT)
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField(fill = INSERT_UPDATE)
    private Date updateTime;
    /**
     * 是否删除
     */
    @TableLogic
    private Integer deleted;

    public Integer getId() {
        return id;
    }

    public Weather setId(Integer id) {
        this.id = id;
        return this;
    }
//
    public Integer getDayId() {
        return dayId;
    }

    public Weather setDayId(Integer dayId) {
        this.dayId = dayId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Weather setName(String name) {
        this.name = name;
        return this;
    }

    public String getTime() {
        return time;
    }

    public Weather setTime(String time) {
        this.time = time;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public Weather setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public String getType() {
        return type;
    }

    public Weather setType(String type) {
        this.type = type;
        return this;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public Weather setDeleted(Integer deleted) {
        this.deleted = deleted;
        return this;
    }

}
