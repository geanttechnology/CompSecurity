// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import java.util.Date;

// Referenced classes of package com.mobileapptracker:
//            MobileAppTracker, Parameters

final class v
    implements Runnable
{

    final Date a;
    final MobileAppTracker b;

    v(MobileAppTracker mobileapptracker, Date date)
    {
        b = mobileapptracker;
        a = date;
        super();
    }

    public final void run()
    {
        b.params.setEventDate1(Long.toString(a.getTime() / 1000L));
    }
}
