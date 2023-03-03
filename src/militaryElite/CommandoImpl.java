package militaryElite;

import java.util.LinkedHashSet;


public class CommandoImpl extends SpecialisedSoldierImpl{
    private LinkedHashSet<Mission> missionSet;

    public LinkedHashSet<Mission> getMissionSet() {
        return missionSet;
    }

    public void setMissionSet(LinkedHashSet<Mission> missionSet) {
        this.missionSet = missionSet;
    }

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary, corp);
        this.missionSet = new LinkedHashSet<>();
    }

    public void addMission(Mission mission) {
        this.missionSet.add(mission);
    }

    public LinkedHashSet<Mission> getMissions() {
        return this.missionSet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Missions:").append(System.lineSeparator());
        for (Mission mission : missionSet) {
            sb.append(mission.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
