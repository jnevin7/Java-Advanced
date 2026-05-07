package ex12_1_exercise;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

import static java.time.DayOfWeek.*;
import static java.time.DayOfWeek.MONDAY;
import static java.time.Month.*;
import static java.time.temporal.ChronoUnit.*;

public class LocalDatesAndTimes {

  public static void main(String[] args) {
    
    // Abe Lincoln's Birthday: February 12, 1809, died April 15, 1855
    LocalDate abeBorn = LocalDate.of(1809, 2, 12);
    System.out.println("Abe was born on: " + abeBorn);
    LocalDate abeDied = LocalDate.of(1855, 4, 15);
    System.out.println("Abe died on: " + abeDied);
    //   How old when he died?
    int abeAge = (abeDied.getYear() - abeBorn.getYear());
    System.out.println("Abe was " + abeAge + " years old.");
    //   How many days did he live?  
    double abeAgeDays = ((abeDied.getYear() - abeBorn.getYear()) * 365.25);
    System.out.println("Abe was " + abeAgeDays + " days old.");
    System.out.println();
    
    // Bennedict Cumberbatch, July 19, 1976
    LocalDate benBorn = LocalDate.of(1976,7,19);
    LocalDate now = LocalDate.now();
    //   Born in a leap year?
    System.out.println("Was Ben born in a leap year? " + benBorn.isLeapYear());
    //   How many days in the year he was born?
    System.out.println("Days in the year he was born: " + benBorn.lengthOfYear());
    //   How many decades old is he?
    System.out.println("Bennedict is " + benBorn.until(now, DECADES) + " decades old.");
    //   What was the day of the week on his 21st birthday?
    System.out.println("It was a " + benBorn.plusYears(21).getDayOfWeek() + " on his 21st birthday.");
    System.out.println();
    
    
    // Train departs Boston at 1:45PM and arrives New York 7:25PM
    //   How many minutes long is the train ride?
    //   If the train was delayed 1 hour 19 minutes, what is the actual arrival time?
    LocalTime depart = LocalTime.of(13, 45);
    LocalTime arrive = LocalTime.of(19, 25);
    System.out.println("Planned Travel time:  " + depart.until(arrive, MINUTES) + " minutes");
    System.out.println("Delayed arrival time: " + arrive.plusHours(1).plusMinutes(19));
    System.out.println();
    
    // Flight: Boston to Miami, leaves March 24th 9:15PM. Flight time is 4 hours 15 minutes
    //   When does it arrive in Miami?
    //   When does it arrive if the flight is delays 4 hours 27 minutes?
    LocalDateTime leaveBoston = LocalDateTime.of(2014, MARCH, 24, 21, 15);
    LocalDateTime arriveMiami = leaveBoston.plusHours(4).plusMinutes(15);
    System.out.println("The flight arrives in Miami: " + arriveMiami);
    System.out.println("The delayed arrival time is: " + arriveMiami.plusHours(4).plusMinutes(27));
    System.out.println();
    
    // School semester starts the second Tuesday of September of this year.
    //   Hint: Look at the TemporalAdjusters class
    //   What is the date?
    //   School summer vacation starts June 25th
    //   Assuming:
    //     *  Two weeks off in December
    //     *  Two other vacation weeks
    //     *  School is taught Monday - Friday
    //   How many days of school are there?
    //   Hint: keep track of the short weeks also
    int excludeWeeks = 5;
    LocalDate schoolStarts = LocalDate.of(2014, SEPTEMBER, 1).with(TemporalAdjusters.firstInMonth(TUESDAY)).with(TemporalAdjusters.next(TUESDAY));
    LocalDate endOfFirstWeek = schoolStarts.with(TemporalAdjusters.next(FRIDAY));
    long firstWeekDays = schoolStarts.until(endOfFirstWeek, DAYS) + 1;
    System.out.println("School starts: " + schoolStarts);
    LocalDate schoolEnds = LocalDate.of(2015, JUNE, 25);
    System.out.println("School ends:   " + schoolEnds);
    long lastWeeksDays = 0;
    if (schoolEnds.getDayOfWeek() != MONDAY) {
      LocalDate lastWeekStart = schoolEnds.with(TemporalAdjusters.previous(MONDAY));
      lastWeeksDays = lastWeekStart.until(schoolEnds, DAYS) + 1;
      excludeWeeks++;
    }
    long days = ((schoolStarts.until(schoolEnds, WEEKS) - excludeWeeks) * 5); // 7 days per week, weekdays are 5/7 of a week.
    days = days + firstWeekDays + lastWeeksDays;
    System.out.println("Number of school days: " + days);
    System.out.println();
    
    // A meeting is schedule for 1:30 PM next Tuesday. If today is Tuesday, assume it is today.
    //   What is the time of the week's meetings?
    LocalTime meetingTime = LocalTime.of(13, 30);
    LocalDate meetingDate = LocalDate.now().with(TemporalAdjusters.nextOrSame(TUESDAY));
    LocalDateTime meeting = LocalDateTime.of(meetingDate, meetingTime);
    System.out.println("The meeting time is: " + meeting);
    System.out.println();
   
  }
  
}
