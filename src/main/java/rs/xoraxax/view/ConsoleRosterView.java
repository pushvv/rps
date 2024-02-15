package rs.xoraxax.view;

public class ConsoleRosterView implements RosterView {
    @Override
    public void display(String nameA, String nameB, Long resultA, Long resultB, Long tie, Long total) {
        System.out.println(nameA + " wins " + resultA + " of " + total + " games.");
        System.out.println(nameB + " wins " + resultB + " of " + total + " games.");
        System.out.println("Tie: " + tie + " of " + total + " games.");
    }
}
