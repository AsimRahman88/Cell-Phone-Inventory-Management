# **Cell List Utilization Program**

## **Description**
This project implements a **Cell List Utilization Program** in **Java**. It allows users to manage a linked list of cell phone objects, providing functionalities such as adding, deleting, replacing, and searching for cell phone records. The program also handles duplicate records and provides a detailed menu-driven interface for interacting with the list.

The project demonstrates strong Java programming skills, focusing on:
- **Object-Oriented Programming (OOP)**
- **Linked List Implementation**
- **Dynamic Memory Management**
- **Input Validation and Error Handling**
- **Encapsulation and Modular Design**

---

## **Features**
### **1. Manage Cell Phone Records**
- Supports the creation and manipulation of cell phone records, including:
  - Adding new cell phone objects to the list.
  - Preventing duplicate entries by validating serial numbers.
  - Copying entire lists to create independent copies.

### **2. Perform List Operations**
- Add, delete, or replace cell phone objects at specified indices:
  - **Add to Start**: Inserts a new record at the beginning of the list.
  - **Insert at Index**: Inserts a new record at a user-defined index.
  - **Delete from Index**: Removes a record from a specified index.
  - **Delete from Start**: Removes the first record in the list.
  - **Replace at Index**: Replaces a record at a specific index with a new cell phone object.

### **3. Search and Validation**
- Search for a cell phone by its serial number:
  - Tracks the number of iterations performed during the search.
  - Displays whether the serial number was found and provides a pointer to the record.
- Validate if a serial number exists in the list.

### **4. Display and Compare Lists**
- Show the contents of the list in a formatted structure.
- Compare two lists to determine equality based on their contents.

### **5. Handle File Input**
- Reads cell phone records from a `Cell_Info.txt` file and initializes a list.
- Ensures duplicate records are skipped during initialization.

---

## **Technical Details**
### **Programming Language**
- **Java**

### **Key Concepts**
- **Object-Oriented Design**:
  - Encapsulated functionalities in modular classes (`CellList`, `CellPhone`, and `CellNode`).
  - Used constructors and methods for deep copies and cloning.
- **Linked List Implementation**:
  - Created a custom linked list structure using an inner `CellNode` class.
  - Implemented operations such as addition, deletion, replacement, and traversal.
- **File Handling**:
  - Read and processed input from `Cell_Info.txt` to initialize the list.
  - Ensured file-related errors are handled gracefully.
- **Input Validation**:
  - Validated indices for insertion, deletion, and replacement.
  - Checked for duplicate serial numbers.
- **Error Handling**:
  - Managed exceptions like `InputMismatchException` and `NoSuchElementException`.
- **Dynamic Memory Management**:
  - Used linked lists to dynamically manage memory for cell phone records.

---

## **How to Run**
1. **Compile the Code**:
   ```bash
   javac CellListUtilization.java
