package id.codes.smartwarehousemanagementsystem.Model;

public class DataStatus {
    String debu,kelembapan,suhu,level_pendingin,level_pemanas;

    public DataStatus(String debu, String kelembapan, String suhu, String level_pendingin, String level_pemanas) {
        this.debu = debu;
        this.kelembapan = kelembapan;
        this.suhu = suhu;
        this.level_pendingin = level_pendingin;
        this.level_pemanas = level_pemanas;
    }
    public DataStatus(){}
    public String getDebu() {
        return debu;
    }

    public String getKelembapan() {
        return kelembapan;
    }

    public String getSuhu() {
        return suhu;
    }

    public String getLevel_pendingin() {
        return level_pendingin;
    }

    public String getLevel_pemanas() {
        return level_pemanas;
    }
}
