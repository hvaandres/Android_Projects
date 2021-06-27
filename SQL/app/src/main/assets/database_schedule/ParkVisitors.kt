package database_schedule

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ParkVisitors {
    @Query("SELECT * FROM park WHERE park_visitors ASC")
    fun getAll(): List<Park>

    @Query("SELECT * FROM park WHERE city = :city ORDER BY park_visitors")
    fun getByParkVisitors(city: Int): List <Park>
}