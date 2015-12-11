// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;


// Referenced classes of package com.mobileapptracker:
//            MobileAppTracker, Parameters

final class i
    implements Runnable
{

    final int a;
    final MobileAppTracker b;

    i(MobileAppTracker mobileapptracker, int j)
    {
        b = mobileapptracker;
        a = j;
        super();
    }

    public final void run()
    {
        b.params.setAge(Integer.toString(a));
    }
}
