package it.ikbo1120.fitness_club_v1_1.domain.room;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
import it.ikbo1120.fitness_club_v1_1.domain.model.Services;

public class ServicesRepository {
    private ServicesMethods serviceDao;
    private LiveData<List<Services>> mAllServices;


    public ServicesRepository(Application application) {
        ServiceRoomDatabase db = ServiceRoomDatabase.getInstance(application);
        serviceDao = db.serviceDao();
        mAllServices = serviceDao.getAllServices();
    }

    public void createService(Services service){
        ServiceRoomDatabase.databaseWriteExecutor.execute(()->{
            serviceDao.insertService(service);
        });
    }

    public LiveData<List<Services>> getAllServices(){

        ServiceRoomDatabase.databaseWriteExecutor.execute(()->{
            mAllServices = serviceDao.getAllServices();
        });

        return mAllServices;
    }

    public void deleteService(Services service){
        ServiceRoomDatabase.databaseWriteExecutor.execute(() ->{
            serviceDao.deleteService(service);
        });
    }


}
