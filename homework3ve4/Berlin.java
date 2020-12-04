package homework3ve4;

public class Berlin extends City implements Runnable {
    public Berlin(String cityName) {
        setName(cityName);
        setCityCode("BER");
        setGmt("GMT+1");
        addCityCodeList("BER");
    }

    @Override
    public void run() {
        synchronized (this) {
            this.showTime();
        }

    }
}
