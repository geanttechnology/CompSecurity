// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.ads;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.kernel.net.LogTrackError;
import com.ebay.nautilus.kernel.net.LogTrackManager;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.search.SearchAdView;
import java.util.Locale;

public class GoogleTextAdLoader
{

    private static final String GOOGLE_TEXT_AD_FONT = "sans-serif-light";
    private static final int GOOGLE_TEXT_AD_FONT_SIZE = 13;
    private static final String GOOGLE_TEXT_AD_SEARCH = "search";
    private static final String GOOGLE_TEXT_AD_UNIT_ID_PREFIX = "mobile-app-ebay";
    private static final String GOOGLE_TEXT_AD_VIP = "vip";
    public SearchAdView textAdView;

    public GoogleTextAdLoader()
    {
    }

    private String buildAdUnitId(boolean flag)
    {
        Object obj = EbaySite.getInstanceFromId(MyApp.getCurrentSite());
        StringBuilder stringbuilder;
        if (((EbaySite) (obj)).equals(EbaySite.UK))
        {
            obj = ((EbaySite) (obj)).name.toLowerCase(Locale.US);
        } else
        if (((EbaySite) (obj)).equals(EbaySite.CAFR) || ((EbaySite) (obj)).equals(EbaySite.FRBE) || ((EbaySite) (obj)).equals(EbaySite.NLBE))
        {
            obj = (new StringBuilder()).append(((EbaySite) (obj)).localeCountry.toLowerCase(Locale.US)).append("-").append(((EbaySite) (obj)).localeLanguage.toLowerCase(Locale.US)).toString();
        } else
        {
            obj = EbaySite.getInstanceFromId(MyApp.getCurrentSite()).localeCountry.toLowerCase(Locale.US);
        }
        stringbuilder = (new StringBuilder()).append("mobile-app-ebay-").append(((String) (obj))).append("-");
        if (flag)
        {
            obj = "search";
        } else
        {
            obj = "vip";
        }
        return stringbuilder.append(((String) (obj))).toString();
    }

    public void loadAd(Context context, ViewGroup viewgroup, String s, boolean flag, AdListener adlistener)
    {
        if (context != null && viewgroup != null && !TextUtils.isEmpty(s) && adlistener != null)
        {
            int i = viewgroup.getWidth();
            viewgroup = context.getResources();
            DisplayMetrics displaymetrics = viewgroup.getDisplayMetrics();
            int k = (int)((float)i / ((float)displaymetrics.densityDpi / 160F));
            int j = viewgroup.getDimensionPixelSize(0x7f090143) / (int)displaymetrics.density;
            if (flag)
            {
                i = (viewgroup.getDimensionPixelSize(0x7f0900bd) / (int)displaymetrics.density) * 6;
            } else
            {
                i = j;
            }
            i = k - i;
            j = (int)(42.25D + (double)j);
            if (i >= 0)
            {
                textAdView = new SearchAdView(context);
                textAdView.setAdSize(new AdSize(i, j));
                textAdView.setAdUnitId(buildAdUnitId(flag));
                textAdView.setAdListener(adlistener);
                context = (new com.google.android.gms.ads.search.SearchAdRequest.Builder()).setQuery(s).setBackgroundColor(-1).setAnchorTextColor(viewgroup.getColor(0x7f0d00df)).setHeaderTextColor(viewgroup.getColor(0x7f0d00df)).setHeaderTextSize(13).setFontFace("sans-serif-light").setDescriptionTextColor(viewgroup.getColor(0x7f0d00aa)).build();
                try
                {
                    textAdView.loadAd(context);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context) { }
                if (adlistener != null)
                {
                    adlistener.onAdFailedToLoad(0);
                }
                LogTrackManager.addLogErrorData(new LogTrackError("GoogleTextAds", "loadTextAd", null, null, "Application", "CrashError", context));
                return;
            }
        }
    }
}
