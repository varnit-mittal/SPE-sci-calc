# Scientific Calculator Project

This project implements a **Scientific Calculator** with advanced mathematical functionalities, developed as part of the **Software Production Engineering** course. It demonstrates full-stack development using **Spring Boot** for the backend and **React** for the frontend, along with CI/CD automation using **Jenkins**, **Docker**, and **Ansible**.

---

## Features

The scientific calculator supports the following operations:

- **Square Root** (`sqrt`)
- **Factorial** (`!`)
- **Natural Logarithm** (`ln`)
- **Power Function** (`x^y`)

---

## Technology Stack

- **Backend:** Spring Boot (Java)
- **Frontend:** React.js
- **CI/CD:** Jenkins
- **Containerization:** Docker
- **Deployment Automation:** Ansible
- **Version Control:** Git & GitHub

---

## Architecture Overview

1. **Frontend (React)**  
   - Provides a user-friendly interface for inputting numbers and selecting operations.
   - Sends requests to the backend API to compute results.

2. **Backend (Spring Boot)**  
   - Handles calculation logic for square root, factorial, natural logarithm, and power functions.
   - Exposes REST APIs consumed by the frontend.

3. **CI/CD Pipeline (Jenkins)**  
   - Pulls the latest code from the repository using a webhook.
   - Builds Docker images for frontend and backend.
   - Pushes the images to **Docker Hub**.
   - Deploys the application locally using **Ansible**.

4. **Deployment (Docker + Ansible)**  
   - Docker containers run the backend and frontend.
   - Ansible automates the deployment process on the local system.

---

## Getting Started

### Prerequisites

- Java 17 or higher
- Node.js and npm
- Docker
- Docker Compose
- Ansible
- Jenkins (for CI/CD)

### Running Locally

1. **Clone the Repository:**

```bash
git clone https://github.com/varnit-mittal/SPE-sci-calc.git
cd SPE-sci-calc
docker-compose up --build
```

---

# Running Test