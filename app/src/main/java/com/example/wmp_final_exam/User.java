public class User {
    private String username;
    private boolean enrollmentStatus;

    // Constructor kosong untuk Firestore
    public User() {
    }

    // Constructor untuk inisialisasi
    public User(String username, boolean enrollmentStatus) {
        this.username = username;
        this.enrollmentStatus = enrollmentStatus;
    }

    // Getter dan Setter untuk username dan enrollmentStatus
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(boolean enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }
}