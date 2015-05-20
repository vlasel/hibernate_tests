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
package by.academy.it.loader;

import by.academy.it.db.Dao;
import by.academy.it.db.StudentDao;
import by.academy.it.db.exceptions.DaoException;
import by.academy.it.pojos.Address;
import by.academy.it.pojos.Book;
import by.academy.it.pojos.Person;
import by.academy.it.pojos.Student;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Scanner;

/**
 * User: yslabko
 * Date: 14.04.14
 * Time: 12:28
 */
public class MenuLoader {
    private static Logger log = Logger.getLogger(MenuLoader.class);
    public static Boolean needMenu = true;
    private static Dao dao = null;

    public static void menu() throws DaoException {
        Student student = null;
        while (needMenu) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    List<? extends Person> persons = getDao().getAll();
                    for (Person person : persons) {
                        log.info(person);
                    }
                    break;
                case 2:
                    student = findPerson();
                    break;
                case 3:
                    student = createPerson(student);
                    getDao().saveOrUpdate(student);
                    break;
                case 4:

                    break;
                case 5:
                    student = findPerson();
                    Book book = newBook();
                    book.setPerson(student);
                    getDao().saveOrUpdate(book);
                    student.getBooks().add(book);
                    getDao().saveOrUpdate(student);
                    break;
                default:
                    needMenu = true;
                    break;
            }
            needMenu = true;
        }

    }

    private static void printMenu() {
        System.out.println("\nOptions:");
        System.out.println("        0. Exit");
        System.out.println("        1. List all Persons");
        System.out.println("        2. Get Person");
        System.out.println("        3. Save or Update Person");
        System.out.println("        4. Delete Person");
        System.out.println("        5. Add book to person by id");
    }

    public static Student createPerson(Student student) {
        System.out.println("Please enter person description:");
        System.out.print("Name - ");

        if (student == null) {
            student = new Student();
        }
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        student.setName(parameter);
        System.out.print("Surname - ");
        parameter = scanner.nextLine();
        student.setSurname(parameter);
        System.out.print("Age - ");
        parameter = scanner.nextLine();
        student.setAge(Integer.valueOf(parameter));
        System.out.print("Faculty - ");
        parameter = scanner.nextLine();
        student.setFaculty(parameter);

        student.setAddress(new Address());
        System.out.print("City - ");
        parameter = scanner.nextLine();
        student.getAddress().setCity(parameter);
        System.out.print("Street - ");
        parameter = scanner.nextLine();
        student.getAddress().setStreet(parameter);

        return student;
    }

    private static Book newBook() {
        String parameter = "";
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();

        System.out.println("\nBook:");
        System.out.print("name - ");
        parameter = scanner.nextLine();
        book.setName(parameter);
        System.out.print("author - ");
        parameter = scanner.nextLine();
        book.setAuthor(parameter);

        return book;
    }

    public static Student findPerson() {
        System.out.println("Get by Id. Please enter person id:");
        System.out.print("Id - ");

        Scanner scanner = new Scanner(System.in);
        Student student = null;
        Integer id = scanner.nextInt();
        try {
            student = getDao().get(id);
        } catch (DaoException e) {
            log.error(e, e);
        } catch (NullPointerException e) {
            log.error("Unable find person:", e);
        }
        System.out.print(student);
        return student;
    }

    public static Student loadPerson() {
        System.out.println("Loag by Id. Please enter person id:");
        System.out.print("Id - ");

        Scanner scanner = new Scanner(System.in);
        Student student = null;
        Integer id = scanner.nextInt();
        try {
            student = getDao().get(id);
        } catch (DaoException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NullPointerException e) {
            log.error("Unable find person:", e);
        }
        System.out.print(student);
        return student;
    }

    public static void flushSession() {
        System.out.println("Please enter person id:");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Student student = null;
        Integer id = scanner.nextInt();
        System.out.println("Please enter new Name:");
        System.out.print("New Name - ");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            getDao().flush(id, name);
        } catch (DaoException e) {
            log.error("Unable run flush example");
        }
    }


    public static Dao getDao(Class clazz) {
        if(Student.class.equals(clazz)) {
            return StudentDao.
        }
        switch (clazz.getSimpleName()) {
            case "PersonDao":
                break;
            case "BookDao":
                break;

        }
        if (dao == null) {
            dao = new StudentDao();
        }

        return dao;
    }

}
