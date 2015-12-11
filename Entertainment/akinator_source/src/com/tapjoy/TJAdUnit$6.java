// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.widget.VideoView;
import java.util.Timer;

// Referenced classes of package com.tapjoy:
//            TJAdUnit

final class >
    implements Runnable
{

    final ridge.AdUnitAsyncTaskListner a;
    final TJAdUnit b;

    public final void run()
    {
        TJAdUnit.l(b).cancel();
        TJAdUnit.f(b).setVisibility(4);
        TJAdUnit.f(b).stopPlayback();
        TJAdUnit.a(b, false);
        TJAdUnit.m(b);
        a.onComplete(true);
    }

    istner(TJAdUnit tjadunit, ridge.AdUnitAsyncTaskListner adunitasynctasklistner)
    {
        b = tjadunit;
        a = adunitasynctasklistner;
        super();
    }
}
