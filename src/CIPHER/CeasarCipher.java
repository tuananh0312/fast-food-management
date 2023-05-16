package CIPHER;

public class CeasarCipher {

    private String msg;
    private int k;

    public CeasarCipher(String msg, int k) {
        this.msg = msg;
        this.k = k;
    }

    public CeasarCipher() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public String MaHoa(String msg, int k) {
        String c = "";
        for (int i = 0; i < msg.length(); i++) {
            c += (char) ('a' + (msg.charAt(i) - 'a' + k) % 26);
        }
        return c;
    }

    public String GiaiMa(String msg1, int k) {
        msg1 = msg1.toUpperCase();
        String kq = "";
        for (int i = 0; i < msg1.length(); i++) {
            kq += (char) ('A' + (msg1.charAt(i) - 'A' + (26 - k)) % 26);
        }
        return kq;
    }
}
