// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.app.Activity;
import android.app.Application;

// Referenced classes of package com.tapjoy.internal:
//            cf, be, cz

public final class d
{

    private static Application a;
    private static int b;
    private static final cf c = new cf();
    private static final be d = new be();
    private static final cf e = new cf();

    public static Activity a()
    {
label0:
        {
            Activity activity1 = (Activity)e.a();
            Activity activity = activity1;
            if (activity1 == null)
            {
                activity = (Activity)c.a();
                if (activity == null)
                {
                    break label0;
                }
            }
            return activity;
        }
        return (Activity)cz.a(d.iterator());
    }

    public static void a(Activity activity)
    {
        b++;
        c.a(activity);
        d.add(activity);
    }

    public static void a(Application application)
    {
        com/tapjoy/internal/d;
        JVM INSTR monitorenter ;
        if (a != application)
        {
            a = application;
        }
        com/tapjoy/internal/d;
        JVM INSTR monitorexit ;
        return;
        application;
        throw application;
    }

    public static void b(Activity activity)
    {
        b--;
        c.a = null;
        d.remove(activity);
        if (b < 0)
        {
            b = 0;
        }
    }

    public static boolean b()
    {
        return b > 0;
    }

}
