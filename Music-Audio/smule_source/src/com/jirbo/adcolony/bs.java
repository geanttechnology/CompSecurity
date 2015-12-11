// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            h, cs

class bs
{

    boolean a;
    cs b;
    int c;
    String d;
    boolean e;
    int f;

    bs()
    {
    }

    boolean a(h h1)
    {
        if (h1 != null)
        {
            a = h1.g("enabled");
            if (!a)
            {
                return true;
            }
            b = new cs();
            if (b.a(h1.a("limits")))
            {
                c = h1.f("reward_amount");
                d = h1.d("reward_name");
                e = h1.g("client_side");
                f = h1.f("videos_per_reward");
                return true;
            }
        }
        return false;
    }
}
