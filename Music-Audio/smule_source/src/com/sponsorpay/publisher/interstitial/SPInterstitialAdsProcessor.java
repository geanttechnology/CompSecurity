// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.interstitial;

import android.os.AsyncTask;
import com.sponsorpay.mediation.SPMediationAdFormat;
import com.sponsorpay.mediation.SPMediationCoordinator;
import com.sponsorpay.utils.SponsorPayLogger;

// Referenced classes of package com.sponsorpay.publisher.interstitial:
//            SPInterstitialClient, SPInterstitialEvent, SPInterstitialAd

public class SPInterstitialAdsProcessor extends AsyncTask
{

    private static final String TAG = "SPInterstitialAdsProcessor";

    private SPInterstitialAdsProcessor()
    {
    }

    public static void processAds(SPInterstitialAd aspinterstitialad[])
    {
        (new SPInterstitialAdsProcessor()).execute(aspinterstitialad);
    }

    protected transient SPInterstitialAd doInBackground(SPInterstitialAd aspinterstitialad[])
    {
        Thread.currentThread().setName("SPInterstitialAdsProcessor");
        int j = aspinterstitialad.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                SponsorPayLogger.d("SPInterstitialAdsProcessor", "There are no ads available currently.");
                SPInterstitialClient.INSTANCE.fireEvent(null, SPInterstitialEvent.ValidationNoFill);
                return null;
            }
            SPInterstitialAd spinterstitialad = aspinterstitialad[i];
            SponsorPayLogger.d("SPInterstitialAdsProcessor", (new StringBuilder("Processing ad from ")).append(spinterstitialad.getProviderType()).toString());
            if (SPMediationCoordinator.INSTANCE.isNetworkAvailable(spinterstitialad.getProviderType(), SPMediationAdFormat.Interstitial))
            {
                SponsorPayLogger.d("SPInterstitialAdsProcessor", (new StringBuilder(String.valueOf(spinterstitialad.getProviderType()))).append(" is available, proceeding...").toString());
                SPInterstitialClient.INSTANCE.fireEvent(spinterstitialad, SPInterstitialEvent.ValidationRequest);
                if (SPInterstitialClient.INSTANCE.validateAd(spinterstitialad))
                {
                    SponsorPayLogger.d("SPInterstitialAdsProcessor", (new StringBuilder("Ad is available from ")).append(spinterstitialad.getProviderType()).toString());
                    SPInterstitialClient.INSTANCE.fireEvent(spinterstitialad, SPInterstitialEvent.ValidationFill);
                    SPInterstitialClient.INSTANCE.fireEvent(null, SPInterstitialEvent.ValidationFill);
                    return spinterstitialad;
                }
                SponsorPayLogger.d("SPInterstitialAdsProcessor", (new StringBuilder("No ad available from ")).append(spinterstitialad.getProviderType()).toString());
                SPInterstitialClient.INSTANCE.fireEvent(spinterstitialad, SPInterstitialEvent.ValidationNoFill);
            } else
            {
                SponsorPayLogger.d("SPInterstitialAdsProcessor", (new StringBuilder(String.valueOf(spinterstitialad.getProviderType()))).append(" is not integrated").toString());
                SPInterstitialClient.INSTANCE.fireEvent(spinterstitialad, SPInterstitialEvent.NotIntegrated);
            }
            i++;
        } while (true);
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((SPInterstitialAd[])aobj);
    }

    protected void onPostExecute(SPInterstitialAd spinterstitialad)
    {
        SPInterstitialClient.INSTANCE.availableAd(spinterstitialad);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((SPInterstitialAd)obj);
    }
}
