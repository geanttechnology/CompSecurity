// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.exacttarget.etpushsdk.ETPush;
import com.exacttarget.etpushsdk.data.AnalyticItem;
import com.exacttarget.etpushsdk.util.i;
import com.exacttarget.etpushsdk.util.m;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONArray;

public class a
{

    public static final String a[] = {
        "id", "device_id", "et_app_id", "event_date", "analytic_types", "object_ids", "value", "ready_to_send", "pi_app_key", "last_sent"
    };

    public static int a(int j)
    {
        return i.a().b().delete("analytic_item", "id = ?", new String[] {
            String.valueOf(j)
        });
    }

    public static int a(List list)
    {
        return i.a().b().delete("analytic_item", String.format("id IN (%s)", new Object[] {
            TextUtils.join(",", list)
        }), new String[0]);
    }

    public static AnalyticItem a(Cursor cursor)
    {
        AnalyticItem analyticitem;
        boolean flag;
        flag = true;
        analyticitem = new AnalyticItem();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
        analyticitem.setId(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("id"))));
        analyticitem.setDeviceId(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("device_id"))));
        analyticitem.setEtAppId(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("et_app_id"))));
        analyticitem.setEventDate(simpledateformat.parse(cursor.getString(cursor.getColumnIndex("event_date"))));
        analyticitem.setValue(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("value"))));
        ArrayList arraylist;
        JSONArray jsonarray;
        int j;
        if (cursor.getInt(cursor.getColumnIndex("ready_to_send")) != 1)
        {
            flag = false;
        }
        analyticitem.setReadyToSend(Boolean.valueOf(flag));
        analyticitem.setPiAppKey(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("pi_app_key"))));
        analyticitem.setLastSent(Long.valueOf(cursor.getLong(cursor.getColumnIndex("last_sent"))));
        arraylist = new ArrayList();
        jsonarray = new JSONArray(cursor.getString(cursor.getColumnIndex("analytic_types")));
        j = 0;
_L2:
        if (j >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(Integer.valueOf(jsonarray.getInt(j)));
        j++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        m.c("~!da", exception.getMessage(), exception);
_L1:
        analyticitem.setAnalyticTypes(arraylist);
        arraylist = new ArrayList();
        cursor = new JSONArray(cursor.getString(cursor.getColumnIndex("object_ids")));
        j = 0;
_L4:
        if (j >= cursor.length())
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(cursor.getString(j));
        j++;
        if (true) goto _L4; else goto _L3
        cursor;
        m.c("~!da", cursor.getMessage(), cursor);
_L3:
        analyticitem.setObjectIds(arraylist);
        return analyticitem;
        cursor;
        m.c("~!da", cursor.getMessage(), cursor);
        return null;
    }

    public static List a(String s, String as[], String s1, String s2, String s3)
    {
        s = i.a().b().query("analytic_item", a, s, as, s1, s2, s3);
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

    public static void a(AnalyticItem analyticitem)
    {
        analyticitem.setId(Integer.valueOf((int)i.a().b().insert("analytic_item", null, c(analyticitem))));
    }

    public static int b(AnalyticItem analyticitem)
    {
        String s = String.valueOf(analyticitem.getId());
        return i.a().b().update("analytic_item", c(analyticitem), "id = ?", new String[] {
            s
        });
    }

    private static ContentValues c(AnalyticItem analyticitem)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("device_id", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), analyticitem.getDeviceId()));
        contentvalues.put("et_app_id", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), analyticitem.getEtAppId()));
        contentvalues.put("event_date", simpledateformat.format(analyticitem.getEventDate()));
        contentvalues.put("analytic_types", (new JSONArray(analyticitem.getAnalyticTypes())).toString());
        contentvalues.put("object_ids", (new JSONArray(analyticitem.getObjectIds())).toString());
        contentvalues.put("value", analyticitem.getValue());
        int j;
        if (analyticitem.getReadyToSend().booleanValue())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        contentvalues.put("ready_to_send", Integer.valueOf(j));
        contentvalues.put("pi_app_key", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), analyticitem.getPiAppKey()));
        contentvalues.put("last_sent", analyticitem.getLastSent());
        return contentvalues;
    }

}
