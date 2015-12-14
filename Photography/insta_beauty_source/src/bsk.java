// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Application;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class bsk
{

    private final Set a = new HashSet();
    private final Application b;

    bsk(Application application)
    {
        b = application;
    }

    private void a()
    {
        android.app.Application.ActivityLifecycleCallbacks activitylifecyclecallbacks;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); b.unregisterActivityLifecycleCallbacks(activitylifecyclecallbacks))
        {
            activitylifecyclecallbacks = (android.app.Application.ActivityLifecycleCallbacks)iterator.next();
        }

    }

    static void a(bsk bsk1)
    {
        bsk1.a();
    }

    static boolean a(bsk bsk1, bsm bsm)
    {
        return bsk1.a(bsm);
    }

    private boolean a(bsm bsm)
    {
        if (b != null)
        {
            bsm = new bsl(this, bsm);
            b.registerActivityLifecycleCallbacks(bsm);
            a.add(bsm);
            return true;
        } else
        {
            return false;
        }
    }
}
