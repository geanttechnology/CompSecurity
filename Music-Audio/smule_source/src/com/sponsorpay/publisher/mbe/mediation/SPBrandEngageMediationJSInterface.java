// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe.mediation;

import android.webkit.WebView;
import com.sponsorpay.utils.SponsorPayLogger;
import com.sponsorpay.utils.StringUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class SPBrandEngageMediationJSInterface
{

    private static final String SP_GET_OFFERS = "Sponsorpay.MBE.SDKInterface.do_getOffer()";
    private static final String SP_TPN_JSON_KEY = "uses_tpn";
    private static final String TAG = "SPBrandEngageMediationJSInterface";
    private final String interfaceName = "SynchJS";
    private CountDownLatch latch;
    private String returnValue;

    public SPBrandEngageMediationJSInterface()
    {
        latch = null;
    }

    private String getJSValue(WebView webview, String s)
    {
        if (webview == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        latch = new CountDownLatch(1);
        webview.loadUrl((new StringBuilder("javascript:window.SynchJS.setValue((function(){try{return ")).append(s).append("+\"\";}catch(js_eval_err){return '';}})());").toString());
        latch.await(1L, TimeUnit.SECONDS);
        webview = returnValue;
        return webview;
        webview;
        SponsorPayLogger.e("SPBrandEngageMediationJSInterface", "Interrupted", webview);
        return null;
    }

    public String getInterfaceName()
    {
        return "SynchJS";
    }

    public boolean playThroughTirdParty(WebView webview)
    {
        webview = getJSValue(webview, "Sponsorpay.MBE.SDKInterface.do_getOffer()");
        if (!StringUtils.notNullNorEmpty(webview))
        {
            break MISSING_BLOCK_LABEL_42;
        }
        boolean flag = (new JSONObject(webview)).getBoolean("uses_tpn");
        return flag;
        webview;
        SponsorPayLogger.e("SPBrandEngageMediationJSInterface", webview.getLocalizedMessage(), webview);
        return false;
    }

    public void setValue(String s)
    {
        returnValue = s;
        try
        {
            latch.countDown();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }
}
