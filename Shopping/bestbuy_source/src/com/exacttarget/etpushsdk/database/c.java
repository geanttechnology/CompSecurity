// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.exacttarget.etpushsdk.ETPush;
import com.exacttarget.etpushsdk.event.GeofenceRequest;
import com.exacttarget.etpushsdk.util.a;
import com.exacttarget.etpushsdk.util.i;
import com.exacttarget.etpushsdk.util.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
{

    public static final String a[] = {
        "id", "device_id", "latitude", "longitude"
    };

    public static int a(List list)
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(((GeofenceRequest)list.next()).getId())) { }
        return i.a().b().delete("geofence_request", String.format("id IN (%s)", new Object[] {
            TextUtils.join(",", arraylist)
        }), new String[0]);
    }

    public static GeofenceRequest a(Cursor cursor)
    {
        GeofenceRequest geofencerequest = new GeofenceRequest();
        try
        {
            geofencerequest.setId(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("id"))));
            geofencerequest.setDeviceId(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("device_id"))));
            geofencerequest.setLatitude(Double.valueOf(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("latitude")))));
            geofencerequest.setLongitude(Double.valueOf(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("longitude")))));
        }
        // Misplaced declaration of an exception variable
        catch (Cursor cursor)
        {
            m.c("~!dc", cursor.getMessage(), cursor);
            return null;
        }
        return geofencerequest;
    }

    public static List a(String s, String as[], String s1, String s2, String s3)
    {
        s = i.a().b().query("geofence_request", a, s, as, s1, s2, s3);
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

    public static void a(GeofenceRequest geofencerequest)
    {
        i.a().b().insert("geofence_request", null, b(geofencerequest));
    }

    private static ContentValues b(GeofenceRequest geofencerequest)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id", geofencerequest.getId());
        contentvalues.put("device_id", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), geofencerequest.getDeviceId()));
        contentvalues.put("latitude", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), String.valueOf(geofencerequest.getLatitude())));
        contentvalues.put("longitude", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), String.valueOf(geofencerequest.getLongitude())));
        return contentvalues;
    }

}
