package CreationOfTasks;

public class IncorrectArgumentException extends RuntimeException {

    private String argument;

    public IncorrectArgumentException(String argument) {
        this.argument = argument;
    }

    public String getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        return "CreationOfTasks.IncorrectArgumentException{" +
                "argument='" + argument + '\'' +
                '}';
    }
}
