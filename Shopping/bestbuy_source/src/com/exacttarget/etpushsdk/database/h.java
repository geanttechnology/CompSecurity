// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.exacttarget.etpushsdk.ETPush;
import com.exacttarget.etpushsdk.data.Registration;
import com.exacttarget.etpushsdk.util.a;
import com.exacttarget.etpushsdk.util.i;

public class h
{

    public static final String a[] = {
        "id", "platform", "device_id", "subscriber_key", "et_app_id", "email", "badge", "timezone", "dst", "tags", 
        "attributes", "platform_version", "push_enabled", "location_enabled", "last_sent", "hwid", "gcm_sender_id", "locale"
    };

    public static int a(String s, String as[])
    {
        return i.a().b().delete("registration", s, as);
    }

    public static Registration a()
    {
        Registration registration = null;
        Object obj = null;
        Cursor cursor = i.a().b().query("registration", a, null, null, null, null, "id DESC ", "1");
        if (cursor != null)
        {
            registration = obj;
            if (cursor.moveToFirst())
            {
                registration = a(cursor);
            }
            cursor.close();
        }
        return registration;
    }

    public static Registration a(Cursor cursor)
    {
        boolean flag1 = true;
        Registration registration = new Registration();
        registration.setId(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("id"))));
        registration.setPlatform(cursor.getString(cursor.getColumnIndex("platform")));
        registration.setDeviceId(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("device_id"))));
        registration.setSubscriberKey(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("subscriber_key"))));
        registration.setEtAppId(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("et_app_id"))));
        registration.setEmail(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("email"))));
        registration.setBadge(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("badge"))));
        registration.setTimeZone(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("timezone"))));
        boolean flag;
        if (cursor.getInt(cursor.getColumnIndex("dst")) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        registration.setDst(Boolean.valueOf(flag));
        registration.setTags(Registration.deserializeTags(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("tags")))));
        registration.setAttributes(Registration.deserializeAttributes(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("attributes")))));
        registration.setPlatformVersion(cursor.getString(cursor.getColumnIndex("platform_version")));
        if (cursor.getInt(cursor.getColumnIndex("push_enabled")) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        registration.setPushEnabled(Boolean.valueOf(flag));
        if (cursor.getInt(cursor.getColumnIndex("location_enabled")) == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        registration.setLocationEnabled(Boolean.valueOf(flag));
        registration.setLastSent(Long.valueOf(cursor.getLong(cursor.getColumnIndex("last_sent"))));
        registration.setHwid(cursor.getString(cursor.getColumnIndex("hwid")));
        registration.setGcmSenderId(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("gcm_sender_id"))));
        registration.setLocale(cursor.getString(cursor.getColumnIndex("locale")));
        return registration;
    }

    public static void a(Registration registration)
    {
        registration.setId(Integer.valueOf((int)i.a().b().insert("registration", null, c(registration))));
    }

    public static int b(Registration registration)
    {
        String s = String.valueOf(registration.getId());
        return i.a().b().update("registration", c(registration), "id = ?", new String[] {
            s
        });
    }

    private static ContentValues c(Registration registration)
    {
        boolean flag = true;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("platform", registration.getPlatform());
        contentvalues.put("device_id", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), registration.getDeviceId()));
        contentvalues.put("subscriber_key", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), registration.getSubscriberKey()));
        contentvalues.put("et_app_id", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), registration.getEtAppId()));
        contentvalues.put("email", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), registration.getEmail()));
        contentvalues.put("badge", registration.getBadge());
        contentvalues.put("timezone", registration.getTimeZone());
        int j;
        if (registration.getDst().booleanValue())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        contentvalues.put("dst", Integer.valueOf(j));
        contentvalues.put("tags", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), Registration.serializeTags(registration.getTags())));
        contentvalues.put("attributes", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), Registration.serializeAttributes(registration.getAttributes())));
        contentvalues.put("platform_version", registration.getPlatformVersion());
        if (registration.getPushEnabled().booleanValue())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        contentvalues.put("push_enabled", Integer.valueOf(j));
        if (registration.getLocationEnabled().booleanValue())
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = 0;
        }
        contentvalues.put("location_enabled", Integer.valueOf(j));
        contentvalues.put("last_sent", registration.getLastSent());
        contentvalues.put("hwid", registration.getHwid());
        contentvalues.put("gcm_sender_id", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), registration.getGcmSenderId()));
        contentvalues.put("locale", registration.getLocale());
        return contentvalues;
    }

}
