package expenditure;

public class Expenditure {
    protected String description;

    protected String type;

    protected Float amount;
    protected String date;

    public Expenditure(String description, String type, Float amount, String date) {
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public Float getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return description + " | " + type + " | Cost: $" + amount + " | date: " + date;
    }

    public String toStringStorage() {
        return description + " | " + type + " | " + amount + " | " + date;
    }
}
