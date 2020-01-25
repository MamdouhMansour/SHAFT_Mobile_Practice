package tests.cli.demo;

import org.testng.annotations.Test;

import com.shaft.cli.TerminalActions;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.AssertionComparisonType;
import com.shaft.validation.Assertions.AssertionType;

public class cliTest {
    @Test
    public void sampleTestCase() {
	String commandToListFilesInCurrentDirectory = "ls";
	if (System.getProperty("targetOperatingSystem").toLowerCase().contains("windows")) {
	    commandToListFilesInCurrentDirectory = "cmd.exe /c dir";
	}
	TerminalActions localTerminal = new TerminalActions();
	String consoleLog = localTerminal.performTerminalCommand(commandToListFilesInCurrentDirectory);
	Assertions.assertEquals("pom.xml", consoleLog, AssertionComparisonType.CONTAINS, AssertionType.POSITIVE,
		"Demoing local terminal actions");
    }
}
