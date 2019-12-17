package vn.hblab.moviebase.Home.ShowTrending;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.hblab.moviebase.Home.MainActivity;
import vn.hblab.moviebase.Home.Trending.TrendingRecvAdpater;
import vn.hblab.moviebase.Model.Trending;
import vn.hblab.moviebase.R;

public class ShowTrendingFragments extends Fragment {

    MainActivity activity;
    List<Trending.Results> results = new ArrayList<>();
    TrendingRecvAdpater adpater;
    @BindView(R.id.tv_title)
    TextView tvtitle;
    @BindView(R.id.rcv_show_trending)
    RecyclerView rcvshowtrending;

    public static ShowTrendingFragments newInstance(MainActivity activity, List<Trending.Results> results) {
        Bundle args = new Bundle();
        ShowTrendingFragments fragments = new ShowTrendingFragments();
        fragments.activity = activity;
        fragments.results = results;
        fragments.setArguments(args);
        return fragments;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.show_trending_fragments, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvtitle.setText("Movie");
        adpater = new TrendingRecvAdpater(activity, results);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(activity, 4, LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setReverseLayout(true);
        rcvshowtrending.setLayoutManager(linearLayoutManager);
        rcvshowtrending.setAdapter(adpater);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
