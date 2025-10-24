package RMI ;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.ProductX;
public class XuLySanPham2 {
    public static void main(String[] args) throws Exception {
        //a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        ProductX product = (ProductX) sv.requestObject("B22DCCN099", "7OVKe1VB ");
        System.out.println(product);
        // b. Thực hiện chuẩn hóa sản phẩm:
        int tong = 0;
        for(char x: product.getDiscountCode().toCharArray()){
            if(java.lang.Character.isDigit(x))
                tong += java.lang.Character.getNumericValue(x);

        }
        product.setDiscount(tong);
        // c. Triệu gọi phương thức submitObject để gửi đối tượng đã chuẩn hóa trở lại server
        System.out.println(product);
        sv.submitObject("B22DCCN099", "7OVKe1VB ", product);
    }
}



