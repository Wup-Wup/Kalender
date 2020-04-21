import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.IsoFields;

public class TestMain {

	public static void main(String[] args) {
		kalender(2020,10);
		
	}
	
		static void kalender(int jahr,int monat) {
		
		LocalDate kdate = LocalDate.of(jahr, monat, 1);

		System.out.println(kdate.getMonth()+", "+kdate.getYear());
		System.out.println("Wo\t Mo\t Di\t Mi\t Do\t Fr\t Sa\t So");
		int weekNumber = kdate.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
		int newWeekNumber=weekNumber;
		System.out.print(weekNumber+"\t ");
		
		
		
		switch(kdate.getDayOfWeek()) {
		 case MONDAY:
	            System.out.print(kdate.getDayOfMonth());
	            break;
		 case TUESDAY:
	            System.out.print("\t "+kdate.getDayOfMonth());
	            break;
		 case WEDNESDAY:
	            System.out.print("\t \t "+kdate.getDayOfMonth());
	            break;
		 case THURSDAY:
	            System.out.print("\t \t \t "+kdate.getDayOfMonth());
	            break;
		 case FRIDAY:
	            System.out.print("\t \t \t \t "+kdate.getDayOfMonth());
	            break;
		 case SATURDAY:
	            System.out.print("\t \t \t \t \t "+kdate.getDayOfMonth());
	            break;
		 case SUNDAY:
	            System.out.print("\t \t \t \t \t \t "+kdate.getDayOfMonth());
	            break;      
		}
		kdate= kdate.plusDays(1);
		
		do {
			if(newWeekNumber!=weekNumber) {
				System.out.print(newWeekNumber);
			}
			weekNumber=newWeekNumber;
			if(kdate.getDayOfWeek()==DayOfWeek.SUNDAY) {
				System.out.println("\t "+kdate.getDayOfMonth());
			}else {
				System.out.print("\t "+kdate.getDayOfMonth());
			}
			kdate= kdate.plusDays(1);
			newWeekNumber = kdate.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
		}while(kdate.getMonthValue()==monat);
	}
}
