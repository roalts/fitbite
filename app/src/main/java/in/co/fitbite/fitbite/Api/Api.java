package in.co.fitbite.fitbite.Api;

import java.util.List;

import in.co.fitbite.fitbite.models.Product;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by raghav on 17/10/15.
 */
public interface Api {
    String BASE_URL = "http://52.27.225.123/api";

    @GET("/get/products")
    void getProducts(
            Callback<List<Product>> products);

    @POST("/get/product")
    void getProduct(
            @Query("id") String id,
            Callback<Product> product);

    @POST("/get/productImage")
    void getProductImage(
            @Field("filename") String fileName,
            Callback<Product> product);
}
