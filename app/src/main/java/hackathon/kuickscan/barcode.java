package hackathon.kuickscan;

import java.util.HashMap;

public class barcode {
    private HashMap<String, String> upcDescription;
    private HashMap<String, Integer> upcPrice;

    public barcode(){
        upcDescription = new HashMap<>();
        upcPrice = new HashMap<>();

        upcDescription.put("03600828003", "ChapStick - $3.99");
        upcDescription.put("049000072228", "Sprite Cherry - $1.75");
        upcDescription.put("759023076140", "Come with me kitty - $19.99");
        upcDescription.put("030111440808", "Royal Canin Cat Food - $4.99");
        upcDescription.put("070847811169", "Monster Energy 16oz - $2.50");
        upcDescription.put("078742040370", "Great Value Water - $1.49");

        upcPrice.put("03600828003", 399);
        upcPrice.put("049000072228", 175);
        upcPrice.put("759023076140", 1999);
        upcPrice.put("030111440808", 499);
        upcPrice.put("070847811169", 250);
        upcPrice.put("078742040370", 149);
    }

    public String getDescription(String UPC){
        return upcDescription.get(UPC);
    }

    public int getPrice(String UPC){
        return upcPrice.get(UPC);
    }

}
