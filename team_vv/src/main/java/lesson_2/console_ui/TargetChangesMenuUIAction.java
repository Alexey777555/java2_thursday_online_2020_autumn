package lesson_2.console_ui;

public class TargetChangesMenuUIAction implements UIAction {

    @Override
    public void execute() {
        System.out.println("Choose target parameter: ");
        System.out.println("[1] Change target name");
        System.out.println("[2] Change target description");
        System.out.println("[3] Change target deadline");
        System.out.println("[0] Back to Menu");
    }
}
