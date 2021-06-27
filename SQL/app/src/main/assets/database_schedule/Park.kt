package database_schedule

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

@Entity
data class Park(
    @PrimaryKey val id: Int,
    @NonNull @ColumnInfo(name = "city") val city: String,
    @NonNull @ColumnInfo(name = "park_visitors") val parkVisitors: Int
)