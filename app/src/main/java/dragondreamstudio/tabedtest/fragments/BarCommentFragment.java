package dragondreamstudio.tabedtest.fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import dragondreamstudio.tabedtest.R;
import dragondreamstudio.tabedtest.adapters.CommentsAdapter;
import dragondreamstudio.tabedtest.managers.VolleyManager;
import dragondreamstudio.tabedtest.models.Place;

public class BarCommentFragment extends Fragment{

    private static final String TAG = BarCommentFragment.class.getSimpleName();
    private final String BUNDLE_KEY_URL = "keyString";

    VolleyManager volleyManager;
    private Place reviewList;
    private Context context;
    private View view;
    RecyclerView myRecyclerView;

    private String requestUrl;

    private TextView fName;
    private TextView fText;
    private RatingBar fRating;
    private ImageView fImg;

    public static Fragment newInstance() {
        return new BarCommentFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        volleyManager = VolleyManager.getInstance(getActivity().getApplicationContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view =  inflater.inflate(R.layout.fragment_bar_comments_list, container, false);
        myRecyclerView = (RecyclerView) view.findViewById(R.id.bar_comment_recycleviewiew);
        context = this.getActivity();

        requestUrl = getArguments().getString(BUNDLE_KEY_URL);

        fRating = (RatingBar) view.findViewById(R.id.bar_comment_rating);
        fName = (TextView) view.findViewById(R.id.bar_comment_name);
        fText = (TextView) view.findViewById(R.id.bar_comment_text);
        fImg = (ImageView) view.findViewById(R.id.bar_comment_img);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        myRecyclerView.setItemAnimator(new DefaultItemAnimator());

        CommentsAdapter adapter = new CommentsAdapter(reviewList.getReviews(), context);
        myRecyclerView.setAdapter(adapter);
    }
}
