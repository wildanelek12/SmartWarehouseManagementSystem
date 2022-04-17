package id.codes.smartwarehousemanagementsystem.Model;

public class DataKelembapan {
    int kelembapan;
    String waktu;

    public DataKelembapan(){}
    public int getKelembapan() {
        return kelembapan;
    }

    public String getWaktu() {
        return waktu;
    }

    public DataKelembapan(int kelembapan, String waktu) {
        this.kelembapan = kelembapan;
        this.waktu = waktu;
    }
}
