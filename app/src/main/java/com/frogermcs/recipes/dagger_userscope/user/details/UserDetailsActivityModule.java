package com.frogermcs.recipes.dagger_userscope.user.details;

import com.frogermcs.recipes.dagger_userscope.BaseActivityModule;

import dagger.Module;

@Module
public class UserDetailsActivityModule extends BaseActivityModule<UserDetailsActivity> {
    UserDetailsActivityModule(UserDetailsActivity activity) {
        super(activity);
    }
}