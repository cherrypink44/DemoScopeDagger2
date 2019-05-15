package com.frogermcs.recipes.dagger_userscope.login;

import com.frogermcs.recipes.dagger_userscope.di.scopes.ActivityScope;
import dagger.Subcomponent;


@ActivityScope
@Subcomponent(
        modules = LoginActivityModule.class
)
public interface LoginActivityComponent {
    LoginActivity inject(LoginActivity activity);

}