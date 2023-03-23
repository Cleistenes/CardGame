import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.*;

public class CardTable extends Canvas {

    private Image[][] images;
    private int cardWidth, cardHeight;

    public CardTable(String cardset) {
        setBackground(new Color(0x088A4B));

        //aqui se cria imagens 2D das cartas.
        images = new Image[14][4];
        String suits = "cdhs";

        for (int suit = 0; suit <= 3; suit++) {
            char c = suits.charAt(suit);

            for (int rank = 1; rank <= 3; rank++) {
                String s = String.format("%s/%02d%c.gif", cardset, rank, c);

                images[rank][suit] = new ImageIcon(s).getImage();
            }
        }

        //pega a largura e a altura das cartas e as ajusta
        //ao tamanho da mesa.
        cardWidth = images[1][1].getWidth(null);
        cardHeight = images[1][1].getHeight(null);

        //coloca um tamanho temporário.
        setTableSize(14,4);
    }

    /**
     * aqui define-se o tamanho da mesa.
     * x e y serão unidades de cartas largura/altura.
     */
    public void setTableSize (double x, double y) {
        setSize((int) (x * cardWidth), (int) (y * cardHeight));
    }

    /**
     * Aqui determina-se a criação da carta na coordenada dada.
     * x e y são as unidades de largura/altura das cartas.
     */
    public void drawCard (Graphics g, int rank, int suit, double x, double y) {
        Image image = images[rank][suit];
        g.drawImage(image,
                (int) (x * cardWidth),
                (int) (y * cardHeight),
                null);
    }

    /** método especial para quando uma moldura
     * precisa ser criada.
     */
    public void paint(Graphics g) {
        for (int rank = 1; rank <= 13; rank++) {
            for (int suit = 0; suit <= 3; suit++) {
                double x = rank -1 + suit / 5.0;
                double y = suit / 2.0;
                drawCard(g, rank, suit, x, y);
            }
        }
    }

    public static void main (String[] args) {
        /**
         * criará a moldura.
         */
        JFrame frame = new JFrame("Tabuleiro de Cartas.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Adiciona a mesa de cartas.
         */
        String cardset = "cardset-DeckDeCartas";
        Canvas canvas = new CardTable(cardset);
        frame.getContentPane().add(canvas);

        /**
         * mostra a moldura.
         */
        frame.pack();
        frame.setVisible(true);
    }

}
