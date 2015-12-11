// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

// Referenced classes of package com.sponsorpay.publisher.mbe:
//            SPBrandEngageClientStatusListener, SPBrandEngageClient

public class SPBrandEngageActivity extends Activity
    implements SPBrandEngageClientStatusListener
{

    private static int $SWITCH_TABLE$com$sponsorpay$publisher$mbe$SPBrandEngageClientStatusListener$SPBrandEngageClientStatus[];
    private static final String ENGAGMENT_ALREADY_CLOSE_KEY_BUNDLE = "ENGAGMENT_ALREADY_CLOSE";
    private static final String PENDING_CLOSE_KEY_BUNDLE = "PENDING_CLOSE";
    private static final String PLAY_THROUGH_MEDIATION_KEY_BUNDLE = "PLAY_THROUGH_MEDIATION";
    private boolean mEngagementAlreadyClosed;
    private boolean mPendingClose;
    private boolean mPlayThroughMediation;

    static int[] $SWITCH_TABLE$com$sponsorpay$publisher$mbe$SPBrandEngageClientStatusListener$SPBrandEngageClientStatus()
    {
        int ai[] = $SWITCH_TABLE$com$sponsorpay$publisher$mbe$SPBrandEngageClientStatusListener$SPBrandEngageClientStatus;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[SPBrandEngageClientStatusListener.SPBrandEngageClientStatus.values().length];
        try
        {
            ai[SPBrandEngageClientStatusListener.SPBrandEngageClientStatus.CLOSE_ABORTED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            ai[SPBrandEngageClientStatusListener.SPBrandEngageClientStatus.CLOSE_FINISHED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            ai[SPBrandEngageClientStatusListener.SPBrandEngageClientStatus.ERROR.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[SPBrandEngageClientStatusListener.SPBrandEngageClientStatus.PENDING_CLOSE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[SPBrandEngageClientStatusListener.SPBrandEngageClientStatus.STARTED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$com$sponsorpay$publisher$mbe$SPBrandEngageClientStatusListener$SPBrandEngageClientStatus = ai;
        return ai;
    }

    public SPBrandEngageActivity()
    {
        mPendingClose = false;
        mEngagementAlreadyClosed = false;
        mPlayThroughMediation = false;
    }

    private void closeActivity()
    {
        mEngagementAlreadyClosed = true;
        finish();
    }

    private void setResultAndClose(String s)
    {
        Intent intent = new Intent();
        intent.putExtra("ENGAGEMENT_STATUS", s);
        setResult(-1, intent);
        closeActivity();
    }

    public void didChangeStatus(SPBrandEngageClientStatusListener.SPBrandEngageClientStatus spbrandengageclientstatus)
    {
        switch ($SWITCH_TABLE$com$sponsorpay$publisher$mbe$SPBrandEngageClientStatusListener$SPBrandEngageClientStatus()[spbrandengageclientstatus.ordinal()])
        {
        default:
            return;

        case 2: // '\002'
            setResultAndClose("CLOSE_FINISHED");
            return;

        case 3: // '\003'
            setResultAndClose("CLOSE_ABORTED");
            return;

        case 5: // '\005'
            setResultAndClose("ERROR");
            return;

        case 4: // '\004'
            mPendingClose = true;
            return;
        }
    }

    public void didReceiveOffers(boolean flag)
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            mPendingClose = bundle.getBoolean("PENDING_CLOSE");
            mEngagementAlreadyClosed = bundle.getBoolean("ENGAGMENT_ALREADY_CLOSE");
            mPlayThroughMediation = bundle.getBoolean("PLAY_THROUGH_MEDIATION");
        } else
        {
            mPlayThroughMediation = SPBrandEngageClient.INSTANCE.playThroughMediation();
        }
        getWindow().requestFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(128);
        if (!mPlayThroughMediation && android.os.Build.VERSION.SDK_INT == 10)
        {
            setRequestedOrientation(0);
        }
        SPBrandEngageClient.INSTANCE.setStatusListener(this);
        SPBrandEngageClient.INSTANCE.startEngagement(this, mPlayThroughMediation);
    }

    protected void onDestroy()
    {
        SPBrandEngageClient.INSTANCE.setStatusListener(null);
        super.onDestroy();
    }

    protected void onPause()
    {
        super.onPause();
        if (!mPendingClose && !mPlayThroughMediation && !mEngagementAlreadyClosed)
        {
            SPBrandEngageClient.INSTANCE.onPause();
            SPBrandEngageClient.INSTANCE.closeEngagement();
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (mPendingClose)
        {
            SPBrandEngageClient.INSTANCE.closeEngagement();
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("PENDING_CLOSE", mPendingClose);
        bundle.putBoolean("ENGAGMENT_ALREADY_CLOSE", mEngagementAlreadyClosed);
        bundle.putBoolean("PLAY_THROUGH_MEDIATION", mPlayThroughMediation);
    }
}
