package in.co.fitbite.fitbite.Api;

import java.util.List;

import in.co.fitbite.fitbite.models.Product;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by raghav on 17/10/15.
 */
public interface Api {
    String BASE_URL = "http://52.27.225.123/api";

    @GET("/get/products")
    void getProducts(
            Callback<List<Product>> products);

    @GET("/get/product/")
    void getProduct(
            String id,
            Callback<Product> product);
}
