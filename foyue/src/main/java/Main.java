import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.Color.BLUE;
import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.ansi;

public class Main {
    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        System.out.println(ansi().fg(BLUE).bg(RED).a("改变颜色").reset());
        AnsiConsole.systemInstall();
    }
}
