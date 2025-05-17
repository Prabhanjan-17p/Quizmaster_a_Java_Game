# 🎮 QuizMaster: A Java-Based Quiz Game

**QuizMaster** is a desktop-style web-based quiz application developed using Java Servlets, JSP, HTML, CSS, JavaScript, and backed by an Oracle Database. It is designed to offer an engaging and interactive experience for users with a sleek, dynamic interface.

This application supports various quiz subjects, including Java, SQL, and Data Structures, making it an excellent platform for students, programming enthusiasts, and learners to test, practice, and enhance their knowledge.

Whether you're preparing for a technical interview or brushing up your coding concepts, QuizMaster offers an intuitive environment to make learning fun and effective.

---

## 🚀 Features

- **Multi-Subject Support**: Quizzes available in Java, ORACLE, and Data Structures.
- **User-Friendly Interface**: Intuitive and responsive design for seamless navigation.
- **Timed Quizzes**: Each quiz is time-bound to add a competitive edge.
- **Instant Feedback**: Immediate results and correct answers provided after each quiz.
- **Admin Panel**: Manage questions, view user statistics, and monitor quiz performance.

---

## 🎥 Demo Video

*A demonstration video of the QuizMaster application is available below:*

https://github.com/user-attachments/assets/f041970c-7e90-4b1f-b370-a24c6a84ff17

*Click the image above to watch the demo video on YouTube.*

---

## 🛠️ Technologies Used

- **Java**: Core programming language for application development.
- **HTML CSS Js**: Used for building the graphical user interface.
- **Oracle Database**: Backend database for storing quiz questions and user data.
- **JDBC**: Java Database Connectivity for database interactions.

---

## 📂 Project Structure

```plaintext
Online Quiz Application/
├── src/
│   └── main/
│       ├── java/
│       │   └── game/
│       │       ├── AdminLogin.java             # Handles admin login authentication
│       │       ├── QuizExamServlet.java        # Core servlet for handling quiz logic
│       │       ├── QuizFrom.java               # Manages quiz data models
│       │       ├── UserRegistration.java       # Handles new user registrations
│       │       └── VerifyUser.java             # Verifies user credentials
│       └── webapp/
│           ├── META-INF/
│           ├── WEB-INF/
│           ├── adminlogin.html                 # Admin login page
│           ├── availablequizzes.html           # Shows quizzes to the user
│           ├── gamemg.png                      # Game image used in UI
│           ├── javaquizexam.html               # Quiz examination page
│           ├── quizform.html                   # Form for creating quizzes
│           ├── quizmaster.html                 # Main UI page for the quiz platform
│           ├── userlogin.html                  # User login page
│           ├── usersignup.html                 # User registration page
│           ├── welcome.html                    # Welcome landing page
│           └── welcome.jsp                     # JSP-based landing page
├── build/                                       # Compiled files (if applicable)
├── Libraries/                                   # Project libraries
└── Referenced Libraries/                        # External JARs and dependencies
...
```

---

## 🔧 Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Prabhanjan-17p/Quizmaster_a_Java_Game.git
   ```

2. **Set Up the Database**:
   - Install Oracle Database.
   - Run the `quizmaster_db.sql` script located in the `database/` directory to create necessary tables and insert sample data.

3. **Configure the Application**:
   - Ensure JDBC is properly configured to connect to your Oracle Database.
   - Update database connection details in the application's configuration files if necessary.

4. **Run the Application**:
   - Compile and run `quizmaster.html` to start the QuizMaster application.

---

## 👤 Author

- **Prabhanjan Amanta**
  - [GitHub](https://github.com/Prabhanjan-17p)
  - [LinkedIn](https://www.linkedin.com/in/pravanjan-17p)
  - [HackerRank](https://www.hackerrank.com/pravanjanamanta)

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙏 Acknowledgements

Special thanks to all who contributed to the development and testing of QuizMaster.
