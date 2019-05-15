package com.frogermcs.recipes.dagger_userscope.login;

import com.frogermcs.recipes.dagger_userscope.BaseActivityModule;
import dagger.Module;

@Module
public class LoginActivityModule extends BaseActivityModule<LoginActivity> {
    LoginActivityModule(LoginActivity activity) {
        super(activity);
    }
}