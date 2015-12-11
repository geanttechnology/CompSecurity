// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.interstitial;

import android.os.AsyncTask;
import com.sponsorpay.credentials.SPCredentials;
import com.sponsorpay.utils.SPHttpConnection;
import com.sponsorpay.utils.SponsorPayBaseUrlProvider;
import com.sponsorpay.utils.SponsorPayLogger;
import com.sponsorpay.utils.StringUtils;
import com.sponsorpay.utils.UrlBuilder;

// Referenced classes of package com.sponsorpay.publisher.interstitial:
//            SPInterstitialEvent, SPInterstitialAd

public class SPInterstitialEventDispatcher extends AsyncTask
{

    private static final int SUCCESSFUL_HTTP_STATUS_CODE = 200;
    private static final String TAG = "SPInterstitialEventDispatcher";
    private static final String TRACKERL_URL_KEY = "tracker";
    private static String additionalParamKey[] = {
        "platform", "ad_format", "client", "rewarded"
    };
    private static String additionalParamValues[] = {
        "android", "interstitial", "sdk", "0"
    };

    private SPInterstitialEventDispatcher()
    {
    }

    private static String getBaseUrl()
    {
        return SponsorPayBaseUrlProvider.getBaseUrl("tracker");
    }

    private static UrlBuilder getUrlBuilder(SPCredentials spcredentials, String s, SPInterstitialAd spinterstitialad, SPInterstitialEvent spinterstitialevent)
    {
        spcredentials = UrlBuilder.newBuilder(getBaseUrl(), spcredentials).addKeyValue("request_id", s).addKeyValue("event", spinterstitialevent.toString()).addExtraKeysValues(UrlBuilder.mapKeysToValues(additionalParamKey, additionalParamValues)).addScreenMetrics();
        if (spinterstitialad != null)
        {
            spcredentials.addKeyValue("ad_id", spinterstitialad.getAdId()).addKeyValue("provider_type", spinterstitialad.getProviderType());
        }
        return spcredentials;
    }

    public static void trigger(SPCredentials spcredentials, String s, SPInterstitialAd spinterstitialad, SPInterstitialEvent spinterstitialevent)
    {
        if (spcredentials == null || StringUtils.nullOrEmpty(s) || spinterstitialevent == null)
        {
            SponsorPayLogger.d("SPInterstitialEventDispatcher", "The event cannot be sent, a required field is missing.");
            return;
        }
        if (spinterstitialad != null)
        {
            SponsorPayLogger.d("SPInterstitialEventDispatcher", String.format("Notifiying tracker of event=%s with request_id=%s for ad_id=%s and provider_type=%s ", new Object[] {
                spinterstitialevent, s, spinterstitialad.getAdId(), spinterstitialad.getProviderType()
            }));
        } else
        {
            SponsorPayLogger.d("SPInterstitialEventDispatcher", String.format("Notifiying tracker of event=%s with request_id=%s", new Object[] {
                spinterstitialevent, s
            }));
        }
        (new SPInterstitialEventDispatcher()).execute(new UrlBuilder[] {
            getUrlBuilder(spcredentials, s, spinterstitialad, spinterstitialevent)
        });
    }

    protected transient Boolean doInBackground(UrlBuilder aurlbuilder[])
    {
        boolean flag;
        flag = false;
        Thread.currentThread().setName("SPInterstitialEventDispatcher");
        aurlbuilder = aurlbuilder[0].buildUrl();
        SponsorPayLogger.d("SPInterstitialEventDispatcher", (new StringBuilder("Sending event to ")).append(aurlbuilder).toString());
        if (SPHttpConnection.getConnection(aurlbuilder).open().getResponseCode() == 200)
        {
            flag = true;
        }
        return Boolean.valueOf(flag);
        aurlbuilder;
        SponsorPayLogger.e("SPInterstitialEventDispatcher", (new StringBuilder("An exception occurred when trying to send advertiser callback: ")).append(aurlbuilder).toString());
        return Boolean.valueOf(false);
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((UrlBuilder[])aobj);
    }

}
