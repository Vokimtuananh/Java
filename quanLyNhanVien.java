interface EmailSender {
    void sendEmail(String to, String subject, String body);
}
interface Programmer {
    void writeCode();
}
interface Salesperson {
    void sellProduct();
}
abstract class NhanVien {
    private String ten;
    private int tuoi;
    protected double luong;
    public NhanVien(String ten, int tuoi) {
        this.ten = ten;
        this.tuoi = tuoi;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public int getTuoi() {
        return tuoi;
    }
    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    public double getLuong() {
        return luong;
    }
    public abstract void tinhLuong();
}
class OfficeEmployee extends NhanVien implements EmailSender {
    private int soNgayLamViec;
    private static final double LUONG_MOI_NGAY = 100;
    public OfficeEmployee(String ten, int tuoi, int soNgayLamViec) {
        super(ten, tuoi);
        this.soNgayLamViec = soNgayLamViec;
        tinhLuong();
    }
    @Override
    public void tinhLuong() {
        luong = soNgayLamViec * LUONG_MOI_NGAY;
    }
    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }
    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
        tinhLuong();
    }
    @Override
    public void sendEmail(String to, String subject, String body) {
        System.out.println(getTen() + " is sending email to " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }
}
class TechnicalEmployee extends NhanVien implements Programmer, EmailSender {
    private int soGioLamViec;
    private double tienCongTheoGio;
    public TechnicalEmployee(String ten, int tuoi, int soGioLamViec, double tienCongTheoGio) {
        super(ten, tuoi);
        this.soGioLamViec = soGioLamViec;
        this.tienCongTheoGio = tienCongTheoGio;
        tinhLuong();
    }
    @Override
    public void tinhLuong() {
        luong = soGioLamViec * tienCongTheoGio;
    }
    @Override
    public void writeCode() {
        System.out.println(getTen() + " is writing code.");
    }
    @Override
    public void sendEmail(String to, String subject, String body) {
        System.out.println(getTen() + " is sending email to " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }
    public int getSoGioLamViec() {
        return soGioLamViec;
    }
    public void setSoGioLamViec(int soGioLamViec) {
        this.soGioLamViec = soGioLamViec;
        tinhLuong();
    }
    public double getTienCongTheoGio() {
        return tienCongTheoGio;
    }
    public void setTienCongTheoGio(double tienCongTheoGio) {
        this.tienCongTheoGio = tienCongTheoGio;
        tinhLuong();
    }
}
class SalesEmployee extends NhanVien implements Salesperson, EmailSender {
    private double doanhThu;
    public SalesEmployee(String ten, int tuoi, double doanhThu) {
        super(ten, tuoi);
        this.doanhThu = doanhThu;
        tinhLuong();
    }
    @Override
    public void tinhLuong() {
        luong = doanhThu * 0.1;
    }
    @Override
    public void sellProduct() {
        System.out.println(getTen() + " is selling a product.");
    }
    @Override
    public void sendEmail(String to, String subject, String body) {
        System.out.println(getTen() + " is sending email to " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }
    public double getDoanhThu() {
        return doanhThu;
    }
    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
        tinhLuong();
    }
}