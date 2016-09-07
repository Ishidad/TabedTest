package dragondreamstudio.tabedtest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;
import dragondreamstudio.tabedtest.R;
import dragondreamstudio.tabedtest.models.Review;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.MyViewHolder> {

    private List<Review> mCommentList;
    private Context adapterContext;

    public CommentsAdapter(List<Review> reviewList, Context context){
        mCommentList = reviewList;
        adapterContext = context;
    }

    @Override
    public CommentsAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bar_comment_list_content,viewGroup,false);
        return new CommentsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentsAdapter.MyViewHolder myViewHolder, final int i){
        myViewHolder.mBarCommentRating.setRating(mCommentList.get(i).getRating());
        myViewHolder.mBarCommentName.setText(mCommentList.get(i).getAuthor_name());
        myViewHolder.mBarCommentText.setText(mCommentList.get(i).getText());
        Picasso.with(adapterContext).load(mCommentList.get(i).getProfile_photo_url()).into(myViewHolder.mBarCommentImg);
        /*
        myViewHolder.mView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(adapterContext, BarInfoActivity.class);
                adapterContext.startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mCommentList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        View mView;
        RatingBar mBarCommentRating;
        TextView mBarCommentName;
        TextView mBarCommentText;
        ImageView mBarCommentImg;

        MyViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mBarCommentRating = (RatingBar) itemView.findViewById(R.id.bar_comment_rating);
            mBarCommentName = (TextView) itemView.findViewById(R.id.bar_comment_name);
            mBarCommentText = (TextView) itemView.findViewById(R.id.bar_comment_text);
            mBarCommentImg = (ImageView) itemView.findViewById(R.id.bar_comment_img);
        }
    }
}
