package mate.academy;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventManager {
    private List<EventListener> listeners = new CopyOnWriteArrayList<>();

    public void registerListener(EventListener listener) {
        listeners.add(listener);
    }

    public void deregisterListener(EventListener listener) {
        listeners.remove(listener);
    }

    public void notifyEvent(Event event) {
        listeners.stream()
                .forEach(listener -> listener.onEvent(event));
    }

    public void shutdown() {
        listeners.clear();
    }
}
