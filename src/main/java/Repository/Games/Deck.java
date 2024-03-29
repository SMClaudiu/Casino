package Repository.Games;
import java.util.Random;

public class Deck
{

    private final int DECK_SIZE = 52;
    public int restOfDeck = 6;

    Card[] deck = new Card[DECK_SIZE];
    Random r = new Random();

    // fill deck with cardss
    public void fillDeck()
    {
        int counter = 0;
        for (int suit = 1; suit <= 4; suit++)
        {
            for (int rank = 1; rank <= 13; rank++)
            {
                deck[counter] = new Card();
                deck[counter].suit = suit;
                deck[counter].rank = rank;
                counter++;
            }
        }
    }

    // shuffle deck
    public void shuffle()
    {
        int SHUFFLE_EXCHANGES = 2000;
        for (int x = 0; x <= SHUFFLE_EXCHANGES; x++)
        {
            int number1 = r.nextInt(DECK_SIZE);
            int number2 = r.nextInt(DECK_SIZE);
            Card temp = deck[number1];
            deck[number1] = deck[number2];
            deck[number2] = temp;
        }
    }

    // deals 5 cards
    public Card[] deal()
    {
        int HAND_SIZE = 5;
        Card[] hand = new Card[HAND_SIZE];
        System.arraycopy(deck, 0, hand, 0, 5);
        return hand;
    }

    // deals cards for redraw
    public Card redeal()
    {
        Card nextCard = deck[restOfDeck];
        restOfDeck++;
        return nextCard;
    }

    // refreshes deck position to 6 for next hand
    public void refreshDeckPosition()
    {
        restOfDeck = 6;
    }

}