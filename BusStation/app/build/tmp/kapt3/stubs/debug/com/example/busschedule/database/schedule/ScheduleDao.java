package com.example.busschedule.database.schedule;

import java.lang.System;

/**
 * Provides access to read/write operations on the schedule table.
 * Used by the view models to format the query results for use in the UI.
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u001c\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH\'\u00a8\u0006\t"}, d2 = {"Lcom/example/busschedule/database/schedule/ScheduleDao;", "", "getAll", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/busschedule/database/schedule/Schedule;", "getByStopName", "stopName", "", "app_debug"})
public abstract interface ScheduleDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM schedule ORDER BY arrival_time ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.busschedule.database.schedule.Schedule>> getAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM schedule WHERE stop_name = :stopName ORDER BY arrival_time ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.busschedule.database.schedule.Schedule>> getByStopName(@org.jetbrains.annotations.NotNull()
    java.lang.String stopName);
}