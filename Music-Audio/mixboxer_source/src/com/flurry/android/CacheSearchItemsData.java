// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.ArrayList;

// Referenced classes of package com.flurry.android:
//            al, dw, av

public class CacheSearchItemsData extends al
{

    private static String TAG = "CacheSearchData";

    public CacheSearchItemsData(Context context, String s)
    {
        cD = dw.e(context, s);
        cE = "searchItemsTable";
    }

    public void addItem(String s, String s1, long l)
    {
        Log.d(TAG, "--- Insert in mytable: ---");
        SQLiteDatabase sqlitedatabase = cD.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("objectsId", s);
        contentvalues.put("objectsLocalId", s1);
        contentvalues.put("timestamp", Long.valueOf(l));
        l = sqlitedatabase.insert(cE, null, contentvalues);
        Log.d(TAG, (new StringBuilder()).append("row inserted, ID = ").append(l).toString());
    }

    public volatile void clearTable()
    {
        super.clearTable();
    }

    public volatile boolean contains(String s)
    {
        return super.contains(s);
    }

    public ArrayList getItemsById(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = cD.getReadableDatabase().query(cE, null, (new StringBuilder()).append("objectsId='").append(s).append("'").toString(), null, null, null, null);
        if (s.moveToFirst())
        {
            int i = s.getColumnIndex("objectsLocalId");
            do
            {
                arraylist.add(s.getString(i));
            } while (s.moveToNext());
        }
        s.close();
        return arraylist;
    }

    public volatile boolean isEmpty()
    {
        return super.isEmpty();
    }

    public void readAll()
    {
        Cursor cursor = cD.getReadableDatabase().query(cE, null, null, null, null, null, null);
        if (cursor.moveToFirst())
        {
            int i = cursor.getColumnIndex("objectsId");
            int j = cursor.getColumnIndex("objectsLocalId");
            int k = cursor.getColumnIndex("timestamp");
            do
            {
                Log.w(TAG, (new StringBuilder()).append("id = ").append(cursor.getString(i)).append(", objects_id = ").append(cursor.getString(j)).append(", timestamp = ").append(cursor.getLong(k)).toString());
            } while (cursor.moveToNext());
        } else
        {
            Log.w(TAG, "TABLE IS EMPTY");
        }
        cursor.close();
    }

    public void removeItemsById(String s)
    {
        cD.getWritableDatabase().delete(cE, (new StringBuilder()).append("objectsId='").append(s).append("'").toString(), null);
    }

    public volatile int size()
    {
        return super.size();
    }

}
