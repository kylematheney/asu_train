
/**
 * Pulls train, station, and time information and passes the information to a String
 * formatter for printing by the driver
 *
 * Completion Time: 3 hours
 *
 * @author Kyle Matheney
 * @version 1.0
 */
import java.text.NumberFormat;

public class TrainRoute {

    static NumberFormat nf = NumberFormat.getCurrencyInstance();
    private Train train;
    private String number;
    private double cost;
    private Time departure;
    private int duration;
    private TrainStation source, destination;

    public TrainRoute(Train train, String trainNumber, double routeCost,
            Time departureTime, int durationTime, TrainStation sourceTrainStation,
            TrainStation destinationTrainStation) {
        this.train = train;
        this.number = trainNumber;
        this.cost = routeCost;
        this.departure = departureTime;
        this.duration = durationTime;
        this.source = sourceTrainStation;
        this.destination = destinationTrainStation;
    }

    public Train getTrain() {
        return train;
    }

    public String getNumber() {
        return number;
    }

    public double getCost() {
        return cost;
    }

    public TrainStation getDestination() {
        return destination;
    }

    public Time getDeparture() {
        return departure;
    }

    public Time getArrival() {
        Time arrival = new Time(departure.getHour(), departure.getMinute());
        arrival.addMinutes(duration);
        return arrival;
    }

    public TrainStation getSource() {
        return source;
    }

    public String toOverviewString() {
        String durationTime = (duration / 60) + "h:" + (duration % 60) + "m";
        String verbiage = nf.format(cost) + "\n";
        verbiage += getDeparture() + " - " + getArrival() + "\t" + durationTime;
        verbiage += "\n" + train.getTrainType() + "\t\t" + getSource() + "-"
                + getDestination();
        return verbiage;
    }

    public String toDetailedString() {
        String verbiage = getDeparture() + " - " + getArrival() + "\n";
        verbiage += TrainStation.getTrainStationCity(source) + " (" + source + ") - ";
        verbiage += TrainStation.getTrainStationCity(destination)
                + " (" + destination + ")\n";
        verbiage += train.getTrainType() + " " + getNumber();
        return verbiage;
    }
}
