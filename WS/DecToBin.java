
import vn.medianews.*;
import java.util.*;
public class DecToBin {
    public static void main(String[] args) throws Exception{
        String msv = "B22DCCN099", qCode = "deindb4t";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        List<String>ans = new java.util.ArrayList<>();
        for(int x: a) ans.add(Integer.toBinaryString(x));
        System.out.println(ans);
        port.submitDataStringArray(msv, qCode, ans);
    }
}
