// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.a;

import android.content.ContentValues;
import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.utilities.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.inmobi.rendering.a:
//            a

public class b
{

    public static final String a[] = {
        "id", "pending_attempts", "url", "ping_in_webview", "follow_redirect", "ts"
    };
    private static final String b = com/inmobi/rendering/a/b.getSimpleName();

    public b()
    {
        com.inmobi.commons.core.b.b b1 = com.inmobi.commons.core.b.b.a();
        b1.a("click", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, pending_attempts INTEGER NOT NULL, url TEXT NOT NULL, ping_in_webview TEXT NOT NULL, follow_redirect TEXT NOT NULL, ts TEXT NOT NULL)");
        b1.b();
    }

    public com.inmobi.rendering.a.a a(ContentValues contentvalues)
    {
        int i = contentvalues.getAsInteger("id").intValue();
        int j = contentvalues.getAsInteger("pending_attempts").intValue();
        String s = contentvalues.getAsString("url");
        long l = Long.valueOf(contentvalues.getAsString("ts")).longValue();
        return new com.inmobi.rendering.a.a(i, s, Boolean.valueOf(contentvalues.getAsString("follow_redirect")).booleanValue(), Boolean.valueOf(contentvalues.getAsString("ping_in_webview")).booleanValue(), j, l);
    }

    public List a(int i, int j)
    {
        ArrayList arraylist = new ArrayList();
        com.inmobi.commons.core.b.b b1 = com.inmobi.commons.core.b.b.a();
        if (b1.a("click") == 0)
        {
            return arraylist;
        }
        Object obj;
        if (-1 == i)
        {
            obj = null;
        } else
        {
            obj = Integer.toString(i);
        }
        obj = b1.a("click", a, null, null, "ts", (new StringBuilder()).append("ts < ").append(String.valueOf(System.currentTimeMillis() - (long)j)).toString(), "ts ASC ", ((String) (obj)));
        b1.b();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(a((ContentValues)((Iterator) (obj)).next()))) { }
        return arraylist;
    }

    public void a(com.inmobi.rendering.a.a a1)
    {
        com.inmobi.commons.core.b.b b1 = com.inmobi.commons.core.b.b.a();
        int i = a1.a;
        b1.b("click", c(a1), "id = ?", new String[] {
            String.valueOf(i)
        });
        b1.b();
    }

    public boolean a()
    {
        return com.inmobi.commons.core.b.b.a().a("click") == 0;
    }

    public boolean a(com.inmobi.rendering.a.a a1, int i)
    {
        this;
        JVM INSTR monitorenter ;
        a1 = c(a1);
        com.inmobi.commons.core.b.b b1 = com.inmobi.commons.core.b.b.a();
        if (b1.a("click") >= i)
        {
            Object obj = new HashMap();
            ((Map) (obj)).put("errorCode", "MaxDbLimitBreach");
            com.inmobi.commons.core.c.a.a().a("ads", "PingDiscarded", ((Map) (obj)));
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Pruning persistent store to remove the oldest entry ...");
            obj = a((ContentValues)b1.a("click", a, "ts= (SELECT MIN(ts) FROM click LIMIT 1)", null, null, null, null, null).get(0));
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("Deleting click (").append(((com.inmobi.rendering.a.a) (obj)).a).append(")").toString());
            b(((com.inmobi.rendering.a.a) (obj)));
        }
        b1.a("click", a1);
        b1.b();
        this;
        JVM INSTR monitorexit ;
        return true;
        a1;
        throw a1;
    }

    public void b(com.inmobi.rendering.a.a a1)
    {
        com.inmobi.commons.core.b.b b1 = com.inmobi.commons.core.b.b.a();
        b1.a("click", "id = ?", new String[] {
            String.valueOf(a1.a)
        });
        b1.b();
    }

    public ContentValues c(com.inmobi.rendering.a.a a1)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id", Integer.valueOf(a1.a));
        contentvalues.put("url", a1.b);
        contentvalues.put("pending_attempts", Integer.valueOf(a1.d));
        contentvalues.put("ts", Long.toString(a1.c));
        contentvalues.put("follow_redirect", Boolean.toString(a1.g));
        contentvalues.put("ping_in_webview", Boolean.toString(a1.f));
        return contentvalues;
    }

}
