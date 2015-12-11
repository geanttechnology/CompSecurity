// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.os.Handler;

// Referenced classes of package com.appnexus.opensdk:
//            m

final class a
    implements Runnable
{

    final m a;

    public final void run()
    {
        if (m.h(a))
        {
            return;
        } else
        {
            a.i();
            m.i(a).postDelayed(this, 1000L);
            return;
        }
    }

    (m m1)
    {
        a = m1;
        super();
    }
}
