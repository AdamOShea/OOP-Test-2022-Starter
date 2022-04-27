package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();
	public int scroll = 0;

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
			if (scroll != 0) scroll--;
		}		
		if (keyCode == RIGHT)
		{
			scroll++;
		}		
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();	
		loadNematodes();			
	}

	// void printStars()
    // {
    //     for(Nematode n:nematodes)
    //     {
    //         System.out.println(n);
    //     }
    // }
	
	// public void drawNemat()
	// {
	// 	for (Nematode n:nematodes)
	// 	{
	// 		n.render(this);
	// 	}
	// }

	public void loadNematodes()
	{
		Table table = loadTable("nematodes.csv", "header");

		for (TableRow r:table.rows())
		{
			Nematode nemat = new Nematode(r);
			nematodes.add(nemat);
		}
	}


	public void draw()
	{	
		int amt = nematodes.size();
		scroll = scroll % amt;
		clear();
		textSize(60);
		textAlign(CENTER);
		String Name = nematodes.get(scroll).name;
		text(Name, 400, 50);

		float off = 75;
		float circles = nematodes.get(scroll).length;

		for (int i = 0; i < circles; i++)
		{
			strokeWeight(5);
			stroke(255);
			noFill();

			circle(400, (height / 5f) + off*i, 75);
		}

		if (nematodes.get(scroll).limbs == 1)
		{
		for (int i = 0; i < circles; i++)
			{
				stroke(255);
				line(360, (height / 5f) + off*i, 330, (height / 5f) + off*i);
				line(440, (height / 5f) + off*i, 470, (height / 5f) + off*i);
			}
		}
		
	}
}
