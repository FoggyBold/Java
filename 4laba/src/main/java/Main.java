package main.java;

import au.com.bytecode.opencsv.CSVReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Human {
    int ID;
    String name;
    String gender;
    Department department;
    int salary;
    String birthday;

    Human(int ID, String name, String gender, int salary, String birthday, int departmentId, String departmentName) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.birthday = birthday;
        this.department = new Department(departmentId, departmentName);
    }

    public String toString(){
        return String.valueOf(ID) + ' ' + name + ' ' + gender + ' ' + department.toString() + ' ' + String.valueOf(salary) + ' ' + birthday;
    }
}

class Department {
    int ID;
    String name;

    Department(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String toString(){
        return String.valueOf(ID) + ' ' + name;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        String path = "D:\\лабы\\6 семестр\\Java\\4laba\\src\\main\\resources\\foreign_names.csv";
        CSVReader reader = new CSVReader(new FileReader(path), ';');
        if(reader == null) {
            throw new FileNotFoundException(path);
        }
        List<Human> myFile = new ArrayList<>();
        String[] nextLine = reader.readNext();
        while((nextLine = reader.readNext())!= null) {
            if (nextLine != null) {
                myFile.add(new Human(Integer.parseInt(nextLine[0]),nextLine[1],nextLine[2],Integer.parseInt(nextLine[5]),nextLine[3],getDepartmentID(nextLine[4],myFile),nextLine[4]));
            }
        }
        print(myFile);
    }

    private static void print(List<Human> list){
        for(var i : list) {
            System.out.println(i.toString());
        }
    }

    private static int getDepartmentID(String name, List<Human> list) {
        int id = -1, maxId = -1;
        for(var i : list){
            if(i.department.name.compareTo(name) == 0){
                id = i.department.ID;
                break;
            }
            if(i.department.ID > maxId){
                maxId = i.department.ID;
            }
        }
        return id == -1 ? maxId + 1 : id;
    }
}
