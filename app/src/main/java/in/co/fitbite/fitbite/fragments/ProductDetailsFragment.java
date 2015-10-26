package in.co.fitbite.fitbite.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import in.co.fitbite.fitbite.Api.Api;
import in.co.fitbite.fitbite.App;
import in.co.fitbite.fitbite.R;
import in.co.fitbite.fitbite.models.Product;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ProductDetailsFragment extends Fragment {
    private static final String PRODUCT_ID = "productid";
    private int product_id;

    private TextView productName, timeToCook, servings, price, quantity, description, instructionsPara;
    private ImageView productImage, vegOrNonVeg;

    public static ProductDetailsFragment newInstance(String product_id) {
        ProductDetailsFragment fragment = new ProductDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PRODUCT_ID, product_id);
        fragment.setArguments(bundle);
        return fragment;
    }

    public ProductDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            product_id = Integer.parseInt(getArguments().getString(PRODUCT_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_product_details, container, false);
        productName = (TextView) v.findViewById(R.id.productName);
        timeToCook = (TextView) v.findViewById(R.id.timeToCook);
        servings = (TextView) v.findViewById(R.id.servings);
        price = (TextView) v.findViewById(R.id.price);
        quantity = (TextView) v.findViewById(R.id.quantity);
        description = (TextView) v.findViewById(R.id.description);
        instructionsPara = (TextView) v.findViewById(R.id.instructionsPara);
        productImage = (ImageView) v.findViewById(R.id.productPicture);
        vegOrNonVeg = (ImageView) v.findViewById(R.id.vegNonVegIndicator);
        Api apiHandler = ((App) getActivity().getApplication()).getApiHandler();
        apiHandler.getProduct(product_id + "", new Callback<Product>() {
            @Override
            public void success(Product product, Response response) {
                Picasso.with(getActivity()).load("http://52.27.225.123/api/get/productImage?filename=" + product.getImages().get(0).getImageFile())
                        .fit().centerCrop().into(productImage);
                productName.setText(product.getName());
                timeToCook.setText(product.getTimeToCook()+"mins");
                servings.setText("1-2 servings, " + product.getCalories() + " cal");
                price.setText("Rs: "+product.getPrice());
                description.setText(product.getCategory());
                instructionsPara.setText("What we'll send? \n 5 Ounces Ground Beef \n What you'll need? \n" +
                        "Cooking pan \n Instructions");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("Fitbite", "failure" + error.getUrl() + error.getMessage());
                Toast.makeText(getActivity(), "Check Your Internet Connection", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        return v;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
    }

}
