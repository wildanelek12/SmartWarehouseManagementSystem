package id.codes.smartwarehousemanagementsystem.Model;

public class DataMonitor {
    int daya_pemanas,daya_pendingin,debu,kelembapan,suhu;

    public DataMonitor(){}

    public DataMonitor(int daya_pemanas, int daya_pendingin, int debu, int kelembapan, int suhu) {
        this.daya_pemanas = daya_pemanas;
        this.daya_pendingin = daya_pendingin;
        this.debu = debu;
        this.kelembapan = kelembapan;
        this.suhu = suhu;
    }

    public int getDaya_pemanas() {
        return daya_pemanas;
    }

    public int getDaya_pendingin() {
        return daya_pendingin;
    }

    public int getDebu() {
        return debu;
    }

    public int getKelembapan() {
        return kelembapan;
    }

    public int getSuhu() {
        return suhu;
    }
}
