# 📝 Saif Task App

Saif Task App is a full-stack **Task Management System** that allows users to create task lists, manage tasks, update task status, and track completion efficiently.  
The application is built using **Spring Boot** for the backend and **React (Vite + TypeScript)** for the frontend, following clean architecture and RESTful API principles.

---

## 🚀 Features

### ✅ Task List Management
- Create, update, delete task lists
- View all task lists

### ✅ Task Management
- Create, update, delete tasks
- Mark tasks as **Completed**
- Update task priority, status, and due date
- View tasks by task list

### ✅ Frontend
- Built with **React + TypeScript**
- **Vite** for fast development
- **Tailwind CSS + NextUI** for UI styling
- Context API for state management
- Clean routing using **React Router**

### ✅ Backend
- **Spring Boot** REST APIs
- **Spring Data JPA** with PostgreSQL
- Proper HTTP methods (`GET`, `POST`, `PUT`, `DELETE`)
- UUID-based entities
- Layered architecture (Controller, Service, Repository)

### ✅ DevOps Ready
- Docker support for backend
- Environment-based configuration
- Frontend proxy configuration using Vite

---

## 🛠 Tech Stack

### Frontend
- React 18
- TypeScript
- Vite
- Tailwind CSS
- NextUI
- Axios
- React Router

### Backend
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

### DevOps / Tools
- Docker
- Git & GitHub
- IntelliJ IDEA
- VS Code

---

## 📂 Project Structure

```text
saif-task-app/
│
├── backend/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── domain/
│   └── SaifTaskApplication.java
│
├── frontend/
│   ├── components/
│   ├── domain/
│   ├── AppProvider.tsx
│   ├── App.tsx
│   └── main.tsx
