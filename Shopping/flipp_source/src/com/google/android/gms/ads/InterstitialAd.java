// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.r;

// Referenced classes of package com.google.android.gms.ads:
//            AdRequest, AdListener

public final class InterstitialAd
{

    private final r ea;

    public InterstitialAd(Context context)
    {
        ea = new r(context);
    }

    public final AdListener getAdListener()
    {
        return ea.a;
    }

    public final String getAdUnitId()
    {
        return ea.c;
    }

    public final boolean isLoaded()
    {
        return ea.a();
    }

    public final void loadAd(AdRequest adrequest)
    {
        ea.a(adrequest.v());
    }

    public final void setAdListener(AdListener adlistener)
    {
        ea.a(adlistener);
    }

    public final void setAdUnitId(String s)
    {
        ea.a(s);
    }

    public final void show()
    {
        ea.b();
    }
}
