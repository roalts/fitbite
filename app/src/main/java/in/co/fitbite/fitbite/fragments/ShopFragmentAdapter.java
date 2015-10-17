package in.co.fitbite.fitbite.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import in.co.fitbite.fitbite.models.Product;
import in.co.fitbite.fitbite.R;

/**
 * Created by pujamathur on 15/10/15.
 */
public class ShopFragmentAdapter extends RecyclerView.Adapter<ShopFragmentAdapter.ProductViewHolder> {

    List<Product> products;
    public ShopFragmentAdapter(List<Product> products) {
        this.products = products;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_grid_item, parent, false);
        ProductViewHolder productViewHolder = new ProductViewHolder(v);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
//        holder.name.setText(products.get(position).getName());
//        holder.price.setText(products.get(position).getPrice());
//        holder.calories.setText(products.get(position).getCalories());
//        holder.timeToCook.setText(products.get(position).getTimeToCook());
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView price;
        TextView calories;
        TextView timeToCook;

        public ProductViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            price = (TextView) itemView.findViewById(R.id.price);
            calories = (TextView) itemView.findViewById(R.id.calories);
            timeToCook = (TextView) itemView.findViewById(R.id.timeToCook);
        }
    }
}
