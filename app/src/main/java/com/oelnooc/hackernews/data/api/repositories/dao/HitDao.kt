package com.oelnooc.hackernews.data.api.repositories.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oelnooc.hackernews.data.models.HitEntity

@Dao
interface HitDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(hit: HitEntity)

    @Query("SELECT * FROM hitentity")
    suspend fun getAll(): List<HitEntity>

    @Delete
    suspend fun delete(hit: HitEntity)
}