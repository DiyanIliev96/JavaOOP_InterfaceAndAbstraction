package militaryElite;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Soldier> privatesList = new ArrayList<>();

        while (!input[0].equals("End")) {
            try {
                int id = Integer.parseInt(input[1]);
                String firstName = input[2];
                String lastName = input[3];
                double salary = Double.parseDouble(input[4]);
                switch (input[0]) {
                    case "Private":
                        Soldier privat = new PrivateImpl(id, firstName, lastName, salary);
                        privatesList.add(privat);
                        System.out.println(privat);
                        break;
                    case "LieutenantGeneral":
                        LieutenantGeneral lieutenant = new LieutenantGeneralImpl(id, firstName, lastName, salary);
                        collectPrivates(privatesList, lieutenant);
                        System.out.println(lieutenant);
                        break;
                    case "Engineer":
                        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, input[5]);
                        collectRepairs(input, engineer);
                        System.out.println(engineer);
                        break;

                    case "Commando":
                        CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, input[5]);
                        collectMissions(input, commando);
                        System.out.println(commando);
                        break;

                    case "Spy":
                        SpyImpl spy = new SpyImpl(id, firstName, lastName, input[4]);
                        System.out.println(spy);
                        break;
                }

            } catch (IllegalArgumentException ex) {
                input = scanner.nextLine().split(" ");
                continue;
            }
            input = scanner.nextLine().split(" ");
        }


    }

    private static void collectMissions(String[] input, CommandoImpl commando) {
        List<Mission> missionList = new ArrayList<>();

        for (int i = 6; i < input.length; i += 2) {
            try {
                Mission mission = new Mission(input[i], input[i + 1]);
                missionList.add(mission);
            } catch (IllegalArgumentException ex) {
            }
        }
        for (Mission mission : missionList) {
            commando.addMission(mission);
        }
    }

    private static void collectRepairs(String[] input, EngineerImpl engineer) {
        List<Repair> repairList = new ArrayList<>();

        for (int i = 6; i < input.length; i += 2) {
            Repair repair = new Repair(input[i], Integer.parseInt(input[i + 1]));
            repairList.add(repair);
        }
        for (Repair repair : repairList) {
            engineer.addRepair(repair);
        }
    }

    private static void collectPrivates(List<Soldier> privatesList, LieutenantGeneral lieutenant) {
        for (Soldier soldier : privatesList) {
            lieutenant.addPrivate((Private) soldier);
        }
    }
}
