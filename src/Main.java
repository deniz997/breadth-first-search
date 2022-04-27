import java.util.Scanner;
import java.util.Vector;


class Knoten {

    public Knoten(int knotenIndex) {
        this.knotenIndex = knotenIndex;
    }

    public Vector<Knoten> getNachKnoten() {
        return nachKnoten;
    }

    public void setNachKnoten(Vector<Knoten> nachKnoten) {
        this.nachKnoten = nachKnoten;
    }

    private int knotenIndex;

    private Vector<Knoten> nachKnoten = new Vector();

    @Override
    public String toString() {
        return String.valueOf(knotenIndex);
    }
}


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int dim = sc.nextInt();
        Vector<Knoten> knotenListe = new Vector<>();
        int[][] matrix = new int[dim][dim];
        for (int i = 0; i < dim; i++) {
            Knoten v = new Knoten(i);
            knotenListe.add(i, v);
        }
        Knoten temp;

        for (int k = 0; k < dim; k++) {
            for (int i = 0; i < dim; i++) {
                matrix[k][i] = sc.nextInt();
                temp = knotenListe.get(k);
                if (matrix[k][i] == 1) {
                    temp.getNachKnoten().add(knotenListe.get(i));
                }
            }
        }

        Knoten startKnoten = knotenListe.get(sc.nextInt());

        //BFS

        Vector<Knoten> offen = new Vector<>();
        Vector<Knoten> besucht = new Vector<>();
        temp = startKnoten;
        offen.add(startKnoten);
        while (offen.size()!=0) {
            for (int i = 0; i < temp.getNachKnoten().size(); i++) {
                if (temp.getNachKnoten().elementAt(i) != temp && !besucht.contains(temp.getNachKnoten().elementAt(i))) {
                    offen.add(temp.getNachKnoten().elementAt(i));
                }
            }
            if (!besucht.contains(temp)) {
                besucht.add(temp);
            }
            offen.remove(temp);
            if (offen.size()!=0) {
                temp = offen.firstElement();
            }
        }
        String ergebnis = besucht.toString().replaceAll("[],]","").replace("[","");
        System.out.println(ergebnis);
        return;
    }
}