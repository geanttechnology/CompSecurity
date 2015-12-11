// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import java.util.TimerTask;

// Referenced classes of package com.tapjoy:
//            TJAdUnitActivity, TJAdUnit, TapjoyLog

final class a extends TimerTask
{

    final TJAdUnitActivity a;

    public final void run()
    {
        if (TJAdUnitActivity.a(a).getCloseRequested())
        {
            TapjoyLog.i("TJAdUnitActivity", "Did not receive callback from content. Closing ad.");
            a.finish();
        }
    }

    (TJAdUnitActivity tjadunitactivity)
    {
        a = tjadunitactivity;
        super();
    }
}
