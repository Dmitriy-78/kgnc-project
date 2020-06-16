package ru.krilovskiy.domain;

public enum ClearanceForm {
    ONE,TWO,THREE;

    public static ClearanceForm fromValue(int value) {
        for (ClearanceForm cf : ClearanceForm.values()) {
            if (cf.ordinal() == value) {
                return cf;
            }
        }
        return null;
    }
}
