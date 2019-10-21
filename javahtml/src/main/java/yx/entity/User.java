package yx.entity;

/**
 * @author:三金
 * @Date:2019/10/17 19:16
 */
public class User {
    private int ID;
    private String name;
    private String pwd;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User() {
    }

    public User(int ID, String name, String pwd) {
        this.ID = ID;
        this.name = name;
        this.pwd = pwd;
    }
}
