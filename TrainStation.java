
/**
 * Lists train stations by code and returns their city. Returns "unknown city"
 * if an invalid code is used.
 *
 * Completion Time: 15 minutes
 *
 * @author Kyle Matheney
 * @version 1.0
 */
public enum TrainStation {
    AMS,
    BRU,
    CDG,
    DUS,
    FRA,
    LHR,
    RWA,
    VIE;

    public static String getTrainStationCity(TrainStation trainStation) {
        switch (trainStation) {
            case AMS:
                return "Amsterdam";
            case BRU:
                return "Brussels";
            case CDG:
                return "Paris";
            case DUS:
                return "Düsseldorf";
            case FRA:
                return "Frankfurt";
            case LHR:
                return "London";
            case RWA:
                return "Warsaw";
            case VIE:
                return "Vienna";
            default:
                return "Unknown City";

        }
    }
}
