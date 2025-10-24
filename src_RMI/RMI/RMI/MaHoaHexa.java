package RMI;

import java.rmi.registry.*;

public class MaHoaHexa {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B22DCCN099", "7eABmt3M");
        for (byte x : a) System.out.print(x + " ");
        System.out.println();
        // b. Chuyển đổi mảng byte thành chuỗi hexa
        String res = "";
        for (byte x : a) res+=String.format("%02x", x & 0xFF);
        System.out.println(res);
        byte[] ans = res.toString().getBytes();
        sv.submitData("B22DCCN099", "7eABmt3M ", ans);
    }
}

