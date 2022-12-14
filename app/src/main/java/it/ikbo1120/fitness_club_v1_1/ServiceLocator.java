package it.ikbo1120.fitness_club_v1_1;

import android.app.Application;

import it.ikbo1120.fitness_club_v1_1.domain.room.ServicesRepository;

public class ServiceLocator {
    private static ServiceLocator instance = null;

    private ServiceLocator(){};

    public static ServiceLocator getInstance(){
        if(instance == null){
            instance = new ServiceLocator();
        }
        return instance;
    }

    private ServicesRepository servicesRepository;

    public ServicesRepository getRepository(Application application){
        if(servicesRepository == null){
            servicesRepository = new ServicesRepository(application);
        }
        return servicesRepository;
    }


}
