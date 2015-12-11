// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.interstitial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package com.sponsorpay.publisher.interstitial:
//            SPInterstitialAdListener, SPInterstitialClient, SPInterstitialAdCloseReason

public class SPInterstitialActivity extends Activity
    implements SPInterstitialAdListener
{

    public static final String SP_AD_STATUS = "AD_STATUS";
    public static final String SP_ERROR_MESSAGE = "ERROR_MESSAGE";

    public SPInterstitialActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        SPInterstitialClient.INSTANCE.setAdStateListener(this);
        SPInterstitialClient.INSTANCE.showInterstitial(this);
    }

    public void onSPInterstitialAdClosed(SPInterstitialAdCloseReason spinterstitialadclosereason)
    {
        Intent intent = new Intent();
        intent.putExtra("AD_STATUS", spinterstitialadclosereason);
        setResult(-1, intent);
        finish();
    }

    public void onSPInterstitialAdError(String s)
    {
        Intent intent = new Intent();
        intent.putExtra("AD_STATUS", SPInterstitialAdCloseReason.ReasonError);
        intent.putExtra("ERROR_MESSAGE", s);
        setResult(-1, intent);
        finish();
    }

    public void onSPInterstitialAdShown()
    {
    }
}
