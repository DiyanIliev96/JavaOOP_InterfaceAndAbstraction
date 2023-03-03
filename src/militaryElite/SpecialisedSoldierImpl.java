package militaryElite;

public class SpecialisedSoldierImpl extends PrivateImpl{
    private String corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary);
        setCorps(corp);
    }

    private void setCorps(String corp) {
        if (corp.equals(String.valueOf(Corps.Marines)) || corp.equals(String.valueOf(Corps.Airforces))) {
            this.corps = corp;
        } else {
            throw new IllegalArgumentException("Invalid corpse");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append(String.format("Corps: %s",corps)).append(System.lineSeparator());
        return sb.toString().trim();
    }
}
