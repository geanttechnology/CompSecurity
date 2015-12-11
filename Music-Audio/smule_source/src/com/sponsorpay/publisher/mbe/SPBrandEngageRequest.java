// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe;

import android.app.Activity;
import android.content.Intent;
import com.sponsorpay.credentials.SPCredentials;
import com.sponsorpay.utils.SponsorPayLogger;

// Referenced classes of package com.sponsorpay.publisher.mbe:
//            SPBrandEngageClientStatusListener, SPBrandEngageClient, SPBrandEngageActivity, SPBrandEngageRequestListener

public class SPBrandEngageRequest
    implements SPBrandEngageClientStatusListener
{

    private static final String TAG = "SPBrandEngageRequest";
    private Activity mActivity;
    private SPBrandEngageClient mBrandEngageClient;
    private SPCredentials mCredentials;
    private SPBrandEngageRequestListener mListener;

    public SPBrandEngageRequest(SPCredentials spcredentials, Activity activity, SPBrandEngageClient spbrandengageclient, SPBrandEngageRequestListener spbrandengagerequestlistener)
    {
        mCredentials = spcredentials;
        mActivity = activity;
        mBrandEngageClient = spbrandengageclient;
        mListener = spbrandengagerequestlistener;
    }

    private Intent getMBEActivity()
    {
        if (mBrandEngageClient.canStartEngagement())
        {
            return new Intent(mActivity, com/sponsorpay/publisher/mbe/SPBrandEngageActivity);
        } else
        {
            SponsorPayLogger.d("SPBrandEngageRequest", "Undefined error");
            return null;
        }
    }

    public void askForOffers()
    {
        mBrandEngageClient.setStatusListener(this);
        mBrandEngageClient.requestOffers(mCredentials, mActivity);
    }

    public void didChangeStatus(SPBrandEngageClientStatusListener.SPBrandEngageClientStatus spbrandengageclientstatus)
    {
        if (spbrandengageclientstatus == SPBrandEngageClientStatusListener.SPBrandEngageClientStatus.ERROR)
        {
            mListener.onSPBrandEngageError("An error happened while trying to get offers from mBE");
        }
    }

    public void didReceiveOffers(boolean flag)
    {
        if (flag)
        {
            mListener.onSPBrandEngageOffersAvailable(getMBEActivity());
            return;
        } else
        {
            mListener.onSPBrandEngageOffersNotAvailable();
            return;
        }
    }
}
