import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import javax.swing.text.Position;
public class NotificationClass {
    static Notifications getNotifications(String title, String message){
        return  Notifications.create().title(title)
                .text(message)
                .graphic(null).hideAfter(Duration.seconds(20))
                .position(Pos.TOP_CENTER);
    }
}
