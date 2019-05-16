package com.frogermcs.recipes.dagger_userscope.user.repositories;

import com.frogermcs.recipes.dagger_userscope.BaseActivityModule;
import com.frogermcs.recipes.dagger_userscope.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesListActivityModule extends BaseActivityModule<RepositoriesListActivity> {
    RepositoriesListActivityModule(RepositoriesListActivity activity) {
        super(activity);
    }

    @Provides
    @ActivityScope
    RepositoriesListAdapter repositoriesListAdapter() {
        return new RepositoriesListAdapter(activity);
    }
}