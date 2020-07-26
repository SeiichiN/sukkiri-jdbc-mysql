package model;

public class Employee {
    private String id;
    private String name;
    private int age;

    public Employee( String id, String name, int age ) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
}

// 修正時刻： Wed Jul  8 09:33:39 2020
