# 🧠 Intelligent Complaint Management & Routing System (ICMPRS)

## 📌 Overview

The **ICMPRS System** is a Java-based application that automates complaint handling using intelligent logic.
It analyzes complaint descriptions to determine **priority level** and **department routing**, improving efficiency and response time.

---

## 🚀 Key Features

### 🔹 AI-Based Priority Detection

* Uses keyword-based sentiment and impact analysis
* Dynamically calculates complaint urgency
* Self-improving learning factor

### 🔹 Automatic Department Routing

* Routes complaints to:

  * Finance
  * IT Support
  * Logistics
  * Product Team
  * General Support

### 🔹 Database Integration

* Stores complaints in MySQL
* Supports:

  * Add
  * View
  * Search
  * Update
  * Delete

### 🔹 Smart Console Interface

* Menu-driven system
* Input validation
* Error handling

---

## 🛠️ Technologies Used

* Java
* JDBC
* MySQL
* OOP Concepts

---

## 🧩 System Architecture

User Input → Priority Detection → Department Routing → Database Storage → Output Display

---

## ⚙️ Setup Instructions

### 1️⃣ Create Database

```sql
CREATE DATABASE complaintdb;
USE complaintdb;

CREATE TABLE complaints (
    id INT PRIMARY KEY,
    description VARCHAR(255),
    priority INT,
    status VARCHAR(50),
    high_priority_flag INT,
    created_at TIMESTAMP
);
```

---

### 2️⃣ Configure Database Connection

Edit the file:

```java
DBConnection.java
```

Change credentials:

```java
String user = "root";
String password = "your_password";
```

---

### 3️⃣ Compile the Project

```bash
javac *.java
```

---

### 4️⃣ Run the Program

```bash
java Main
```

---

## 📊 Example Workflow

1. User enters complaint
2. System analyzes text
3. Priority is calculated
4. Complaint is routed
5. Stored in database

---

## 🧠 Intelligent Components

* Priority calculation based on:

  * Sentiment analysis
  * Impact detection
* Department detection using keyword mapping

---

## 📈 Future Improvements

* GUI (JavaFX / Web App)
* Machine Learning integration
* Email/SMS notifications
* Admin dashboard
