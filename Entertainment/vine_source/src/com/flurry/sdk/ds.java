// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            dq, dl, dr

public class ds
{

    private static ds b;
    private final dq a = new dq();

    private ds()
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            ((Application)dl.a().b()).registerActivityLifecycleCallbacks(new android.app.Application.ActivityLifecycleCallbacks() {

                final ds a;

                protected void a(Activity activity, dr.a a1)
                {
                    for (Iterator iterator = ds.a(a).iterator(); iterator.hasNext(); ((dr)iterator.next()).a(activity, a1)) { }
                }

                public void onActivityCreated(Activity activity, Bundle bundle)
                {
                    a(activity, dr.a.a);
                }

                public void onActivityDestroyed(Activity activity)
                {
                    a(activity, dr.a.b);
                }

                public void onActivityPaused(Activity activity)
                {
                    a(activity, dr.a.c);
                }

                public void onActivityResumed(Activity activity)
                {
                    a(activity, dr.a.d);
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
                {
                    a(activity, dr.a.g);
                }

                public void onActivityStarted(Activity activity)
                {
                    a(activity, dr.a.e);
                }

                public void onActivityStopped(Activity activity)
                {
                    a(activity, dr.a.f);
                }

            
            {
                a = ds.this;
                super();
            }
            });
        }
    }

    public static ds a()
    {
        com/flurry/sdk/ds;
        JVM INSTR monitorenter ;
        ds ds1;
        if (b == null)
        {
            b = new ds();
        }
        ds1 = b;
        com/flurry/sdk/ds;
        JVM INSTR monitorexit ;
        return ds1;
        Exception exception;
        exception;
        throw exception;
    }

    static List a(ds ds1)
    {
        return ds1.c();
    }

    private List c()
    {
        this;
        JVM INSTR monitorenter ;
        List list = a.a();
        this;
        JVM INSTR monitorexit ;
        return list;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(dr dr)
    {
        this;
        JVM INSTR monitorenter ;
        a.a(dr);
        this;
        JVM INSTR monitorexit ;
        return;
        dr;
        throw dr;
    }

    public boolean b()
    {
        return android.os.Build.VERSION.SDK_INT >= 14;
    }
}
