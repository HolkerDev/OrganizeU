package pl.holker.organizeu_android.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.holker.organizeu_android.data.persistance.NotesDao
import pl.holker.organizeu_android.data.persistance.NotesDatabase
import javax.inject.Singleton

@Module
class RoomModule {
    @Singleton
    @Provides
    fun provideNoteDao(context: Context): NotesDao {
        return NotesDatabase.getInstance(context).noteDao()
    }
}