// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;


// Referenced classes of package com.google.analytics.tracking.android:
//            ao, ap, ak

public final class an
{

    private static ak a;

    public static void a(String s)
    {
        ao ao1 = b();
        if (ao1 != null)
        {
            ao1.d(s);
        }
    }

    public static boolean a()
    {
        if (b() != null)
        {
            return ap.a.equals(b().a());
        } else
        {
            return false;
        }
    }

    private static ao b()
    {
        if (a == null)
        {
            a = ak.a();
        }
        if (a != null)
        {
            return a.b;
        } else
        {
            return null;
        }
    }

    public static void b(String s)
    {
        ao ao1 = b();
        if (ao1 != null)
        {
            ao1.b(s);
        }
    }

    public static void c(String s)
    {
        ao ao1 = b();
        if (ao1 != null)
        {
            ao1.a(s);
        }
    }

    public static void d(String s)
    {
        ao ao1 = b();
        if (ao1 != null)
        {
            ao1.c(s);
        }
    }
}
