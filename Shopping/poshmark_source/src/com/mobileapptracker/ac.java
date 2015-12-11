// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;


// Referenced classes of package com.mobileapptracker:
//            MobileAppTracker, MATEvent

final class ac
    implements Runnable
{

    final MATEvent a;
    final MobileAppTracker b;

    ac(MobileAppTracker mobileapptracker, MATEvent matevent)
    {
        b = mobileapptracker;
        a = matevent;
        super();
    }

    public final void run()
    {
        MobileAppTracker.a(b, a);
    }
}
