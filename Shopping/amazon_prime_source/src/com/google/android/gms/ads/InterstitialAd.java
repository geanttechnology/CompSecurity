// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.au;

// Referenced classes of package com.google.android.gms.ads:
//            AdRequest, AdListener

public final class InterstitialAd
{

    private final au kv;

    public InterstitialAd(Context context)
    {
        kv = new au(context);
    }

    public void loadAd(AdRequest adrequest)
    {
        kv.a(adrequest.O());
    }

    public void setAdListener(AdListener adlistener)
    {
        kv.setAdListener(adlistener);
    }

    public void setAdUnitId(String s)
    {
        kv.setAdUnitId(s);
    }

    public void show()
    {
        kv.show();
    }
}
