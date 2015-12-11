// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;

// Referenced classes of package com.google.android.gms.internal:
//            d

public final class kv extends d
{

    private final AdListener a;

    public kv(AdListener adlistener)
    {
        a = adlistener;
    }

    public final void a()
    {
        a.onAdClosed();
    }

    public final void a(int i)
    {
        a.onAdFailedToLoad(i);
    }

    public final void b()
    {
        a.onAdLeftApplication();
    }

    public final void c()
    {
        a.onAdLoaded();
    }

    public final void d()
    {
        a.onAdOpened();
    }
}
