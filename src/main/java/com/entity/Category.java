package com.entity;

import lombok.Data;
                                     
import java.util.Date;

@Data
public class Category {

    private int cid;
    private String cname;
    private int level;
    private Date createTime;
    private Date lastModifyDate;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Category{");
        sb.append("pid=").append(cid);
        sb.append(", cname='").append(cname).append('\'');
        sb.append(", level=").append(level);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastModifyDate=").append(lastModifyDate);
        sb.append('}');
        return sb.toString();
    }
}
