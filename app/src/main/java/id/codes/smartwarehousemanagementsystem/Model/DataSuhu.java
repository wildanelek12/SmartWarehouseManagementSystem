package id.codes.smartwarehousemanagementsystem.Model;

public class DataSuhu {
    int suhu;
    String waktu;

    public DataSuhu(){}

    public DataSuhu(int suhu, String waktu) {
        this.suhu = suhu;
        this.waktu = waktu;
    }

    public int getSuhu() {
        return suhu;
    }

    public String getWaktu() {
        return waktu;
    }
}
