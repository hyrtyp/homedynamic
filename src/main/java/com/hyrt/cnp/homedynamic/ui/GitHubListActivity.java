package com.hyrt.cnp.homedynamic.ui;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.Toast;

import com.hyrt.cnp.homedynamic.R;
import com.hyrt.cnp.homedynamic.adapter.GitHubUserListAdapter;
import com.hyrt.cnp.homedynamic.api.BaseActivity;
import com.hyrt.cnp.homedynamic.model.GitHubUser;
import com.hyrt.cnp.homedynamic.request.GitHubRequest;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

/**
 * Created by GYH on 13-12-27.
 */
public class GitHubListActivity extends BaseActivity {

    private ListView githubListView;
    private View loadingView;

    private GitHubUserListAdapter gitHubUserListAdapter;


    // --------------------------------------------------------------------------------------------
    // ACTIVITY LIFECYCLE
    // --------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setProgressBarIndeterminateVisibility(false);
        setContentView(R.layout.activity_githublist);

        githubListView = (ListView) findViewById(R.id.listview_github);
        loadingView = findViewById(R.id.loading_layout);
    }

    @Override
    public void onStart() {
        super.onStart();
        loadListGithub();
    }

    @Override
    public void onStop() {

        super.onStop();
    }

    // --------------------------------------------------------------------------------------------
    // PRIVATE
    // --------------------------------------------------------------------------------------------

    private void updateListViewContent(GitHubUser.List users) {
        gitHubUserListAdapter = new GitHubUserListAdapter(this, getSpiceManagerBinary(), users);
        githubListView.setAdapter(gitHubUserListAdapter);

        loadingView.setVisibility(View.GONE);
        githubListView.setVisibility(View.VISIBLE);
    }

    private void loadListGithub() {
        setProgressBarIndeterminateVisibility(true);
        getSpiceManager().execute(new GitHubRequest("android"), "github", DurationInMillis.ONE_SECOND * 10,
                new GitHubUserListListener());
    }

    // --------------------------------------------------------------------------------------------
    // PRIVATE
    // --------------------------------------------------------------------------------------------

    private class GitHubUserListListener implements RequestListener<GitHubUser.List> {

        @Override
        public void onRequestFailure(SpiceException spiceException) {
            setProgressBarIndeterminateVisibility(false);
            Toast.makeText(GitHubListActivity.this, "Impossible to get the list of users", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRequestSuccess(GitHubUser.List result) {
            setProgressBarIndeterminateVisibility(false);
            updateListViewContent(result);
            Toast.makeText(GitHubListActivity.this,"successfully",Toast.LENGTH_SHORT).show();
        }
    }

}
