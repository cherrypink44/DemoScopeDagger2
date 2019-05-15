package com.frogermcs.recipes.dagger_userscope.application;

import com.frogermcs.recipes.dagger_userscope.api.GithubApiModule;
import com.frogermcs.recipes.dagger_userscope.login.LoginActivityComponent;
import com.frogermcs.recipes.dagger_userscope.login.LoginActivityModule;
import com.frogermcs.recipes.dagger_userscope.user.BaseUserActivity;
import com.frogermcs.recipes.dagger_userscope.user.UserComponent;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(
        modules = {
                AppModule.class,
                GithubApiModule.class
        }
)
public interface AppComponent {
    LoginActivityComponent plus(LoginActivityModule module);

    UserComponent.Builder userComponentBuilder();

    void inject(BaseUserActivity activity);
}