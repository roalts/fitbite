package in.co.fitbite.fitbite.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toolbar;

import java.util.List;

import in.co.fitbite.fitbite.R;
import in.co.fitbite.fitbite.models.Product;


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
        List<Product> products = null;
        adapter = new ShopFragmentAdapter(products);
        recyclerViewBreakfast.setAdapter(adapter);
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
