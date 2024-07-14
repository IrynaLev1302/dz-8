import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StudentsGroup {
        private Student headStudent;
        private final List<Student> students;
        private final Map<Student, List<Task>> tasks;

        public StudentsGroup(Student headStudent) {
            if (headStudent == null) {
                throw new IllegalArgumentException("Head student must not be null");
            }
            this.headStudent = headStudent;
            this.students = new ArrayList<>();
            this.tasks = new HashMap<>();
            addStudent(headStudent);
        }

        public Student getHeadStudent() {
            return headStudent;
        }

        public void changeHeadStudent(Student newHeadStudent) {
            if (newHeadStudent == null || !students.contains(newHeadStudent)) {
                throw new IllegalArgumentException("New head student must be a member of the group");
            }
            this.headStudent = newHeadStudent;
        }

        public void addStudent(Student student) {
            if (student == null || students.contains(student)) {
                throw new IllegalArgumentException("Student is invalid or already in the group");
            }
            students.add(student);
            tasks.putIfAbsent(student, new ArrayList<>());
        }

        public void removeStudent(Student student) {
            if (student == null || student.equals(headStudent) || !students.contains(student)) {
                throw new IllegalArgumentException("Cannot remove head student or non-existent student");
            }
            students.remove(student);
            tasks.remove(student);
        }

        public void addTask(String task) {
            if (task == null || task.isEmpty()) {
                throw new IllegalArgumentException("Task must not be empty");
            }
            for (Student student : students) {
                tasks.get(student).add(new Task(task));
            }
        }

        public void markTaskCompleted(Student student, String task) {
            if (student == null || !students.contains(student)) {
                throw new IllegalArgumentException("Student is not in the group");
            }
            List<Task> studentTasks = tasks.get(student);
            for (Task t : studentTasks) {
                if (t.getTask().equals(task)) {
                    t.setCompleted(true);
                    return;
                }
            }
            throw new IllegalArgumentException("Task not found for the given student");
        }

        @Override
        public String toString() {
            return "Head Student: " + headStudent + "\nStudents: " + students + "\nTasks: " + tasks;


        }
        private static class Task {
            private final String task;
            private boolean completed;

            public Task(String task) {
                this.task = task;
                this.completed = false;
            }

            public String getTask() {
                return task;
            }

            public boolean isCompleted() {
                return completed;
            }

            public void setCompleted(boolean completed) {
                this.completed = completed;
            }

            @Override
            public String toString() {
                return task + " (Completed: " + completed + ")";
            }
        }







}
