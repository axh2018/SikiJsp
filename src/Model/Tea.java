package Model;

//教师Model
public class Tea
{
    private int tno;
    private String tname;
    private int tage;

    public Tea()
    {

    }

    public Tea(int tno, String tname, int tage)
    {
        this.tno = tno;
        this.tname = tname;
        this.tage = tage;
    }

    public int getTno()
    {
        return tno;
    }

    public void setTno(int tno)
    {
        this.tno = tno;
    }

    public String getTname()
    {
        return tname;
    }

    public void setTname(String tname)
    {
        this.tname = tname;
    }

    public int getTage()
    {
        return tage;
    }

    public void setTage(int tage)
    {
        this.tage = tage;
    }
}
