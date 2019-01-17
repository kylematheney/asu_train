
/**
 * Gets times, converts time from 24 hour format to 12 hour, and formats to hh:mm
 * String
 *
 * Completion Time: 2 hours
 *
 * @author Kyle Matheney
 * @version 1.0
 */
public class Time {

    int hour, minute;

    public Time() {
        this.hour = 0;
        this.minute = 0;
    }

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public void addHours(int hour) {
        this.hour = ((this.hour + hour % 24) + 24) % 24;
        //this.hour = (((hour % 24) + this.hour) + 24) % 24;
    }

    public void addMinutes(int minute) {
        this.minute += minute;
        // Converts all intervals of 60 minutes to an hour
        this.addHours((int) Math.floor(((double) this.minute) / (60.0)));
        this.minute = (((this.minute % (60 * 24)) + (60 * 24)) % (60 * 24)) % 60;
    }

    public void addTime(Time time) {
        this.addHours(time.hour);
        this.addMinutes(time.minute);
    }

    public Time getCopy() {
        Time time = new Time(this.hour, this.minute);
        return time;
    }

    public boolean isEarlierThan(Time time) {
        boolean value = false;
        if (hour < time.getHour()) {
            value = true;
        }
        return value;
    }

    public boolean isSameTime(Time time) {
        boolean value = false; // return value is false by default
        if (hour == time.getHour() && minute == time.getMinute()) {
            // return value is only changed if this condition is met
            value = true;
        }
        return value;
    }

    public boolean isLaterThan(Time time) {
        boolean value = false;
        if (hour > time.getHour()) {
            value = true;
        }
        return value;
    }

    @Override
    public String toString() {
        String AM_PM = "PM";
        String minutes = String.format("%02d", this.minute);
        if (this.hour <= 11) {
            AM_PM = "AM";
        }
        int formattedHour = (((((this.hour % 12) - 1)) + 12) % 12) + 1;
        return formattedHour + ":" + minutes + AM_PM;
    }
}
