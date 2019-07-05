import java.io.PrintStream;

public class ReplyHandler implements EventHandler {

    private PrintStream out;
    private String reply;

    public ReplyHandler(PrintStream out, String reply){
        this.out = out;
        this.reply = reply;
    }

    @Override
    public void handle() {
        out.println(reply);
    }
}
