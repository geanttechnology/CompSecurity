// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.interstitial;

import android.app.Activity;
import android.content.Intent;
import com.sponsorpay.credentials.SPCredentials;
import com.sponsorpay.mediation.SPMediationCoordinator;
import com.sponsorpay.utils.HostInfo;
import com.sponsorpay.utils.SponsorPayLogger;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package com.sponsorpay.publisher.interstitial:
//            SPInterstitialClientState, SPInterstitialEvent, SPInterstitialRequester, SPInterstitialActivity, 
//            SPInterstitialRequestListener, SPInterstitialEventDispatcher, SPInterstitialAdCloseReason, SPInterstitialAdListener, 
//            SPInterstitialAdsProcessor, SPInterstitialAd

public class SPInterstitialClient
{

    private static int $SWITCH_TABLE$com$sponsorpay$publisher$interstitial$SPInterstitialClientState[];
    private static int $SWITCH_TABLE$com$sponsorpay$publisher$interstitial$SPInterstitialEvent[];
    public static final SPInterstitialClient INSTANCE = new SPInterstitialClient();
    public static final String SP_REQUEST_ID_PARAMETER_KEY = "request_id";
    private static final String TAG = "SPInterstitialClient";
    private Activity mActivity;
    private SPInterstitialAd mAd;
    private SPInterstitialAdListener mAdStateListener;
    private SPCredentials mCredentials;
    private Map mCustomParameters;
    private String mRequestId;
    private SPInterstitialRequestListener mRequestListener;
    private SPInterstitialClientState mState;

