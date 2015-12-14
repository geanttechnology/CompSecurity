// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.fotoable.ad.StaticFlurryEvent;
import eg;
import ja;

// Referenced classes of package com.fotoable.ads:
//            FotoNativeAbroadIcon

class a
    implements Runnable
{

    final ja a;
    final FotoNativeAbroadIcon b;

    public void run()
    {
        Looper.prepare();
        try
        {
            FotoNativeAbroadIcon.access$002(b, new Handler());
            if (FotoNativeAbroadIcon.access$100(b) != null)
            {
                FotoNativeAbroadIcon.access$100(b).a = new NativeAd(b.getContext(), FotoNativeAbroadIcon.access$200(b));
                FotoNativeAbroadIcon.access$100(b).a.setAdListener(new AdListener() {

                    final FotoNativeAbroadIcon._cls1 a;

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
                            (new Handler(a.b.getContext().getMainLooper())).post(new Runnable(this) {

                                final _cls1 a;

                                public void run()
                                {
                                    if (a.a.a != null)
                                    {
                                        a.a.a.adIconLoaded(a.a.b);
                                        StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.FBNativeIconAD, StaticFlurryEvent.adLoaded);
                                    }
                                }

            
            {
                a = _pcls1;
                super();
            }
                            });
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

            
            {
                a = FotoNativeAbroadIcon._cls1.this;
                super();
            }
                });
                FotoNativeAbroadIcon.access$100(b).a.loadAd();
                StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.FBNativeIconAD, StaticFlurryEvent.adRequest);
                StaticFlurryEvent.recordNativeAdRequestTimes(b.getContext(), true, false);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        Looper.loop();
    }

    _cls1.a(FotoNativeAbroadIcon fotonativeabroadicon, ja ja)
    {
        b = fotonativeabroadicon;
        a = ja;
        super();
    }
}
