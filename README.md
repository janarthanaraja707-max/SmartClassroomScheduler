# Smart Classroom & Timetable Scheduler

A Java Swing desktop application for managing classroom scheduling, faculty, subjects, and timetables — built with NetBeans IDE and SQLite database.

## Features

- **Login System** — Secure authentication with database-backed credentials
- **Dashboard** — Central navigation hub to access all modules
- **Faculty Management** — Add and view faculty records (ID, Name, Subject)
- **Subject Management** — Add and view subject records (Code, Name, Credits)
- **Classroom Management** — Add and view classroom records (Room No, Capacity, Type)
- **Timetable Management** — Schedule classes with Day, Time Slot, Subject, Faculty, and Classroom
- **Reports** — Summary view of system data

## Tech Stack

- **Language:** Java
- **GUI Framework:** Java Swing
- **Database:** SQLite (embedded, file-based)
- **IDE:** Apache NetBeans 30

## Project Structure

```
SmartClassroomScheduler/
├── src/
│   ├── LoginForm.java
│   └── smartclassroomscheduler/
│       ├── DashboardForm.java
│       ├── DBHelper.java
│       ├── FacultyForm.java
│       ├── SubjectForm.java
│       ├── ClassroomForm.java
│       ├── TimetableForm.java
│       └── ReportForm.java
├── smartclassroom.db
└── manifest.mf
```

## How to Run

1. Open the project in Apache NetBeans IDE.
2. Ensure the SQLite JDBC driver (`sqlite-jdbc-x.x.x.jar`) is added to the project Libraries.
3. Run `LoginForm.java`.
4. Log in with default credentials:
   - **Username:** `admin`
   - **Password:** `admin123`

## Default Login Credentials

| Username | Password   |
|----------|------------|
| admin    | admin123   |

## Author

Janarthanaraja

## License

This project was created for academic / project review purposes.
