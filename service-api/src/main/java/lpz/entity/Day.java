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
 * 日期实体类
 * </p>
 *
 * @author lpz
 * @date Created in 2022-04-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "day")
public class Day implements Serializable {

    /**
     * 日期编号
     */
    private Integer id;
    /**
     * 日期名
     */
    private String name;
    /**
     * 密码（明文）
     */
    private String status;
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

    public Day setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Day setName(String name) {
        this.name = name;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Day setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Day setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public Day setDeleted(Integer deleted) {
        this.deleted = deleted;
        return this;
    }
}
