package tests.cli.demo;

import org.testng.annotations.Test;

import com.shaft.cli.TerminalActions;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.AssertionComparisonType;
import com.shaft.validation.Assertions.AssertionType;

public class cliTest {
    @Test
    public void sampleTestCase() {
	// does not work for windows
	TerminalActions localTerminal = new TerminalActions();
	String consoleLog = localTerminal.performTerminalCommand("ls");
	Assertions.assertEquals("pom.xml", consoleLog, AssertionComparisonType.CONTAINS, AssertionType.POSITIVE,
		"Demoing local terminal actions");
    }
}
