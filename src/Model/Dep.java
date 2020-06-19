package Model;

//学院Model
public class Dep
{
    private int dno;
    private String dname;
    private String dtea;
    private int dnumber;

    public Dep()
    {

    }

    public Dep(int dno, String dname, String dtea, int dnumber)
    {
        this.dno = dno;
        this.dname = dname;
        this.dtea = dtea;
        this.dnumber = dnumber;
    }

    public int getDno()
    {
        return dno;
    }

    public void setDno(int dno)
    {
        this.dno = dno;
    }

    public String getDname()
    {
        return dname;
    }

    public void setDname(String dname)
    {
        this.dname = dname;
    }

    public String getDtea()
    {
        return dtea;
    }

    public void setDtea(String dtea)
    {
        this.dtea = dtea;
    }

    public int getDnumber()
    {
        return dnumber;
    }

    public void setDnumber(int dnumber)
    {
        this.dnumber = dnumber;
    }
}
