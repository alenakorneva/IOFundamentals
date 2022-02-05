package optionalTask;

import java.util.ArrayList;

public class ActionsWithJavaProgramInFileRunner {
    public static void main (String[] args){
        ActionsWithJavaProgramInFile actionsWithJavaProgramInFile = new ActionsWithJavaProgramInFile();
        ArrayList<String> linesFromFile = actionsWithJavaProgramInFile.readJavaProgramFromFile();
        ArrayList<String> linesFromFileWithCharactersInReversedOrder = actionsWithJavaProgramInFile.reverseOrderOfCharactersInEachLine(linesFromFile);
        actionsWithJavaProgramInFile.writeInFileLinesWithReversedCharacters(linesFromFileWithCharactersInReversedOrder);
    }
}
