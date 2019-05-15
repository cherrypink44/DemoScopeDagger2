package com.frogermcs.recipes.dagger_userscope.user.details;

import com.frogermcs.recipes.dagger_userscope.di.scopes.ActivityScope;
import dagger.Subcomponent;


@ActivityScope
@Subcomponent(
        modules = UserDetailsActivityModule.class
)
public interface UserDetailsActivityComponent {
    UserDetailsActivity inject(UserDetailsActivity activity);
}