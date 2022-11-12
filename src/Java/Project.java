package Java;

import java.util.Arrays;
import java.util.Scanner;

public class Project {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        char login;
        String start =  "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n" +
                        "            Welcome to test Marker               \n" +
                        "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n" +
                        "You are ?     \n" +
                        "a - An Admin  \n" +
                        "b - A Student \n" +
                        "press q to exit....";

        String admin =
                "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n" +
                "                   Hi Admin                      \n" +
                "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n" +
                "a. add an admin        \n" +
                "b. delete an admin     \n" +
                "c. search for an admin \n" +
                "d. show all admins     \n" +
                "e. add a question      \n" +
                "f. show all questions  \n" +
                "g. delete a question   \n" +
                "press q to back ... ";

        String student = "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n" +
                "                  Hi Student                     \n" +
                "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n" +
                "a. Math Exam \n" +
                "b. Java Exam \n" +
                "press q to back ... \n" +
                "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n";

        String[] userName = {"ahmad", "yasmine"};
        int[] password = {123456, 456789};

        String[] quiz = {"what is the result for 25%4",
                "Computer can execute the code in ____________.",
                "The equal comparison operator in Java is __________.",
                "The signature of a method consists of ____________.",
                "________ is the physical aspect of the computer that can be seen.",
                "One byte has ________ bits"};

        String[][] quizAnswers = {{"2", "1", "3", "4"}
                , {"machine language", "assembly language", "high-level language", "none of the above"}
                , {"<>", "!=", "==", "="}
                , {"method name", "method name and parameter list", "return type, method name", "parameter list"}
                , {"Hardware", "Software", "Operating system", "Application program"}
                , {"4", "8", "12", "16"}};

        int[] answers = {1, 0, 2, 1, 0, 1};
        int[] questionDeleted = {};

