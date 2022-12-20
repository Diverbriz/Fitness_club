package it.ikbo1120.fitness_club_v1_1.presentation.view;

import static android.content.ContentValues.TAG;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;

import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import it.ikbo1120.fitness_club_v1_1.MainActivity;
import it.ikbo1120.fitness_club_v1_1.R;
import it.ikbo1120.fitness_club_v1_1.databinding.FragmentCalendarBinding;
import it.ikbo1120.fitness_club_v1_1.presentation.viewmodel.CalendarViewModel;

public class CalendarFragment extends Fragment {

    private CalendarViewModel mViewModel;
    private FragmentCalendarBinding mBinding;
    public static CalendarFragment newInstance() {
        return new CalendarFragment();
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(CalendarViewModel.class);
        mBinding = FragmentCalendarBinding.inflate(inflater, container, false);

        Uri calendars = Uri.parse("content://calendar/calendars");

        long eventID = 208;



//        getRealPathFromURI(calendars);


        mBinding.calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = i + "/" + i1 + "/" + i2;
                Log.i(TAG, date);
            }
        });



        mBinding.floatingActionButton.setOnClickListener(v ->{
//            System.out.println(v.getX());
            Uri uri = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, eventID);
            Intent intent = new Intent(Intent.ACTION_EDIT)
                    .setData(uri)
                    .putExtra(CalendarContract.Events.TITLE, "My New Title");
            startActivity(intent);
//            Navigation.findNavController(mBinding.getRoot()).navigate(R.id.action_calendarFragment_to_addEventFragment);
        });


        return mBinding.getRoot();
    }

    public void getRealPathFromURI(Uri contentUri) {
        Calendar cal = Calendar.getInstance();
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("beginTime", cal.getTimeInMillis());
        intent.putExtra("allDay", true);
        intent.putExtra("rrule", "FREQ=YEARLY");
        intent.putExtra("endTime", cal.getTimeInMillis()+60*60*1000);
        intent.putExtra("title", "A Test Event from android app");
        startActivity(intent);
    }


//    public void readCalendarsByAccount(View view) {
//        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_CALENDAR}, MY_PERMISSIONS_REQUEST_WRITE_CALENDAR);
//            return;
//        }
//
//        // Projection array. Creating indices for this array instead of doing dynamic lookups improves performance.
//        final String[] EVENT_PROJECTION = new String[] {
//                CalendarContract.Calendars._ID,                           // 0
//                CalendarContract.Calendars.ACCOUNT_NAME,                  // 1
//                CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,         // 2
//                CalendarContract.Calendars.OWNER_ACCOUNT                  // 3
//        };
//
//        // The indices for the projection array above.
//        final int PROJECTION_ID_INDEX = 0;
//        final int PROJECTION_ACCOUNT_NAME_INDEX = 1;
//        final int PROJECTION_DISPLAY_NAME_INDEX = 2;
//        final int PROJECTION_OWNER_ACCOUNT_INDEX = 3;
//
//        // Run query
//        Cursor cur = null;
//        ContentResolver cr = requireActivity().getContentResolver();
//        Uri uri = CalendarContract.Calendars.CONTENT_URI;
//        String selection = "((" + CalendarContract.Calendars.ACCOUNT_NAME + " = ?) AND ("
//                + CalendarContract.Calendars.ACCOUNT_TYPE + " = ?) AND ("
//                + CalendarContract.Calendars.OWNER_ACCOUNT + " = ?))";
//        String[] selectionArgs = new String[] {"test@gmail.com", "com.google", "test@gmail.com"};
//        // Submit the query and get a Cursor object back.
//        cur = cr.query(uri, EVENT_PROJECTION, selection, selectionArgs, null);
//
//        // Use the cursor to step through the returned records
//        ArrayList<String> calendars = new ArrayList<>();
//        while (cur.moveToNext()) {
//            long calID = 0;
//            String displayName = null;
//            String accountName = null;
//            String ownerName = null;
//
//            // Get the field values
//            calID = cur.getLong(PROJECTION_ID_INDEX);
//            displayName = cur.getString(PROJECTION_DISPLAY_NAME_INDEX);
//            accountName = cur.getString(PROJECTION_ACCOUNT_NAME_INDEX);
//            ownerName = cur.getString(PROJECTION_OWNER_ACCOUNT_INDEX);
//
//            String calendarInfo = String.format("Calendar ID: %s\nDisplay Name: %s\nAccount Name: %s\nOwner Name: %s", calID, displayName, accountName, ownerName);
//            calendars.add(calendarInfo);
//        }
//
//        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, calendars);
//        listView.setAdapter(stringArrayAdapter);
//    }

    static Uri asSyncAdapter(Uri uri, String account, String accountType) {
        return uri.buildUpon()
                .appendQueryParameter(android.provider.CalendarContract.CALLER_IS_SYNCADAPTER,"true")
                .appendQueryParameter(CalendarContract.Calendars.ACCOUNT_NAME, account)
                .appendQueryParameter(CalendarContract.Calendars.ACCOUNT_TYPE, accountType).build();}


}