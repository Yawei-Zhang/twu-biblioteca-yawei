package com.twu.biblioteca.models;

public class Option {
    private int optionID;
    private String optionItem;

    public Option(int id, String item) {
        optionID = id;
        optionItem = item;
    }

    public int getOptionID() {
        return this.optionID;
    }

    public String getOptionItem() {
        return this.optionItem;
    }

    @Override
    public String toString () {
        return this.optionID + ". " + this.optionItem;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;

        if (!(object instanceof Option))
            return false;

        Option option = (Option) object;

        return option.getOptionID() == this.optionID &&
                option.getOptionItem() == this.optionItem;
    }
}
