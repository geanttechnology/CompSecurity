// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;


// Referenced classes of package com.mobileapptracker:
//            MobileAppTracker, Parameters

final class ar
    implements Runnable
{

    final String a;
    final MobileAppTracker b;

    ar(MobileAppTracker mobileapptracker, String s)
    {
        b = mobileapptracker;
        a = s;
        super();
    }

    public final void run()
    {
        b.params.setPublisherId(a);
    }
}
