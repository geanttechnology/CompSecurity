// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;


// Referenced classes of package com.mobileapptracker:
//            MobileAppTracker, MATEvent

final class r
    implements Runnable
{

    final MobileAppTracker a;

    r(MobileAppTracker mobileapptracker)
    {
        a = mobileapptracker;
        super();
    }

    public final void run()
    {
        a.notifiedPool = false;
        a.measureEvent(new MATEvent("session"));
    }
}
