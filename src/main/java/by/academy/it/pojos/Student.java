/*
 * Copyright (c) 2012 by VeriFone, Inc.
 * All Rights Reserved.
 *
 * THIS FILE CONTAINS PROPRIETARY AND CONFIDENTIAL INFORMATION
 * AND REMAINS THE UNPUBLISHED PROPERTY OF VERIFONE, INC.
 *
 * Use, disclosure, or reproduction is prohibited
 * without prior written approval from VeriFone, Inc.
 */
package by.academy.it.pojos;

/**
 * User: yslabko
 * Date: 14.04.14
 * Time: 12:24
 */
public class Student extends Person {

    private static final long serialVersionUID = -98456874L;

    private String faculty;

    public Student() {
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        if (faculty != null ? !faculty.equals(student.faculty) : student.faculty != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        return result;
    }

//    @Override
//    public String toString() {
//        return super.toString()
//                +", Student ["
//                + "faculty=" + faculty
//                + "]";
//    }


    @Override
     public String toString() {
        return  super.toString()
                + ", Student{" +
                "faculty='" + faculty + '\'' +
                '}';
    }
}
