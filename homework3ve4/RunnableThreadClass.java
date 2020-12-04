package homework3ve4;

public class RunnableThreadClass implements Runnable {
    private City city;

    public RunnableThreadClass(City city) {
        this.city = city;
    }

    @Override
    public void run() {
        synchronized (this) {
            city.showTime();
        }
    }


}
