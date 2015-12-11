// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation;

import com.google.android.gms.ads.a;
import com.google.android.gms.ads.c.d;

// Referenced classes of package com.google.ads.mediation:
//            AbstractAdViewAdapter

static final class zzaQ extends a
    implements com.google.android.gms.ads.internal.client.a
{

    final AbstractAdViewAdapter zzaP;
    final d zzaQ;

    public final void onAdClicked()
    {
        zzaQ.e();
    }

    public final void onAdClosed()
    {
        zzaQ.c();
    }

    public final void onAdFailedToLoad(int i)
    {
        zzaQ.a(i);
    }

    public final void onAdLeftApplication()
    {
        zzaQ.d();
    }

    public final void onAdLoaded()
    {
        zzaQ.a();
    }

    public final void onAdOpened()
    {
        zzaQ.b();
    }

    public (AbstractAdViewAdapter abstractadviewadapter, d d1)
    {
        zzaP = abstractadviewadapter;
        zzaQ = d1;
    }
}
