// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.util.Log;
import com.facebook.k;
import com.facebook.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            kc

public class jv
{

    private static final HashMap a = new HashMap();
    private final s b;
    private final String c;
    private StringBuilder d;
    private int e;

    public jv(s s1, String s2)
    {
        e = 3;
        kc.a(s2, "tag");
        b = s1;
        c = (new StringBuilder()).append("FacebookSDK.").append(s2).toString();
        d = new StringBuilder();
    }

    public static void a(s s1, int i, String s2, String s3)
    {
        if (k.a(s1))
        {
            String s4 = d(s3);
            s3 = s2;
            if (!s2.startsWith("FacebookSDK."))
            {
                s3 = (new StringBuilder()).append("FacebookSDK.").append(s2).toString();
            }
            Log.println(i, s3, s4);
            if (s1 == s.f)
            {
                (new Exception()).printStackTrace();
            }
        }
    }

    public static transient void a(s s1, int i, String s2, String s3, Object aobj[])
    {
        if (k.a(s1))
        {
            a(s1, i, s2, String.format(s3, aobj));
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
        android/support/v7/jv;
        JVM INSTR monitorenter ;
        if (!k.a(s.b))
        {
            a(s1, "ACCESS_TOKEN_REMOVED");
        }
        android/support/v7/jv;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public static void a(String s1, String s2)
    {
        android/support/v7/jv;
        JVM INSTR monitorenter ;
        a.put(s1, s2);
        android/support/v7/jv;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    private boolean b()
    {
        return k.a(b);
    }

    private static String d(String s1)
    {
        android/support/v7/jv;
        JVM INSTR monitorenter ;
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            s1 = s1.replace((CharSequence)entry.getKey(), (CharSequence)entry.getValue());
        }

        android/support/v7/jv;
        JVM INSTR monitorexit ;
        return s1;
        s1;
        throw s1;
    }

    public void a()
    {
        b(d.toString());
        d = new StringBuilder();
    }

    public void a(String s1, Object obj)
    {
        a("  %s:\t%s\n", new Object[] {
            s1, obj
        });
    }

    public transient void a(String s1, Object aobj[])
    {
        if (b())
        {
            d.append(String.format(s1, aobj));
        }
    }

    public void b(String s1)
    {
        a(b, e, c, s1);
    }

    public void c(String s1)
    {
        if (b())
        {
            d.append(s1);
        }
    }

}
