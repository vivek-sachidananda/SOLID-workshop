package warehouse.item;

import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Models an Item or Article from a business perspective
 */
@Data
public abstract class Item {
    private String name;
    private String description;
    private long amount;
    private String currency;
    private String type;

    public Item(String name, String description, String type, int amount) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.type = type;
    }

    public static void save(Item item) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("### ITEM ####");
            sb.append(System.lineSeparator());
            sb.append("NAME: ");
            sb.append(item.name + " " + item.description);
            sb.append(System.lineSeparator());
            sb.append("AMOUNT: ");
            sb.append(item.amount);
            sb.append(System.lineSeparator());

            Path path = Paths.get(item.getName()
                    .replace(" ","_") + ".rec");
            Files.write(path, sb.toString().getBytes());

            System.out.println("Saved item " + item.toString());
        } catch (IOException e){
            System.out.println("ERROR: Could not save item. " + e);
        }
    }
}
