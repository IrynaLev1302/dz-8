public class HW08 {
        public static void main(String[] args) {
            // Створення студента
            Student student1 = new Student("TEST", "TESTOVYY");
            Student student2 = new Student("IVAN", "IVANOV");
            Student student3 = new Student("STEPAN", "STEPANOV");

            // Створення групи студентів зі старостою
            StudentsGroup group = new StudentsGroup(student1);

            // Додавання студента в групу
            group.addStudent(student2);
            group.addStudent(student3);

            // Додавання завдання
            group.addTask("Вивчити інкапсуляцію");
            group.addTask("Вивчити наслідування");

            // Відмітити завдання як виконане
            group.markTaskCompleted(student1, "Вивчити інкапсуляцію");

            // Змінити старосту
            group.changeHeadStudent(student2);

            System.out.println(group);
        }
    }




