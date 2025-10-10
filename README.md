# Spring Boot API Assignment

## 🏦 ข้อที่ 1: Digital Safe API (ตู้เซฟดิจิทัล)

### 📌 คำอธิบาย
โปรเจกต์นี้เป็นการจำลองการทำงานของ "ตู้เซฟดิจิทัล" ที่สามารถฝากเงินได้เท่านั้น (ไม่สามารถถอนเงินได้) เพื่อทดสอบความเข้าใจเรื่อง **Encapsulation** ใน Java

### 🧱 โครงสร้างคลาส
#### `DigitalSafe` Class
- **Properties (private)**  
  - `ownerName` (String) — ชื่อเจ้าของ  
  - `balance` (double) — ยอดเงินในตู้เซฟ (ค่าเริ่มต้น 0.0)
- **Constructor**
  - รับค่า `ownerName` และตั้งค่า `balance = 0.0`
- **Methods**
  - `deposit(double amount)` — ฝากเงิน (ต้องเป็นค่าบวกเท่านั้น)
  - `getBalance()` — ดูยอดเงินปัจจุบัน
  - `getOwnerName()` — ดูชื่อเจ้าของ
- ❌ ห้ามมีเมธอดสำหรับถอนเงินหรือแก้ไข balance โดยตรง

#### `SafeController` Class
- ใช้ Annotations: `@RestController`, `@GetMapping`, `@PostMapping`, `@RequestParam`

### 🌐 API Endpoints
| Method | Endpoint            | Description                      | Parameters              | Response                         |
|--------|----------------------|------------------------------------|--------------------------|-----------------------------------|
| GET    | `/safe/owner`        | แสดงชื่อเจ้าของตู้เซฟ             | -                        | Owner name                        |
| GET    | `/safe/balance`      | แสดงยอดเงินปัจจุบัน              | -                        | Current balance                   |
| POST   | `/safe/deposit`      | ฝากเงินเข้าตู้เซฟ                | `amount` (double)        | New balance after deposit         |

---

## 🎬 ข้อที่ 2: Simple Movie Catalog API (แคตตาล็อกภาพยนตร์)

### 📌 คำอธิบาย
โปรเจกต์นี้เป็นการสร้าง API สำหรับจัดการแคตตาล็อกภาพยนตร์ เพื่อฝึกการออกแบบ Class และการจัดการกลุ่ม Object ด้วย `List`

### 🧱 โครงสร้างคลาส
#### `Movie` Class
- **Properties (private)**  
  - `title` (String) — ชื่อภาพยนตร์  
  - `director` (String) — ผู้กำกับ  
  - `releaseYear` (int) — ปีที่ออกฉาย
- **Constructor**
  - รับค่าทั้งสามมาเพื่อสร้าง Movie object
- **Methods**
  - มีเฉพาะ Public Getters สำหรับทุก Properties
- ❌ ห้ามมี Public Setters

#### `MovieController` Class
- ใช้ Annotations: `@RestController`, `@GetMapping`, `@PostMapping`, `@RequestParam`
- ใช้ `List<Movie>` ในการเก็บข้อมูล

### 🌐 API Endpoints
| Method | Endpoint             | Description                              | Parameters                             | Response                                 |
|--------|-----------------------|-------------------------------------------|-----------------------------------------|-------------------------------------------|
| GET    | `/movies`            | แสดงรายชื่อภาพยนตร์ทั้งหมด              | -                                       | List of movies                            |
| POST   | `/movies/add`       | เพิ่มภาพยนตร์ใหม่                        | `title` (String), `director` (String), `releaseYear` (int) | Confirmation message |
| GET    | `/movies/search`    | ค้นหาภาพยนตร์ตามชื่อ                    | `title` (String)                        | Movie info or not found message          |

---

## 🛠️ การติดตั้งและรันโปรเจกต์
1. ติดตั้ง [Java 17](https://adoptium.net/) และ [Maven](https://maven.apache.org/)
2. สร้างโปรเจกต์ Spring Boot ด้วย Spring Initializr โดยเลือก dependency: `Spring Web`
3. เพิ่มไฟล์คลาส `DigitalSafe.java`, `SafeController.java`, `Movie.java`, `MovieController.java` ในโฟลเดอร์ `src/main/java`
4. รันโปรเจกต์ด้วยคำสั่ง:
```bash
mvn spring-boot:run
```
5. เปิดเว็บเบราว์เซอร์หรือใช้ Postman เรียก API ตาม Endpoint ที่กำหนด

---

## 🧪 ตัวอย่างการใช้งาน API (Digital Safe)
```bash
# ดูชื่อเจ้าของ
GET http://localhost:8080/safe/owner

# ดูยอดเงิน
GET http://localhost:8080/safe/balance

# ฝากเงิน 1000
POST http://localhost:8080/safe/deposit?amount=1000
```

## 🧪 ตัวอย่างการใช้งาน API (Movie Catalog)
```bash
# ดูรายการหนังทั้งหมด
GET http://localhost:8080/movies

# เพิ่มหนังใหม่
POST http://localhost:8080/movies/add?title=Inception&director=Christopher+Nolan&releaseYear=2010

# ค้นหาหนัง
GET http://localhost:8080/movies/search?title=Inception
```

---

## 📄 License
This project is for **educational purposes** only.
