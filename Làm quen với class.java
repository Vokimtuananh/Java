// Bài 1:
class HinhChuNhat {
    private double chieuDai;
    private double chieuRong;
    public HinhChuNhat(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }
    public double tinhChuVi() {
        return 2 * (chieuDai + chieuRong);
    }
    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }
    public void hienThiThongTin() {
        System.out.println("Chiều dài: " + chieuDai + ", Chiều rộng: " + chieuRong);
        System.out.println("Chu vi: " + tinhChuVi() + ", Diện tích: " + tinhDienTich());
    }
}
public class Main {
    public static void main(String[] args) {
        HinhChuNhat hcn1 = new HinhChuNhat(5, 3);
        HinhChuNhat hcn2 = new HinhChuNhat(7, 2);
        hcn1.hienThiThongTin();
        hcn2.hienThiThongTin();
    }
}

// Bài 2:
class SinhVien {
    private String maSinhVien;
    private String hoTen;
    private int tuoi;
    private static int tongSinhVien = 0;
    public SinhVien(String maSinhVien, String hoTen, int tuoi) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        tongSinhVien++;
    }
    public void hienThiThongTin() {
        System.out.println("Mã sinh viên: " + maSinhVien + ", Họ tên: " + hoTen + ", Tuổi: " + tuoi);
    }
    public static void hienThiTongSinhVien() {
        System.out.println("Tổng số sinh viên: " + tongSinhVien);
    }
}
public class Main {
    public static void main(String[] args) {
        SinhVien sv1 = new SinhVien("SV001", "Nguyễn Văn A", 20);
        SinhVien sv2 = new SinhVien("SV002", "Trần Thị B", 21);
        sv1.hienThiThongTin();
        sv2.hienThiThongTin();        
        SinhVien.hienThiTongSinhVien();
    }
}

// Bài 3:
class TaiKhoan {
    private String soTaiKhoan;
    private String tenChuTaiKhoan;
    private double soDu;
    private static double laiSuatNam = 0.05;
    public TaiKhoan(String soTaiKhoan, String tenChuTaiKhoan, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.tenChuTaiKhoan = tenChuTaiKhoan;
        this.soDu = soDu;
    }
    public void napTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Nạp " + soTien + " VND thành công.");
        } else {
            System.out.println("Số tiền nạp phải lớn hơn 0.");
        }
    }
    public void rutTien(double soTien) {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
            System.out.println("Rút " + soTien + " VND thành công.");
        } else {
            System.out.println("Số tiền rút không hợp lệ.");
        }
    }
    public double tinhLai() {
        return soDu * laiSuatNam / 12;
    }
    public void hienThiThongTin() {
        System.out.println("Số tài khoản: " + soTaiKhoan + ", Chủ tài khoản: " + tenChuTaiKhoan + ", Số dư: " + soDu);
    }
    public static void thayDoiLaiSuat(double laiSuat) {
        laiSuatNam = laiSuat;
        System.out.println("Lãi suất năm hiện tại: " + laiSuatNam);
    }
    public static void hienThiLaiSuat() {
        System.out.println("Lãi suất năm hiện tại: " + laiSuatNam);
    }
}
public class Main {
    public static void main(String[] args) {
        TaiKhoan tk1 = new TaiKhoan("TK001", "Nguyễn Văn A", 1000000);
        TaiKhoan tk2 = new TaiKhoan("TK002", "Trần Thị B", 2000000);
        tk1.napTien(500000);
        tk2.rutTien(1000000);        
        tk1.hienThiThongTin();
        tk2.hienThiThongTin();
        System.out.println("Lãi tháng của TK1: " + tk1.tinhLai() + " VND");    
        TaiKhoan.thayDoiLaiSuat(0.07);
        TaiKhoan.hienThiLaiSuat();
    }
}