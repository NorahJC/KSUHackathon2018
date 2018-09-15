package hackathon.kuickscan;

import java.util.HashMap;

public class barcode {
    private HashMap<String, String> upcDescription;
    private HashMap<String, Integer> upcPrice;

    public barcode(){
        upcDescription = new HashMap<>();
        upcPrice = new HashMap<>();

        upcDescription.put("03600828003", "ChapStick - $3.99");
        upcPrice.put("03600828003", 399);
    }

    public String getDescription(String UPC){
        return upcDescription.get(UPC);
    }

    public int getPrice(String UPC){
        return upcPrice.get(UPC);
    }

}
