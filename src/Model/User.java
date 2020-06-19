package Model;

import java.io.Serializable;

//管理员Model
public class User implements Serializable
{
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String passwd;

    public User(int id, String name, String passwd)
    {
        this.id = id;
        this.name = name;
        this.passwd = passwd;
    }
    public User(String name, String passwd)
    {
        this.name = name;
        this.passwd = passwd;
    }
    public User()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPasswd()
    {
        return passwd;
    }

    public void setPasswd(String passwd)
    {
        this.passwd = passwd;
    }
}
