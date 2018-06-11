package model;

import javax.print.attribute.standard.DateTimeAtProcessing;
import java.sql.Date;

public class Expense {

    private int id;
    private double value;
    private String type;
    private String remark;
    private Date date;
    private int userId;

    public Expense(int id, double value, String type, String remark, Date date, int userId) {
        this.id = id;
        this.value = value;
        this.type = type;
        this.remark = remark;
        this.date = date;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
