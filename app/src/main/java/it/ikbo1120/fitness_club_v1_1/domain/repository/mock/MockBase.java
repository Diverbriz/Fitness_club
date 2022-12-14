package it.ikbo1120.fitness_club_v1_1.domain.repository.mock;

import android.content.ClipData;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import it.ikbo1120.fitness_club_v1_1.domain.model.Services;

public class MockBase {
    private List<Services> services;
    private MutableLiveData<List<Services>> items;

    public MockBase() {
        services = new ArrayList<>();

        Services services1 = new Services(1l, "Gym", "Какой-то зал", 1200f,
                "https://p0.zoon.ru/9/f/58e293c440c0886e708de9c0_5d51d93045293.jpg");
        Services services2 = new Services(2l, "Swimming pool", "Какой-то зал", 1200f,
                "https://www.neplacebo.ru/wp-content/uploads/2022/01/bassejn.jpg");
        Services services3 = new Services(3l, "Sauna", "Какой-то зал", 1200f,
                "https://www.rantapallo.fi/maelle/files/2016/05/saimaa-spa-saunamaailma2-2400x1600.jpg");
        Services services4 = new Services(4l, "Massage", "Какой-то зал", 1200f,
                "https://www.fisiomec.com/imagenes_web/filosofia.jpg");
        Services services5 = new Services(5l, "Group classes", "Какой-то зал", 1200f,
                "https://sportishka.com/uploads/posts/2022-01/thumbs/1642070327_39-sportishka-com-p-zanyatiya-yogi-krasivo-foto-42.jpg");
        services.add(services1);
        services.add(services2);
        services.add(services3);
        services.add(services4);
        services.add(services5);

        items = new MutableLiveData<>(services);
    }

    public  List<Services> getServices() {
        return services;
    }

    public  void setServices(List<Services> services) {
        this.services = services;
    }

    public  MutableLiveData<List<Services>> getItems() {
        return items;
    }

    public  void setItems(MutableLiveData<List<Services>> items) {
        this.items = items;
    }

    public  void deleteService(Services service){
        services.remove(service);
        items.setValue(services);
    }

    public List<Services> getAllServices(){
        return services;
    }

    public void delete (int position){
        services.remove(position);
    }
}
