package com.frogermcs.recipes.dagger_userscope.user.repositories;

import com.frogermcs.recipes.dagger_userscope.di.scopes.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(
        modules = RepositoriesListActivityModule.class
)
public interface RepositoriesListActivityComponent {
    RepositoriesListActivity inject(RepositoriesListActivity activity);


}