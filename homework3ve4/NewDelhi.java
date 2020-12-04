package homework3ve4;

public class NewDelhi extends City implements Runnable {
    public NewDelhi(String cityName) {
        setName(cityName);
        setCityCode("DEL");
        setGmt("GMT+5:30");
        addCityCodeList("DEL");

    }

    @Override
    public void run() {
        synchronized (this) {
            this.showTime();
        }

    }
}
