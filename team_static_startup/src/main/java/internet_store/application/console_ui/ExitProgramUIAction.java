package internet_store.application.console_ui;

public class ExitProgramUIAction implements UIAction{

    @Override
    public void execute() {
        System.out.println("Good by!");
        System.exit(0);
    }

}
