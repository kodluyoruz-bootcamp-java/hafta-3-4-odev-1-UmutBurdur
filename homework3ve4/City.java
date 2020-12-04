package homework3ve4;


import java.text.SimpleDateFormat;
import java.util.*;

public class City implements Clock, Comparable<City>{
    private String name;
    private String cityCode;
    private String gmt;
    private static List<String> cityCodeList = new ArrayList<>();


    public City() {
    }

    public static List<String> getCityCodeList() {
        return cityCodeList;
    }

    public void addCityCodeList(String city) {
        City.cityCodeList.add(city);
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGmt(String gmt) {
        this.gmt = gmt;
    }
    boolean enteringLoop = true;

    @Override
    public void showTime() {
        while (enteringLoop) {
            Date time = Calendar.getInstance().getTime();
            SimpleDateFormat now = new SimpleDateFormat("HH:mm:ss");
            now.setTimeZone(TimeZone.getTimeZone(gmt));
            String timer = now.format(time);
            System.out.println(getName() + " : " + timer);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int compareTo(City o) {
        return this.getName().compareTo(o.getName());
    }
}

