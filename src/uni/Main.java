package uni;

import base.Person;

public class Main {
    public static void main(String[] args) {
        // ایجاد رشته‌ها
        Major major1 = new Major("Computer Science", 10);
        Major major2 = new Major("Mathematics", 10);

        // ایجاد افراد
        Person person1 = new Person("Alice", "111");
        Person person2 = new Person("Bob", "222");
        Person person3 = new Person("Charlie", "333");
        Person person4 = new Person("David", "444");
        Person person5 = new Person("Eve", "555");

        // ایجاد دانشجویان
        Student student1 = new Student(person1.id, 2021, major1.id);
        Student student2 = new Student(person2.id, 2021, major1.id);
        Student student3 = new Student(person3.id, 2021, major2.id);

        // چاپ نام و شماره دانشجویی دانشجویان
        for (Student student : Student.studentList) {
            Person person = Person.findByID(student.personID);
            if (person != null) {
                System.out.println("Student Name: " + person.name + ", Student ID: " + student.studentID);
            }
        }

        // ایجاد اساتید
        Professor professor1 = new Professor(person4.id, major1.id);
        Professor professor2 = new Professor(person5.id, major2.id);

        // چاپ آیدی و نام اساتید
        for (Professor professor : Professor.professorList) {
            Person person = Person.findByID(professor.personID);
            if (person != null) {
                System.out.println("Professor Name: " + person.name + ", Professor ID: " + professor.id);
            }
        }

        // ایجاد دروس
        Course course1 = new Course("Data Structures", 3);
        Course course2 = new Course("Algorithms", 3);
        Course course3 = new Course("Calculus", 4);

        // ایجاد دروس ارائه شده
        PresentedCourse presentedCourse1 = new PresentedCourse(course1.id, professor1.id, 10);
        PresentedCourse presentedCourse2 = new PresentedCourse(course2.id, professor1.id, 10);
        PresentedCourse presentedCourse3 = new PresentedCourse(course3.id, professor2.id, 10);

        // اضافه کردن دانشجویان به دروس ارائه شده
        presentedCourse1.addStudent(student1.id);
        presentedCourse1.addStudent(student2.id);
        presentedCourse2.addStudent(student1.id);
        presentedCourse2.addStudent(student2.id);
        presentedCourse2.addStudent(student3.id);
        presentedCourse3.addStudent(student3.id);

        // ایجاد و نمره دادن به کارنامه‌ها
        Transcript transcript1 = new Transcript(student1.id);
        transcript1.setGrade(presentedCourse1.id, 18.5);
        transcript1.setGrade(presentedCourse2.id, 17.0);

        Transcript transcript2 = new Transcript(student2.id);
        transcript2.setGrade(presentedCourse1.id, 19.0);
        transcript2.setGrade(presentedCourse2.id, 16.5);

        Transcript transcript3 = new Transcript(student3.id);
        transcript3.setGrade(presentedCourse2.id, 15.0);
        transcript3.setGrade(presentedCourse3.id, 18.0);

        // چاپ کارنامه‌ها و معدل‌ها
        transcript1.printTranscript();
        System.out.println("GPA: " + transcript1.getGPA());

        transcript2.printTranscript();
        System.out.println("GPA: " + transcript2.getGPA());

        transcript3.printTranscript();
        System.out.println("GPA: " + transcript3.getGPA());
    }
}
