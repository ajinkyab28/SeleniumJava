import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsDemo 
{
	public static void main(String[] args) 
	{
		ArrayList<String>names=new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Rama");
		
		// Print count of names starting with A
		Long count=names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(count);
		
		// Print names of length > 4
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		// Print names whose last letter is A in UpperCase
		names.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		// Print names starting with A, sorted in uppercase
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		List<Integer>values=Arrays.asList(3,2,4,3,2,1,5,9,11,23,7,6,6);
		values.stream().distinct().sorted().forEach(s->System.out.println(s));
	}
}
