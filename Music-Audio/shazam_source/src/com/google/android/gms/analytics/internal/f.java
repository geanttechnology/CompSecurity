// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.g;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            ae, g, ak

public final class f
{

    private static volatile g a = new ae();

    public static g a()
    {
        return a;
    }

    public static void a(g g1)
    {
        a = g1;
    }

    public static void a(String s)
    {
        com.google.android.gms.analytics.internal.g g1 = g.b();
        if (g1 == null) goto _L2; else goto _L1
_L1:
        g1.e(s);
_L4:
        s = a;
        if (s != null)
        {
            s.a();
        }
        return;
_L2:
        if (a(2))
        {
            ak.c.a();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void a(String s, Object obj)
    {
        com.google.android.gms.analytics.internal.g g1 = g.b();
        if (g1 == null) goto _L2; else goto _L1
_L1:
        g1.e(s, obj);
_L4:
        obj = a;
        if (obj != null)
        {
            ((g) (obj)).a(s);
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

    private static boolean a(int i)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (a != null)
        {
            flag = flag1;
            if (a.b() <= i)
            {
                flag = true;
            }
        }
        return flag;
    }

}
