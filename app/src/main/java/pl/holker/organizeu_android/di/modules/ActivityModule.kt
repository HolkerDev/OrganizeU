package pl.holker.organizeu_android.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.holker.organizeu_android.di.ActivityScope
import pl.holker.organizeu_android.functionalities.main.MainActivity
import pl.holker.organizeu_android.functionalities.start.StartActivity

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentsModule::class])
    abstract fun contributeStartActivity(): StartActivity
}