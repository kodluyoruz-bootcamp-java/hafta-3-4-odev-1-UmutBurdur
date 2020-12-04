package homework3ve4;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Map<String, City> unSortedMap = new HashMap<>();

        City moscow = new Moscow("Moscow");
        unSortedMap.put(moscow.getCityCode(), moscow);
        City newYork = new NewYork("New York");
        unSortedMap.put(newYork.getCityCode(), newYork);
        City london = new London("London");
        unSortedMap.put(london.getCityCode(), london);
        City berlin = new Berlin("Berlin");
        unSortedMap.put(berlin.getCityCode(), berlin);
        City newDelhi = new NewDelhi("New Delhi");
        unSortedMap.put(newDelhi.getCityCode(), newDelhi);

        sortCityMapAndPrint(unSortedMap);
        boolean correction = true;
        while (correction) {
            List<String> inputs = getInputs(" ");
            if (inputs.size() >= 3 && inputs.size() <=5) {
                try {
                    for (String check : inputs) {
                        if (City.getCityCodeList().contains(check)) {
                            continue;
                        } else {
                            System.out.println("Your choice is not located. Please select city which contains in the list :)");
                        }
                    }
                    for (String list : inputs) {
                        switch (list) {
                            case "MOW":
                                executorService.execute(new RunnableThreadClass(moscow));
                                break;
                            case "NYC":
                                executorService.execute(new RunnableThreadClass(newYork));
                                break;
                            case "LON":
                                executorService.execute(new RunnableThreadClass(london));
                                break;
                            case "BER":
                                executorService.execute(new RunnableThreadClass(berlin));
                                break;
                            case "DEL":
                                executorService.execute(new RunnableThreadClass(newDelhi));
                                break;
                        }
                    }
                    break;
                }catch (Exception exception) {
                    System.out.println("Your choice is not located. Please select city which contains in the list :)");
                }
            } else {
                System.out.println("Please select at least three or at most five cities. Try again! :)");
            }
        }
    }

    private static List<String> getInputs(String inputseperator) {
        System.out.println("Please select at least three cities to view local time. You can only get "
        + "local times of cities which exists in the list. Please give city codes for input and give blanks"
                +" For example: MOW BER NYC");

        String line = scanner.nextLine().toUpperCase();
        return Arrays.asList(line.split(inputseperator));
    }

    private static void sortCityMapAndPrint(Map<String, City> map) {
        List<City> cityName = new ArrayList<>(map.values());
        Collections.sort(cityName);
        for (City cities : cityName) {
            System.out.println(cities.getCityCode() + " = " + cities.getName());
        }
    }

}
