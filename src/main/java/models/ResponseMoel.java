package models;

import javax.lang.model.element.Name;

public class ResponseMoel {
    private String name ;
    private int age ;
    private double salary;
    private String company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public ResponseMoel(){}
    public ResponseMoel(String name , String company , int age , double salary){
        setName(name);
        setAge(age);
        setCompany(company);
        setSalary(salary);
    }

}
/**
 * ApiResponse apiResponse = response.as(ApiResponse.class);
 *
 *         // Retrieve the URL from the ApiResponse object
 *         String url = apiResponse.getUrl();
 */