package in.co.fitbite.fitbite.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pujamathur on 15/10/15.
 */
public class Product {

    private String calories;
    private String category;
    private String id;
    private List<ProductImage> images = new ArrayList<ProductImage>();
    private String name;
    private String price;
    private String timeToCook;
    private String vegOrNonVeg;

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTimeToCook() {
        return timeToCook;
    }

    public void setTimeToCook(String timeToCook) {
        this.timeToCook = timeToCook;
    }

    public String getVegOrNonVeg() {
        return vegOrNonVeg;
    }

    public void setVegOrNonVeg(String vegOrNonVeg) {
        this.vegOrNonVeg = vegOrNonVeg;
    }

    public class ProductImage {
        private String id;
        private String imageFile;
        private String imageSize;
        private String productID;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImageFile() {
            return imageFile;
        }

        public void setImageFile(String imageFile) {
            this.imageFile = imageFile;
        }

        public String getImageSize() {
            return imageSize;
        }

        public void setImageSize(String imageSize) {
            this.imageSize = imageSize;
        }

        public String getProductID() {
            return productID;
        }

        public void setProductID(String productID) {
            this.productID = productID;
        }
    }

}
