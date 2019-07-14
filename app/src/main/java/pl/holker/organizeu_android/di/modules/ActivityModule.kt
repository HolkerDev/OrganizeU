package pl.holker.organizeu_android.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.holker.organizeu_android.functionalities.main.MainActivity
import pl.holker.organizeu_android.di.ActivityScope

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeLoginActivity(): MainActivity
}