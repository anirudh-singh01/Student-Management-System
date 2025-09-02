# Eclipse Setup Guide for Student Management System
## Complete Step-by-Step Instructions for Company Environment

### ⚠️ IMPORTANT: Company Environment Setup
This guide is specifically designed for company environments where:
- Maven can ONLY run inside Eclipse
- External Maven commands are blocked
- Network access may be restricted
- Eclipse is the primary development environment

---

## 🚀 Pre-Import Checklist

### 1. Verify Eclipse Setup (CRITICAL)
**Check Eclipse Version:**
1. Open Eclipse
2. Go to: `Help` → `About Eclipse IDE`
3. Note the version number (should be 2020-12 or newer)
4. If older, contact IT for updated Eclipse

**Check Java Installation:**
1. Go to: `Window` → `Preferences` → `Java` → `Installed JREs`
2. Verify you have JDK 8 or higher
3. If not, contact IT to install Java

**Check Maven Integration:**
1. Go to: `Window` → `Preferences` → `Maven`
2. Verify Maven is configured
3. If not, contact IT to enable Maven in Eclipse

### 2. Install Required Eclipse Plugins
**Step-by-Step Plugin Installation:**

1. **Open Eclipse Marketplace:**
   - Go to: `Help` → `Eclipse Marketplace`
   - Wait for marketplace to load

2. **Search and Install Spring Tools:**
   - In search box, type: `Spring Tools 4`
   - Click on "Spring Tools 4 (aka Spring Tool Suite 4)"
   - Click `Install`
   - Accept license agreement
   - Restart Eclipse when prompted

3. **Verify Maven Integration:**
   - Go to: `Help` → `Eclipse Marketplace`
   - Search: `Maven Integration for Eclipse`
   - If not installed, install it
   - Restart Eclipse if needed

4. **Verify Installation:**
   - Go to: `Window` → `Perspective` → `Open Perspective` → `Other`
   - You should see "Maven" and "Spring" options

---

## 📥 Import Steps (Guaranteed Method)

