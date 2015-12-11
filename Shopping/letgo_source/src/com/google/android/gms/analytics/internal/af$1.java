// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.os.Looper;
import android.support.v7.wf;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            af, r

class a
    implements Runnable
{

    final af a;

    public void run()
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            af.a(a).h().a(this);
        } else
        {
            boolean flag = a.c();
            af.a(a, 0L);
            if (flag && !af.b(a))
            {
                a.a();
                return;
            }
        }
    }

    (af af1)
    {
        a = af1;
        super();
    }
}
