package vn.hblab.moviebase.Home.Trending;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.hblab.moviebase.Model.NowPlaying;
import vn.hblab.moviebase.R;

import static vn.hblab.moviebase.Network.AppConfig.IMAGE_URL;

public class NowplayRecvAdpater extends RecyclerView.Adapter<NowplayRecvAdpater.RecyclerViewHolder> {

    private List<NowPlaying.Results> data;
    Activity activity;

    public NowplayRecvAdpater(Activity activity, List<NowPlaying.Results> data) {
        this.data = data;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_trending, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Picasso.get()
                .load(IMAGE_URL + data.get(position).getPosterPath())
                .resize(500, 750)
                .into(holder.backdropPath);

        holder.originalTitle.setText(data.get(position).getTitle());

        holder.voteAverage.setText(String.valueOf(data.get(position).getVoteAverage()));
        holder.backdropPath.setOnClickListener(v->{
            Toast.makeText(activity, data.get(position).getTitle(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.backdrop_path)
        ImageView backdropPath;
        @BindView(R.id.vote_average)
        TextView voteAverage;
        @BindView(R.id.original_title)
        TextView originalTitle;

        public RecyclerViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}
