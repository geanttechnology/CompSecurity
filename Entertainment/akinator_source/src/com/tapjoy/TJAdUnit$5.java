// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.os.Handler;
import android.widget.VideoView;

// Referenced classes of package com.tapjoy:
//            TJAdUnit, TJVideoListener, TJAdUnitJSBridge

final class >
    implements Runnable
{

    final TJAdUnit a;

    public final void run()
    {
        if (TJAdUnit.f(a).getCurrentPosition() != 0)
        {
            if (!TJAdUnit.g(a))
            {
                TJAdUnit.a(a, true);
                if (a.getPublisherVideoListener() != null)
                {
                    a.getPublisherVideoListener().onVideoStart();
                }
            }
            TJAdUnit.i(a).onVideoStarted(TJAdUnit.h(a));
            TJAdUnit.j(a);
            return;
        } else
        {
            TJAdUnit.k(a).postDelayed(this, 200L);
            return;
        }
    }

    ridge(TJAdUnit tjadunit)
    {
        a = tjadunit;
        super();
    }
}
