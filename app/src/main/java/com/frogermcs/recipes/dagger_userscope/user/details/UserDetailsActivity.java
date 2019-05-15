package com.frogermcs.recipes.dagger_userscope.user.details;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.frogermcs.recipes.dagger_userscope.R;
import com.frogermcs.recipes.dagger_userscope.user.BaseUserActivity;
import com.frogermcs.recipes.dagger_userscope.user.UserComponent;
import com.frogermcs.recipes.dagger_userscope.user.repositories.RepositoriesListActivity;

import javax.inject.Inject;

public class UserDetailsActivity extends BaseUserActivity {

    @Inject
    UserDetailsActivityPresenter presenter;

    private TextView tvUser;
    private TextView tvUserUrl;
    private TextView tvFullName;
    private TextView tvUserLocation;
    private TextView tvFollowers;
    private TextView tvFollowing;

    @Override
    protected void onUserComponentSetup(UserComponent userComponent) {
        userComponent.plus(new UserDetailsActivityModule(this)).inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        tvUser = findViewById(R.id.tvUser);
        tvUserUrl = findViewById(R.id.tvUserUrl);
        tvFullName = findViewById(R.id.tvFullname);
        tvUserLocation = findViewById(R.id.tvUserLocation);
        tvFollowers = findViewById(R.id.tvFollowers);
        tvFollowing = findViewById(R.id.tvFollowing);

        //This check has to be called. Otherwise, when user is not logged in, presenter won't be injected and this line will cause NPE
        if (isUserSessionStarted()) {
            presenter.onCreate();
        }
    }

    @Override
    public void finish() {
        super.finish();
        presenter.onFinish();
    }

    public void setUserName(String userName) {
        tvUser.setText(userName);
    }

    public void setUserUrl(String url) {
        tvUserUrl.setText(url);
    }

    public void setFullName(String fullName) {
        tvFullName.setText(fullName);
    }

    public void setLocation(String location) {
        tvUserLocation.setText(location);
    }

    public void setFollowers(String followers) {
        tvFollowers.setText(followers);
    }

    public void setFollowing(String following) {
        tvFollowing.setText(following);
    }

    public void onLogoutClick(View view) {
        presenter.onLogoutClick();
    }

    public void onRepositoriesClick(View view) {
        startActivity(new Intent(this, RepositoriesListActivity.class));
    }
}