        System.out.print(start);
        login = input.next().charAt(0);
        while (login != 'q') {

            while (login == 'a') {
                char finish = ' ';
                System.out.print("Enter username : ");
                String user = input.next();
                System.out.print("Enter password : ");
                int pass = input.nextInt();
                if (find(userName, password, user, pass) != -1) {
                    while (finish != 'q') {
                        System.out.print(admin);
                        finish = input.next().charAt(0);
                        switch (finish) {
                            case 'a':
                                System.out.print("Enter username : ");
                                String user2 = input.next();
                                System.out.print("Enter password : ");
                                int pass2 = input.nextInt();

                                userName = increase(userName, user2);
                                password = increase(password, pass2);
                                break;

                            case 'b':
                                deleteAdmin(userName, password);
                                break;
                            case 'c':
                                System.out.print("Enter username : ");
                                String user3 = input.next();
                                int index = search(userName, user3);
                                if (index != -1) {
                                    System.out.printf("Username : %s || Password : %d \n",
                                            userName[index], password[index]);
                                } else {
                                    System.out.println("admin not found ");
                                }
                                break;
                            case 'd':
                                showAdmin(userName, password);
                                break;
                            case 'e':
                                System.out.println("enter a question : ");
                                input.nextLine();
                                String newQuestion = input.nextLine();
                                System.out.println("enter a answers : ");
                                String[] newAnswers = answers();
                                System.out.println("enter number of correct");
                                int answer = input.nextInt();
                                quiz = increase(quiz, newQuestion);
                                quizAnswers = increase(quizAnswers, newAnswers);
                                answers = increase(answers, answer);
                                break;
                            case 'f':
                                showQuestion(quiz, quizAnswers, answers, questionDeleted);
                                break;
                            case 'g':
                                System.out.print("enter number a question which you want deleted : ");
                                int d = input.nextInt();
                                questionDeleted = increase(questionDeleted, d - 1);
                                quiz[d - 1] = "";
                                break;
                        }
                        login = ' ';
                    }
                } else {
                    System.out.println("Incorrect username or password");
                    login = input.next().charAt(0);
                }
            }

            while (login == 'b') {
                char finish;
                System.out.print(student);
                finish = input.next().charAt(0);
                switch (finish) {
                    case 'a':
                        mathExam();
                        break;
                    case 'b':
                        javaExam(quiz, quizAnswers, answers);
                        break;
                }
                if (finish == 'q')
                    login = ' ';
            }
            System.out.println(start);
            login = input.next().charAt(0);
        }
    }

    // to find the user and match it with the password
    public static int find(String[] userName, int[] password, String user, int pass) {
        for (int i = 0; i < userName.length; i++) {
            if (userName[i].equals(user)) {
                if (password[i] == pass) {
                    return i;
                }
            }
        }
        return -1;
    }

    // add a new password in the data or a new answer
    public static int[] increase(int[] passWord, int pass) {
        int[] newArray = new int[passWord.length + 1];
        System.arraycopy(passWord, 0, newArray, 0, passWord.length);
        newArray[passWord.length] = pass;
        return newArray;
    }

    // add a new username in a data or a new question
    public static String[] increase(String[] userName, String user) {
        String[] newArray = new String[userName.length + 1];
        for (int i = 0; i < userName.length; i++) {
            newArray[i] = userName[i];
        }
        newArray[userName.length] = user;
        return newArray;
    }

    // show all admins
    public static void showAdmin(String[] userName, int[] passWord) {
        for (int i = 0; i < userName.length; i++) {
            if (passWord[i] != 0)
                System.out.printf("Username : %s || Password : %d \n", userName[i], passWord[i]);
        }
    }

    // add a new answers
    public static String[][] increase(String[][] quizAnswers, String[] answers) {
        String[][] newAnswers = new String[quizAnswers.length + 1][quizAnswers.length];
        for (int i = 0; i < quizAnswers.length; i++) {
            for (int j = 0; j < quizAnswers[i].length; j++) {
                newAnswers[i][j] = quizAnswers[i][j];
            }
        }
        for (int i = 0; i < answers.length; i++) {
            newAnswers[quizAnswers.length][i] = answers[i];
        }
        return newAnswers;
    }

    //search for an admin
    public static int search(String[] userName, String user) {
        for (int i = 0; i < userName.length; i++) {
            if (userName[i].equals(user)) {
                return i;
            }
        }
        return -1;
    }


    public static void deleteAdmin(String[] userName, int[] passWord) {
        System.out.print("Enter username to delete: ");
        String user = input.next();
        int index = search(userName, user);
        if (index != -1) {
            for (int i = 0, j = 0; i < userName.length; i++) {
                if (index == i) {
                    continue;
                }
                userName[j] = userName[i];
            }
            userName[userName.length - 1] = null;
            System.out.println(Arrays.toString(userName));

            for (int i = 0, j = 0; i < passWord.length; i++) {
                if (index == i) {
                    continue;
                }
                passWord[j] = passWord[i];
            }
            passWord[passWord.length - 1] = 0;
            System.out.printf("Admin \" %s \" successful deleted \n", user);

        } else {
            System.out.printf(" Admin %s is not found \n", user);
        }
    }

    // enter a answers
    public static String[] answers() {
        String[] answers = new String[4];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = input.next();
        }
        return answers;
    }

    // show all question
    public static void showQuestion(String[] quiz, String[][] quizAnswer, int[] answers, int[] deleted) {
        for (int i = 0; i < quiz.length; i++) {
            if (!find(deleted, i)) {
                System.out.println((i + 1) + ". " + quiz[i]);
                for (int j = 0; j < quizAnswer[i].length; j++) {
                    System.out.println((char) (j + 'a') + ". " + quizAnswer[i][j]);
                }
                System.out.println("the correct answer is " + (char) (answers[i] + 'a'));
            }
        }
    }

    public static boolean find(int[] array, int k) {
        for (int e : array) {
            if (e == k)
                return true;
        }
        return false;
    }

    public static void shufflingQuestion(String[] quiz, String[][] quizAnswers, int[] answers) {
        for (int i = 0; i < quiz.length; i++) {
            int index = (int) (Math.random() * quiz.length);
            String tempQuiz = quiz[i];
            quiz[i] = quiz[index];
            quiz[index] = tempQuiz;

            String[] tempAnswer = quizAnswers[i];
            quizAnswers[i] = quizAnswers[index];
            quizAnswers[index] = tempAnswer;

            int temp = answers[i];
            answers[i] = answers[index];
            answers[index] = temp;
        }
    }

    public static void shufflingAnswers(String[][] quizAnswers, int[] answers) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < quizAnswers[i].length; j++) {
                int index = (int) (Math.random() * quizAnswers[i].length);
                String temp = quizAnswers[i][i];
                quizAnswers[i][i] = quizAnswers[i][index];
                quizAnswers[i][index] = temp;
                if (index == answers[i]) {
                    answers[i] = i;
                } else if (i == answers[i]) {
                    answers[i] = index;
                }
            }
        }
    }

    public static void javaExam(String[] quiz, String[][] quizAnswers, int[] answers) {
        int score = 0;
        shufflingQuestion(quiz, quizAnswers, answers);
        shufflingAnswers(quizAnswers, answers);
        int[] incorrect = {};
        for (int i = 0, k = 0; (k < 5) && (i < quiz.length); i++) {
            if (!quiz[i].isEmpty()) {
                System.out.println((i + 1) + ". " + quiz[i]);
                for (int j = 0; j < quizAnswers[i].length; j++) {
                    System.out.println((char) ('a' + j) + "_" + quizAnswers[i][j]);
                }
                System.out.print("Your Answer is : ");
                String answer = input.next().trim();
                if (answers[i] == (answer.charAt(0) - 'a')) {
                    System.out.println("Correct..:)");
                    score++;
                } else {
                    incorrect = increase(incorrect, i);
                    System.out.println("Not Correct :(");
                }
                k++;
            }
        }
        if (score > 2) {
            System.out.printf("^-^ Nice , you pass the exam and Your Grade is %d / 5..... \n\n", score);
            for (int i = 0; i < incorrect.length; i++) {
                System.out.println(incorrect[i] + ". " + quiz[incorrect[i]]);
                for (int j = 0; j < quizAnswers[i].length; j++) {
                    System.out.println(quizAnswers[incorrect[i]][j]);
                }
                System.out.println("the correct answer is " + (char) (answers[i] + 'a'));
            }

        } else {
            System.out.printf("(:  Oh you failed try again .. Your Grade is %d / 5..... \n\n", score);
        }
    }

    public static void mathExam() {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            int x = (int) (Math.random() * 4) + 1;
            int number1 = (int) (Math.random() * 10 + 1);
            int number2 = (int) (Math.random() * 10 + 1);
            double result = 0;
            double answer ;
            switch (x) {
                case 1:
                    System.out.printf("%d + %d = ? ", number1, number2);
                    result = number1 + number2;
                    break;
                case 2:
                    System.out.printf("%d * %d = ? ", number1, number2);
                    result = number1 * number2;
                    break;
                case 3:
                    System.out.printf("%d / %d = ?( Ex : 2.12 )", number1, number2);
                    result = ((int) ((100 * number1) / (1.0 * number2))) / 100.0;
                    break;
                case 4:
                    System.out.printf("%d - %d = ? ", number1, number2);
                    result = number1 - number2;
                    break;
            }
            answer = input.nextDouble();
            if (answer == result) {
                score += 1;
                System.out.println(":) correct ");
            } else {
                System.out.println(":( incorrect");
            }
        }
        if (score > 2) {
            System.out.printf("^-^ Nice , you pass the exam and Your Grade is %d / 5..... \n", score);
        } else {
            System.out.printf("(:  Oh you failed try again .. Your Grade is %d / 5..... \n", score);
        }
    }
}
