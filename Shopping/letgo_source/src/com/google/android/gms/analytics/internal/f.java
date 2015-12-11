// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.support.v7.kz;
import android.util.Log;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            ae, g, ak

public class f
{

    private static volatile kz a;

    public static kz a()
    {
        return a;
    }

    public static void a(kz kz1)
    {
        a = kz1;
    }

    public static void a(String s)
    {
        g g1 = g.b();
        if (g1 == null) goto _L2; else goto _L1
_L1:
        g1.e(s);
_L4:
        kz kz1 = a;
        if (kz1 != null)
        {
            kz1.a(s);
        }
        return;
_L2:
        if (a(2))
        {
            Log.w((String)ak.c.a(), s);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void a(String s, Object obj)
    {
        g g1 = g.b();
        if (g1 == null) goto _L2; else goto _L1
_L1:
        g1.e(s, obj);
_L4:
        obj = a;
        if (obj != null)
        {
            ((kz) (obj)).b(s);
        }
        return;
_L2:
        if (a(3))
        {
            if (obj != null)
            {
                obj = (new StringBuilder()).append(s).append(":").append(obj).toString();
            } else
            {
                obj = s;
            }
            Log.e((String)ak.c.a(), ((String) (obj)));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static boolean a(int i)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (a() != null)
        {
            flag = flag1;
            if (a().a() <= i)
            {
                flag = true;
            }
        }
        return flag;
    }

    static 
    {
        a(new ae());
    }
}
