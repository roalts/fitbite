package in.co.fitbite.fitbite.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pujamathur on 15/10/15.
 */
public class Product {

    private String calories;
    private String category;
    private Integer id;
    private List<ProductImage> images = new ArrayList<ProductImage>();
    private String name;
    private Integer price;
    private Integer timeToCook;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTimeToCook() {
        return timeToCook;
    }

    public void setTimeToCook(Integer timeToCook) {
        this.timeToCook = timeToCook;
    }

    public String getVegOrNonVeg() {
        return vegOrNonVeg;
    }

    public void setVegOrNonVeg(String vegOrNonVeg) {
        this.vegOrNonVeg = vegOrNonVeg;
    }

    public class ProductImage {
        private Integer id;
        private String imageFile;
        private String imageSize;
        private Integer productID;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
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

        public Integer getProductID() {
            return productID;
        }

        public void setProductID(Integer productID) {
            this.productID = productID;
        }
    }

}
