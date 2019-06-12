package com.example.vietha1.Fragment;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vietha1.Adapter.SearchAdapter;
import com.example.vietha1.Model.Lichsu;
import com.example.vietha1.R;
import com.example.vietha1.Service.APIService;
import com.example.vietha1.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

public class Fragment_Tim_Kiem extends Fragment implements View.OnClickListener {
    View view;
    Toolbar toolbar;

    RecyclerView recyclerViewsearchlichsu;
    TextView txtkhongcodulieu,textView;
    SearchAdapter searchAdapter;
    private ArrayList<Lichsu> manglichsu;
    private SearchView searchView;




    private final int REQ_CODE_SPEECH_INPUT = 100;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tim_kiem, container, false);
        toolbar = view.findViewById(R.id.toolbarsearchlicshu);
        recyclerViewsearchlichsu = view.findViewById(R.id.recycleviewsearchlichsu);
        txtkhongcodulieu = view.findViewById(R.id.textviewkhongcodulieu);


        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("");

        setHasOptionsMenu(true);

        initUI();
        getData();

        return view;
    }

    private void initUI() {
        manglichsu = new ArrayList<>();
        searchAdapter = new SearchAdapter(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewsearchlichsu.setLayoutManager(linearLayoutManager);
        recyclerViewsearchlichsu.setAdapter(searchAdapter);
//        txtkhongcodulieu.setVisibility(View.GONE);
//        recyclerViewsearchlichsu.setVisibility(View.VISIBLE);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_view, menu);

        MenuItem menuItem = menu.findItem(R.id.menu_search);
        searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);


        searchView.setOnSearchClickListener(new SearchView.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length()>0){
                    SearchTuKhoaLichsu(newText);
                }else {
                    searchAdapter.setClearList();
                }
                return true;
            }
        });


        super.onCreateOptionsMenu(menu, inflater);
    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();


        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    SearchTuKhoaLichsu(result.get(0));
                    searchView.setQuery(result.get(0),true);

                }
                break;
            }

        }
    }


    private void SearchTuKhoaLichsu(String query){
        Log.d("pppppppppppppp",query);
        ArrayList<Lichsu> mList = new ArrayList<>();
        for (Lichsu lichsu : manglichsu){
            if (lichsu.getTenLichsu().toLowerCase().contains(query.toLowerCase())){
                mList.add(lichsu);
            }
        }
        searchAdapter.setNewList(mList);
    }

    private void getData(){
        Dataservice dataservice = APIService.getService();
        Call<List<Lichsu>> callback = dataservice.GetSearchLichsu("   ");
        callback.enqueue(new Callback<List<Lichsu>>() {
            @Override
            public void onResponse(Call<List<Lichsu>> call, Response<List<Lichsu>> response) {
                manglichsu = (ArrayList<Lichsu>) response.body();
                Log.d("mmmmmmmmmmmmmmm",manglichsu.size()+"");
//                if(manglichsu.size() > 0){
//
//                }else{
//                    recyclerViewsearchlichsu.setVisibility(View.GONE);
//                    txtkhongcodulieu.setVisibility(View.VISIBLE);
//                }
            }

            @Override
            public void onFailure(Call<List<Lichsu>> call, Throwable t) {
                Log.d("mmmmmmmmmmmmmmm",t.toString());
            }
        });
    }


        @Override
    public void onClick(View v) {

    }

}


