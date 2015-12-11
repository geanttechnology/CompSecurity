// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.exacttarget.etpushsdk.ETPush;
import com.exacttarget.etpushsdk.data.Region;
import com.exacttarget.etpushsdk.util.a;
import com.exacttarget.etpushsdk.util.i;
import com.exacttarget.etpushsdk.util.m;
import java.util.ArrayList;
import java.util.List;

public class g
{

    public static final String a[] = {
        "id", "latitude", "longitude", "radius", "active", "beacon_guid", "beacon_major", "beacon_minor", "entry_count", "exit_count", 
        "description", "name", "location_type", "has_entered"
    };

    public static int a(String s, String as[], ContentValues contentvalues)
    {
        return i.a().b().update("regions", contentvalues, s, as);
    }

    public static Region a(Cursor cursor)
    {
        Region region;
        boolean flag1;
        flag1 = true;
        region = new Region();
        region.setId(cursor.getString(cursor.getColumnIndex("id")));
        region.setLatitude(Double.valueOf(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("latitude")))));
        region.setLongitude(Double.valueOf(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("longitude")))));
        region.setRadius(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("radius"))));
        boolean flag;
        if (cursor.getInt(cursor.getColumnIndex("active")) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        region.setActive(Boolean.valueOf(flag));
        region.setGuid(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("beacon_guid"))));
        region.setMajor(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("beacon_major"))));
        region.setMinor(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("beacon_minor"))));
        region.setEntryCount(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("entry_count"))));
        region.setExitCount(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("exit_count"))));
        region.setDescription(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("description"))));
        region.setName(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("name"))));
        region.setLocationType(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("location_type"))));
        if (cursor.getInt(cursor.getColumnIndex("has_entered")) == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        try
        {
            region.setHasEntered(Boolean.valueOf(flag));
        }
        // Misplaced declaration of an exception variable
        catch (Cursor cursor)
        {
            m.c("~!dg", cursor.getMessage(), cursor);
            return null;
        }
        return region;
    }

    public static Region a(String s)
    {
        Object obj1 = null;
        Object obj = null;
        Cursor cursor = i.a().b().query("regions", a, "id = ?", new String[] {
            s
        }, null, null, null, "1");
        s = obj1;
        if (cursor != null)
        {
            s = obj;
            if (cursor.moveToFirst())
            {
                s = a(cursor);
            }
            cursor.close();
        }
        return s;
    }

    public static List a(String s, String as[], String s1, String s2, String s3)
    {
        s = i.a().b().query("regions", a, s, as, s1, s2, s3);
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

    public static void a(Region region)
    {
        i.a().b().insert("regions", null, d(region));
    }

    public static void b(Region region)
    {
        if (a(region.getId()) == null)
        {
            a(region);
            return;
        } else
        {
            c(region);
            return;
        }
    }

    public static int c(Region region)
    {
        String s = String.valueOf(region.getId());
        return i.a().b().update("regions", d(region), "id = ?", new String[] {
            s
        });
    }

    private static ContentValues d(Region region)
    {
        boolean flag = true;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id", region.getId());
        contentvalues.put("latitude", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), String.valueOf(region.getLatitude())));
        contentvalues.put("longitude", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), String.valueOf(region.getLongitude())));
        contentvalues.put("radius", region.getRadius());
        int j;
        if (region.getActive().booleanValue())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        contentvalues.put("active", Integer.valueOf(j));
        contentvalues.put("beacon_guid", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), region.getGuid()));
        contentvalues.put("beacon_major", region.getMajor());
        contentvalues.put("beacon_minor", region.getMinor());
        contentvalues.put("entry_count", region.getEntryCount());
        contentvalues.put("exit_count", region.getExitCount());
        contentvalues.put("description", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), region.getDescription()));
        contentvalues.put("name", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), region.getName()));
        contentvalues.put("location_type", region.getLocationType());
        if (region.getHasEntered().booleanValue())
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = 0;
        }
        contentvalues.put("has_entered", Integer.valueOf(j));
        return contentvalues;
    }

}
