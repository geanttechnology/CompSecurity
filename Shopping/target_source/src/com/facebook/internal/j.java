// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.util.Log;
import com.facebook.i;
import com.facebook.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.facebook.internal:
//            p

public class j
{

    private static final HashMap a = new HashMap();
    private final q b;
    private final String c;
    private StringBuilder d;
    private int e;

    public j(q q1, String s)
    {
        e = 3;
        p.a(s, "tag");
        b = q1;
        c = (new StringBuilder()).append("FacebookSDK.").append(s).toString();
        d = new StringBuilder();
    }

    public static void a(q q1, int k, String s, String s1)
    {
        if (i.a(q1))
        {
            String s2 = d(s1);
            s1 = s;
            if (!s.startsWith("FacebookSDK."))
            {
                s1 = (new StringBuilder()).append("FacebookSDK.").append(s).toString();
            }
            Log.println(k, s1, s2);
            if (q1 == q.f)
            {
                (new Exception()).printStackTrace();
            }
        }
    }

    public static transient void a(q q1, int k, String s, String s1, Object aobj[])
    {
        if (i.a(q1))
        {
            a(q1, k, s, String.format(s1, aobj));
        }
    }

    public static void a(q q1, String s, String s1)
    {
        a(q1, 3, s, s1);
    }

    public static transient void a(q q1, String s, String s1, Object aobj[])
    {
        if (i.a(q1))
        {
            a(q1, 3, s, String.format(s1, aobj));
        }
    }

    public static void a(String s)
    {
        com/facebook/internal/j;
        JVM INSTR monitorenter ;
        if (!i.a(q.b))
        {
            a(s, "ACCESS_TOKEN_REMOVED");
        }
        com/facebook/internal/j;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public static void a(String s, String s1)
    {
        com/facebook/internal/j;
        JVM INSTR monitorenter ;
        a.put(s, s1);
        com/facebook/internal/j;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    private boolean b()
    {
        return i.a(b);
    }

    private static String d(String s)
    {
        com/facebook/internal/j;
        JVM INSTR monitorenter ;
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            s = s.replace((CharSequence)entry.getKey(), (CharSequence)entry.getValue());
        }

        com/facebook/internal/j;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public void a()
    {
        b(d.toString());
        d = new StringBuilder();
    }

    public void a(String s, Object obj)
    {
        a("  %s:\t%s\n", new Object[] {
            s, obj
        });
    }

    public transient void a(String s, Object aobj[])
    {
        if (b())
        {
            d.append(String.format(s, aobj));
        }
    }

    public void b(String s)
    {
        a(b, e, c, s);
    }

    public void c(String s)
    {
        if (b())
        {
            d.append(s);
        }
    }

}
