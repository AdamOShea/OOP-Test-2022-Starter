package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Nematode
{
    private String name;
    private int length;
    private int limbs;
    private String gender;
    private boolean eyes;
    
    @Override
    public String toString() {
        return "Nematode []";
    }

    public Nematode(TableRow tr) 
    {
        this(tr.getString("name"),
        tr.getInt("length"),
        tr.getInt("limbs"),
        tr.getString("gender"),
        tr.getInt("eyes") == 1);
    }

    

    private String name;

    public String getName() 
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void getLength()
    {
        return length;
    }

    public int getLimbs()
    {
        return limbs;
    }

    public String getGender()
    {
        return gender;
    }

    public void getEyes()
    {
        return eyes;
    }
    
}