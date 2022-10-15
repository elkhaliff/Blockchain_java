import java.util.Locale;

class TestDrive {
    public static void main(String[] args) {
        Pizza simpleVeganPizza = new Vegan();
        System.out.println(simpleVeganPizza.getDescription() + " $" + formatSum(simpleVeganPizza.cost()));

        Pizza veganPizzaDecor = new Vegan();
        veganPizzaDecor = new Broccoli(veganPizzaDecor);
        veganPizzaDecor = new Tomato(veganPizzaDecor);
        veganPizzaDecor = new Spinach(veganPizzaDecor);
        System.out.println(veganPizzaDecor.getDescription() + " $" + formatSum(veganPizzaDecor.cost()));

        Pizza meatPizzaDecor = new MeatHeaven();
        meatPizzaDecor = new Ham(meatPizzaDecor);
        meatPizzaDecor = new Chicken(meatPizzaDecor);
        meatPizzaDecor = new Cheese(meatPizzaDecor);
        System.out.println(meatPizzaDecor.getDescription() + " $" + formatSum(meatPizzaDecor.cost()));

    }

    private static String formatSum(double sum) {
        return String.format(Locale.ROOT, "%.2f", sum);
    }
}

abstract class Pizza {
    String description;

    String getDescription() {
        return description;
    }

    abstract double cost();
}

class Vegan extends Pizza {
    private static final double ADDCOST = 4.99;

    Vegan() {
        super();
        description = "Vegan";
    }

    @Override
    double cost() {
        return ADDCOST;
    }
}

class MeatHeaven extends Pizza {
    private static final double ADDCOST = 4.0;

    MeatHeaven() {
        super();
        description = "MeatHeaven";
    }

    @Override
    double cost() {
        return ADDCOST;
    }
}

abstract class Decorator extends Pizza {
    abstract String getDescription();
}

class Ham extends Decorator {
    private static final double ADDCOST = 1.0;
    private Pizza pizza;

    Ham(Pizza pizza) {
        super();
        this.pizza = pizza;
    }

    @Override
    String getDescription() {
        return pizza.getDescription() + ", Ham";
    }

    @Override
    double cost() {
        return ADDCOST + pizza.cost();
    }
}

class Chicken extends Decorator {
    private static final double ADDCOST = 1.5;

    private Pizza pizza;

    Chicken(Pizza pizza) {
        super();
        this.pizza = pizza;
    }

    @Override
    String getDescription() {
        return pizza.getDescription() + ", Chicken";
    }

    @Override
    double cost() {
        return ADDCOST + pizza.cost();
    }
}

class Cheese extends Decorator {
    private static final double ADDCOST = .20;

    private Pizza pizza;

    Cheese(Pizza pizza) {
        super();
        this.pizza = pizza;
    }

    @Override
    String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    @Override
    double cost() {
        return ADDCOST + pizza.cost();
    }
}

class Broccoli extends Decorator {
    private static final double ADDCOST = .10;

    private Pizza pizza;

    Broccoli(Pizza pizza) {
        super();
        this.pizza = pizza;
    }

    @Override
    String getDescription() {
        return pizza.getDescription() + ", Broccoli";
    }

    @Override
    double cost() {
        return ADDCOST + pizza.cost();
    }
}

class Tomato extends Decorator {
    private static final double ADDCOST = .09;

    private Pizza pizza;

    Tomato(Pizza pizza) {
        super();
        this.pizza = pizza;
    }

    @Override
    String getDescription() {
        return pizza.getDescription() + ", Tomato";
    }

    @Override
    double cost() {
        return ADDCOST + pizza.cost();
    }
}

class Spinach extends Decorator {
    private static final double ADDCOST = .09;

    private Pizza pizza;

    Spinach(Pizza pizza) {
        super();
        this.pizza = pizza;
    }

    @Override
    String getDescription() {
        return pizza.getDescription() + ", Spinach";
    }

    @Override
    double cost() {
        return ADDCOST + pizza.cost();
    }
}