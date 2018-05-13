package LapTimer;

public class LapTimerThread implements Runnable {

    private boolean running;

    private float lapSeconds, totalSeconds;

    private LapTimer parent;

    private float increment = (float) 0.1;

    /*
     * The constructor takes the parent frame and the total seconds that the
     * application has been running for so far as parameters, and then launches a
     * thread.
     */
    public LapTimerThread(LapTimer parent, float totalSeconds) {

	this.parent = parent;

	running = true;

	lapSeconds = (float) 0.0;

	this.totalSeconds = totalSeconds;
	// (new Thread(this)).start();

    }

    @Override
    /*
     * This method should keep incrementing the two counters - lapSeconds and
     * totalSeconds - by the increment each tenth of a second. It should then update
     * the corresponding text fields in the main display.
     */
    public void run() {

	/* Insert code here */
	while (running) {
	    // Moving actions before sleep to avoid difference in the final display and the textField
	    totalSeconds += increment;
	    lapSeconds += increment;
	    parent.updateTotalDisplay(totalSeconds);
	    parent.updateLapDisplay(lapSeconds);

	    try {
		Thread.sleep(100);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }

    /* This method stops the thread. */
    public void stop() {

	/* Insert code here */
	running = false;
    }

    public float getLapSeconds() {
	return lapSeconds;

    }

    public float getTotalSeconds() {

	return totalSeconds;

    }
    
    /*
     * Returns current status of the lapTimeThread. Allows to deal with the state of this lapThread
     */
    public boolean isRunning() {
	return running;
    }
}
