// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import java.lang.ref.WeakReference;
import java.util.Map;

// Referenced classes of package com.inmobi.ads:
//            p, i, n, InMobiAdRequestStatus

public final class InMobiInterstitial
{
    public static interface InterstitialAdListener
    {

        public abstract void onAdDismissed(InMobiInterstitial inmobiinterstitial);

        public abstract void onAdDisplayed(InMobiInterstitial inmobiinterstitial);

        public abstract void onAdInteraction(InMobiInterstitial inmobiinterstitial, Map map);

        public abstract void onAdLoadFailed(InMobiInterstitial inmobiinterstitial, InMobiAdRequestStatus inmobiadrequeststatus);

        public abstract void onAdLoadSucceeded(InMobiInterstitial inmobiinterstitial);

        public abstract void onAdRewardActionCompleted(InMobiInterstitial inmobiinterstitial, Map map);

        public abstract void onUserLeftApplication(InMobiInterstitial inmobiinterstitial);
    }

    private static final class a extends Handler
    {

        private WeakReference a;
        private WeakReference b;
        private boolean c;

        public void a()
        {
            c = false;
        }

        public void handleMessage(Message message)
        {
            Map map;
            Object obj;
            InMobiInterstitial inmobiinterstitial;
            InterstitialAdListener interstitialadlistener;
            obj = null;
            map = null;
            inmobiinterstitial = (InMobiInterstitial)b.get();
            interstitialadlistener = (InterstitialAdListener)a.get();
            if (inmobiinterstitial == null || interstitialadlistener == null) goto _L2; else goto _L1
_L1:
            message.what;
            JVM INSTR tableswitch 1 7: default 84
        //                       1 96
        //                       2 118
        //                       3 135
        //                       4 145
        //                       5 155
        //                       6 181
        //                       7 191;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L5:
            break MISSING_BLOCK_LABEL_118;
_L6:
            break MISSING_BLOCK_LABEL_135;
_L7:
            break MISSING_BLOCK_LABEL_145;
_L8:
            break MISSING_BLOCK_LABEL_155;
_L9:
            break MISSING_BLOCK_LABEL_181;
_L10:
            break MISSING_BLOCK_LABEL_191;
_L3:
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, InMobiInterstitial.TAG, "Unhandled ad lifecycle event! Ignoring ...");
_L2:
            return;
_L4:
            if (c) goto _L2; else goto _L11
_L11:
            c = true;
            interstitialadlistener.onAdLoadSucceeded(inmobiinterstitial);
            return;
            interstitialadlistener.onAdLoadFailed(inmobiinterstitial, (InMobiAdRequestStatus)message.obj);
            return;
            interstitialadlistener.onAdDisplayed(inmobiinterstitial);
            return;
            interstitialadlistener.onAdDismissed(inmobiinterstitial);
            return;
            if (message.obj != null)
            {
                map = (Map)message.obj;
            }
            interstitialadlistener.onAdInteraction(inmobiinterstitial, map);
            return;
            interstitialadlistener.onUserLeftApplication(inmobiinterstitial);
            return;
            Map map1 = obj;
            if (message.obj != null)
            {
                map1 = (Map)message.obj;
            }
            interstitialadlistener.onAdRewardActionCompleted(inmobiinterstitial, map1);
            return;
        }

