import java.util.HashMap;
import java.util.Map;

public class EventTracker implements Tracker {

    private static EventTracker INSTANCE = new EventTracker();

    private Map<String, Integer> tracker;

    private EventTracker() {
        this.tracker = new HashMap<>();
    }

    synchronized public static EventTracker getInstance() {
        return INSTANCE;
    }

    synchronized public void push(String message) {
        tracker.merge(message, 1, Integer::sum);
    }

    synchronized public Boolean has(String message) {
        if(tracker.get(message)==null || tracker.get(message).equals(0)){
            return false;
        }
        else{
            return true;
        }
    }

    synchronized public void handle(String message, EventHandler e) {
        if(tracker.get(message)!=null && tracker.get(message) > 0){
            e.handle();
            tracker.merge(message,-1,Integer::sum);
        }
    }

    public Map<String, Integer> tracker(){
        return tracker;
    }

    // Do not use this. This constructor is for tests only
    // Using it breaks the singleton class
    EventTracker(Map<String, Integer> tracker) {
        this.tracker = tracker;
    }
}
