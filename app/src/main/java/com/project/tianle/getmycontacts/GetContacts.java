package com.project.tianle.getmycontacts;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Tianle on 2015/5/12.
 */
public class GetContacts {

    public static ArrayList<PhoneInfo> lists = new ArrayList<PhoneInfo>();

    public static String getContacts(Context context){
        lists.clear();
        Cursor cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        String phoneNumber;
        String phoneName;
        while(cursor.moveToNext()){
            phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            phoneName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            PhoneInfo phoneInfo = new PhoneInfo(phoneName, phoneNumber);
            lists.add(phoneInfo);
            System.out.println(phoneName + phoneNumber);
        }
        return null;
    }

}
