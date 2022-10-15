import java.util.*;

class Address implements Comparable<Address> {
    private final String city;
    private final String street;
    private final String house;

    public Address(String city, String street, String house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }

    @Override
    public int compareTo(Address other) {
        int compare = house.compareTo(other.house);
        if (compare == 0) {
            compare = street.compareTo(other.street);
            if (compare == 0) {
                compare = city.compareTo(other.city);
            }
        }
        return compare;
    }

    @Override
    public String toString() {
        return "%s, %s, %s".formatted(house, street, city);
    }
}

// do not change the code below
class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Address> list = new ArrayList<>();

        while (sc.hasNextLine()) {
            String[] arguments = sc.nextLine().split(",");
            list.add(new Address(arguments[0], arguments[1], arguments[2]));
        }
        Collections.sort(list);
        Checker.check(list);
    }
}