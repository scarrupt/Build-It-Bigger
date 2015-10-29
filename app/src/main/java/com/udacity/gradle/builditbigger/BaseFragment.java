package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

public abstract class BaseFragment extends Fragment implements GetJokeAsyncTask.Callback {

    private ProgressBar mProgressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        mProgressBar = (ProgressBar) root.findViewById(R.id.progress_bar);
        mProgressBar.setVisibility(View.GONE);
        return root;
    }

    public abstract void tellJoke();

    protected void getJoke() {
        mProgressBar.setVisibility(View.VISIBLE);
        new GetJokeAsyncTask(this).execute(getActivity());
    }

    @Override
    public void done() {
        mProgressBar.setVisibility(View.GONE);
    }
}
