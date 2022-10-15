import java.util.Locale;

class TestDrive {
    public static void main(String[] args) throws InterruptedException {
        final int sleepTime = 1500;

        Coffee simpleEspresso = new Espresso();
        System.out.println(simpleEspresso.getDescription() + " $" + formatSum(simpleEspresso.cost()));

        Coffee espressoWithDecor = new Espresso();
        espressoWithDecor = new Milk(espressoWithDecor);
        espressoWithDecor = new Sugar(espressoWithDecor);
        System.out.println(espressoWithDecor.getDescription() + " $" + formatSum(espressoWithDecor.cost()));

        Coffee instantWithDecor = new InstantCoffee();
        instantWithDecor = new WhippedCream(instantWithDecor);
        instantWithDecor = new Sugar(instantWithDecor);
        instantWithDecor = new Sugar(instantWithDecor);
        instantWithDecor = new Sugar(instantWithDecor);
        System.out.println(instantWithDecor.getDescription() + " $" + formatSum(instantWithDecor.cost()));

        System.out.println("I'm drinking my " + instantWithDecor.getDescription());
        Thread.sleep(sleepTime);
        System.out.println("-I want to add some Whipped Cream to my coffee." +
                " And don't make a new one! Just add Whipped Cream");
        Thread.sleep(sleepTime);
        System.out.println("-Okay! But the final price will change");
        Thread.sleep(sleepTime);
        System.out.println("-I understand");

        instantWithDecor = new WhippedCream(instantWithDecor);
        System.out.println(instantWithDecor.getDescription() + " $" + formatSum(instantWithDecor.cost()));
    }

    private static String formatSum(double sum) {
        return String.format(Locale.ROOT, "%.2f", sum);
    }
}

abstract class Coffee {
    String description;

    String getDescription() {
        return description;
    }

    abstract double cost();
}

class Espresso extends Coffee {
    private static final double ADDCOST = 1.99;

    Espresso() {
        super();
        description = "Espresso";
    }

    @Override
    double cost() {
        return ADDCOST;
    }
}

class InstantCoffee extends Coffee {
    private static final double ADDCOST = 1.0;

    InstantCoffee() {
        super();
        description = "Instant Coffee";
    }

    @Override
    double cost() {
        return ADDCOST;
    }
}

abstract class Decorator extends Coffee {
    abstract String getDescription();
}

class Milk extends Decorator {
    private static final double ADDCOST = .13;

    private Coffee coffee;

    public Milk(Coffee coffee) {
        super();
        this.coffee = coffee;
    }

    @Override
    String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    double cost() {
        return ADDCOST + coffee.cost();
    }
}

class Sugar extends Decorator {
    private static final double ADDCOST = .02;

    private Coffee coffee;

    public Sugar(Coffee coffee) {
        super();
        this.coffee = coffee;
    }

    @Override
    String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    double cost() {
        return ADDCOST + coffee.cost();
    }
}

class WhippedCream extends Decorator {
    private static final double ADDCOST = .10;

    private Coffee coffee;

    public WhippedCream(Coffee coffee) {
        super();
        this.coffee = coffee;
    }

    @Override
    String getDescription() {
        return coffee.getDescription() + ", Whipped Cream";
    }

    @Override
    double cost() {
        return ADDCOST + coffee.cost();
    }
}