package Domain;

import Domain.NotificationBuilder.Notification;
import Domain.NotificationObserver.Message;
import Domain.NotificationObserver.NotificationObserver;

public class User extends NotificationObserver {
    private String Name;
    private Role role;
    private int age;
    private String email;
    private Notification notification;

    public User() {
    }

    public User(String name, Role role, int age, String email) {
        Name = name;
        this.role = role;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void onNotification(Message message) {
        if(this.notification!=null){
            this.notification.send(message.getSubject(), message.getMessage());
        }else {
            System.out.println("onNotification: notification object is null,  Message { Subject: " +  message.getSubject()+ ", Message: " + message.getMessage()+ "} User: " + this.toString());
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", role=" + role +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", notification='" + notification + '\'' +
                '}';
    }
}
