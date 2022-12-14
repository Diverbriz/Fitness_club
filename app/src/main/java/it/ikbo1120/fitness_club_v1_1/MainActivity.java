package it.ikbo1120.fitness_club_v1_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;

import it.ikbo1120.fitness_club_v1_1.databinding.ActivityMainBinding;
import it.ikbo1120.fitness_club_v1_1.domain.room.ServiceRoomDatabase;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        Navigation.findNavController(mBinding.navHostFragment)
                                .navigate(R.id.action_global_homeFragment);
                        return true;
                    case R.id.menu_checklist:
                        Navigation.findNavController(mBinding.navHostFragment)
                                .navigate(R.id.action_global_checkListFragment);
                        return true;
                    case R.id.menu_account:
                        Navigation.findNavController(mBinding.navHostFragment)
                                .navigate(R.id.action_global_profileFragment);
                        return true;
                    case R.id.menu_season_ticket:
                        return true;
//                    default:
//                        Navigation.findNavController(mBinding.navHostFragment)
//                                .navigate(R.id.action_global_homeFragment);
                }
                System.out.println(item.getTitle());
//                System.out.println(R.id.);
                return false;
            }
        });

    }
}