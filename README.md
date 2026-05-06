Lost & Found Registry (Java Swing + JDBC + MySQL)

A desktop application to report, track, and manage lost items. Built with **Java Swing** for UI, **JDBC** for database access, and **MySQL** as the backend.

---

## Features

*  Add new lost items
*  View all items in a table
*  Mark items as **CLAIMED**
*  Delete items
*  Refresh data
*  Input validation (prevents empty item names)

---

##  Tech Stack

* **Java (JDK 8+)**
* **Swing (UI)**
* **JDBC (Database connectivity)**
* **MySQL**
* **Eclipse IDE**

---

##  Project Structure

```
src/
 └── com/lostfound/
      ├── dao/            # Interface layer
      ├── daoimpl/        # JDBC implementation
      ├── dto/            # Data model (Item)
      ├── service/        # Business logic
      ├── ui/             # Swing UI (MainFrame)
      ├── util/           # DB connection
      └── main/           # Entry point
```

---

##  Setup Instructions

### 1️⃣ Clone the repository

```
git clone https://github.com/YOUR_USERNAME/LostAndFoundRegistry.git
cd LostAndFoundRegistry
```

---

### 2️⃣ Configure MySQL

Run this SQL in MySQL Workbench:

```
CREATE DATABASE IF NOT EXISTS lost_found_db;
USE lost_found_db;

CREATE TABLE IF NOT EXISTS items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(100),
    description TEXT,
    location VARCHAR(100),
    status VARCHAR(20)
);
```

---

### 3️⃣ Update DB credentials

Open:

```
src/com/lostfound/util/DBConnection.java
```

Update:

```java
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

---

### 4️⃣ Add MySQL Connector

* Download MySQL Connector JAR
* Add it to your project:

  * Eclipse → Right click project → Build Path → Add External JAR

---

### 5️⃣ Run the application

Run:

```
MainApp.java
```

---

## 🖥️ UI Overview

* Form to enter item details
* Table to display all records
* Buttons: Add, Claim, Delete, Refresh

---

## 🔄 Application Flow

```
UI (Swing)
   ↓
Service Layer
   ↓
DAO Layer (JDBC)
   ↓
MySQL Database
```

---

##  Future Improvements

*  Search & filter items
*  User authentication
*  Convert to web app (Spring Boot)
*  ML-based item classification
