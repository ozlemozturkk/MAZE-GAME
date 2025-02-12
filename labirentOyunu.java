/**
 * @file Oyun dosyası
 * @description Labirent oyunununda ilerlerken verilen bonusları kullanarak en
 * az hamle sayısı ile labirentin bitiş noktasına gelmektir .
 * @assigment 1.Proje
 * @date 04.12.2023-29.12.2023
 * @author Özlem Öztürk , ozlem.ozturk@stu.fsm.edu.tr
 */
package Main;

import java.util.Random;
import java.util.Scanner;

public class labirentOyunu {

    static char[][] labirent = {
        {'#', '!', '.', '.', 'R', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.'},
        {'.', '.', '#', '.', '.', '.', '#', '.', 'H', '.', '.', '.', '.', '.', '!'},
        {'F', '.', '.', '.', '#', '.', '!', '.', '.', 'R', '.', '.', '#', '#', '.'},
        {'.', '.', '#', '.', '.', '#', '.', '.', '.', '.', 'F', '.', '.', '.', '.'},
        {'.', '!', '.', '.', '#', '.', '#', '.', '#', '.', '.', '#', '.', '.', '.'},
        {'.', '.', 'H', '.', '.', '!', '.', '.', 'H', '.', '.', 'F', '.', '.', 'R'},
        {'#', '#', '#', '#', '.', '.', '#', '.', '.', '.', 'T', '.', '.', '.', 'E'},
        {'.', '.', '#', '.', 'F', '.', '#', '#', '.', '#', '#', '#', '#', '.', '.'},
        {'.', '#', '.', '.', '.', '.', '!', '.', '#', '.', '.', '.', '#', '.', '.'},
        {'.', 'T', 'T', '.', '#', '#', '.', '.', '.', '.', 'T', '.', '.', '.', 'R'},
        {'.', '.', '.', '#', '.', '.', '.', '#', '.', '#', '.', '#', '.', 'T', '.'},
        {'B', '.', '#', '.', '.', '!', '.', '!', '.', '.', '.', '.', '.', '.', '#'},
        {'.', '.', '.', 'F', '!', '.', '.', '.', 'H', '.', '.', 'R', '.', '.', '.'},
        {'.', '.', 'H', '.', '.', '.', '!', '.', '.', '.', '#', '.', '.', '#', '.'},
        {'.', '.', '.', '#', '.', '.', '#', '.', '#', '.', '#', '.', '.', '#', '#'}};

    public static int bonusT = 0;
    public static int bonusR = 0;
    public static int bonusH = 0;
    public static int bonusF = 0;
    public static int movesNumber = 0;
    private static int x;
    private static int y;
    private static int row;
    private static int column;

    public static void main(String[] args) {

        System.out.println("LABİRENT OYUNUNA HOŞ GELDİNİZ.....");
        startFind();
        mixBonus();
        mixMines();
        step();
    }

    public static void step() {
        int stepNumber = -1;
        while (true) {
            stepNumber++;
            movesNumber++;

            if (stepNumber % 5 == 0) {
                mixBonus();
                mixMines();
            }
            writeLabirent();
            System.out.println("Adım sayısı :" + (stepNumber));
            System.out.println();
            System.out.println("Bulunduğunuz Konum :" + "(" + x + " , " + y + ")");
            direction();

        }
    }

    public static void startFind() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < labirent.length; i++) {
            for (int j = 0; j < labirent[0].length; j++) {

                if (labirent[i][j] == 'B') {
                    x = i;
                    y = j;

                }
            }
        }

    }

    public static void writeLabirent() {
        System.out.println();
        for (int i = 0; i < labirent.length; i++) {
            for (int j = 0; j < labirent[0].length; j++) {
                System.out.print(labirent[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println();
    }

    public static void placeRandomBonus(char bonusİsmi, int adetBonus) {

        Random random = new Random();
        int i = 0;
        while (i < adetBonus) {
            int row = random.nextInt(labirent.length);
            int column = random.nextInt(labirent[0].length);
            if (labirent[row][column] == '.') {
                labirent[row][column] = bonusİsmi;
                i++;
            }

        }

    }

    public static void mixBonus() {

        for (int i = 0; i < labirent.length; i++) {
            for (int j = 0; j < labirent[0].length; j++) {
                char bonusChar = labirent[i][j];
                if (bonusChar == 'T' || bonusChar == 'R' || bonusChar == 'H' || bonusChar == 'F') {
                    labirent[i][j] = '.';
                }
            }
        }
        placeRandomBonus('T', 5);
        placeRandomBonus('R', 5);
        placeRandomBonus('H', 5);
        placeRandomBonus('F', 5);
    }

    public static void placeRandomMines(int numberMines) {

        Random random = new Random();
        int i = 0;

        while (i < numberMines) {
            row = random.nextInt(labirent.length);
            column = random.nextInt(labirent[0].length);
            if (labirent[row][column] == '.') {
                labirent[row][column] = '!';
                i++;
            }
        }
    }

    public static void mixMines() {
        placeRandomMines(10);
        for (int i = 0; i < labirent.length; i++) {
            for (int j = 0; j < labirent[0].length; j++) {
                char minesChar = labirent[i][j];
                if (minesChar == '!') {
                    labirent[i][j] = '.';
                }
            }
        }
        placeRandomMines(10);
    }

    public static void useBonus() {

        Scanner scanner = new Scanner(System.in);
        String bonusEnter;
        System.out.println("Toplam T bonusunuz : " + bonusT);
        System.out.println("Toplam R bonusunuz : " + bonusR);
        System.out.println("Toplam H bonusunuz : " + bonusH);
        System.out.println("Toplam F bonusunuz : " + bonusF);
        System.out.println();
        System.out.print("Kullanmak istediğin bonusu seç (T, H, R, F):");
        bonusEnter = scanner.nextLine();
        bonusEnter = bonusEnter.toUpperCase();

        switch (bonusEnter) {

            case "T":
                if (bonusT > 0) {
                    System.out.println();
                    System.out.println("T karakteri seçildi. ");
                    System.out.println();
                    System.out.print("Işınlanmak istediğiniz x noktasını giriniz :");
                    int teleportX = scanner.nextInt();
                    System.out.println();
                    System.out.print("Işınlanmak istediğiniz y noktasını giriniz :");
                    int teleportY = scanner.nextInt();

                    if (teleportX < 0 || teleportX >= labirent.length || teleportY < 0 || teleportY >= labirent[0].length) {
                        System.out.println();
                        System.out.println("Geçersiz bir nokta seçtiniz . Lütfen labirent içinde bir nokta seçiniz . ");
                    } else {
                        if (labirent[teleportX][teleportY] == '.') {
                            System.out.println();
                            System.out.println("Şuraya ışınlandınız:" + " ( " + teleportX + "," + teleportY + " ) ");
                            x = teleportX;
                            y = teleportY;
                            bonusT--;

                        } else if (labirent[teleportX][teleportY] == '#') {
                            System.out.println();
                            System.out.println("Işınlanmak istenilen noktada duvar var. Konumunuz değişmedi.");

                        } else if (labirent[teleportX][teleportY] == '!') {
                            System.out.println();
                            System.out.println("Işınlanmak istenilen noktada mayın var. Konumunuz değişmedi.");

                        } else if (labirent[teleportX][teleportY] == 'T') {
                            x = teleportX;
                            y = teleportY;
                            System.out.println();
                            System.out.println("Şuraya ışınlandınız:" + " ( " + teleportX + "," + teleportY + " ) ");
                            bonusT--;
                            System.out.println();
                            System.out.println("T karakteri ile karşılaştınız, bonus listesine eklendi.");
                            bonusT++;

                        } else if (labirent[teleportX][teleportY] == 'R') {
                            x = teleportX;
                            y = teleportY;
                            System.out.println();
                            System.out.println("Şuraya ışınlandınız:" + " ( " + teleportX + "," + teleportY + " ) ");
                            System.out.println();
                            System.out.println("R karakteri ile karşılaştınız, bonus listesine eklendi.");
                            bonusR++;
                            bonusT--;

                        } else if (labirent[teleportX][teleportY] == 'H') {
                            x = teleportX;
                            y = teleportY;
                            System.out.println();
                            System.out.println("Şuraya ışınlandınız:" + " ( " + teleportX + "," + teleportY + " ) ");
                            System.out.println();
                            System.out.println("H karakteri ile karşılaştınız, bonus listesine eklendi.");
                            bonusH++;
                            bonusT--;

                        } else if (labirent[teleportX][teleportY] == 'F') {
                            x = teleportX;
                            y = teleportY;
                            System.out.println();
                            System.out.println("Şuraya ışınlandınız:" + " ( " + teleportX + "," + teleportY + " ) ");
                            System.out.println();
                            System.out.println("F karakteri ile karşılaştınız, bonus listesine eklendi.");
                            bonusF++;
                            bonusT--;

                        } else if (labirent[teleportX][teleportY] == 'E') {
                            System.out.println();
                            System.out.println("Şuraya ışınlandınız:" + " ( " + teleportX + "," + teleportY + " ) ");
                            System.out.println();
                            System.out.println("Gidilen nokta ‘E’ karakterine eşit. Çıkışa geldiniz. Oyun bitti, tebrikler! ");
                            System.out.println();
                            System.out.println("Toplam Adım Sayısı : " + movesNumber);
                            System.exit(0);

                        }

                    }
                } else {
                    System.out.println();
                    System.out.println("T bonusu dizi içerisinde yoktur . Tekrar bonus giriniz: ");
                    System.out.println();
                    useBonus();
                }
                break;

            case "R":

                if (bonusR > 0) {
                    System.out.println();
                    System.out.println("R bonusu sadece duvarla karşılaştığı zaman kullanılabilir .");

                } else {
                    System.out.println();
                    System.out.println("R bonusu dizi içerisinde yoktur . ");

                }
                break;
            case "H":
                if (bonusH > 0) {

                    if (movesNumber < 0) {
                        movesNumber = 0;
                    }
                    System.out.println();
                    System.out.println("H bonusu kullanıldı . Hamle Sayısı 2 azaldı .");
                    bonusH--;
                    movesNumber -= 2;
                    System.out.println();
                    System.out.println("Yeni Hamle Sayısı :" + movesNumber);

                } else {
                    System.out.println();
                    System.out.println("H bonusu dizi içerisinde yoktur . ");

                }
                break;

            case "F":
                if (bonusF > 0) {
                    System.out.println();
                    System.out.println("F bonusu sadece mayınla karşılaştığı zaman kullanılabilir . ");

                } else {
                    System.out.println();
                    System.out.println("F bonusu dizi içerisinde yoktur . ");
                }
                break;

            default:
                System.out.println();
                System.out.println("Geçersiz bonus girdiniz . Lütfen geçerli bonus giriniz:");
                useBonus();
                break;
        }
    }

    public static void direction() {
        System.out.println();
        System.out.println("W, A, S, D karakterlerinden birini giriniz ya da bonus kullanmak için + \n"
                + "karakterine basınız. Çıkış için “exit” yazınız.");
        System.out.println();
        System.out.print("Girdi: ");

        Scanner scanner = new Scanner(System.in);
        String girdi = scanner.nextLine();
        girdi = girdi.toUpperCase();

        switch (girdi) {

            case "W":
                moveUp();
                break;

            case "A":
                moveLeft();
                break;

            case "S":
                moveDown();
                break;

            case "D":
                moveRight();
                break;

            case "+":
                System.out.println();
                useBonus();
                break;

            case "EXİT":
                System.out.println("Çıkış yapılıyor...");
                System.out.println();
                System.out.println("Çıkış yapıldı.");
                System.exit(0);

            default:
                System.out.println();
                System.out.println("Geçersiz hamle girdiniz . Lütfen tekrar deneyiniz.... ");
                break;
        }
    }

    public static void moveUp() {

        if (x > 0) {
            Scanner scanner = new Scanner(System.in);
            char location;
            location = labirent[x - 1][y];

            if (location == '#') {

                if (bonusR > 0) {
                    System.out.println();
                    System.out.print("Yukarıya gittiniz .Duvarla Karşılaştınız . R bonusunu kullanmak istiyor musunuz ? ( E / H ) : ");
                    String answer = scanner.nextLine();
                    answer = answer.toUpperCase();

                    if (answer.equals("E")) {
                        System.out.println();
                        System.out.println("Duvarı kaldırdınız ve Bulunduğunuz Konum : " + " ( " + (x - 1) + " , " + y + " )");
                        labirent[x - 1][y] = '.';
                        x--;
                        bonusR--;
                    } else if (answer.equals("H")) {
                        System.out.println();
                        System.out.println("Duvar var . İlerleyemezsiniz. Konumunuz : " + "(" + x + "," + y + ")");

                    } else {
                        System.out.println();
                        System.out.print("Geçersiz bir hamle girdiniz . İlerleyemdiniz . Konumunuz : " + "(" + x + "," + y + " )");
                    }

                } else {
                    System.out.println();
                    System.out.println("R bonusunuz olmadığı için duvarı kaldıramazsınız bu yüzden ilerleyemediniz . Konumunuz : " + "(" + x + "," + y + ")");

                }
            } else if (location == '!') {
                if (bonusF > 0) {
                    System.out.println();
                    bonusF--;
                    System.out.println("Yukarıya gittiniz ve mayınla karşılaştınız . F bonusu mayını imha etti . Kalan F bonusu :" + bonusF);
                    System.out.println();
                    labirent[x - 1][y] = '.';
                    System.out.println("Yeni konumunuz : " + "( " + (x - 1) + " , " + y + " ) ");
                    x--;

                } else {
                    System.out.println();
                    System.out.println("Mayın patladı  . İlerleyemezsiniz .Konumunuz : " + "(" + x + "," + y + ")");
                    labirent[x - 1][y] = '.';
                    movesNumber += 5;
                }
            } else if (location == '.') {
                System.out.println();
                System.out.println("Yukarıya gittiniz ve bulunduğunuz Konum :" + "( " + (x - 1) + " , " + y + " ) ");
                x--;

            } else if (location == 'T') {
                System.out.println();
                System.out.println("Yukarıya gittiniz ve bulunduğunuz Konum :" + "( " + (x - 1) + " , " + y + " ) ");
                labirent[x - 1][y] = '.';
                System.out.println();
                System.out.println("T karakteri ile karşılaştınız, bonus listesine eklendi. ");
                bonusT++;
                x--;

            } else if (location == 'R') {
                System.out.println();
                System.out.println("Yukarıya gittiniz ve bulunduğunuz Konum :" + "( " + (x - 1) + " , " + y + " ) ");
                labirent[x - 1][y] = '.';
                System.out.println();
                System.out.println("R karakteri ile karşılaştınız, bonus listesine eklendi. ");
                bonusR++;
                x--;

            } else if (location == 'H') {
                System.out.println();
                System.out.println("Yukarıya gittiniz ve bulunduğunuz Konum :" + "( " + (x - 1) + " , " + y + " ) ");
                labirent[x - 1][y] = '.';
                System.out.println();
                System.out.println("H karakteri ile karşılaştınız, bonus listesine eklendi. ");
                bonusH++;
                x--;

            } else if (location == 'F') {
                System.out.println();
                System.out.println("Yukarıya gittiniz ve bulunduğunuz Konum :" + "( " + (x - 1) + " , " + y + " ) ");
                labirent[x - 1][y] = '.';
                System.out.println();
                System.out.println("F karakteri ile karşılaştınız, bonus listesine eklendi. ");
                bonusF++;
                x--;

            } else if (location == 'B') {
                System.out.println();
                System.out.println("Başlangıç noktasına geri döndünüz...Konumunuz:" + "(" + x + "," + y + ")");

            } else if (location == 'E') {
                System.out.println();
                System.out.println("Gidilen nokta E karakterine eşit. Çıkışa geldiniz. Oyun bitti, tebrikler! ");
                System.out.println();
                System.out.println("Toplam Adım Sayısı : " + movesNumber);
                System.out.println();
                System.exit(0);

            }

        } else {
            System.out.println();
            System.out.println("Geçersiz Hamle .Labirentin dışına çıkamazsınız .Konumunuz Değişmedi.");
        }

    }

    public static void moveLeft() {
        Scanner scanner = new Scanner(System.in);
        if (y > 0) {
            char location;
            location = labirent[x][y - 1];

            if (location == '#') {

                if (bonusR > 0) {
                    System.out.println();
                    System.out.print("Sola gittiniz. .Duvarla Karşılaştınız . R bbonusunu kullanmak istiyor musunuz ? ( E/ H ) : ");
                    String answer = scanner.nextLine();
                    answer = answer.toUpperCase();

                    if (answer.equals("E")) {
                        System.out.println();
                        System.out.println("Duvarı kaldırdınız .Bulunduğunuz Konum : " + " ( " + x + " , " + (y - 1) + " )");
                        labirent[x][y - 1] = '.';
                        y--;
                        bonusR--;

                    } else if (answer.equals("H")) {
                        System.out.println();
                        System.out.println("Duvar var . İlerleyemezsiniz. Konumunuz : " + "(" + x + "," + y + ")");

                    } else {
                        System.out.println();
                        System.out.print("Geçersiz bir hamle girdiniz . İlerleyemediniz . Konumunuz : " + "(" + x + "," + y + " )");
                    }

                } else {
                    System.out.println();
                    System.out.println("R bonusunuz olmadığı için duvarı kaldıramazsınız bu yüzden ilerleyemediniz . Konumunuz : " + "(" + x + "," + y + ")");

                }
            } else if (location == '!') {

                if (bonusF > 0) {
                    System.out.println();
                    bonusF--;
                    System.out.println("Sola gittiniz ve mayınla karşılaştınız . F bonusu mayını imha etti . Kalan F bonusu :" + bonusF);
                    System.out.println();
                    labirent[x][y - 1] = '.';
                    System.out.println("Yeni konumunuz : " + "( " + x + " , " + (y - 1) + " ) ");
                    y--;

                } else {
                    System.out.println();
                    System.out.println("Mayın patladı  . İlerleyemezsiniz .Konumunuz : " + "(" + x + "," + y + ")");
                    labirent[x - 1][y] = '.';
                    movesNumber += 5;
                }

            } else if (location == '.') {
                System.out.println();
                System.out.println("Sola gittiniz.. Bulunduğunuz Konum :" + "( " + x + " , " + (y - 1) + " ) ");
                y--;

            } else if (location == 'T') {
                System.out.println();
                System.out.println("Sola gittiniz. . Bulunduğunuz Konum :" + "( " + x + " , " + (y - 1) + " ) ");
                labirent[x][y - 1] = '.';
                System.out.println();
                System.out.println("T karakteri ile karşılaştınız, bonus listesine eklendi. ");
                bonusT++;
                y--;

            } else if (location == 'R') {
                System.out.println();
                System.out.println("Sola gittiniz . Bulunduğunuz Konum :" + "( " + x + " , " + (y - 1) + " ) ");
                labirent[x][y - 1] = '.';
                System.out.println();
                System.out.println("R karakteri ile karşılaştınız, bonus listesine eklendi. ");
                bonusR++;
                y--;

            } else if (location == 'H') {
                System.out.println();
                System.out.println("Sola gittiniz . Bulunduğunuz Konum :" + "( " + x + " , " + (y - 1) + " ) ");
                labirent[x][y - 1] = '.';
                System.out.println();
                System.out.println("H karakteri ile karşılaştınız, bonus listesine eklendi. ");
                bonusH++;
                y--;

            } else if (location == 'F') {
                System.out.println();
                System.out.println("Sola gittiniz . Bulunduğunuz Konum :" + "( " + x + " , " + (y - 1) + " ) ");
                labirent[x][y - 1] = '.';
                System.out.println();
                System.out.println("F karakteri ile karşılaştınız, bonus listesine eklendi. ");
                bonusF++;
                y--;

            } else if (location == 'B') {
                System.out.println();
                System.out.println("Başlangıç noktasına geri döndünüz...Konumunuz:" + "(" + x + "," + (y - 1) + ")");

            } else if (location == 'E') {
                System.out.println();
                System.out.println("Gidilen nokta E karakterine eşit. Çıkışa geldiniz. Oyun bitti, tebrikler! ");
                System.out.println();
                System.out.println("Toplam Adım Sayısı : " + movesNumber);
                System.out.println();
                System.exit(0);

            }

        } else {
            System.out.println();
            System.out.println("Geçersiz Hamle .Labirentin dışına çıkamazsınız .Konumunuz Değişmedi.");
        }

    }

    public static void moveDown() {
        Scanner scanner = new Scanner(System.in);
        if (x + 1 < labirent.length) {
            char location = labirent[x + 1][y];

            if (location == '#') {

                if (bonusR > 0) {
                    System.out.println();
                    System.out.print("Aşağıya gittiniz .Duvarla Karşılaştınız . R bonusunu kullanmak istiyor musunuz ? ( E/ H) : ");
                    String answer = scanner.nextLine();
                    answer = answer.toUpperCase();

                    if (answer.equals("E")) {
                        System.out.println();
                        System.out.println("Duvarı kaldırdınız .Bulunduğunuz Konum : " + " ( " + (x + 1) + " , " + y + ")");
                        labirent[x + 1][y] = '.';
                        x++;
                        bonusR--;

                    } else if (answer.equals("H")) {
                        System.out.println();
                        System.out.println("Duvar var . İlerleyemezsiniz. Konumunuz : " + "(" + x + "," + y + " )");

                    } else {
                        System.out.println();
                        System.out.print("Geçersiz bir hamle girdiniz . İlerleyemediniz . Konumunuz : " + "(" + x + "," + y + " )");
                    }

                } else {
                    System.out.println();
                    System.out.println("R bonusunuz olmadığı için duvarı kaldıramazsınız bu yüzden ilerleyemediniz . Konumunuz : " + "(" + x + "," + y + ")");
                }

            } else if (location == '!') {
                if (bonusF > 0) {
                    System.out.println();
                    bonusF--;
                    System.out.println("Aşağıya gittiniz ve mayınla karşılaştınız . F bonusu mayını imha etti . Kalan F bonusu :" + bonusF);
                    System.out.println();
                    labirent[x + 1][y] = '.';
                    System.out.println("Yeni konumunuz : " + "( " + (x + 1) + " , " + y + " ) ");
                    x++;

                } else {
                    System.out.println();
                    System.out.println("Mayın patladı  . İlerleyemezsiniz .Konumunuz : " + "(" + x + "," + y + ")");
                    labirent[x - 1][y] = '.';
                    movesNumber += 5;
                }

            } else if (location == '.') {
                System.out.println();
                System.out.println("Aşağıya gittiniz . Bulunduğunuz Konum :" + "( " + (x + 1) + " , " + y + " ) ");
                x++;

            } else if (location == 'T') {
                System.out.println();
                System.out.println("Aşağıya gittiniz . Bulunduğunuz Konum :" + "( " + (x + 1) + " , " + y + " ) ");
                labirent[x + 1][y] = '.';
                System.out.println();
                System.out.println("T karakteri ile karşılaştınız, bonus listesine eklendi. ");
                bonusT++;
                x++;

            } else if (location == 'R') {
                System.out.println();
                System.out.println("Aşağıya gittiniz . Bulunduğunuz Konum :" + "( " + (x + 1) + " , " + y + " ) ");
                labirent[x + 1][y] = '.';
                System.out.println();
                System.out.println("R karakteri ile karşılaştınız, bonus listesine eklendi. ");
                bonusR++;
                x++;

            } else if (location == 'H') {
                System.out.println();
                System.out.println("Aşağıya gittiniz . Bulunduğunuz Konum :" + "( " + (x + 1) + " , " + y + " ) ");
                labirent[x + 1][y] = '.';
                System.out.println();
                System.out.println("H karakteri ile karşılaştınız, bonus listesine eklendi. ");
                bonusH++;
                x++;

            } else if (location == 'F') {
                System.out.println();
                System.out.println("Aşağıya gittiniz . Bulunduğunuz Konum :" + "( " + (x + 1) + " , " + y + " ) ");
                labirent[x + 1][y] = '.';
                System.out.println();
                System.out.println("F karakteri ile karşılaştınız, bonus listesine eklendi. ");
                bonusF++;
                x++;

            } else if (location == 'B') {
                System.out.println();
                System.out.println("Başlangıç noktasına geri döndünüz...Konumunuz : " + "(" + (x + 1) + "," + y + ")");
                x++;

            } else if (location == 'E') {
                System.out.println();
                System.out.println("Gidilen nokta E karakterine eşit. Çıkışa geldiniz. Oyun bitti, tebrikler! ");
                System.out.println();
                System.out.println("Toplam Adım Sayısı : " + movesNumber);
                System.out.println();
                System.exit(0);

            }

        } else {
            System.out.println();
            System.out.println("Geçersiz Hamle .Labirentin dışına çıkamazsınız .Konumunuz Değişmedi.");
        }
    }

    public static void moveRight() {
        Scanner scanner = new Scanner(System.in);
        if (y + 1 < labirent[0].length) {
            char location = labirent[x][(y + 1)];

            if (location == '#') {

                if (bonusR > 0) {
                    System.out.println();
                    System.out.print("Sağa  gittiniz .Duvarla Karşılaştınız . R bonusunu kullanmak istiyor musunuz ? ( E/ H ) : ");
                    String answer = scanner.nextLine();
                    answer = answer.toUpperCase();

                    if (answer.equals("E")) {
                        System.out.println();
                        System.out.println("Duvarı kaldırdınız .Bulunduğunuz Konum :   " + " ( " + x + " , " + (y + 1) + ")");
                        labirent[x][y + 1] = '.';
                        x++;
                        bonusR--;

                    } else if (answer.equals("H")) {
                        System.out.println();
                        System.out.println("Duvar var . İlerleyemezsiniz. Konumunuz : " + "(" + x + "," + y + ")");
                    } else {
                        System.out.println();
                        System.out.print("Geçersiz bir hamle girdiniz . İlerleyemediniz . Konumunuz : " + "(" + x + "," + y + " )");
                    }

                } else {
                    System.out.println();
                    System.out.println("R bonusunuz olmadığı için duvarı kaldıramazsınız bu yüzden ilerleyemediniz . Konumunuz : " + "(" + x + "," + y + ")");

                }
            } else if (location == '!') {

                if (bonusF > 0) {
                    System.out.println();
                    bonusF--;
                    System.out.println("Sağa gittiniz ve mayınla karşılaştınız . F bonusu mayını imha etti . Kalan F bonusu :" + bonusF);
                    System.out.println();
                    labirent[x][y + 1] = '.';
                    System.out.println("Yeni konumunuz : " + "( " + x + " , " + (y + 1) + " ) ");
                    y++;

                } else {
                    System.out.println();
                    System.out.println("Mayın patladı  . İlerleyemezsiniz .Konumunuz : " + "(" + x + "," + y + ")");
                    labirent[x - 1][y] = '.';
                    movesNumber += 5;
                }

            } else if (location == '.') {
                System.out.println();
                System.out.println("Sağa gittiniz . Bulunduğunuz Konum :" + "( " + x + " , " + (y + 1) + " ) ");
                y++;

            } else if (location == 'T') {
                System.out.println();
                System.out.println("Sağa  gittiniz . Bulunduğunuz Konum :" + "( " + x + " , " + (y + 1) + " ) ");
                labirent[x][y + 1] = '.';
                System.out.println();
                System.out.println("T karakteri ile karşılaştınız, bonus listesine eklendi. ");
                bonusT++;
                y++;

            } else if (location == 'R') {
                System.out.println();
                System.out.println("Sağa gittiniz . Bulunduğunuz Konum :" + "( " + x + " , " + (y + 1) + " ) ");
                labirent[x][y + 1] = '.';
                System.out.println();
                System.out.println("R karakteri ile karşılaştınız, bonus listesine eklendi. ");
                bonusR++;
                y++;

            } else if (location == 'H') {
                System.out.println();
                System.out.println("Sağa  gittiniz . Bulunduğunuz Konum :" + "( " + x + " , " + (y + 1) + " ) ");
                labirent[x][(y + 1)] = '.';
                System.out.println();
                System.out.println("H karakteri ile karşılaştınız, bonus listesine eklendi. ");
                bonusH++;
                y++;

            } else if (location == 'F') {
                System.out.println();
                System.out.println("Sağa  gittiniz . Bulunduğunuz Konum :" + "( " + x + " , " + y + " ) ");
                labirent[x][y + 1] = '.';
                System.out.println();
                System.out.println("F karakteri ile karşılaştınız, bonus listesine eklendi. ");
                bonusF++;
                y++;

            } else if (location == 'B') {
                System.out.println();
                System.out.println("Başlangıç noktasına geri döndünüz...Konumunuz:" + "(" + x + "," + y + ")");

            } else if (location == 'E') {
                System.out.println();
                System.out.println("Gidilen nokta E karakterine eşit. Çıkışa geldiniz. Oyun bitti, tebrikler! ");
                System.out.println();
                System.out.println("Toplam Adım Sayısı : " + movesNumber);
                System.out.println();
                System.exit(0);

            } else {
                System.out.println();
                System.out.println("Geçersiz Hamle .Labirentin dışına çıkamazsınız .");
            }

        }
    }

}
