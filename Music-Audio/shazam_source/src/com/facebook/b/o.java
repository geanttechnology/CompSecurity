// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.b;

import android.util.Log;
import com.facebook.k;
import com.facebook.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.facebook.b:
//            u

public final class o
{

    private static final HashMap a = new HashMap();
    private final s b;
    private final String c;
    private StringBuilder d;
    private int e;

    public o(s s1, String s2)
    {
        e = 3;
        u.a(s2, "tag");
        b = s1;
        c = (new StringBuilder("FacebookSDK.")).append(s2).toString();
        d = new StringBuilder();
    }

    public static void a(s s1, int i, String s2, String s3)
    {
        if (k.a(s1))
        {
            String s4 = c(s3);
            s3 = s2;
            if (!s2.startsWith("FacebookSDK."))
            {
                s3 = (new StringBuilder("FacebookSDK.")).append(s2).toString();
            }
            Log.println(i, s3, s4);
            if (s1 == s.f)
            {
                (new Exception()).printStackTrace();
            }
        }
    }

    public static void a(s s1, String s2, String s3)
    {
        a(s1, 3, s2, s3);
    }

    public static transient void a(s s1, String s2, String s3, Object aobj[])
    {
        if (k.a(s1))
        {
            a(s1, 3, s2, String.format(s3, aobj));
        }
    }

    public static void a(String s1)
    {
        com/facebook/b/o;
        JVM INSTR monitorenter ;
        if (!k.a(s.b))
        {
            a(s1, "ACCESS_TOKEN_REMOVED");
        }
        com/facebook/b/o;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    private static void a(String s1, String s2)
    {
        com/facebook/b/o;
        JVM INSTR monitorenter ;
        a.put(s1, s2);
        com/facebook/b/o;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public static transient void b(s s1, String s2, String s3, Object aobj[])
    {
        if (k.a(s1))
        {
            a(s1, 5, s2, String.format(s3, aobj));
        }
    }

    private static String c(String s1)
    {
        com/facebook/b/o;
        JVM INSTR monitorenter ;
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            s1 = s1.replace((CharSequence)entry.getKey(), (CharSequence)entry.getValue());
        }

        com/facebook/b/o;
        JVM INSTR monitorexit ;
        return s1;
        s1;
        throw s1;
    }

    public final void a()
    {
        String s1 = d.toString();
        a(b, e, c, s1);
        d = new StringBuilder();
    }

    public final void a(String s1, Object obj)
    {
        if (k.a(b))
        {
            d.append(String.format("  %s:\t%s\n", new Object[] {
                s1, obj
            }));
        }
    }

    public final void b(String s1)
    {
        if (k.a(b))
        {
            d.append(s1);
        }
    }

}
