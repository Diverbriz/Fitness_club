package it.ikbo1120.fitness_club_v1_1.domain.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.ikbo1120.fitness_club_v1_1.domain.model.Services;

@Database(entities = {Services.class}, version = 2)
public abstract class ServiceRoomDatabase extends RoomDatabase{
    public abstract ServicesMethods serviceDao();

    private static volatile ServiceRoomDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static ServiceRoomDatabase getInstance(final Context context){
        if(INSTANCE == null){
            synchronized (ServiceRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ServiceRoomDatabase.class, "fitness_club_db")

                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
