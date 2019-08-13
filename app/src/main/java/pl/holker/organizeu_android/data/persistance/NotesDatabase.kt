package pl.holker.organizeu_android.data.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class, NoteLocation::class], version = 1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun noteDao(): NotesDao

    companion object {
        @Volatile
        private var INSTANCE: NotesDatabase? = null

        fun getInstance(context: Context): NotesDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext, NotesDatabase::class.java, "test_database1"
        ).build()
    }
}