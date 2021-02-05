import java.util.Objects;

public class Computer {
    private static final String DEFAULT_MEMORY = "128GB";

    private String brand;
    private String name;
    private String memorySize;

    public Computer(String brand, String name, String memorySize) {
        this.brand = brand;
        this.name = name;
        this.memorySize = memorySize;
    }

    public Computer(String brand, String name) {
        this(brand, name, DEFAULT_MEMORY);
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getMemorySize() {
        return memorySize;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemorySize(String memorySize) {
        this.memorySize = memorySize;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + "\tName: " + name + "\tMemory Size: " + memorySize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Computer)) return false;
        Computer computer = (Computer) o;
        return brand.equalsIgnoreCase(computer.getBrand()) && name.equalsIgnoreCase(computer.getName()) &&
                memorySize.equalsIgnoreCase(computer.getMemorySize());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getName(), getMemorySize());
    }
}
