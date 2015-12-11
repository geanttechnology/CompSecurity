// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.Set;

// Referenced classes of package com.paypal.android.sdk:
//            hf, fa, lx, ey, 
//            bk, dd

public final class ex
{

    public static boolean a;
    private static final hf b;
    private static Set c = new ey();

    public static String a(fa fa1)
    {
        return b.a(fa1);
    }

    public static String a(String s)
    {
        if (s.equals(bk.b.toString()))
        {
            return b.a(fa.aK);
        }
        if (s.equals(bk.a.toString()))
        {
            return b.a("INTERNAL_SERVICE_ERROR", fa.aQ);
        }
        if (s.equals(bk.c.toString()))
        {
            return b.a(fa.bu);
        } else
        {
            return b.a(s, fa.aQ);
        }
    }

    public static void b(String s)
    {
        b.a(s);
        boolean flag;
        if (dd.c(s) && c.contains(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }

    public static String c(String s)
    {
        String s2 = b.a();
        String s1 = s2;
        if (!s2.contains("_"))
        {
            s1 = (new StringBuilder()).append(s2).append("_").append(s).toString();
        }
        return s1;
    }

    static 
    {
        b = new hf(com/paypal/android/sdk/fa, lx.a);
    }
}
