import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProcessData{


    public static void main(String[] args) {
        List<int []> list = processTornadoList("1950-2024_all_tornadoes.csv");
        printFirstLines(list);
        double[] histogram = makeHistogramByTime(list);
        for (double percent : histogram) {
            System.out.print(percent + " ");
            System.out.println();
        }
        System.out.println();
        double[] magnHistogram = makeHistogramByMagn(list);
        for (double average : magnHistogram) {
            System.out.print(average + " ");
            System.out.println();
        }
        
        saveList("time_magnitude.csv", list);
        //processCountyData("county_data.dat");
    }

    public static double[] makeHistogramByTime(List<int []> list) {
        int[] time = new int[24];
        int total = 0;
        for (int[] line : list){
            int bin = line[0];
            time[bin]++;
            total++;
        }
        double[] normalizedTime = new double[24];
        for (int i = 0; i < time.length; i++){
            normalizedTime[i] = (double) time[i] / total;
        }
        return normalizedTime;
    }

    public static double[] makeHistogramByMagn(List<int []> list){
        double[] totalMagnitude = new double[24];
        int[] countPerHour = new int[24];

        for (int[] line : list) {
        int hour = line[0];      
        int magnitude = line[1];
        
            if (hour >= 0 && hour < 24) {
                totalMagnitude[hour] += magnitude;
                countPerHour[hour]++;
            }
        }
        double[] averages = new double[24];
        for (int i = 0; i < 24; i++) {
            if (countPerHour[i] > 0) {
                averages[i] = totalMagnitude[i] / countPerHour[i];
            } else {
                averages[i] = 0.0; // No data for this hour
            }
        }

        return averages;
    }

    /**
     * Reads a csv file of NOAA tornado data and converts it to a String array
     * where each row is a tornado event
     */
    public static List<int  []> processTornadoList(String filename){ // need to import List
        List<int []> tornados = new ArrayList<int []>();
        try (Scanner fileIn = new Scanner(new File(filename))) {
            fileIn.nextLine();    // discard header row
            String delimiter = ",";
            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine();
                String [] tokens = line.split(delimiter);
                int time = Integer.parseInt(tokens[5].substring(0,2));
                int magn = Integer.parseInt(tokens[10]);
                int [] thisTornado = {time, magn};
                tornados.add(thisTornado);
                // create a new String array that has only the 9 fields that are needed in step one
                // add that new String array to the list
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return tornados;

    }

    public static void processCountyData(String filename){ // change to make it so only writes so much data and removes brackets and prints outside the method
        List<String []> counties = new ArrayList<String []>();
        try (Scanner fileIn = new Scanner(new File(filename))) {
            fileIn.nextLine();
            String delimiter = "##";
            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine();
                String[] tokens = line.split(delimiter);
                counties.add(tokens);
                // process tokens
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        boolean append = false;
        String file = "counties.csv";
        // false to overwrite, true to append
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, append)))){
            for(int i = 0; i < counties.size(); i++){
                out.println(Arrays.toString(counties.get(i)));
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void saveList(String filename, List<int []> list){
        boolean append = false;
        // false to overwrite, true to append
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename, append)))){
            for (int [] line : list){
                for (int s : line){
                    out.print(s + ",");
                }
                out.println();
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void printFirstLines(List<int []> list){
        for (int i = 0; i < 5; i++){
            System.out.println(Arrays.toString(list.get(i))); // import
        }
    }

    



}