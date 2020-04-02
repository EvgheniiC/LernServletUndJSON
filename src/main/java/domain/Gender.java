package domain;

public enum Gender {
    MAN,
    WOMAN;

    public String getStatus() {
        return this.name();
    }
}