    static int[] $SWITCH_TABLE$com$sponsorpay$publisher$interstitial$SPInterstitialClientState()
    {
        int ai[] = $SWITCH_TABLE$com$sponsorpay$publisher$interstitial$SPInterstitialClientState;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[SPInterstitialClientState.values().length];
        try
        {
            ai[SPInterstitialClientState.READY_TO_CHECK_OFFERS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            ai[SPInterstitialClientState.READY_TO_SHOW_OFFERS.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            ai[SPInterstitialClientState.REQUESTING_OFFERS.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[SPInterstitialClientState.SHOWING_OFFERS.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[SPInterstitialClientState.VALIDATING_OFFERS.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$com$sponsorpay$publisher$interstitial$SPInterstitialClientState = ai;
        return ai;
    }

    static int[] $SWITCH_TABLE$com$sponsorpay$publisher$interstitial$SPInterstitialEvent()
    {
        int ai[] = $SWITCH_TABLE$com$sponsorpay$publisher$interstitial$SPInterstitialEvent;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[SPInterstitialEvent.values().length];
        try
        {
            ai[SPInterstitialEvent.NotIntegrated.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            ai[SPInterstitialEvent.ShowClick.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            ai[SPInterstitialEvent.ShowClose.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            ai[SPInterstitialEvent.ShowError.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            ai[SPInterstitialEvent.ShowImpression.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            ai[SPInterstitialEvent.ValidationError.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            ai[SPInterstitialEvent.ValidationFill.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[SPInterstitialEvent.ValidationNoFill.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[SPInterstitialEvent.ValidationRequest.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$com$sponsorpay$publisher$interstitial$SPInterstitialEvent = ai;
        return ai;
    }

    private SPInterstitialClient()
    {
        mState = SPInterstitialClientState.READY_TO_CHECK_OFFERS;
    }

    private boolean canChangeParameters()
    {
        return mState.canChangeParameters();
    }

    private void setState(SPInterstitialClientState spinterstitialclientstate)
    {
        mState = spinterstitialclientstate;
        switch ($SWITCH_TABLE$com$sponsorpay$publisher$interstitial$SPInterstitialClientState()[mState.ordinal()])
        {
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        default:
            return;

        case 1: // '\001'
            mActivity = null;
            break;
        }
    }

    private void startQueryingForAds(SPCredentials spcredentials, Activity activity)
    {
        mAd = null;
        mCredentials = spcredentials;
        mActivity = activity;
        mRequestId = UUID.randomUUID().toString();
        SPInterstitialRequester.requestAds(spcredentials, mRequestId, mCustomParameters);
        setState(SPInterstitialClientState.REQUESTING_OFFERS);
    }

    public void availableAd(SPInterstitialAd spinterstitialad)
    {
        if (spinterstitialad != null)
        {
            mAd = spinterstitialad;
            if (mRequestListener != null)
            {
                mRequestListener.onSPInterstitialAdAvailable(new Intent(mActivity, com/sponsorpay/publisher/interstitial/SPInterstitialActivity));
            }
            setState(SPInterstitialClientState.READY_TO_SHOW_OFFERS);
            return;
        }
        if (mRequestListener != null)
        {
            mRequestListener.onSPInterstitialAdNotAvailable();
        }
        setState(SPInterstitialClientState.READY_TO_CHECK_OFFERS);
    }

    public boolean canRequestAds()
    {
        return mState.canRequestAds();
    }

    public void fireEvent(SPInterstitialAd spinterstitialad, SPInterstitialEvent spinterstitialevent)
    {
        fireEvent(spinterstitialad, spinterstitialevent, null);
    }

    public void fireEvent(SPInterstitialAd spinterstitialad, SPInterstitialEvent spinterstitialevent, String s)
    {
        SPInterstitialEventDispatcher.trigger(mCredentials, mRequestId, spinterstitialad, spinterstitialevent);
        $SWITCH_TABLE$com$sponsorpay$publisher$interstitial$SPInterstitialEvent()[spinterstitialevent.ordinal()];
        JVM INSTR tableswitch 4 8: default 56
    //                   4 111
    //                   5 56
    //                   6 57
    //                   7 84
    //                   8 111;
           goto _L1 _L2 _L1 _L3 _L4 _L2
_L1:
        return;
_L3:
        setState(SPInterstitialClientState.READY_TO_CHECK_OFFERS);
        if (mAdStateListener != null)
        {
            mAdStateListener.onSPInterstitialAdClosed(SPInterstitialAdCloseReason.ReasonUserClickedOnAd);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        setState(SPInterstitialClientState.READY_TO_CHECK_OFFERS);
        if (mAdStateListener != null)
        {
            mAdStateListener.onSPInterstitialAdClosed(SPInterstitialAdCloseReason.ReasonUserClosedAd);
            return;
        }
        if (true) goto _L1; else goto _L2
_L2:
        setState(SPInterstitialClientState.READY_TO_CHECK_OFFERS);
        SponsorPayLogger.d("SPInterstitialClient", (new StringBuilder("An error occurred. Message: ")).append(s).toString());
        if (mAdStateListener != null)
        {
            mAdStateListener.onSPInterstitialAdError(s);
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void processAds(SPInterstitialAd aspinterstitialad[])
    {
        setState(SPInterstitialClientState.VALIDATING_OFFERS);
        SPInterstitialAdsProcessor.processAds(aspinterstitialad);
    }

    public boolean requestAds(SPCredentials spcredentials, Activity activity)
    {
        if (!HostInfo.isDeviceSupported())
        {
            availableAd(null);
            return false;
        }
        if (canRequestAds())
        {
            startQueryingForAds(spcredentials, activity);
            return true;
        } else
        {
            SponsorPayLogger.d("SPInterstitialClient", "SPInterstitialClient cannot request offers at this point. It might be requesting offers right now or an offer might be currently being presented to the user.");
            return false;
        }
    }

    public void setAdStateListener(SPInterstitialAdListener spinterstitialadlistener)
    {
        mAdStateListener = spinterstitialadlistener;
    }

    public boolean setCustomParameters(Map map)
    {
        if (canChangeParameters())
        {
            mCustomParameters = map;
            setState(SPInterstitialClientState.READY_TO_CHECK_OFFERS);
            return true;
        } else
        {
            SponsorPayLogger.d("SPInterstitialClient", "Cannot change custom parameters while a request to the server is going on or an offer is being presented to the user.");
            return false;
        }
    }

    public void setRequestListener(SPInterstitialRequestListener spinterstitialrequestlistener)
    {
        mRequestListener = spinterstitialrequestlistener;
    }

    public boolean showInterstitial(Activity activity)
    {
        if (mState.canShowAds())
        {
            boolean flag = SPMediationCoordinator.INSTANCE.showInterstitial(activity, mAd);
            if (flag)
            {
                if (mAdStateListener != null)
                {
                    mAdStateListener.onSPInterstitialAdShown();
                }
                setState(SPInterstitialClientState.SHOWING_OFFERS);
            }
            return flag;
        } else
        {
            return false;
        }
    }

    public boolean validateAd(SPInterstitialAd spinterstitialad)
    {
        return SPMediationCoordinator.INSTANCE.validateInterstitialNetwork(mActivity, spinterstitialad);
    }

}
