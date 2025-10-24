
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.CharacterService;
public class DemSoLanXH1 {
    public static void main(String[] args) throws Exception {
        // a. Nhận chuỗi từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN099", "MyJfsE8O");
        System.out.println(s);
        // b. Xử lý xâu
        String res = "";
        int[] cnt = new int[256];
        for (char x : s.toCharArray()) cnt[x]++;
        for(char x: s.toCharArray()){
            if(cnt[x] > 0){
                res+=String.format("%c%d", x, cnt[x]);
                cnt[x] = 0;
            }
        }
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B22DCCN099", "MyJfsE8O", res);
    }
}


