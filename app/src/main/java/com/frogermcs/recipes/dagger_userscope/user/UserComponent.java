package com.frogermcs.recipes.dagger_userscope.user;

import com.frogermcs.recipes.dagger_userscope.di.scopes.UserScope;
import com.frogermcs.recipes.dagger_userscope.user.details.UserDetailsActivityComponent;
import com.frogermcs.recipes.dagger_userscope.user.details.UserDetailsActivityModule;
import com.frogermcs.recipes.dagger_userscope.user.repositories.RepositoriesListActivityComponent;
import com.frogermcs.recipes.dagger_userscope.user.repositories.RepositoriesListActivityModule;

import dagger.Subcomponent;

@UserScope
@Subcomponent(
        modules = {
                UserModule.class
        }
)
public interface UserComponent {

    @Subcomponent.Builder
    interface Builder {
        Builder sessionModule(UserModule userModule);

        UserComponent build();
    }

    UserDetailsActivityComponent plus(UserDetailsActivityModule module);

    RepositoriesListActivityComponent plus(RepositoriesListActivityModule module);

    LogoutManager logoutManager();
}