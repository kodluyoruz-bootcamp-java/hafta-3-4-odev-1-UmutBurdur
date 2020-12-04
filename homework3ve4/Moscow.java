package homework3ve4;

public class Moscow extends City implements Runnable{

    public Moscow(String cityName) {
        setName(cityName);
        setCityCode("MOW");
        setGmt("GMT+3");
        addCityCodeList("MOW");

    }

    @Override
    public void run() {
        synchronized (this) {
            this.showTime();
    }

    }
}
