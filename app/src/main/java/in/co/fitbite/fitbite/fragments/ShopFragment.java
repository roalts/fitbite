package in.co.fitbite.fitbite.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

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
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShopFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShopFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShopFragment extends Fragment {
    private RecyclerView recyclerViewBreakfast, recyclerViewDinner;
    private ShopFragmentAdapter adapter;
    private Button filterButton;
    private List<Product> products = new ArrayList<>();
    public static ShopFragment newInstance() {
        ShopFragment fragment = new ShopFragment();
        return fragment;
    }

    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_shop, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Shop");
        recyclerViewBreakfast = (RecyclerView) v.findViewById(R.id.breakfastRecyclerView);
        recyclerViewDinner = (RecyclerView) v.findViewById(R.id.dinnerRecyclerView);
        recyclerViewBreakfast.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        Product p =new Product();
        p.setName("raghav");
        products.add(p);
        Api apiHandler = ((App) getActivity().getApplication()).getApiHandler();
        apiHandler.getProducts(
                new Callback<List<Product>>() {
                    @Override
                    public void success(List<Product> productsList, Response response) {
                        Log.d("Fitbite", "success" + response.getUrl() + response.getStatus());
                        products = productsList;
                        Log.d("Product", products.get(0).getName() + " " + products.size());
                        adapter = new ShopFragmentAdapter(products, getActivity());
                        recyclerViewBreakfast.setAdapter(adapter);

                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d("Fitbite", "failure" + error.getUrl() + error.getMessage());
                        Toast.makeText(getActivity(), "Check Your Internet Connection", Toast.LENGTH_SHORT)
                                .show();
                    }
                }
        );


        Log.d("Set Adapter", products.get(0).getName() + " " + products.size());
        filterButton = (Button) v.findViewById(R.id.filters);
        recyclerViewDinner.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerViewDinner.setAdapter(adapter);
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
