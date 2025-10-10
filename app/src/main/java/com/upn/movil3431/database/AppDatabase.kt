package com.upn.movil3431.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.upn.movil3431.dao.ContactDao
import com.upn.movil3431.entities.sql.Contact

@Database(
    entities = [Contact::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun contactDao(): ContactDao

//    static fun getAppDabaseInstance() {}

//    @Volatile
//    private var instance: Singleton? = null
//
//    fun getInstance(): Singleton {
//        return instance ?: synchronized(this) {
//            instance ?: Singleton().also { instance = it }
//        }
//    }
    companion object {
        @Volatile
        var instance: AppDatabase? = null
        fun getAppDatabaseInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                val inst = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database.db"
                )
                    // aca va las migraciones
                    // fallbackToDestructiveMigration solo para desarrollo
//                    .fallbackToDestructiveMigration()
                    .build()
                instance = inst
                inst
            }
        }
    }

}

//val migration_1_2 = object : Migration(1, 2) {
//    override fun migrate(db: SupportSQLiteDatabase) {
//        db.execSQL("ALTER TABLE contacts ADD COLUMN phone TEXT NOT NULL DEFAULT undefined")
//        db.execSQL("ALTER TABLE contacts ADD COLUMN email TEXT NOT NULL DEFAULT undefined")
//    }
//}

