/* 	Homework 5
 * 	@author NinnYu Chin
 * 	Instruction:	Let's say that you draw a square around the top right 
 *			quadrant of a circle. If the circle has a radius r, then the square that 
 *			covers the top right quadrant of the circle will cover an area r^2.
 *
 *			The area of a circle is Pi*r^2. Given that we're dealing with only the top 
 *			right quadrant, the area will be (Pi*r^2)/4. The ratio of the area of 
 *			the top right quadrant of the circle to the square that covers it would 
 *			be...?
 *
 *			Generate 4 billion random dots that fall within that square. Figure out 
 *			how many of them fall inside the circle, and how many fall outside of it. 
 *			If you divide the number of dots that fall within the circle by the total 
 *			number of dots (the ones that fell anywhere in the entire square), you 
 *			should get roughly the same ratio as the one you computed above. From 
 *			there, you should be able to calculate the value of PI.
 *
 *			Btw, this is known as the monte carlo method, if you wanna google stuff.
 */

import java.util.Scanner;

public class MonteCarlo {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a radius: ");
		
		double radius = sc.nextDouble(),
				circleArea = Math.pow(radius, 2) * Math.PI,
				quadrantArea = circleArea/4,
				squareArea = Math.pow(radius, 2),
				ratio1 = quadrantArea/squareArea,
				pie1 = ratio1*4,
				pie2, ratio2, x = 0, y = 0;
		long circleCount = 0L, total = 0L;
		
		System.out.printf(	"Radius = %.3f%n"
							+ "Circle's area = %.3f%n"
							+ "Quadrant's area = %.3f%n"
							+ "Square's area = %.3f%n"
							+ "Ratio of quadrant's area to square's area = %.3f%n"
							+ "Calculated Pi using the quadrant's area and the square's area = %.10f%n%n",
							radius, circleArea, quadrantArea, squareArea, ratio1, pie1);
		
		//Generates random points and keeps track of count.
		for (long i = 0L; i < 4000000000L; i++) {
			x = Math.random()*radius;
			y = Math.random()*radius;
			if (inCircle(radius, x, y))
				circleCount++;
			total++;
		}
		
		ratio2 = (double)circleCount/(double)total;
		pie2 = ratio2*4;
		
		System.out.printf(	"Number of points in circle = %d%n"
							+ "Number of points in square = %d%n"
							+ "Ratio of points in circle to points in square = %.3f%n"
							+ "Calculated Pi using points in circle and points in square = %.10f%n",
							circleCount, total, ratio2, pie2);
		sc.close();
	}
	
	//Helper function that checks if a point is in the circle.
	public static boolean inCircle(double radius, double x, double y) {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= radius;
	}
}
