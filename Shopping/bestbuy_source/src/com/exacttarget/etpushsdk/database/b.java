// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.exacttarget.etpushsdk.ETPush;
import com.exacttarget.etpushsdk.event.BeaconRequest;
import com.exacttarget.etpushsdk.util.a;
import com.exacttarget.etpushsdk.util.i;
import com.exacttarget.etpushsdk.util.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{

    public static final String a[] = {
        "id", "device_id", "latitude", "longitude"
    };

    public static int a(List list)
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(((BeaconRequest)list.next()).getId())) { }
        return i.a().b().delete("beacon_request", String.format("id IN (%s)", new Object[] {
            TextUtils.join(",", arraylist)
        }), new String[0]);
    }

    public static BeaconRequest a(Cursor cursor)
    {
        BeaconRequest beaconrequest = new BeaconRequest();
        try
        {
            beaconrequest.setId(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("id"))));
            beaconrequest.setDeviceId(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("device_id"))));
            beaconrequest.setLatitude(Double.valueOf(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("latitude")))));
            beaconrequest.setLongitude(Double.valueOf(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("longitude")))));
        }
        // Misplaced declaration of an exception variable
        catch (Cursor cursor)
        {
            m.c("~!db", cursor.getMessage(), cursor);
            return null;
        }
        return beaconrequest;
    }

    public static List a(String s, String as[], String s1, String s2, String s3)
    {
        s = i.a().b().query("beacon_request", a, s, as, s1, s2, s3);
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

    public static void a(BeaconRequest beaconrequest)
    {
        i.a().b().insert("beacon_request", null, b(beaconrequest));
    }

    private static ContentValues b(BeaconRequest beaconrequest)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id", beaconrequest.getId());
        contentvalues.put("device_id", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), beaconrequest.getDeviceId()));
        contentvalues.put("latitude", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), String.valueOf(beaconrequest.getLatitude())));
        contentvalues.put("longitude", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), String.valueOf(beaconrequest.getLongitude())));
        return contentvalues;
    }

}
