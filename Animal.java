public class Animal {
    public int age;
    public String gender;
    public Animal(int age, String gender) {
        this.age = age;
        this.gender = gender;
    }

    public void isMammal() {
        System.out.println("This animal is a mammal.");
    }

    public void mate() {
        System.out.println("This animal is mating.");
    }

    public static void main(String[] args) {
        Animal myAnimal = new Animal(5, "Male");
        Fish myFish = new Fish(2, "Female", 3);
        Zebra myZebra = new Zebra(4, "Male", true);
        myAnimal.isMammal();
        myAnimal.mate();
        myZebra.isMammal();
        myZebra.mate();
        myZebra.run();
    }
}
class Fish extends Animal {
    private int sizeInFeet;
    public Fish(int age, String gender, int sizeInFeet) {
        super(age, gender);
        this.sizeInFeet = sizeInFeet;
    }

    private void canEat() {
        System.out.println("This is a private method canEat() from class Fish");
    }
}
class Zebra extends Animal {
    public boolean is_wild;
    public Zebra(int age, String gender, boolean is_wild) {
        super(age, gender);
        this.is_wild = is_wild;
    }

    public void run() {
        System.out.println("The zebra is running.");
    }
}