### Step 1: Prepare Project Location
1. **Copy project to accessible location:**
   - Copy the entire `Student-Management-System-main` folder
   - Paste it to a location Eclipse can access (e.g., `C:\Projects\` or your workspace)
   - Ensure the folder contains `pom.xml` file

2. **Verify project structure:**
   ```
   Student-Management-System-main/
   ├── pom.xml                    ← MUST BE PRESENT
   ├── src/
   │   ├── main/
   │   │   ├── java/
   │   │   │   └── com/example/
   │   │   └── resources/
   │   └── test/
   ├── README.md
   └── eclipse-setup.md
   ```

### Step 2: Import Project into Eclipse
**Method A: Maven Import (RECOMMENDED)**

1. **Open Eclipse**
2. **Go to:** `File` → `Import`
3. **Expand:** `Maven` folder
4. **Select:** `Existing Maven Projects`
5. **Click:** `Next`

6. **Browse to project:**
   - Click `Browse`
   - Navigate to your `Student-Management-System-main` folder
   - Select the folder (not individual files)
   - Click `OK`

7. **Verify project detection:**
   - You should see the project listed in the "Projects" section
   - Check the checkbox next to the project
   - Ensure "Add project(s) to working set" is checked

8. **Click:** `Finish`

**Method B: General Import (If Maven Import Fails)**

1. **Go to:** `File` → `Import`
2. **Expand:** `General` folder
3. **Select:** `Existing Projects into Workspace`
4. **Click:** `Next`
5. **Browse to project folder**
6. **Check the project checkbox**
7. **Click:** `Finish`

### Step 3: Post-Import Verification
**Check Project Structure:**
1. In Package Explorer, expand your project
2. You should see:
   ```
   Student-Management-System-main/
   ├── src/
   │   ├── main/
   │   │   ├── java/
   │   │   │   └── com.example/
   │   │   │       ├── StudentManagementApplication.java
   │   │   │       ├── config/
   │   │   │       ├── model/
   │   │   │       ├── repository/
   │   │   │       ├── service/
   │   │   │       └── servlet/
   │   │   └── resources/
   │   │       ├── application.properties
   │   │       └── static/
   │   │           └── index.html
   │   └── test/
   ├── Maven Dependencies/        ← MUST BE PRESENT
   ├── target/                     ← Will be created
   └── pom.xml
   ```

**Check for Errors:**
1. Look for red X marks on project or files
2. Check Problems view: `Window` → `Show View` → `Problems`
3. If errors exist, proceed to troubleshooting section

---

## 🔧 Maven Configuration (CRITICAL)

### Step 1: Force Maven Update
1. **Right-click on project**
2. **Select:** `Maven` → `Update Project`
3. **Check:** `Force Update of Snapshots/Releases`
4. **Click:** `OK`
5. **Wait for Maven to download dependencies**

### Step 2: Verify Maven Dependencies
1. **Expand:** `Maven Dependencies` folder
2. **You should see:**
   ```
   Maven Dependencies/
   ├── spring-boot-starter-web-2.7.0.jar
   ├── spring-boot-starter-data-jpa-2.7.0.jar
   ├── h2-2.1.214.jar
   ├── spring-boot-devtools-2.7.0.jar
   └── (other Spring Boot dependencies)
   ```

### Step 3: Maven Clean and Install
1. **Right-click on project**
2. **Select:** `Maven` → `Clean`
3. **Wait for clean to complete**
4. **Right-click on project**
5. **Select:** `Maven` → `Install`
6. **Wait for install to complete**

---

## ⚙️ Project Configuration

### Step 1: Java Compiler Settings
1. **Right-click on project**
2. **Select:** `Properties`
3. **Go to:** `Java Compiler`
4. **Set Compiler compliance level to:** `8` or higher
5. **Click:** `Apply and Close`

### Step 2: Project Facets
1. **Right-click on project**
2. **Select:** `Properties`
3. **Go to:** `Project Facets`
4. **Set:**
   - **Java:** `8` or higher
   - **Dynamic Web Module:** `4.0` or higher
5. **Click:** `Apply and Close`

### Step 3: Build Path Verification
1. **Right-click on project**
2. **Select:** `Properties`
3. **Go to:** `Java Build Path`
4. **Check:** `Maven Dependencies` is listed
5. **Click:** `Apply and Close`

---

## 🚀 Running the Application

### Method 1: Spring Boot App (RECOMMENDED)
1. **Right-click on project**
2. **Select:** `Run As` → `Spring Boot App`
3. **If Spring Boot App is not available, use Method 2**

### Method 2: Java Application
1. **Right-click on project**
2. **Select:** `Run As` → `Java Application`
3. **Select:** `com.example.StudentManagementApplication`
4. **Click:** `OK`

### Method 3: Manual Run Configuration
1. **Go to:** `Run` → `Run Configurations`
2. **Double-click:** `Java Application`
3. **Set:**
   - **Name:** `Student Management System`
   - **Main class:** `com.example.StudentManagementApplication`
4. **Click:** `Apply` → `Run`

### Method 4: Debug Mode
1. **Right-click on project**
2. **Select:** `Debug As` → `Java Application`
3. **Select:** `com.example.StudentManagementApplication`
4. **Click:** `OK`

---

## ✅ Verification Steps

### Step 1: Check Console Output
**Look for these messages in Console:**
```
Student Management System is running!
Open your browser and go to: http://localhost:8080
```

### Step 2: Test Web Interface
1. **Open web browser**
2. **Navigate to:** `http://localhost:8080`
3. **You should see:** Student Management System interface
4. **Test functionality:**
   - Add a student
   - View students in table
   - Edit a student
   - Delete a student

### Step 3: Test H2 Database Console
1. **Navigate to:** `http://localhost:8080/h2-console`
2. **Use connection settings:**
   - **Driver Class:** `org.h2.Driver`
   - **JDBC URL:** `jdbc:h2:mem:studentdb`
   - **User Name:** `sa`
   - **Password:** `(leave empty)`
3. **Click:** `Connect`
4. **Run:** `SELECT * FROM STUDENTS;`

---

## 🔧 Troubleshooting

### Issue 1: Maven Dependencies Not Downloaded
**Symptoms:** Red X marks, missing Maven Dependencies folder
**Solution:**
1. **Right-click on project** → `Maven` → `Clean`
2. **Right-click on project** → `Maven` → `Install`
3. **Right-click on project** → `Maven` → `Update Project`
4. **Check:** `Force Update of Snapshots/Releases`
5. **Click:** `OK`

### Issue 2: Spring Boot App Not Available
**Symptoms:** No "Spring Boot App" option in Run As menu
**Solution:**
1. **Install Spring Tools:**
   - `Help` → `Eclipse Marketplace`
   - Search: `Spring Tools 4`
   - Install and restart Eclipse
2. **Alternative:** Use `Run As` → `Java Application`

### Issue 3: Java Version Issues
**Symptoms:** Compilation errors, version mismatch
**Solution:**
1. **Right-click on project** → `Properties` → `Java Compiler`
2. **Set to:** Java 8 or higher
3. **Right-click on project** → `Properties` → `Project Facets`
4. **Set Java to:** 8 or higher
5. **Click:** `Apply and Close`

### Issue 4: Port 8080 Already in Use
**Symptoms:** Application fails to start, port binding error
**Solution:**
1. **Edit:** `src/main/resources/application.properties`
2. **Change:** `server.port=8080` to `server.port=8081`
3. **Save file**
4. **Restart application**
5. **Access:** `http://localhost:8081`

### Issue 5: Network/Firewall Issues
**Symptoms:** Maven can't download dependencies
**Solution:**
1. **Contact IT** to whitelist Maven repositories
2. **Check:** `Window` → `Preferences` → `Maven` → `User Settings`
3. **Verify:** Company Maven settings file location

### Issue 6: Eclipse Errors
**Symptoms:** Various Eclipse-specific errors
**Solution:**
1. **Check Error Log:** `Window` → `Show View` → `Error Log`
2. **Clean workspace:** `Project` → `Clean`
3. **Restart Eclipse**
4. **Contact IT** if persistent

---

## 🆘 Emergency Fallback Plan

### If Nothing Works:
1. **Create new Spring Boot project:**
   - `File` → `New` → `Spring Starter Project`
   - Name: `StudentManagementSystem`
   - Package: `com.example`
   - Dependencies: Web, JPA, H2, DevTools

2. **Copy source files:**
   - Copy all `.java` files from `src/main/java/com/example/`
   - Copy `application.properties`
   - Copy `index.html`

3. **Update dependencies:**
   - Copy dependencies from original `pom.xml`
   - Update new project's `pom.xml`

4. **Run the new project**

---

## 📋 Final Verification Checklist

After setup, verify ALL items:
- [ ] Project imports without errors
- [ ] No red X marks on project or files
- [ ] Maven Dependencies folder is populated
- [ ] Application starts in Console
- [ ] Console shows "Student Management System is running!"
- [ ] Browser opens to http://localhost:8080 (or 8081)
- [ ] Student Management System interface loads
- [ ] Can add new students
- [ ] Can view students in table
- [ ] Can edit existing students
- [ ] Can delete students with confirmation
- [ ] H2 Console accessible at /h2-console
- [ ] Database operations work correctly

---

## 🎯 Success Indicators

✅ **Console shows:** "Student Management System is running!"  
✅ **Browser shows:** Student Management System interface  
✅ **No red X marks** on project  
✅ **Maven Dependencies** folder is populated  
✅ **Application runs** without errors  
✅ **All CRUD operations** work correctly  

---

## 📞 Support Commands

### Check Eclipse Version:
```
Help → About Eclipse IDE
```

### Check Java Version:
```
Window → Preferences → Java → Installed JREs
```

### Check Maven Settings:
```
Window → Preferences → Maven → User Settings
```

### Check Error Log:
```
Window → Show View → Error Log
```

### Check Problems:
```
Window → Show View → Problems
```

---

## 🚨 If Still Having Issues

1. **Check Eclipse Error Log:** `Window` → `Show View` → `Error Log`
2. **Check Console Output:** Look for specific error messages
3. **Check Problems View:** `Window` → `Show View` → `Problems`
4. **Verify Network:** Company firewall might block Maven downloads
5. **Contact IT:** May need Maven repository access or Eclipse configuration
6. **Use Emergency Fallback:** Create new Spring Boot project and copy files

---

**Note**: This project is designed to work in any standard Eclipse environment with Maven support. The layered architecture and standard Spring Boot structure make it highly compatible with company development environments.
