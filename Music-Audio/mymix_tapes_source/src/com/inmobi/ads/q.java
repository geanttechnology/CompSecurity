// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.content.ContentValues;
import com.inmobi.commons.core.b.b;
import com.inmobi.commons.core.utilities.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.inmobi.ads:
//            p

public class q
{

    public static final String a[] = {
        "id", "placement_id", "tp_key", "last_accessed_ts"
    };
    private static final String b = com/inmobi/ads/q.getSimpleName();
    private static q c;
    private static Object d = new Object();

    private q()
    {
        b b1 = com.inmobi.commons.core.b.b.a();
        b1.a("placement", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, placement_id INTEGER NOT NULL,tp_key TEXT,last_accessed_ts INTEGER NOT NULL,UNIQUE(placement_id,tp_key))");
        b1.b();
    }

    public static q a()
    {
        Object obj;
        obj = c;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        Object obj1 = d;
        obj1;
        JVM INSTR monitorenter ;
        q q1 = c;
        obj = q1;
        if (q1 != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        c = new q();
        obj = c;
        obj1;
        JVM INSTR monitorexit ;
        return ((q) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        return ((q) (obj));
    }

    public int a(long l)
    {
        b b1 = com.inmobi.commons.core.b.b.a();
        int i = b1.a("placement", "last_accessed_ts<?", new String[] {
            String.valueOf(System.currentTimeMillis() - 1000L * l)
        });
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("Deleted ").append(i).append(" expired pids from cache").toString());
        b1.b();
        return i;
    }

    public int a(List list, int i)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        if (list == null) goto _L2; else goto _L1
_L1:
        int j = list.size();
        if (j != 0) goto _L3; else goto _L2
_L2:
        i = 0;
_L9:
        this;
        JVM INSTR monitorexit ;
        return i;
_L3:
        b b1 = com.inmobi.commons.core.b.b.a();
        j = 0;
_L5:
        if (j >= list.size())
        {
            break; /* Loop/switch isn't completed */
        }
        long l = ((p)list.get(j)).c();
        String s = ((p)list.get(j)).d();
        b1.a("placement", ((p)list.get(j)).f(), "placement_id = ? AND tp_key=?", new String[] {
            String.valueOf(l), s
        });
        j++;
        if (true) goto _L5; else goto _L4
_L4:
        j = b1.a("placement") - i;
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_268;
        }
        String as[];
        list = b1.a("placement", new String[] {
            "id"
        }, null, null, null, null, "last_accessed_ts ASC", String.valueOf(j));
        as = new String[list.size()];
        i = ((flag) ? 1 : 0);
_L7:
        if (i >= list.size())
        {
            break; /* Loop/switch isn't completed */
        }
        as[i] = String.valueOf(((ContentValues)list.get(i)).getAsInteger("id"));
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        list = Arrays.toString(as).replace("[", "(").replace("]", ")");
        b1.a("placement", (new StringBuilder()).append("id IN ").append(list).toString(), null);
        b1.b();
        i = j;
        if (true) goto _L9; else goto _L8
_L8:
        list;
        throw list;
    }

    public List b()
    {
        ArrayList arraylist = new ArrayList();
        b b1 = com.inmobi.commons.core.b.b.a();
        List list = b1.a("placement", a, null, null, null, null, null, null);
        b1.b();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); arraylist.add(new p((ContentValues)iterator.next()))) { }
        return arraylist;
    }

}
