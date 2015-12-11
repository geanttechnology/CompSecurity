// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            h

class cg
{

    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;

    cg()
    {
    }

    boolean a(h h1)
    {
        if (h1 == null)
        {
            return false;
        } else
        {
            a = h1.f("daily_play_cap");
            b = h1.f("custom_play_cap");
            c = h1.f("custom_play_cap_period");
            d = h1.f("total_play_cap");
            e = h1.f("monthly_play_cap");
            f = h1.f("weekly_play_cap");
            g = h1.f("volatile_expiration");
            h = h1.f("volatile_play_cap");
            return true;
        }
    }
}
