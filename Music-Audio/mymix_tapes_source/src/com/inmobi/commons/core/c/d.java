// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.c;

import android.content.ContentValues;
import com.inmobi.commons.core.b.b;
import com.inmobi.commons.core.utilities.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.inmobi.commons.core.c:
//            e

public class d
{

    private static final String a = com/inmobi/commons/core/c/d.getSimpleName();

    public d()
    {
        b b1 = com.inmobi.commons.core.b.b.a();
        b1.a("telemetry", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, componentType TEXT NOT NULL, eventType TEXT NOT NULL, payload TEXT NOT NULL, ts TEXT NOT NULL)");
        b1.a("metric", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, componentType TEXT NOT NULL, eventType TEXT NOT NULL, payload TEXT NOT NULL )");
        b1.b();
    }

    private void b(List list)
    {
        if (list.isEmpty())
        {
            return;
        }
        b b1 = com.inmobi.commons.core.b.b.a();
        String s = "";
        for (int i = 0; i < list.size() - 1; i++)
        {
            s = (new StringBuilder()).append(s).append(((ContentValues)list.get(i)).getAsString("id")).append(",").toString();
        }

        list = (new StringBuilder()).append(s).append(((ContentValues)list.get(list.size() - 1)).getAsString("id")).toString();
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Deleting events with id: ").append(list).toString());
        int j = b1.a("telemetry", (new StringBuilder()).append("id IN (").append(list).append(")").toString(), null);
        b1.b();
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Deleted Count: ").append(j).toString());
    }

    public List a()
    {
        b b1 = com.inmobi.commons.core.b.b.a();
        List list = b1.a("metric", null, null, null, null, null, null, null);
        b1.b();
        b();
        return list;
    }

    public List a(int i)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Querying db for events");
        b b1 = com.inmobi.commons.core.b.b.a();
        List list = b1.a("telemetry", null, null, null, null, null, "ts ASC", String.valueOf(i));
        b(list);
        ArrayList arraylist = new ArrayList();
        b1.b();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); arraylist.add(e.a((ContentValues)iterator.next()))) { }
        return arraylist;
    }

    public void a(e e1)
    {
        b b1 = com.inmobi.commons.core.b.b.a();
        b1.a("telemetry", e1.e());
        b1.b();
    }

    public void a(String s, String s1, String s2)
    {
        b b1 = com.inmobi.commons.core.b.b.a();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("componentType", s);
        contentvalues.put("eventType", s1);
        contentvalues.put("payload", s2);
        b1.a("metric", contentvalues);
        b1.b();
    }

    public void a(List list)
    {
        b b1 = com.inmobi.commons.core.b.b.a();
        for (list = list.iterator(); list.hasNext(); b1.a("telemetry", ((e)list.next()).e())) { }
        b1.b();
    }

    public void b()
    {
        b b1 = com.inmobi.commons.core.b.b.a();
        b1.a("metric", null, null);
        b1.b();
    }

    public int c()
    {
        b b1 = com.inmobi.commons.core.b.b.a();
        int i = b1.a("telemetry");
        b1.b();
        return i;
    }

}
