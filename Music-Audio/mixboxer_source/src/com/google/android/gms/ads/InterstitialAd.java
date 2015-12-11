// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.ah;

// Referenced classes of package com.google.android.gms.ads:
//            AdRequest, AdListener

public final class InterstitialAd
{

    private final ah ea;

    public InterstitialAd(Context context)
    {
        ea = new ah(context);
    }

    public AdListener getAdListener()
    {
        return ea.getAdListener();
    }

    public String getAdUnitId()
    {
        return ea.getAdUnitId();
    }

    public boolean isLoaded()
    {
        return ea.isLoaded();
    }

    public void loadAd(AdRequest adrequest)
    {
        ea.a(adrequest.v());
    }

    public void setAdListener(AdListener adlistener)
    {
        ea.setAdListener(adlistener);
    }

    public void setAdUnitId(String s)
    {
        ea.setAdUnitId(s);
    }

    public void show()
    {
        ea.show();
    }
}
