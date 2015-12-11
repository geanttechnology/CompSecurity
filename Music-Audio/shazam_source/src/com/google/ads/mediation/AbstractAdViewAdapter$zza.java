// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation;

import android.view.View;
import com.google.android.gms.ads.b.c;
import com.google.android.gms.ads.b.d;
import com.google.android.gms.ads.c.h;

// Referenced classes of package com.google.ads.mediation:
//            AbstractAdViewAdapter

static class setOverrideClickHandling extends h
{

    private final d zzaN;

    public void trackView(View view)
    {
        if (view instanceof c)
        {
            ((c)view).setNativeAd(zzaN);
        }
    }

    public (d d1)
    {
        zzaN = d1;
        setHeadline(d1.b().toString());
        setImages(d1.c());
        setBody(d1.d().toString());
        setIcon(d1.e());
        setCallToAction(d1.f().toString());
        setStarRating(d1.g().doubleValue());
        setStore(d1.h().toString());
        setPrice(d1.i().toString());
        setOverrideImpressionRecording(true);
        setOverrideClickHandling(true);
    }
}
