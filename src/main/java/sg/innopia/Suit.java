package sg.innopia;

public enum Suit {
    SPADE("Spade", '\u2660'),
    CLUB("Clubs", '\u2663'),
    HEART("Hearts", '\u2665'),
    DIAMOND("Diamonds", '\u2666');

    final String name;
    final Character unicode;
    Suit(String name, Character unicode) {
        this.name = name;
        this.unicode = unicode;
    }

}
