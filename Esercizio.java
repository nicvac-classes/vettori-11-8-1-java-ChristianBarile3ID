import java.util.Scanner;

class Esercizio {
    
    public int eliminaVettori (int[]pesi, int[]ore, int nPesci, int posizione) {
        int i;
        for (i=nPesci; i<posizione-1) {
            pesi[i] = pesi[i+1];
            ore[i] = ore[i+1];
        }
        nPesci--;
        return nPesci;
    }

    public int inserisciVettori (int[]pesi, int[]ore, int nPesci, int elementoPeso, int elementoOra, int posizione) {
        int i;
        for (i=nPesci; i>posizione; i--) {
            pesi[i] = pesi[i-1];
            ore[i] = ore[i-1];
        }
        pesi[posizione] = elementoPeso;
        ore[posizione] = elementoOra;
        nPesci++;
        return nPesci;
    }

    public int ricercaMassimo(int[]pesi, int Pesci) {
        int i, iMax;
        iMax = 0;
        for (i=0; i<nPesci; i++) {
            if (pesi[i]>pesi[iMax]) {
                iMax = i;
            }
        }
        return iMax;
    }

    public int rimuoviDuplicati (int[]pesi, int[]ore, int nPesci) {
        int i, j;
        for (i=0; i<nPesci-1; i++) {
            j = i+1;
            while (j<=nPesci-1) {
                if (pesi[i]==pesi[j]) {
                    nPesci = eliminaVettori(pesi, ore, nPesci, j);
                } else {
                    j++;
                }
            }
        }
        return nPesci;
    }

    public void visualizzaVettori(int[]pesi, int[]ore, int nPesci) {
        int i;
        for (i=0; i<nPesci; i++) {
            System.out.println("------");
            System.out.println("Pesce n°" + i);
            System.out.println("Peso: " + pesi[i] + "g");
            System.out.println("Ora di cattura: " + ore[i]);
            System.out.println("------");
        }
    }

    public static void main(String args[] {
        Scanner in = new Scanner( System.in );
        System.out.println("Inserire il numero di pesci che saranno pescati: ");
        do {
            N = Integer.parseInt(in.nextLine());
        } while (N<1);
        int [] pesi = new int[N];
        int [] ore = new int[N];
        nPesci = 0;
        for (i=0; i<pesi.length; i++) {
            pesi = (random.nextInt(9) * 50) + 100;
            System.out.println("Inserisci l'ora di cattura: ");
            ora = (i+10)%24;
            System.out.println("Pesce di peso: " + peso + "g");
            System.out.println("Pescato all'ora: " + ora);
            nPesci = inserisciVettori(pesi, ore, nPesci, peso, ora, nPesci);
            j = 0;
            while (j<nPesci) {
                if (pesi[i]<pesi[nPesci-1]) {
                    System.out.println("Il pesce che pesa " + pesi[j] + " grammi, che è stato catturato all'ora " + ore[j] + ", viene rilasciato");
                    nPesci = eliminaVettori(pesi, ore, nPesci, j);
                } else {
                    j++;
                }
            visualizzaVettori(pesi, ore, nPesci);
            }
        }
        iMax = ricercaMassimo(pesi, nPesci);
        System.out.println("Il pesce più pesante è quello che pesa " + pesi[iMax] + " grammi e che è stato catturato all'ora " + ore[iMax]);
        nPesci = rimuoviDuplicati(pesi, ore, nPesci);
        visualizzaVettori(pesi, ore, nPesci);
    }
}
