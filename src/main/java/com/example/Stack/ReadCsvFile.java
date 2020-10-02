package com.example.Stack;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

// Read and analyze the data.csv file, and output the answers to these questions:

//How many total customers are in this data set?
//How many customers are in each city?
//How many customers are in each country?
//Which country has the largest number of customers' contracts signed in it? How many contracts does it have?
//How many unique cities have at least one customer in them?
//The answers for second and third questions (the number of customers in each city and in each country) must be sorted by city and country name respectively, in ascending order. If there are several cities that are tied for having the most customers' contracts, print the lexicographically larger one. Please keep in mind that all string comparisons should be considered case-sensitive.
//
//The answers should be formatted as:
//
//Total customers:
//<number>
//Customers by city:
//<CITY>: <number>
//<CITY>: <number>
//...
//Customers by country:
//<COUNTRY>: <number>
//<COUNTRY>: <number>
//...
//Country with the largest number of customers' contracts:
//<country> (<number> contracts)
//Unique cities with at least one customer:
//<number>


//Example
//
//For the following data.csv
//
//ID,NAME,CITY,COUNTRY,CPERSON,EMPLCNT,CONTRCNT,CONTRCOST
//00000001,Breadpot,Sydney,Australia,Sam.Keng@info.com,250,48,1024.00
//00000002,Hoviz,Manchester,UK,harry.ham@hoviz.com,150,7,900.00
//00000003,Hoviz,London,UK,hamlet.host@hoviz.com,1500,12800,10510.50
//00000004,Grenns,London,UK,grenns@grenns.com,200,12800,128.30
//00000005,Magnolia,Chicago,USA,man@info.com,1024,25600,512000.00
//00000006,Dozen,San Francisco,USA,dozen@dozen.com,1000,5,1000.20
//00000007,Sun,San Francisco,USA,sunny@sun.com,2000,2,10000.01
//the output for this should be:
//
//Total customers:
//7
//Customers by city:
//Chicago: 1
//London: 2
//Manchester: 1
//San Francisco: 2
//Sydney: 1
//Customers by country:
//Australia: 1
//UK: 3
//USA: 3
//Country with the largest number of customers' contracts:
//USA (25607 contracts)
//Unique cities with at least one customer:
//5





// Main class should be named 'Solution'
class ReadCsvFile {

    public static void main(String[] args) throws Exception {
        FileReader frd = new FileReader("/root/customers/data.csv");
        BufferedReader brd = new BufferedReader(frd);
        String header = brd.readLine();

        String data = null;
        Map<String, Integer> map1 = new TreeMap<>();
        Map<String, Integer> map2 = new TreeMap<>();
        Map<String, Integer> map3 = new TreeMap<>();
        int totalCustomers = 0;

        while((data = brd.readLine()) != null) {
            totalCustomers = totalCustomers + 1;
            String[] array = data.split(",");
            String city = array[2];
            int count = map1.getOrDefault(city, 0);
            map1.put(city, count + 1);
            String country = array[3];
            count = map2.getOrDefault(country, 0);
            map2.put(country, count + 1);
            String contrcnt = array[6];
            count = map3.getOrDefault(country, 0);
            map3.put(country, count + Integer.parseInt(contrcnt));
        }
        displayData(totalCustomers, map1, map2, map3);
        brd.close();
    }

    static void displayData(int totalCustomers, Map<String, Integer> map1, Map<String, Integer> map2, Map<String, Integer> map3) {
        System.out.println("Total customers:");
        System.out.println(totalCustomers);
        System.out.println("Customers by city:");
        StringBuilder sb = new StringBuilder();
        int uniqueCities = 0;

        for(String city : map1.keySet()) {
            int count = map1.get(city);
            if(count > 0) {
                uniqueCities = uniqueCities + 1;
            }
            sb.append(city + ": " + count).append("\n");
        }
        String cities = sb.toString().trim();
        System.out.println(cities);

        System.out.println("Customers by country:");
        sb = new StringBuilder();
        for(String country : map2.keySet()) {
            int count = map2.get(country);
            sb.append(country + ": " + count).append("\n");
        }
        String countries = sb.toString().trim();
        System.out.println(countries);

        System.out.println("Country with the largest number of customers' contracts:");
        String country = null;
        int moreContracts = 0;
        for(String contract : map3.keySet()) {
            int count = map3.get(contract);
            if(moreContracts <= count) {
                moreContracts = count;
                country = contract;
            }
        }
        System.out.println(country + " ("+moreContracts +" contracts)");
        System.out.println("Unique cities with at least one customer:");
        System.out.println(uniqueCities);
    }
}
