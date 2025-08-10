package com.sb21java.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name ="users")
public class User{		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int userId;
		
		@Column(nullable = false, length=50)
		private String username;
		
		@Column(nullable = false, length=50)
		private String password;
		
		@Column(nullable = false, length=20)
		private String role;

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
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		@Override
		public String toString() {
			return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", role=" + role
					+ "]";
		}

}
