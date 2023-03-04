package militaryElite;

import java.util.*;
import java.util.stream.Collectors;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Set<Soldier> privateSet;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privateSet = new LinkedHashSet<>();
    }


    @Override
    public void addPrivate(Private priv) {
        this.privateSet.add((Soldier) priv);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Privates: ").append(System.lineSeparator());
        List<Soldier> tempList = new ArrayList<>(privateSet);
        List<Soldier> sortedList = tempList.stream().sorted(Comparator.comparing(Soldier::getId).reversed()).collect(Collectors.toList());
        for (Soldier soldier : sortedList) {
            sb.append(String.format("  %s", soldier.toString())).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
