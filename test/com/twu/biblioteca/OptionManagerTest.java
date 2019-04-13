package com.twu.biblioteca;

import com.twu.biblioteca.models.Option;
import org.junit.Test;
import static org.junit.Assert.*;

public class OptionManagerTest {

    @Test
    public void should_return_true_when_get_an_valid_option() {
        OptionManager optionManager = new OptionManager();
        optionManager.addOption(new Option("1", "List of books"));
        assertTrue(optionManager.isValidOption("1"));
    }

    @Test
    public void should_return_false_when_get_an_invalid_option() {
        OptionManager optionManager = new OptionManager();
        optionManager.addOption(new Option("1", "List of books"));
        assertFalse(optionManager.isValidOption("2"));
    }

}