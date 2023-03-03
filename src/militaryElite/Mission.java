package militaryElite;

public class Mission {
    private String name;
    private String state;

    public Mission(String name, String state) {
        this.name = name;
        setState(state);
    }

    private void setState(String state) {
        if (state.equals(String.valueOf(State.finished)) || state.equals(String.valueOf(State.inProgress))) {
            this.state = state;
        } else {
            throw new IllegalArgumentException("Invalid state");
        }
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }


    @Override
    public String toString() {
        return String.format("  Code Name: %s State: %s",getName(), getState() );
    }
}
