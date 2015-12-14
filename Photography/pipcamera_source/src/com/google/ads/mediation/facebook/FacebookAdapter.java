// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.facebook;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import qd;
import qe;

public final class FacebookAdapter
    implements MediationBannerAdapter, MediationInterstitialAdapter
{

    private MediationBannerListener a;
    private MediationInterstitialListener b;
    private AdView c;
    private RelativeLayout d;
    private InterstitialAd e;

    public FacebookAdapter()
    {
    }

    private int a(int i)
    {
        DisplayMetrics displaymetrics = Resources.getSystem().getDisplayMetrics();
        return Math.round((float)i / displaymetrics.density);
    }

    private int a(AdError aderror)
    {
        int i;
        if (aderror != null)
        {
            if ((i = aderror.getErrorCode()) != 2001 && i != 2000)
            {
                if (i == 1000)
                {
                    return 2;
                }
                return i != 1002 ? 3 : 1;
            }
        }
        return 0;
    }

    public static int a(FacebookAdapter facebookadapter, AdError aderror)
    {
        return facebookadapter.a(aderror);
    }

    private com.facebook.ads.AdSize a(Context context, AdSize adsize)
    {
        if (adsize.getWidth() == com.facebook.ads.AdSize.BANNER_320_50.getWidth() && adsize.getHeight() == com.facebook.ads.AdSize.BANNER_320_50.getHeight())
        {
            return com.facebook.ads.AdSize.BANNER_320_50;
        }
        int i = a(adsize.getHeightInPixels(context));
        if (i == com.facebook.ads.AdSize.BANNER_HEIGHT_50.getHeight())
        {
            return com.facebook.ads.AdSize.BANNER_HEIGHT_50;
        }
        if (i == com.facebook.ads.AdSize.BANNER_HEIGHT_90.getHeight())
        {
            return com.facebook.ads.AdSize.BANNER_HEIGHT_90;
        }
        if (i == com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250.getHeight())
        {
            return com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250;
        } else
        {
            return null;
        }
    }

    public static MediationBannerListener a(FacebookAdapter facebookadapter)
    {
        return facebookadapter.a;
    }

    private void a(MediationAdRequest mediationadrequest)
    {
        boolean flag = true;
        if (mediationadrequest != null)
        {
            if (mediationadrequest.taggedForChildDirectedTreatment() != 1)
            {
                flag = false;
            }
            AdSettings.setIsChildDirected(flag);
        }
    }

    public static MediationInterstitialListener b(FacebookAdapter facebookadapter)
    {
        return facebookadapter.b;
    }

    public View getBannerView()
    {
        return d;
    }

    public void onDestroy()
    {
        if (c != null)
        {
            c.destroy();
        }
        if (e != null)
        {
            e.destroy();
        }
    }

    public void onPause()
    {
    }

    public void onResume()
    {
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationbannerlistener, Bundle bundle, AdSize adsize, MediationAdRequest mediationadrequest, Bundle bundle1)
    {
        if (context == null || bundle == null || adsize == null)
        {
            return;
        }
        a = mediationbannerlistener;
        mediationbannerlistener = bundle.getString("pubid");
        if (mediationbannerlistener == null)
        {
            Log.w("FacebookAdapter", "Fail to request banner Ad, placementId is null");
            a.onAdFailedToLoad(this, 0);
            return;
        }
        bundle = a(context, adsize);
        if (bundle == null)
        {
            Log.w("FacebookAdapter", (new StringBuilder("The input ad size ")).append(adsize.toString()).append(" is not supported at this moment.").toString());
            a.onAdFailedToLoad(this, 3);
            return;
        } else
        {
            c = new AdView(context, mediationbannerlistener, bundle);
            c.setAdListener(new qd(this, null));
            a(mediationadrequest);
            mediationbannerlistener = new android.widget.RelativeLayout.LayoutParams(adsize.getWidthInPixels(context), adsize.getHeightInPixels(context));
            d = new RelativeLayout(context);
            d.setLayoutParams(mediationbannerlistener);
            d.addView(c);
            c.loadAd();
            return;
        }
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationinterstitiallistener, Bundle bundle, MediationAdRequest mediationadrequest, Bundle bundle1)
    {
        if (context == null || bundle == null)
        {
            return;
        }
        b = mediationinterstitiallistener;
        mediationinterstitiallistener = bundle.getString("pubid");
        if (mediationinterstitiallistener == null)
        {
            Log.w("FacebookAdapter", "Fail to request interstitial Ad, placementId is null");
            b.onAdFailedToLoad(this, 0);
            return;
        } else
        {
            e = new InterstitialAd(context, mediationinterstitiallistener);
            e.setAdListener(new qe(this, null));
            a(mediationadrequest);
            e.loadAd();
            return;
        }
    }

    public void showInterstitial()
    {
        if (e.isAdLoaded())
        {
            e.show();
        }
    }
}
