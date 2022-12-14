package it.ikbo1120.fitness_club_v1_1.domain.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import it.ikbo1120.fitness_club_v1_1.domain.model.Services;

@Dao
public interface ServicesMethods {
    @Insert
    void insertService(Services service);

    @Query("SELECT * FROM services")
    LiveData<List<Services>> getAllServices();

    @Delete
    void deleteService(Services services);
}
