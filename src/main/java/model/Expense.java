package model;

import java.sql.Date;

public class Expense {

    private int expenseId;
    private String name;
    private double value;
    private String type;
    private String description;
    private Date date;
    private int userId;

    public Expense() {
    }

    public Expense(String name, double value, String type, String description, Date date, int userId) {
        this.name = name;
        this.value = value;
        this.type = type;
        this.description = description;
        this.date = date;
        this.userId = userId;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int id) {
        this.expenseId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
