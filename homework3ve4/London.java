package homework3ve4;

public class London extends City implements Runnable {
    public London(String cityName) {
        setName(cityName);
        setCityCode("LON");
        setGmt("GMT");
        addCityCodeList("LON");
    }

    @Override
    public void run() {
        synchronized (this) {
            this.showTime();
        }
    }
}
