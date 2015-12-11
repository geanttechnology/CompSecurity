// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;


// Referenced classes of package com.mobileapptracker:
//            MobileAppTracker

final class d
    implements Runnable
{

    final String a;
    final String b;

    d(String s, String s1)
    {
        a = s;
        b = s1;
        super();
    }

    public final void run()
    {
        MobileAppTracker.b().initAll(a, b);
    }
}
