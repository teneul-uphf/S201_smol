package model;

public enum TypeCellule {
    EAU(false),
    SOL(true);

    private final boolean franchissable;

    TypeCellule(boolean franchissable) {
        this.franchissable = franchissable;
    }

    public boolean isFranchissable() {
        return franchissable;
    }
}