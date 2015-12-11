// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.exacttarget.etpushsdk.ETPush;
import com.exacttarget.etpushsdk.data.LocationUpdate;
import com.exacttarget.etpushsdk.util.a;
import com.exacttarget.etpushsdk.util.i;
import com.exacttarget.etpushsdk.util.m;
import com.exacttarget.etpushsdk.util.n;
import java.util.ArrayList;
import java.util.List;

public class d
{

    public static final String a[] = {
        "id", "device_id", "latitude", "longitude", "accuracy", "timestamp", "last_sent"
    };

    public static int a(int j)
    {
        return i.a().b().delete("location_update", "id = ?", new String[] {
            String.valueOf(j)
        });
    }

    public static LocationUpdate a(Cursor cursor)
    {
        LocationUpdate locationupdate = new LocationUpdate();
        try
        {
            locationupdate.setId(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("id"))));
            locationupdate.setDeviceId(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("device_id"))));
            locationupdate.setLatitude(Double.valueOf(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("latitude")))));
            locationupdate.setLongitude(Double.valueOf(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("longitude")))));
            locationupdate.setAccuracy(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("accuracy"))));
            locationupdate.setTimestamp(n.a(cursor.getString(cursor.getColumnIndex("timestamp"))));
            locationupdate.setLastSent(Long.valueOf(cursor.getLong(cursor.getColumnIndex("last_sent"))));
        }
        // Misplaced declaration of an exception variable
        catch (Cursor cursor)
        {
            m.c("~!dd", cursor.getMessage(), cursor);
            return null;
        }
        return locationupdate;
    }

    public static List a(String s, String as[], String s1, String s2, String s3)
    {
        s = i.a().b().query("location_update", a, s, as, s1, s2, s3);
        as = new ArrayList();
        if (s != null)
        {
            s.moveToFirst();
            for (; !s.isAfterLast(); s.moveToNext())
            {
                as.add(a(((Cursor) (s))));
            }

            s.close();
        }
        return as;
    }

    public static void a(LocationUpdate locationupdate)
    {
        locationupdate.setId(Integer.valueOf((int)i.a().b().insert("location_update", null, c(locationupdate))));
    }

    public static int b(LocationUpdate locationupdate)
    {
        String s = String.valueOf(locationupdate.getId());
        return i.a().b().update("location_update", c(locationupdate), "id = ?", new String[] {
            s
        });
    }

    private static ContentValues c(LocationUpdate locationupdate)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("device_id", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), locationupdate.getDeviceId()));
        contentvalues.put("latitude", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), String.valueOf(locationupdate.getLatitude())));
        contentvalues.put("longitude", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), String.valueOf(locationupdate.getLongitude())));
        contentvalues.put("accuracy", locationupdate.getAccuracy());
        contentvalues.put("timestamp", n.a(locationupdate.getTimestamp()));
        contentvalues.put("last_sent", locationupdate.getLastSent());
        return contentvalues;
    }

}
