package pl.holker.organizeu_android

import android.app.Activity
import android.app.Application
import android.app.Service
import android.content.Context
import dagger.android.*
import pl.holker.organizeu_android.di.AppInjector
import pl.holker.organizeu_android.di.components.AppComponent
import javax.inject.Inject

open class OrganizeU : Application(), HasActivityInjector, HasServiceInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var dispatchingAndroidServiceInjector: DispatchingAndroidInjector<Service>
    lateinit var appComponent: AppComponent

    companion object {
        fun getAppComponent(context: Context): AppComponent = (context as OrganizeU).appComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = AppInjector.init(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> = dispatchingAndroidInjector

    override fun serviceInjector(): AndroidInjector<Service> = dispatchingAndroidServiceInjector

}