package com.sb21java.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class User {
	@Entity
	@Table(name ="User")
	public class Employee {
		
		@Id
		@GeneratedValue
		private int userId;
		
		@Column(nullable = false, length=50)
		private String username;
		
		@Column(nullable = false, length=50)
		private String Password;
		
		@Column(nullable = false, length=20)
		private String Role;

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return Password;
		}

		public void setPassword(String password) {
			Password = password;
		}

		public String getRole() {
			return Role;
		}

		public void setRole(String role) {
			Role = role;
		}

		@Override
		public String toString() {
			return "Employee [userId=" + userId + ", username=" + username + ", Password=" + Password + ", Role=" + Role
					+ "]";
		}
}
}