package militaryElite;

public class SpyImpl extends SoldierImpl implements Soldier{
    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s",super.toString())).append(System.lineSeparator());
        sb.append(String.format("Code Number: %s", codeNumber)).append(System.lineSeparator());
        return sb.toString().trim();
    }
}
