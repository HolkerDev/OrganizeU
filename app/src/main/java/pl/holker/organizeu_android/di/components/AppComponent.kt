package pl.holker.organizeu_android.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import pl.holker.organizeu_android.OrganizeU
import pl.holker.organizeu_android.di.modules.ActivityModule
import pl.holker.organizeu_android.di.modules.AppModule
import pl.holker.organizeu_android.di.modules.FragmentsModule
import pl.holker.organizeu_android.di.modules.RoomModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityModule::class, FragmentsModule::class, RoomModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: OrganizeU)
}