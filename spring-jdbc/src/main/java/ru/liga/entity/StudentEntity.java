package ru.liga.entity;

import java.time.LocalDate;

public class StudentEntity {
    private Long id;
    private String fio;
    private String gender;
    private Long department_id;
    private String studentGroupId;
    private LocalDate birthday;

    public StudentEntity() {
    }

    public StudentEntity(Long id, String fio, String gender, Long department_id, String studentGroupId, LocalDate birthday) {
        this.id = id;
        this.fio = fio;
        this.gender = gender;
        this.department_id = department_id;
        this.studentGroupId = studentGroupId;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public String getStudentGroupId() {
        return studentGroupId;
    }

    public void setStudentGroupId(String studentGroupId) {
        this.studentGroupId = studentGroupId;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
