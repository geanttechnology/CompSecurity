// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.widget.VideoView;

// Referenced classes of package com.tapjoy:
//            TJAdUnit, TapjoyLog

final class >
    implements Runnable
{

    final String a;
    final ridge.AdUnitAsyncTaskListner b;
    final TJAdUnit c;

    public final void run()
    {
        if (TJAdUnit.f(c) != null)
        {
            TapjoyLog.i("TJAdUnit", (new StringBuilder("loadVideoUrl: ")).append(a).toString());
            TJAdUnit.f(c).setVisibility(0);
            TJAdUnit.f(c).setVideoPath(a);
            TJAdUnit.f(c).seekTo(0);
            b.onComplete(true);
            return;
        } else
        {
            b.onComplete(false);
            return;
        }
    }

    istner(TJAdUnit tjadunit, String s, ridge.AdUnitAsyncTaskListner adunitasynctasklistner)
    {
        c = tjadunit;
        a = s;
        b = adunitasynctasklistner;
        super();
    }
}
