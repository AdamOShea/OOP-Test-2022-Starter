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

		if (nematodes.get(scroll).gender.equals("m"))
		{
			stroke(255);
			line(400, 125 + off*circles, 400, 160 + off*circles);
			circle(400, 170 + off*circles, 20);
			
		}

		if (nematodes.get(scroll).gender.equals("f"))
		{
			stroke(255);
			circle(400, 85 + off*circles, 40);
	
		}

		if (nematodes.get(scroll).gender.equals("h"))
		{
			stroke(255);
			circle(400, 85 + off*circles, 40);
			line(400, 125 + off*circles, 400, 160 + off*circles);
			circle(400, 170 + off*circles, 20);
		}

		if (nematodes.get(scroll).eyes.equals("1"))
		{
			stroke(255);
			line(365, 160 - (off-15), 380, 160 - (off-40));
			line(435, 160 - (off-15), 420, 160 - (off-40));
			circle(355, 165-off, 25);
			circle(445, 165-off, 25);
		}
		
	}
}
