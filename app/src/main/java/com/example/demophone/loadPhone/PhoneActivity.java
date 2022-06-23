package com.example.demophone.loadPhone;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.demophone.R;

import java.util.ArrayList;
import java.util.List;

public class PhoneActivity extends AppCompatActivity {
    public static final String TAG = PhoneActivity.class.getSimpleName();
    ListView lvPhone;
    List<Phones> list = new ArrayList<>();
    PhonesAdapter phonesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        lvPhone = findViewById(R.id.lvPhone);


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CONTACTS}, 999);
        } else {
            Uri uri = Uri.parse("content://contacts/people");
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            cursor.moveToFirst();

            int nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            int phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            try {
                do {
                    Phones phones = new Phones();
                    phones.setName(cursor.getString(nameIndex));
                    phones.setPhone(cursor.getString(phoneIndex));
                    list.add(phones);
                } while (cursor.moveToNext());

            } catch (Exception e) {
                Log.e(TAG, "loadListPhone: ", e);
            } finally {
                cursor.close();
            }
        }

        phonesAdapter = new PhonesAdapter(list);
        lvPhone.setAdapter(phonesAdapter);
    }

}