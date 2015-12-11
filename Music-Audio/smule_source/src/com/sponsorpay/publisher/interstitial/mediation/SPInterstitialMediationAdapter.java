// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.interstitial.mediation;

import android.app.Activity;
import android.content.Context;
import com.sponsorpay.mediation.SPMediationAdapter;
import com.sponsorpay.publisher.interstitial.SPInterstitialAd;
import com.sponsorpay.publisher.interstitial.SPInterstitialClient;
import com.sponsorpay.publisher.interstitial.SPInterstitialEvent;
import java.lang.ref.WeakReference;

public abstract class SPInterstitialMediationAdapter
{

    protected WeakReference mActivityRef;
    private SPInterstitialAd mAd;
    private boolean mAdAvailable;
    protected SPMediationAdapter mAdapter;
    private boolean mHasBeenClicked;

    public SPInterstitialMediationAdapter(SPMediationAdapter spmediationadapter)
    {
        mHasBeenClicked = false;
        mAdapter = spmediationadapter;
    }

    private void fireEvent(SPInterstitialEvent spinterstitialevent)
    {
        fireEvent(spinterstitialevent, null);
    }

    private void fireEvent(SPInterstitialEvent spinterstitialevent, String s)
    {
        if (mAd != null)
        {
            SPInterstitialClient.INSTANCE.fireEvent(mAd, spinterstitialevent, s);
        }
    }

    private boolean isAdAvailable()
    {
        return mAdAvailable;
    }

    private void resetState()
    {
        mHasBeenClicked = false;
        mAdAvailable = false;
    }

    protected abstract void checkForAds(Context context);

    protected void fireClickEvent()
    {
        mHasBeenClicked = true;
        fireEvent(SPInterstitialEvent.ShowClick);
    }

    protected void fireCloseEvent()
    {
        if (!mHasBeenClicked)
        {
            fireEvent(SPInterstitialEvent.ShowClose);
        }
        resetState();
        checkForAds(getActivity());
    }

    protected void fireImpressionEvent()
    {
        fireEvent(SPInterstitialEvent.ShowImpression);
    }

    protected void fireShowErrorEvent(String s)
    {
        resetState();
        fireEvent(SPInterstitialEvent.ShowError, s);
        checkForAds(getActivity());
    }

    protected void fireValidationErrorEvent(String s)
    {
        resetState();
        fireEvent(SPInterstitialEvent.ValidationError, s);
    }

    protected Activity getActivity()
    {
        if (mActivityRef != null)
        {
            return (Activity)mActivityRef.get();
        } else
        {
            return null;
        }
    }

    protected String getName()
    {
        return mAdapter.getName();
    }

    public boolean isAdAvailable(Context context, SPInterstitialAd spinterstitialad)
    {
        if (!isAdAvailable())
        {
            mAd = spinterstitialad;
            checkForAds(context);
            return false;
        } else
        {
            return true;
        }
    }

    protected void setAdAvailable()
    {
        mAdAvailable = true;
    }

    protected abstract boolean show(Activity activity);

    public boolean show(Activity activity, SPInterstitialAd spinterstitialad)
    {
        if (isAdAvailable())
        {
            mHasBeenClicked = false;
            mAd = spinterstitialad;
            mActivityRef = new WeakReference(activity);
            return show(activity);
        } else
        {
            checkForAds(activity);
            return false;
        }
    }
}