        public a(InMobiInterstitial inmobiinterstitial, InterstitialAdListener interstitialadlistener)
        {
            super(Looper.getMainLooper());
            c = false;
            b = new WeakReference(inmobiinterstitial);
            a = new WeakReference(interstitialadlistener);
        }
    }


    private static final String TAG = com/inmobi/ads/InMobiInterstitial.getSimpleName();
    private a mClientCallbackHandler;
    private Context mContext;
    private Map mExtras;
    private final AdUnit.a mInterstitialAdListener = new AdUnit.a() {

        final InMobiInterstitial a;

        public void a()
        {
            a.mClientCallbackHandler.sendEmptyMessage(1);
        }

        public void a(InMobiAdRequestStatus inmobiadrequeststatus)
        {
            Message message = Message.obtain();
            message.what = 2;
            message.obj = inmobiadrequeststatus;
            a.mClientCallbackHandler.sendMessage(message);
        }

        public void a(Map map)
        {
            Message message = Message.obtain();
            message.what = 5;
            message.obj = map;
            a.mClientCallbackHandler.sendMessage(message);
        }

        public void b()
        {
            a.mClientCallbackHandler.sendEmptyMessage(3);
        }

        public void b(Map map)
        {
            Message message = Message.obtain();
            message.what = 7;
            message.obj = map;
            a.mClientCallbackHandler.sendMessage(message);
        }

        public void c()
        {
            com.inmobi.ads.i.a().b(a.getPlacementObj());
            a.mClientCallbackHandler.sendEmptyMessage(4);
        }

        public void d()
        {
            a.mClientCallbackHandler.sendEmptyMessage(6);
        }

            
            {
                a = InMobiInterstitial.this;
                super();
            }
    };
    private n mInterstitialAdUnit;
    private boolean mIsHardwareAccelerationDisabled;
    private boolean mIsInitialized;
    private String mKeywords;
    private InterstitialAdListener mListener;
    private long mPlacementId;

    public InMobiInterstitial(Context context, long l, InterstitialAdListener interstitialadlistener)
    {
        mIsInitialized = false;
        if (!com.inmobi.commons.a.a.a())
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "Please initialize the SDK before trying to create an ad.");
            return;
        }
        if (interstitialadlistener == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "The Ad unit cannot be created as no event listener was supplied. Please attach a listener to proceed");
            return;
        }
        if (context == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "Unable to create ad unit with NULL context object.");
            return;
        } else
        {
            mIsInitialized = true;
            mContext = context;
            mPlacementId = l;
            mListener = interstitialadlistener;
            mClientCallbackHandler = new a(this, mListener);
            return;
        }
    }

    private p getPlacementObj()
    {
        p p1 = new p(mPlacementId, com.inmobi.ads.i.a(mExtras));
        p1.a(mKeywords);
        p1.a(mExtras);
        return p1;
    }

    private void setupAdUnit()
    {
        mInterstitialAdUnit.a(mExtras);
        mInterstitialAdUnit.a(mKeywords);
        if (mIsHardwareAccelerationDisabled)
        {
            mInterstitialAdUnit.A();
        }
    }

    public void disableHardwareAcceleration()
    {
        if (mIsInitialized)
        {
            mIsHardwareAccelerationDisabled = true;
        }
    }

    public boolean isReady()
    {
        if (!mIsInitialized || mInterstitialAdUnit == null)
        {
            return false;
        } else
        {
            return mInterstitialAdUnit.z();
        }
    }

    public void load()
    {
label0:
        {
            if (mIsInitialized)
            {
                AdUnit adunit = com.inmobi.ads.i.a().a(getPlacementObj());
                mClientCallbackHandler.a();
                if (adunit == null)
                {
                    break label0;
                }
                mInterstitialAdUnit = (n)adunit;
                mInterstitialAdUnit.a(mInterstitialAdListener);
                setupAdUnit();
                if (mInterstitialAdUnit.g() == AdUnit.AdState.STATE_READY)
                {
                    mInterstitialAdListener.a();
                }
            }
            return;
        }
        mInterstitialAdUnit = new n(mContext, mPlacementId, mInterstitialAdListener);
        setupAdUnit();
        mInterstitialAdUnit.o();
    }

    public void setExtras(Map map)
    {
        if (mIsInitialized)
        {
            mExtras = map;
        }
    }

    public void setKeywords(String s)
    {
        if (mIsInitialized)
        {
            mKeywords = s;
        }
    }

    public void show()
    {
        if (mIsInitialized && mInterstitialAdUnit != null)
        {
            mInterstitialAdUnit.x();
        }
    }

    public void show(int j, int k)
    {
        if (mIsInitialized && mInterstitialAdUnit != null)
        {
            mInterstitialAdUnit.a(j, k);
        }
    }




}
