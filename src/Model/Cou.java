package Model;

//课程Model
public class Cou
{
    private int cno;
    private String cname;
    private String ctea;
    private int cnumber;

    public Cou()
    {

    }
    public Cou(int cno, String cname, String ctea, int cnumber)
    {
        this.cno = cno;
        this.cname = cname;
        this.ctea = ctea;
        this.cnumber = cnumber;
    }

    public int getCno()
    {
        return cno;
    }

    public void setCno(int cno)
    {
        this.cno = cno;
    }

    public String getCname()
    {
        return cname;
    }

    public void setCname(String cname)
    {
        this.cname = cname;
    }

    public String getCtea()
    {
        return ctea;
    }

    public void setCtea(String ctea)
    {
        this.ctea = ctea;
    }

    public int getCnumber()
    {
        return cnumber;
    }

    public void setCnumber(int cnumber)
    {
        this.cnumber = cnumber;
    }
}
