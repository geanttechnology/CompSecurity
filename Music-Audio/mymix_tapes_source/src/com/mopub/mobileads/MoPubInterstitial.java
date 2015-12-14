// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.factories.CustomEventInterstitialAdapterFactory;
import java.util.Map;

// Referenced classes of package com.mopub.mobileads:
//            CustomEventInterstitialAdapter, MoPubErrorCode, MoPubView, AdViewController

public class MoPubInterstitial
    implements CustomEventInterstitialAdapter.CustomEventInterstitialAdapterListener
{
    public static interface InterstitialAdListener
    {

        public abstract void onInterstitialClicked(MoPubInterstitial mopubinterstitial);

        public abstract void onInterstitialDismissed(MoPubInterstitial mopubinterstitial);

        public abstract void onInterstitialFailed(MoPubInterstitial mopubinterstitial, MoPubErrorCode mopuberrorcode);

        public abstract void onInterstitialLoaded(MoPubInterstitial mopubinterstitial);

        public abstract void onInterstitialShown(MoPubInterstitial mopubinterstitial);
    }

    private static final class InterstitialState extends Enum
    {

        private static final InterstitialState $VALUES[];
        public static final InterstitialState CUSTOM_EVENT_AD_READY;
        public static final InterstitialState NOT_READY;

        public static InterstitialState valueOf(String s)
        {
            return (InterstitialState)Enum.valueOf(com/mopub/mobileads/MoPubInterstitial$InterstitialState, s);
        }

        public static InterstitialState[] values()
        {
            return (InterstitialState[])$VALUES.clone();
        }

        boolean isReady()
        {
            return this != NOT_READY;
        }

        static 
        {
            CUSTOM_EVENT_AD_READY = new InterstitialState("CUSTOM_EVENT_AD_READY", 0);
            NOT_READY = new InterstitialState("NOT_READY", 1);
            $VALUES = (new InterstitialState[] {
                CUSTOM_EVENT_AD_READY, NOT_READY
            });
        }

        private InterstitialState(String s, int i)
        {
            super(s, i);
        }
    }

    public class MoPubInterstitialView extends MoPubView
    {

        final MoPubInterstitial this$0;

        protected void adFailed(MoPubErrorCode mopuberrorcode)
        {
            if (mInterstitialAdListener != null)
            {
                mInterstitialAdListener.onInterstitialFailed(MoPubInterstitial.this, mopuberrorcode);
            }
        }

        public AdFormat getAdFormat()
        {
            return AdFormat.INTERSTITIAL;
        }

        protected void loadCustomEvent(String s, Map map)
        {
            if (mAdViewController == null)
            {
                return;
            }
            if (TextUtils.isEmpty(s))
            {
                MoPubLog.d("Couldn't invoke custom event because the server did not specify one.");
                loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
                return;
            }
            if (mCustomEventInterstitialAdapter != null)
            {
                mCustomEventInterstitialAdapter.invalidate();
            }
            MoPubLog.d("Loading custom event interstitial adapter.");
            mCustomEventInterstitialAdapter = CustomEventInterstitialAdapterFactory.create(MoPubInterstitial.this, s, map, mAdViewController.getBroadcastIdentifier(), mAdViewController.getAdReport());
            mCustomEventInterstitialAdapter.setAdapterListener(MoPubInterstitial.this);
            mCustomEventInterstitialAdapter.loadInterstitial();
        }

        protected void trackImpression()
        {
            MoPubLog.d("Tracking impression for interstitial.");
            if (mAdViewController != null)
            {
                mAdViewController.trackImpression();
            }
        }

        public MoPubInterstitialView(Context context)
        {
            this$0 = MoPubInterstitial.this;
            super(context);
            setAutorefreshEnabled(false);
        }
    }


    private Activity mActivity;
    private String mAdUnitId;
    private InterstitialState mCurrentInterstitialState;
    private CustomEventInterstitialAdapter mCustomEventInterstitialAdapter;
    private InterstitialAdListener mInterstitialAdListener;
    private MoPubInterstitialView mInterstitialView;
    private boolean mIsDestroyed;

    public MoPubInterstitial(Activity activity, String s)
    {
        mActivity = activity;
        mAdUnitId = s;
        mInterstitialView = new MoPubInterstitialView(mActivity);
        mInterstitialView.setAdUnitId(mAdUnitId);
        mCurrentInterstitialState = InterstitialState.NOT_READY;
    }

    private void resetCurrentInterstitial()
    {
        mCurrentInterstitialState = InterstitialState.NOT_READY;
        if (mCustomEventInterstitialAdapter != null)
        {
            mCustomEventInterstitialAdapter.invalidate();
            mCustomEventInterstitialAdapter = null;
        }
        mIsDestroyed = false;
    }

    private void showCustomEventInterstitial()
    {
        if (mCustomEventInterstitialAdapter != null)
        {
            mCustomEventInterstitialAdapter.showInterstitial();
        }
    }

    public void destroy()
    {
        mIsDestroyed = true;
        if (mCustomEventInterstitialAdapter != null)
        {
            mCustomEventInterstitialAdapter.invalidate();
            mCustomEventInterstitialAdapter = null;
        }
        mInterstitialView.setBannerAdListener(null);
        mInterstitialView.destroy();
    }

    public void forceRefresh()
    {
        resetCurrentInterstitial();
        mInterstitialView.forceRefresh();
    }

    public Activity getActivity()
    {
        return mActivity;
    }

    Integer getAdTimeoutDelay()
    {
        return mInterstitialView.getAdTimeoutDelay();
    }

    public InterstitialAdListener getInterstitialAdListener()
    {
        return mInterstitialAdListener;
    }

    public String getKeywords()
    {
        return mInterstitialView.getKeywords();
    }

    public Map getLocalExtras()
    {
        return mInterstitialView.getLocalExtras();
    }

    public Location getLocation()
    {
        return mInterstitialView.getLocation();
    }

    MoPubInterstitialView getMoPubInterstitialView()
    {
        return mInterstitialView;
    }

    public boolean getTesting()
    {
        return mInterstitialView.getTesting();
    }

    boolean isDestroyed()
    {
        return mIsDestroyed;
    }

    public boolean isReady()
    {
        return mCurrentInterstitialState.isReady();
    }

    public void load()
    {
        resetCurrentInterstitial();
        mInterstitialView.loadAd();
    }

    public void onCustomEventInterstitialClicked()
    {
        if (!isDestroyed())
        {
            mInterstitialView.registerClick();
            if (mInterstitialAdListener != null)
            {
                mInterstitialAdListener.onInterstitialClicked(this);
                return;
            }
        }
    }

    public void onCustomEventInterstitialDismissed()
    {
        if (!isDestroyed())
        {
            mCurrentInterstitialState = InterstitialState.NOT_READY;
            if (mInterstitialAdListener != null)
            {
                mInterstitialAdListener.onInterstitialDismissed(this);
                return;
            }
        }
    }

    public void onCustomEventInterstitialFailed(MoPubErrorCode mopuberrorcode)
    {
        if (isDestroyed())
        {
            return;
        } else
        {
            mCurrentInterstitialState = InterstitialState.NOT_READY;
            mInterstitialView.loadFailUrl(mopuberrorcode);
            return;
        }
    }

    public void onCustomEventInterstitialLoaded()
    {
        if (!mIsDestroyed)
        {
            mCurrentInterstitialState = InterstitialState.CUSTOM_EVENT_AD_READY;
            if (mInterstitialAdListener != null)
            {
                mInterstitialAdListener.onInterstitialLoaded(this);
                return;
            }
        }
    }

    public void onCustomEventInterstitialShown()
    {
        if (!isDestroyed())
        {
            mInterstitialView.trackImpression();
            if (mInterstitialAdListener != null)
            {
                mInterstitialAdListener.onInterstitialShown(this);
                return;
            }
        }
    }

    public void setInterstitialAdListener(InterstitialAdListener interstitialadlistener)
    {
        mInterstitialAdListener = interstitialadlistener;
    }

    void setInterstitialView(MoPubInterstitialView mopubinterstitialview)
    {
        mInterstitialView = mopubinterstitialview;
    }

    public void setKeywords(String s)
    {
        mInterstitialView.setKeywords(s);
    }

    public void setLocalExtras(Map map)
    {
        mInterstitialView.setLocalExtras(map);
    }

    public void setTesting(boolean flag)
    {
        mInterstitialView.setTesting(flag);
    }

    public boolean show()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$mopub$mobileads$MoPubInterstitial$InterstitialState[];

            static 
            {
                $SwitchMap$com$mopub$mobileads$MoPubInterstitial$InterstitialState = new int[InterstitialState.values().length];
                try
                {
                    $SwitchMap$com$mopub$mobileads$MoPubInterstitial$InterstitialState[InterstitialState.CUSTOM_EVENT_AD_READY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1..SwitchMap.com.mopub.mobileads.MoPubInterstitial.InterstitialState[mCurrentInterstitialState.ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
            showCustomEventInterstitial();
            break;
        }
        return true;
    }



/*
    static CustomEventInterstitialAdapter access$002(MoPubInterstitial mopubinterstitial, CustomEventInterstitialAdapter customeventinterstitialadapter)
    {
        mopubinterstitial.mCustomEventInterstitialAdapter = customeventinterstitialadapter;
        return customeventinterstitialadapter;
    }

*/

}
