package optionalTask;

import java.util.ArrayList;

public class ActionsWithJavaProgramChangingPublicToPrivateRunner {
    public static void main(String[] args) {
        ActionsWithJavaProgramChangingPublicToPrivate actionsWithJavaProgramChangingPublicToPrivate = new ActionsWithJavaProgramChangingPublicToPrivate();
        ArrayList<String> linesFromFile;
        ArrayList<String> linesWithChangedModifiers;
        linesFromFile = actionsWithJavaProgramChangingPublicToPrivate.readJavaProgramFromFile();
        linesWithChangedModifiers = actionsWithJavaProgramChangingPublicToPrivate.changePrivateModifiersToPublic(linesFromFile);
        actionsWithJavaProgramChangingPublicToPrivate.writeInFileJvaProgramWithChangedModifiers(linesWithChangedModifiers);
    }
}
