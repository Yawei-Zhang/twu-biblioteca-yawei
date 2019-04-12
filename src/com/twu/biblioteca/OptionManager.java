package com.twu.biblioteca;

import com.twu.biblioteca.models.Option;

import java.util.ArrayList;

public class OptionManager {

    private ArrayList<Option> optionList;

    public OptionManager() {
        optionList = new ArrayList<>();
    }

    public ArrayList<Option> getOptionList() {
        return this.optionList;
    }

    public void addOption(Option option) {
        this.optionList.add(option);
    }

    public boolean isValidOption(int id) {
        return optionList.stream().anyMatch( option -> id == option.getOptionID());
    }
}
