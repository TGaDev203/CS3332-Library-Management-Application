# CS3332-Library-Management-Application

## Project Overview

Library-Management-Application is a comprehensive library management system developed using JavaFX and Maven. This application is designed to streamline library operations, providing an efficient way to manage books and users effectively.

## Key Features

### User Management
- Secure login system for users and admins.
- User profiles and account management.
- Different roles with distinct permissions.

### Book Management
- Add, update, and delete book records (admin only).
- View detailed information about each book.
- Categorize books by genre, author, and publication year.
- Track book status and availability.

### Borrow and Return Books
- Users can borrow available books.
- Users can return borrowed books.
- Monitor due dates and manage overdue fines.

### Book Information and Status
- View detailed information about each book, including author, genre, and publication year.
- Check the availability and status of books (e.g., available, borrowed, reserved).

### Search and Filtering
- Powerful search functionality to find books by title, author, or ISBN.
- Advanced filtering options to refine search results.

### Notifications
- Email and in-app notifications for due dates, reservations, and library announcements.

## Technology Stack

- **JavaFX:** For building the user interface.
- **Maven:** For project management and dependency management.
- **PHP:** Server-side scripting.
- **MySQL:** Database management.

## Getting Started

### Prerequisites

- JDK 11 or higher
- Apache Maven
- MySQL server
- PHP

### Installation

1. **Clone the Repository:**
   ```sh
   git clone https://github.com/Veicap/LibraryHustManagerment.git
   cd LibraryHustManagerment
   ```
2. **Database Configuration:**
   - Configure your MySQL database as required. Refer to the documentation for detailed instructions.

3. **Install Maven Dependencies:**
   ```sh
   mvn install
   ```

4. Run the Application:

   ```sh
   mvn javafx:run
   ```
