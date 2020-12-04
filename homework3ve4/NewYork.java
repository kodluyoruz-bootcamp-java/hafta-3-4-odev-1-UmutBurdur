package homework3ve4;

public class NewYork extends City implements Runnable{
    public NewYork(String cityName) {

        setName(cityName);
        setCityCode("NYC");
        setGmt("GMT-5");
        addCityCodeList("NYC");
    }

    @Override
    public void run() {
        synchronized (this) {
            this.showTime();
        }
    }
}
