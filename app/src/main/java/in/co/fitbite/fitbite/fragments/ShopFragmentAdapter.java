package in.co.fitbite.fitbite.fragments;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import in.co.fitbite.fitbite.Api.Api;
import in.co.fitbite.fitbite.App;
import in.co.fitbite.fitbite.R;
import in.co.fitbite.fitbite.models.Product;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by pujamathur on 15/10/15.
 */
public class ShopFragmentAdapter extends RecyclerView.Adapter<ShopFragmentAdapter.ProductViewHolder> {

    List<Product> products = new ArrayList<>();
    Activity a;
    public ShopFragmentAdapter(List<Product> product, Activity activity) {
        this.products = product;
        this.a = activity;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_grid_item, parent, false);
        ProductViewHolder productViewHolder = new ProductViewHolder(v);

        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, final int position) {

        holder.name.setText(products.get(position).getName());
        holder.price.setText("Rs." + products.get(position).getPrice()+" ");
        holder.calories.setText(products.get(position).getCalories()+"cal");
        Picasso.with(a).load("http://52.27.225.123/api/get/productImage?filename=" + products.get(position).getImages().get(0).getImageFile())
                .fit().centerCrop().into(holder.productImage);
        holder.timeToCook.setText(products.get(position).getTimeToCook()+"min");
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = a.getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container,ProductDetailsFragment.newInstance(products.get(position).getId())).addToBackStack("").commit();
            }
        });
    }

    @Override
    public int getItemCount() {

        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView price;
        TextView calories;
        TextView timeToCook;
        ImageView productImage;
        View v;

        public ProductViewHolder(View itemView) {
            super(itemView);
            v = itemView;
            name = (TextView) itemView.findViewById(R.id.name);
            productImage = (ImageView) itemView.findViewById(R.id.productImage);
            price = (TextView) itemView.findViewById(R.id.price);
            calories = (TextView) itemView.findViewById(R.id.calories);
            timeToCook = (TextView) itemView.findViewById(R.id.timeToCook);
        }
    }
}
