package pl.holker.oraganizeu_android.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import pl.holker.oraganizeu_android.OrganizeU
import pl.holker.oraganizeu_android.di.modules.ActivityModule
import pl.holker.oraganizeu_android.di.modules.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: OrganizeU)
}