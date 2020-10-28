package User;

public class User {
	private static int id;
	
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		User.id = id;
	}
	private static String username;
	private static String password;
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		User.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		User.password = password;
	}
	@Override
	public String toString() {
		return "User [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
