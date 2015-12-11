// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import org.json.JSONArray;

// Referenced classes of package com.mobileapptracker:
//            MobileAppTracker

final class bq
    implements Runnable
{

    final int a;
    final JSONArray b;
    final double c;
    final String d;
    final String e;
    final String f;
    final String g;
    final MobileAppTracker h;

    bq(MobileAppTracker mobileapptracker, int i, JSONArray jsonarray, double d1, String s, String s1, 
            String s2, String s3)
    {
        h = mobileapptracker;
        a = i;
        b = jsonarray;
        c = d1;
        d = s;
        e = s1;
        f = s2;
        g = s3;
        super();
    }

    public final void run()
    {
        MobileAppTracker.a(h, Integer.valueOf(a), b, c, d, e, f, g);
    }
}
