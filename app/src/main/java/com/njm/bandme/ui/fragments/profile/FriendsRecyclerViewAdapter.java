package com.njm.bandme.ui.fragments.profile;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textview.MaterialTextView;
import com.njm.bandme.R;
import com.njm.bandme.domain.entities.User;
import com.njm.bandme.ui.fragments.profile.FriendsFragment.OnListFragmentInteractionListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FriendsRecyclerViewAdapter extends RecyclerView.Adapter<FriendsRecyclerViewAdapter.ViewHolder> {

    private final List<User> mValues;
    private final OnListFragmentInteractionListener mListener;

    public FriendsRecyclerViewAdapter(List<User> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_friend, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
       // holder.mIdView.setText(mValues.get(position).id);
       // holder.mContentView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public User mItem;
        @BindView(R.id.ivProfileFriend) ImageView ivProfileFriend;
        @BindView(R.id.tvNameFriend) MaterialTextView tvNameFriend;
        @BindView(R.id.tvOfficeFriend) MaterialTextView tvOfficeFriend;
        @BindView(R.id.btnDelete) FloatingActionButton btnDelete;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvNameFriend.getText() + "'";
        }
    }
}
