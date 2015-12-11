// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.os.Looper;

// Referenced classes of package com.tapjoy.internal:
//            ae

public final class ga
{

    public static boolean a;

    public static void a(String s)
    {
        if (a)
        {
            ae.a(4, "Tapjoy", s, null);
        }
    }

    public static void a(String s, String s1, String s2)
    {
        if (a)
        {
            ae.a("Tapjoy", "{}: {} {}", new Object[] {
                s, s1, s2
            });
        }
    }

    public static transient void a(String s, Object aobj[])
    {
        if (a)
        {
            ae.a(4, "Tapjoy", s, aobj);
        }
    }

    public static boolean a(Object obj, String s)
    {
        if (obj == null)
        {
            if (a)
            {
                b(s);
            }
            return false;
        } else
        {
            return true;
        }
    }

    public static boolean a(boolean flag, String s)
    {
        if (a && !flag)
        {
            b(s);
            throw new IllegalStateException(s);
        } else
        {
            return flag;
        }
    }

    public static void b(String s)
    {
        if (a)
        {
            ae.a(6, "Tapjoy", s, null);
        }
    }

    public static transient void b(String s, Object aobj[])
    {
        if (a)
        {
            ae.a("Tapjoy", s, aobj);
        }
    }

    static boolean c(String s)
    {
        boolean flag;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return a(flag, (new StringBuilder()).append(s).append(": Must be called on the main/ui thread").toString());
    }
}
