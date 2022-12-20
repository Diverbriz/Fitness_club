package it.ikbo1120.fitness_club_v1_1.domain.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "calendar_event")
public class CalendarEvent {
    @PrimaryKey(autoGenerate = true)
    public Long id;

    public String uri;


}
