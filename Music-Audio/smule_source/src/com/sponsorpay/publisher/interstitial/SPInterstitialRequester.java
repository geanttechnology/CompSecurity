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
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.sponsorpay.publisher.interstitial:
//            SPInterstitialAd, SPInterstitialClient

public class SPInterstitialRequester extends AsyncTask
{

    private static final String INTERSTITIAL_URL_KEY = "interstitial";
    private static final String TAG = "SPInterstitialRequester";

    private SPInterstitialRequester()
    {
    }

    private static String getBaseUrl()
    {
        return SponsorPayBaseUrlProvider.getBaseUrl("interstitial");
    }

    public static void requestAds(SPCredentials spcredentials, String s, Map map)
    {
        spcredentials = UrlBuilder.newBuilder(getBaseUrl(), spcredentials).addExtraKeysValues(map).addKeyValue("request_id", s).addScreenMetrics();
        (new SPInterstitialRequester()).execute(new UrlBuilder[] {
            spcredentials
        });
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((UrlBuilder[])aobj);
    }

    protected transient SPInterstitialAd[] doInBackground(UrlBuilder aurlbuilder[])
    {
        LinkedList linkedlist;
        int i;
        i = 0;
        Thread.currentThread().setName("SPInterstitialRequester");
        linkedlist = new LinkedList();
        aurlbuilder = aurlbuilder[0].buildUrl();
        SponsorPayLogger.d("SPInterstitialRequester", (new StringBuilder("Querying URL: ")).append(aurlbuilder).toString());
        aurlbuilder = SPHttpConnection.getConnection(aurlbuilder).open().getBodyContent();
        if (!StringUtils.notNullNorEmpty(aurlbuilder)) goto _L2; else goto _L1
_L1:
        SponsorPayLogger.d("SPInterstitialRequester", (new StringBuilder("Parsing ads reponse\n")).append(aurlbuilder).toString());
        aurlbuilder = (new JSONObject(aurlbuilder)).getJSONArray("ads");
_L4:
        int j = aurlbuilder.length();
        if (i < j) goto _L3; else goto _L2
_L2:
        return (SPInterstitialAd[])linkedlist.toArray(new SPInterstitialAd[linkedlist.size()]);
_L3:
        JSONObject jsonobject = aurlbuilder.getJSONObject(i);
        linkedlist.add(new SPInterstitialAd(jsonobject.getString("provider_type"), jsonobject.getString("ad_id")));
        i++;
          goto _L4
        aurlbuilder;
        try
        {
            SponsorPayLogger.e("SPInterstitialRequester", aurlbuilder.getMessage(), aurlbuilder);
        }
        // Misplaced declaration of an exception variable
        catch (UrlBuilder aurlbuilder[])
        {
            SponsorPayLogger.e("SPInterstitialRequester", aurlbuilder.getMessage(), aurlbuilder);
        }
          goto _L2
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((SPInterstitialAd[])obj);
    }

    protected void onPostExecute(SPInterstitialAd aspinterstitialad[])
    {
        SPInterstitialClient.INSTANCE.processAds(aspinterstitialad);
    }
}
