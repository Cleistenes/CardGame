public class Card {

    public static final String [] RANKS = {
            null, "Às", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "Valete", "Rainha", "Rei"};

    public static final String [] SUITS = {
            "Copas", "Diamante", "Coração", "Espadas"};

    private final int rank;

    private final int suit;

    /**
     * Acima foi construído uma carta para cada rank e nipe.
     */

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /** Abaixo tem-se um método que retorna um inteiro(integer)
     * negativo se a carta vier antes da carta dada,
     * zero se as duas cartas forem iguais, ou um integer
     * positivo se a carta vier depois.
     */
    public int compareTo(Card that) {
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
            return 1;
        }
        return 0;
    }

    /** com o método a seguir obteremos true se determinada
     * carta tiver o mesmo rank e suit, ao contrário retornará
     * falsa.
     */

    public boolean equals (Card that) {
        return this.rank == that.rank
        && this.suit == that.suit;
    }

    /**Agora uso um getter para obter o rank da carta.*/

    public int getRank() {
        return rank;
    }

    /** outro getter, mas agora para o suit da carta
    */
    public int getSuit() {
        return suit;
    }

    /**
     * aqui defino um indíce para saber a posição da carta
     * no deck com 52 cartas.
     */
    public int position() {
        return this.suit * 13 + this.rank - 1;
    }

    /**
     * Aqui peço como retorno uma representção em String da
     * carta.
     */
    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }
}