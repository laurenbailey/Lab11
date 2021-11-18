/* Class: CSE 1322L
Section: WJ1
Term: Fall 2021
Instructor: Leul Endashaw
Name: Lauren Bailey
Lab#: 11
*/
import java.util.Scanner;
class InvalidTimeException extends Exception{
    public InvalidTimeException(String message) {
        super(message);
    }
}
public class Lab11 {
    public static int getSeconds(String time) throws InvalidTimeException {
        if(time.trim().equals(""))
            throw new InvalidTimeException("Enter a valid time");
        String[] timeArgs = time.split(":", 3);
        if(timeArgs.length != 3) {
            throw new InvalidTimeException("Enter a valid time");
        }
        int hours = Integer.parseInt(timeArgs[0]);
        if(hours<0 || hours>23)
            throw new InvalidTimeException("Hour must be below 24");
        int minutes = Integer.parseInt(timeArgs[1]);
        if(minutes<0 || minutes>59)
            throw new InvalidTimeException("Minutes must be less than 60");
        int seconds = Integer.parseInt(timeArgs[2]);
        if(seconds<0 || seconds>59)
            throw new InvalidTimeException("Seconds must be less than 60");
        return hours*60*60 + minutes*60 + seconds;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter time 1 in 24hr format as follows (HH:MM:SS)");
            String time1 = scan.nextLine();
            int t1 = getSeconds(time1);
            System.out.println("Enter time 2 in 24hr format as follows (HH:MM:SS)");
            String time2 = scan.nextLine();
            int t2 = getSeconds(time2);
            int difference = Math.abs(t1-t2);
            System.out.println("Difference in seconds: "+difference);
        }
        catch (InvalidTimeException e){
            System.out.println(e.getMessage());
        }
    }
}