// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.exacttarget.etpushsdk.data.Message;
import com.exacttarget.etpushsdk.data.Region;
import com.exacttarget.etpushsdk.data.RegionMessage;
import com.exacttarget.etpushsdk.util.i;
import com.exacttarget.etpushsdk.util.m;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.exacttarget.etpushsdk.database:
//            e, g

public class f
{

    public static final String a[] = {
        "id", "message_id", "region_id"
    };

    public static int a(int j)
    {
        return i.a().b().delete("region_message", "id = ?", new String[] {
            String.valueOf(j)
        });
    }

    public static int a(List list)
    {
        return i.a().b().delete("region_message", String.format("id IN (%s)", new Object[] {
            TextUtils.join(",", list)
        }), new String[0]);
    }

    public static RegionMessage a(Cursor cursor)
    {
        RegionMessage regionmessage = new RegionMessage();
        try
        {
            regionmessage.setId(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("id"))));
            regionmessage.setMessage(e.a(cursor.getString(cursor.getColumnIndex("message_id"))));
            regionmessage.setRegion(g.a(cursor.getString(cursor.getColumnIndex("region_id"))));
        }
        // Misplaced declaration of an exception variable
        catch (Cursor cursor)
        {
            m.c("~!df", cursor.getMessage(), cursor);
            return null;
        }
        return regionmessage;
    }

    public static List a(String s, String as[], String s1, String s2, String s3)
    {
        s = i.a().b().query("region_message", a, s, as, s1, s2, s3);
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

    public static void a(RegionMessage regionmessage)
    {
        regionmessage.setId(Integer.valueOf((int)i.a().b().insert("region_message", null, b(regionmessage))));
    }

    private static ContentValues b(RegionMessage regionmessage)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("message_id", regionmessage.getMessage().getId());
        contentvalues.put("region_id", regionmessage.getRegion().getId());
        return contentvalues;
    }

}
