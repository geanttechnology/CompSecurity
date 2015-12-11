// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation;

import com.google.android.gms.ads.a;
import com.google.android.gms.ads.b.d;
import com.google.android.gms.ads.b.e;
import com.google.android.gms.ads.c.m;

// Referenced classes of package com.google.ads.mediation:
//            AbstractAdViewAdapter

static final class zzaS extends a
    implements com.google.android.gms.ads.b., com.google.android.gms.ads.b., com.google.android.gms.ads.internal.client.a
{

    final AbstractAdViewAdapter zzaP;
    final m zzaS;

    public final void onAdClicked()
    {
        zzaS.n();
    }

    public final void onAdClosed()
    {
        zzaS.l();
    }

    public final void onAdFailedToLoad(int i)
    {
        zzaS.c(i);
    }

    public final void onAdLeftApplication()
    {
        zzaS.m();
    }

    public final void onAdLoaded()
    {
    }

    public final void onAdOpened()
    {
        zzaS.k();
    }

    public final void onAppInstallAdLoaded(d d)
    {
        zzaS.a(new <init>(d));
    }

    public final void onContentAdLoaded(e e)
    {
        zzaS.a(new <init>(e));
    }

    public (AbstractAdViewAdapter abstractadviewadapter, m m1)
    {
        zzaP = abstractadviewadapter;
        zzaS = m1;
    }
}
