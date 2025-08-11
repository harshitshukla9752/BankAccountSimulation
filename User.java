public class User {
    private static int userCounter = 1000;
    private final String userId;
    private String name;
    private String email;

    public User(String name, String email) {
        this.userId = "U" + (++userCounter);
        this.name = name;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
