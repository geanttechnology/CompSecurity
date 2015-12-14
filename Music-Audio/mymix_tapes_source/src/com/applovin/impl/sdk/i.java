// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import java.util.Collection;
import java.util.HashSet;

// Referenced classes of package com.applovin.impl.sdk:
//            e

class i
{

    final AppLovinAdSize a;
    final Object b;
    AppLovinAd c;
    long d;
    boolean e;
    private final Collection f;
    private final Collection g;

    private i(AppLovinAdSize applovinadsize)
    {
        f = new HashSet();
        g = new HashSet();
        a = applovinadsize;
        b = new Object();
        c = null;
        d = 0L;
        e = false;
    }

    i(AppLovinAdSize applovinadsize, e e1)
    {
        this(applovinadsize);
    }

    static Collection a(i j)
    {
        return j.g;
    }

    static Collection b(i j)
    {
        return j.f;
    }
}
