# 🏨 Hotel Management System

A console-based Hotel Management System built with **Java**, **JDBC**, and **MySQL** that allows efficient management of hotel operations including customer records and room bookings.

---

## 📋 Features

- ✅ Add, view, and manage customer records
- ✅ Room booking with check-in and check-out functionality
- ✅ Persistent data storage using MySQL database
- ✅ CRUD operations via JDBC connectivity

---

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Core application logic & OOP |
| JDBC | Java-MySQL connectivity |
| MySQL | Database storage |
| IntelliJ IDEA | Development IDE |

---

## ⚙️ How to Run

### Prerequisites
- Java JDK 8 or above
- MySQL Server
- MySQL Connector JAR (mysql-connector-j-9.3.0)
- IntelliJ IDEA (recommended)

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/mt320236/hotel-management-system.git
   ```

2. **Setup MySQL Database**
   ```sql
   CREATE DATABASE hoteldb;
   USE hoteldb;
   ```

3. **Update DB credentials in code**
   ```java
   String url = "jdbc:mysql://localhost:3306/hoteldb";
   String username = "root";
   String password = "your_password";
   ```

4. **Add MySQL Connector JAR** to project dependencies

5. **Run** `Main.java`

---

## 📁 Project Structure

```
hotel-management-system/
├── src/
│   ├── Main.java
│   ├── Hotel_Reservation_System.java
│   └── Practice.java
└── README.md
```

---

## 👨‍💻 Author

**Ashish Tiwari**  
B.Tech CSE | Gautam Buddha University  
📧 at320236@gmail.com  
🔗 [GitHub](https://github.com/mt320236)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
