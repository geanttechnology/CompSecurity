// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation;

import android.view.View;
import com.google.android.gms.ads.b.c;
import com.google.android.gms.ads.b.e;
import com.google.android.gms.ads.c.i;

// Referenced classes of package com.google.ads.mediation:
//            AbstractAdViewAdapter

static class setOverrideClickHandling extends i
{

    private final e zzaO;

    public void trackView(View view)
    {
        if (view instanceof c)
        {
            ((c)view).setNativeAd(zzaO);
        }
    }

    public (e e1)
    {
        zzaO = e1;
        setHeadline(e1.b().toString());
        setImages(e1.c());
        setBody(e1.d().toString());
        setLogo(e1.e());
        setCallToAction(e1.f().toString());
        setAdvertiser(e1.g().toString());
        setOverrideImpressionRecording(true);
        setOverrideClickHandling(true);
    }
}
