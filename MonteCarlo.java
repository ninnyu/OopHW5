/* Homework 5
 * @author NinnYu Chin
 * Description: An implementation of the monte carlo method using squares and circles.
 */

//import java.util.Random;
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
//		Random r = new Random();
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