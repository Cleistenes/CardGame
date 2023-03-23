/**
 * Essa classe terá os algoritmos para
 * os arrays das cartas.
 */
public class Search {
    /**
     * cria-se um array com 52 cartas.
     */
    public static Card[] makeDeck() {
        Card[] cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank ++) {
                cards[index] = new Card(rank, suit);
                index++;
            }
        }
        return cards;
    }

    /**
     * mostra o deck de cartas.
     */
    public static void printDeck(Card[] cards) {
        for (int i = 0; i < cards.length; i++) {
            System.out.println(cards[i]);
        }
    }

    /**
     * busca sequencial
     */
    public static int search(Card[] cards, Card target) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Busca binária(versão iterativa)
     */
    public static int binarySearch(Card[] cards, Card target) {
        int low = 0;
        int high = cards.length -1;
        while (low <= high) {
            System.out.println(low + ", " + high);

            int mid = (low + high) / 2;
            int comp = cards[mid].compareTo(target);

            if (comp == 0) {
                return mid;
            } else if (comp < 0) {
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }

    /**
     * busca binária (versão recursiva)
     */
    public static int binarySearch(Card[] cards, Card target, int low, int high) {
        System.out.println(low + ", " + high);

        if (high < low) {
           return -1;
        }
        int mid = (low + high) / 2;
        int comp = cards[mid].compareTo(target);

        if (comp == 0) {
            return mid;
        } else if (comp < 0) {
            return binarySearch(cards, target, mid +1, high);
        } else {
            return binarySearch(cards, target, low, mid -1);
        }
    }

    /**
     * mostra como chamar o método de busca
     */
    public static void main(String[] args) {
        Card[] cards = makeDeck();
        Card jack = new Card(11,0);
        Card fake = new Card(15,1);

        System.out.println("Busca sequencial");
        System.out.println(search(cards, jack));
        System.out.println();

        System.out.println("Busca binária");
        System.out.println(binarySearch(cards, jack));
        System.out.println();

        System.out.println("Falha na busca binária");
        System.out.println(binarySearch(cards, fake));
        System.out.println();

        System.out.println("busca binária recursiva");
        System.out.println(binarySearch(cards, jack, 0, 51));
        System.out.println();
    }
}
