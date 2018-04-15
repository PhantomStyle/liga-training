package ru.liga.entity;

import java.time.LocalDate;

public class EmployeeEntity {
    private Long id;
    private String fio;
    private String gender;
    private Long department_id;
    private String degree;
    private String position;
    private LocalDate birthday;

    public EmployeeEntity(Long id, String fio, String gender, Long department_id, String degree, String position, LocalDate birthday) {
        this.id = id;
        this.fio = fio;
        this.gender = gender;
        this.department_id = department_id;
        this.degree = degree;
        this.position = position;
        this.birthday = birthday;
    }

    public EmployeeEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public String getGender() {
        return gender;
    }

    public Long getDepartment() {
        return department_id;
    }

    public String getDegree() {
        return degree;
    }

    public String getPosition() {
        return position;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", gender='" + gender + '\'' +
                ", department_id=" + department_id +
                ", degree='" + degree + '\'' +
                ", position='" + position + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }
}
