// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;


// Referenced classes of package com.mobileapptracker:
//            MobileAppTracker, MATParameters

final class n
    implements Runnable
{

    final int a;
    final MobileAppTracker b;

    n(MobileAppTracker mobileapptracker, int i)
    {
        b = mobileapptracker;
        a = i;
        super();
    }

    public final void run()
    {
        b.params.setGender(Integer.toString(a));
    }
}
