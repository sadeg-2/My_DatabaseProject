package Java;

public class Distances {
    public static void main(String[] args) {
        /*
         * istanbul 0
         * ankara 1
         * izmir 2
         * kayseri 3
         * konya 4
         * malatya 5
         * Diyarbakir 6
         * */

        int[][] graf = MATRISE_ATA();

    }

    // here we define a matrix that represent a matrix to a
    public static int[][] MATRISE_ATA() {
        int[][] x = {
                {0, 500, 450, 0, 0, 0, 0},
                {500, 0, 0, 300, 0, 0, 0},
                {450, 0, 0, 0, 350, 0, 0},
                {0, 300, 0, 0, 250, 200, 550},
                {0, 0, 350, 250, 0, 0, 0},
                {0, 0, 0, 200, 0, 0, 350},
                {0, 0, 0, 550, 350, 0}
        };
        return x;
    }

    // get an index to the name city
    public static int INDIS_CEVIR(String s) {
        /*
         * istanbul 0
         * ankara 1
         * izmir 2
         * kayseri 3
         * konya 4
         * malatya 5
         * Diyarbakir 6
         * */
        switch (s) {
            case "istanbul":
                return 0;
            case "ankara":
                return 1;
            case "izmir":
                return 2;
            case "kayseri":
                return 3;
            case "konya":
                return 4;
            case "malatya":
                return 5;
            case "Diyarbakir":
                return 6;
        }
        return -1;
    }
    // get a distance from two city if exist and if not return -1
    public static int MESAFE(String city , String city2 , int[][] graf){
        int i = INDIS_CEVIR(city);
        int j = INDIS_CEVIR(city2);
        return (graf[i][j] == 0)? -1 : graf[i][j] ;
    }
}
