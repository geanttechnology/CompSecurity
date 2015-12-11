// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import com.medialets.analytics.MMAnalyticsManager;

// Referenced classes of package com.medialets.advertising:
//            AdManagerService, a

final class k
    implements Runnable
{

    private AdManagerService a;

    k(AdManagerService admanagerservice)
    {
        a = admanagerservice;
        super();
    }

    public final void run()
    {
        com.medialets.advertising.a.d((new StringBuilder()).append("Checking if we are bound: ").append(AdManagerService.a(a)).toString());
        if (!AdManagerService.a(a))
        {
            AdManagerService.b(a).stop();
        }
    }
}
