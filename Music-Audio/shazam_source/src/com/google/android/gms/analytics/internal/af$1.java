// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.os.Looper;
import com.google.android.gms.d.ja;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            af, r

final class a
    implements Runnable
{

    final af a;

    public final void run()
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            af.a(a).b().a(this);
        } else
        {
            boolean flag = a.b();
            af.b(a);
            if (flag && !af.c(a))
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
