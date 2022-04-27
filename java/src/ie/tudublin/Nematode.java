package ie.tudublin;

import jogamp.graph.font.typecast.ot.table.CffTable.Index;
import processing.core.PApplet;
import processing.data.TableRow;

public class Nematode
{
    public String name;
    public int length;
    public int limbs;
    public String gender;
    public String eyes;
    
    

    @Override
    public String toString() {
        return "Nematode [eyes=" + eyes + ", gender=" + gender + ", length=" + length + ", limbs=" + limbs + ", name="
                + name + "]";
    }

    public Nematode(TableRow tr) 
    {
        this(tr.getString("name"),
            tr.getInt("length"),
            tr.getInt("limbs"),
            tr.getString("gender"),
            tr.getString("eyes"));
    }

    public Nematode(String name, int length, int limbs, String gender, String eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLimbs() {
        return limbs;
    }

    public void setLimbs(int limbs) {
        this.limbs = limbs;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public void render(NematodeVisualiser pa)
    {
        pa.fill(255);
        pa.textSize(50);
        pa.textAlign(PApplet.CENTER, PApplet.CENTER);
        pa.text(name, pa.width / 2, pa.height - (5 * 0.5f));

    }

  
}