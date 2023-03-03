package militaryElite;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class EngineerImpl extends SpecialisedSoldierImpl{
    private LinkedHashSet<Repair> repairs;
    public EngineerImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary, corp);
        this.repairs = new LinkedHashSet<>();
    }

    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    public LinkedHashSet<Repair> getRepairs() {
        return this.repairs;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Repairs: ").append(System.lineSeparator());
        for (Repair repair : repairs) {
            sb.append(repair.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
