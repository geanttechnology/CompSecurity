// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;

import android.database.Cursor;
import com.cyberlink.you.i;

// Referenced classes of package com.cyberlink.you.database:
//            a, EventObj, BaseObj

public class c extends a
{

    private static final String c[] = {
        "_id", "EventId", "EventFrom", "EventTo", "EventType", "EventContent"
    };

    public c()
    {
    }

    protected BaseObj a(Cursor cursor)
    {
        return b(cursor);
    }

    public EventObj a(String s)
    {
        return (EventObj)a("EventId=?", new String[] {
            s
        }, null);
    }

    protected String a()
    {
        return "database.EventDao";
    }

    protected EventObj b(Cursor cursor)
    {
        long l1 = System.currentTimeMillis();
        int j = cursor.getColumnIndex("_id");
        int k = cursor.getColumnIndex("EventId");
        int l = cursor.getColumnIndex("EventFrom");
        int i1 = cursor.getColumnIndex("EventTo");
        int j1 = cursor.getColumnIndex("EventType");
        int k1 = cursor.getColumnIndex("EventContent");
        if (j < 0 || k < 0 || l < 0 || i1 < 0 || j1 < 0 || k1 < 0)
        {
            i.c("database.EventDao", new Object[] {
                "[_get(Cursor)] ", "cursor.getColumnIndex() returned negative number"
            });
            cursor = null;
        } else
        {
            EventObj eventobj = new EventObj(cursor.getLong(j), cursor.getString(k), cursor.getString(l), cursor.getString(i1), cursor.getString(j1), cursor.getString(k1));
            cursor = eventobj;
            if (i.a() <= 2)
            {
                i.a("database.EventDao", new Object[] {
                    "[_get(Cursor)] ", "    eventObj: ", eventobj.toString()
                });
                i.a("database.EventDao", new Object[] {
                    "[_get(Cursor)] ", "Iterating takes ", Double.valueOf((double)(System.currentTimeMillis() - l1) / 1000D), " seconds."
                });
                return eventobj;
            }
        }
        return cursor;
    }

    protected String b()
    {
        return "Event";
    }

    protected String[] c()
    {
        return c;
    }

}
