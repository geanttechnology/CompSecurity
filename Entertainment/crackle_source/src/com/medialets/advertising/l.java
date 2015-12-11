// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.os.Handler;
import com.medialets.analytics.MMAnalyticsManager;

// Referenced classes of package com.medialets.advertising:
//            AdManagerService, a

final class l
    implements Runnable
{

    private AdManagerService a;

    l(AdManagerService admanagerservice)
    {
        a = admanagerservice;
        super();
    }

    public final void run()
    {
        if (!AdManagerService.a(a))
        {
            com.medialets.advertising.a.d("Pausing the service.");
            AdManagerService.b(a).pause();
            AdManagerService.c(a).postDelayed(a.a, 30000L);
            return;
        } else
        {
            AdManagerService.b(a).resume();
            return;
        }
    }
}
