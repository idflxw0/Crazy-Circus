package Card;

public enum Move {
    KI,
    LO,
    SO,
    NI,
    MA;
    public static Move fromString(String str) {
        try {
            return valueOf(str.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
