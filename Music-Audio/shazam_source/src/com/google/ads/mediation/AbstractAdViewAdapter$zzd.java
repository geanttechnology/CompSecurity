// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation;

import com.google.android.gms.ads.a;
import com.google.android.gms.ads.c.f;

// Referenced classes of package com.google.ads.mediation:
//            AbstractAdViewAdapter

static final class zzaR extends a
    implements com.google.android.gms.ads.internal.client.a
{

    final AbstractAdViewAdapter zzaP;
    final f zzaR;

    public final void onAdClicked()
    {
        zzaR.j();
    }

    public final void onAdClosed()
    {
        zzaR.h();
    }

    public final void onAdFailedToLoad(int i)
    {
        zzaR.b(i);
    }

    public final void onAdLeftApplication()
    {
        zzaR.i();
    }

    public final void onAdLoaded()
    {
        zzaR.f();
    }

    public final void onAdOpened()
    {
        zzaR.g();
    }

    public (AbstractAdViewAdapter abstractadviewadapter, f f1)
    {
        zzaP = abstractadviewadapter;
        zzaR = f1;
    }
}
