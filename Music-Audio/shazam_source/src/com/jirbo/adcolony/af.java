// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

// Referenced classes of package com.jirbo.adcolony:
//            q

final class af
{

    static String a;
    static boolean b;

    static int a()
    {
        if (q.x == null)
        {
            return 0;
        } else
        {
            Context context = q.b().getApplicationContext();
            q.b();
            return ((ActivityManager)context.getSystemService("activity")).getMemoryClass();
        }
    }

    static boolean b()
    {
        if (q.x != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (q.O == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (q.O.equals("tablet"))
        {
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        DisplayMetrics displaymetrics = q.b().getResources().getDisplayMetrics();
        float f = (float)displaymetrics.widthPixels / displaymetrics.xdpi;
        float f1 = (float)displaymetrics.heightPixels / displaymetrics.ydpi;
        if (Math.sqrt(f1 * f1 + f * f) >= 6D)
        {
            return true;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }
}
