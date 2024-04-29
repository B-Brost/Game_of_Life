package life6visitor;

class Invoker {
    private LifeCommand command;

    public Invoker(LifeCommand command){
        this.command = command;
    }
    public void execute(){
        this.command.execute();
    }
}