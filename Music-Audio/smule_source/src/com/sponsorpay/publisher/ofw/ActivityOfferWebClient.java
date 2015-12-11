// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.ofw;

import android.app.Activity;
import android.net.Uri;
import android.webkit.WebView;
import com.sponsorpay.publisher.SponsorPayPublisher;
import com.sponsorpay.utils.SPWebClient;
import com.sponsorpay.utils.SponsorPayLogger;

public class ActivityOfferWebClient extends SPWebClient
{

    private boolean mShouldHostActivityStayOpen;

    public ActivityOfferWebClient(Activity activity, boolean flag)
    {
        super(activity);
        mShouldHostActivityStayOpen = flag;
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        SponsorPayLogger.e(getClass().getSimpleName(), String.format("OfferWall WebView triggered an error. Error code: %d, error description: %s. Failing URL: %s", new Object[] {
            Integer.valueOf(i), s, s1
        }));
        i;
        JVM INSTR lookupswitch 2: default 64
    //                   -7: 77
    //                   -2: 77;
           goto _L1 _L2 _L2
_L1:
        webview = com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.ERROR_LOADING_OFFERWALL;
_L4:
        showDialog(SponsorPayPublisher.getUIString(webview));
        return;
_L2:
        webview = com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.ERROR_LOADING_OFFERWALL_NO_INTERNET_CONNECTION;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onSponsorPayExitScheme(int i, String s)
    {
        Activity activity;
        boolean flag;
        boolean flag1;
        flag1 = true;
        flag = true;
        activity = getHostActivity();
        if (activity != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        activity.setResult(i);
        if (s != null)
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        SponsorPayLogger.i("SPWebClient", (new StringBuilder("Should stay open: ")).append(mShouldHostActivityStayOpen).append(", will close activity: ").append(flag).toString());
        if (flag)
        {
            activity.finish();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        flag = flag1;
        if (mShouldHostActivityStayOpen)
        {
            flag = false;
        }
        if (!launchActivityWithUrl(s))
        {
            return;
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected void onTargetActivityStart(String s)
    {
    }

    protected void processSponsorPayScheme(String s, Uri uri)
    {
    }
}
