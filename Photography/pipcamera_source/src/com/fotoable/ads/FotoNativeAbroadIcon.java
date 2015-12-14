// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.fotoable.ad.NativeAdWrapper;
import com.fotoable.ad.StaticFlurryEvent;
import com.fotoable.fotovariant.nativeAds.FotoNativeIcon;
import eg;
import ja;

public class FotoNativeAbroadIcon extends FotoNativeIcon
{

    private Handler mThreadKillerHandler;
    private String madID;
    private eg nativeAbroadItem;

    public FotoNativeAbroadIcon(Context context)
    {
        super(context);
        nativeAbroadItem = null;
        madID = null;
        mThreadKillerHandler = null;
    }

    public FotoNativeAbroadIcon(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        nativeAbroadItem = null;
        madID = null;
        mThreadKillerHandler = null;
    }

    public FotoNativeAbroadIcon(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        nativeAbroadItem = null;
        madID = null;
        mThreadKillerHandler = null;
    }

    private void initNativeAd(String s)
    {
        madID = s;
        if (nativeAbroadItem == null)
        {
            nativeAbroadItem = new eg();
        }
        if (nativeItem == null)
        {
            nativeItem = nativeAbroadItem;
        }
    }

    public void destroyNativeIcon()
    {
        if (mThreadKillerHandler != null)
        {
            mThreadKillerHandler.getLooper().quit();
        }
    }

    public void loadNativeAd(String s, ja ja1)
    {
        if (!isLoading)
        {
            isLoading = true;
            if (NativeAdWrapper.needFBNativeIcon(getContext()))
            {
                try
                {
                    initNativeAd(s);
                    (new Thread(new Runnable(ja1) {

                        final ja a;
                        final FotoNativeAbroadIcon b;

                        public void run()
                        {
                            Looper.prepare();
                            try
                            {
                                b.mThreadKillerHandler = new Handler();
                                if (b.nativeAbroadItem != null)
                                {
                                    b.nativeAbroadItem.a = new NativeAd(b.getContext(), b.madID);
                                    b.nativeAbroadItem.a.setAdListener(new AdListener(this) {

                                        final _cls1 a;

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
                a = _pcls1;
                super();
            }
                                    });
                                    b.nativeAbroadItem.a.loadAd();
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

            
            {
                b = FotoNativeAbroadIcon.this;
                a = ja1;
                super();
            }
                    })).start();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    isLoading = false;
                }
                s.printStackTrace();
                mThreadKillerHandler.getLooper().quit();
                return;
            }
            isLoading = false;
            if (ja1 != null)
            {
                ja1.adIconFailed();
                return;
            }
        }
    }

    public void registImpression()
    {
    }


/*
    static Handler access$002(FotoNativeAbroadIcon fotonativeabroadicon, Handler handler)
    {
        fotonativeabroadicon.mThreadKillerHandler = handler;
        return handler;
    }

*/


}
