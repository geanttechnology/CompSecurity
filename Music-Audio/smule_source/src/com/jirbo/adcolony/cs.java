// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            h

class cs
{

    int a;
    int b;
    int c;

    cs()
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
            return true;
        }
    }
}
