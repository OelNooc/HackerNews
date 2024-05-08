package com.oelnooc.hackernews.data.api.repositories

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oelnooc.hackernews.data.api.repositories.dao.HitDao
import com.oelnooc.hackernews.data.models.HitEntity

@Database(entities = [HitEntity::class], version = 1)
abstract class HackerNewsDatabase : RoomDatabase() {

    abstract fun hitDao(): HitDao

    companion object {
        @Volatile
        private var INSTANCE: HackerNewsDatabase? = null

        fun getInstance(context: Context): HackerNewsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HackerNewsDatabase::class.java,
                    "hacker_news_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}