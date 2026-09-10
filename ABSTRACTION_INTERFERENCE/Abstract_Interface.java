package ABSTRACTION_INTERFERENCE;
abstract class Device {

    // Variable
    String brand = "Samsung";

    // Abstract method
    abstract void turnOn();

    // Concrete method
    void showBrand() {
        System.out.println("Brand: " + brand);
    }
}


// Interface 1
interface Camera {

    int MAX_ZOOM = 10; // public static final

    void takePhoto(); // public abstract method

    default void cameraInfo() { // Concrete method
        System.out.println("Camera is ready");
    }
}


// Interface 2
interface MusicPlayer {

    String TYPE = "Digital"; // public static final

    void playMusic(); // public abstract method

    default void musicInfo() { // Concrete method
        System.out.println("Music player is ready.");
    }
}


// Child class
class Smartphone extends Device implements Camera, MusicPlayer {

    // Implementing abstract method of Device
    void turnOn() {
        System.out.println("Smartphone is turned on");
    }

    // Implementing abstract method of Camera
    public void takePhoto() {
        System.out.println("Taking photo.....");
    }

    // Implementing abstract method of MusicPlayer
    public void playMusic() {
        System.out.println("Playing music.....");
    }
}


// Main class
public class Abstract_Interface {

    public static void main(String[] args) {

        Smartphone s = new Smartphone();

        s.turnOn();
        s.showBrand();
        s.takePhoto();
        s.playMusic();
        s.cameraInfo();
        s.musicInfo();
    }
}