// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            gw, gg, gm, jz, 
//            ks

public final class kb extends gw
{

    private final gg a;
    private final ks b;

    public kb(gg gg1, ks ks)
    {
        a = gg1;
        b = ks;
    }

    public final gm a()
    {
        String s = a.a("Content-Type");
        if (s != null)
        {
            return gm.a(s);
        } else
        {
            return null;
        }
    }

    public final long b()
    {
        return jz.a(a);
    }

    public final ks c()
    {
        return b;
    }
}
