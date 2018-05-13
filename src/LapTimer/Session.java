package LapTimer;

import java.util.Vector;

public class Session {

    Vector<Lap> laps = new Vector<Lap>();

    public Session() {

	laps = new Vector<Lap>();

    }

    public void addLap(Lap l) {

	laps.add(l);
    }

    public float calculateAverageTime() {

	/*
	 * This method should calculate the average time of all laps in the collection.
	 * It needs to return a float value
	 */
	float sum = 0.0f;

	for (Lap lap : laps) {

	    sum += lap.getLapTime();
	}

	sum = sum / (laps.size());
	return sum;
    }

    public Lap getFastestLap() {

	/*
	 * This method should step through the collection, and return the Lap object
	 * whose lap time is smallest (fastest).
	 */
	Lap res = null;
	
	// get the first lap if any
	if (laps.size() > 0) {
	    res = laps.get(0);
	}
	// for each lap, compare to the current lap and if higher, changes the value
	for (Lap l : laps) {
	    if (res != null && res.getLapTime() > l.getLapTime()) {
		res = l;
	    }
	}

	return res;

    }

    public Lap getSlowestLap() {

	/*
	 * This method should step through the collection, and return the Lap object
	 * whose lap time is largest (slowest).
	 */

	Lap res = null;

	// get the first lap if any
	if (laps.size() > 0) {
	    res = laps.get(0);
	}

	// for each lap, compare to the current lap and if lower, changes the value
	for (Lap l : laps) {
	    if (res != null && res.getLapTime() < l.getLapTime()) {
		res = l;
	    }
	}

	return res;

    }

}
