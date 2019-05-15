package com.frogermcs.recipes.dagger_userscope.user.details;

import com.frogermcs.recipes.dagger_userscope.di.scopes.ActivityScope;
import com.frogermcs.recipes.dagger_userscope.user.UserManager;
import com.frogermcs.recipes.dagger_userscope.user.model.User;

import javax.inject.Inject;

@ActivityScope
public class UserDetailsActivityPresenter {
    private UserDetailsActivity activity;
    private UserManager userManager;
    private User user;

    @Inject
    public UserDetailsActivityPresenter(UserDetailsActivity activity, UserManager userManager, User user) {
        this.activity = activity;
        this.userManager = userManager;
        this.user = user;
    }

    public void onCreate() {
        activity.setUserName("UserID: " + user.login);
        activity.setUserUrl("URL: " + user.url);
        activity.setFullName("Full name: " + user.name);
        activity.setLocation("Location: " + user.location );
        activity.setFollowers("Followers: " + user.followers );
        activity.setFollowing("Following: " + user.following );
    }

    public void onFinish() {
        userManager.closeUserSession();
    }

    public void onLogoutClick() {
        activity.finish();
    }
}
