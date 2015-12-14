// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.fotoable.ad.StaticFlurryEvent;
import com.fotoable.ads.FotoNativeAbroadIcon;

class gy
    implements AdListener
{

    final gx a;

    gy(gx gx1)
    {
        a = gx1;
        super();
    }

    public void onAdClicked(Ad ad)
    {
        StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.FBNativeIconAD, StaticFlurryEvent.adClicked);
        StaticFlurryEvent.logADClickedEvent(a.b.getContext(), StaticFlurryEvent.FBNativeIconAD_Click);
    }

    public void onAdLoaded(Ad ad)
    {
        a.b.isLoading = false;
        if (a.b.getContext() != null)
        {
            (new Handler(a.b.getContext().getMainLooper())).post(new gz(this));
        }
    }

    public void onError(Ad ad, AdError aderror)
    {
        a.b.isLoading = false;
        if (aderror != null)
        {
            Log.e("TAdbuttonGroup", (new StringBuilder()).append("fbnative icon request error ").append(aderror.getErrorMessage()).toString());
        }
        Log.e("TAdbuttonGroup", "fbnative icon request error");
        StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.FBNativeIconAD, StaticFlurryEvent.adLoadedFailed);
    }
}
