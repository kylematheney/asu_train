
/**
 * Gets train information and uses a String formatter for printing
 *
 * Completion Time: 20 minutes
 *
 * @author Kyle Matheney
 * @version 1.0
 */
public class Train {

    TrainType trainType;

    public Train(TrainType train) {
        this.trainType = train;
    }

    public TrainType getTrainType() {
        return this.trainType;
    }

    @Override
    public String toString() {
        return this.trainType + " * ";
    }
}
