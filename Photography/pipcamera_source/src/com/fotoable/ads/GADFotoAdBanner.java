// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.fotoable.ad.FotoAdMediationDB;
import com.fotoable.ad.StaticFlurryEvent;
import com.fotoable.fotovariant.fotoads.FotoAdBanner;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class GADFotoAdBanner extends FotoAdBanner
{

    AdView gadBanner;

    public GADFotoAdBanner(Context context)
    {
        super(context);
        gadBanner = null;
        commonConstruct(context);
    }

    public GADFotoAdBanner(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        gadBanner = null;
        commonConstruct(context);
    }

    public GADFotoAdBanner(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        gadBanner = null;
        commonConstruct(context);
    }

    private void commonConstruct(Context context)
    {
        super.createDefaultBanner();
        String s = FotoAdMediationDB.getAdBannerID(getContext());
        gadBanner = new AdView(context);
        context = new android.widget.FrameLayout.LayoutParams(-1, -1);
        gadBanner.setAdUnitId(s);
        gadBanner.setAdSize(AdSize.BANNER);
        gadBanner.setLayoutParams(context);
        addView(gadBanner, context);
    }

    public void refreshBanner()
    {
        com.google.android.gms.ads.AdRequest adrequest = (new com.google.android.gms.ads.AdRequest.Builder()).build();
        gadBanner.loadAd(adrequest);
        StaticFlurryEvent.logBannerEventWithKV("GADBanner", StaticFlurryEvent.adRequest);
        gadBanner.setAdListener(new AdListener() {

            final GADFotoAdBanner a;

            public void onAdFailedToLoad(int i)
            {
                super.onAdFailedToLoad(i);
                StaticFlurryEvent.logBannerEventWithKV("GADBanner", StaticFlurryEvent.adLoadedFailed);
                Log.d("GADBanner", (new StringBuilder()).append("AdBanner falied.").append(String.valueOf(i)).toString());
            }

            public void onAdLoaded()
            {
                super.onAdLoaded();
                Log.d("GADBanner", "AdBanner loaded.");
                StaticFlurryEvent.logBannerEventWithKV("GADBanner", StaticFlurryEvent.adLoaded);
                if (((StaticFlurryEvent) (a)).adLoadedFailed != null)
                {
                    ((StaticFlurryEvent) (a)).adLoadedFailed.setVisibility(4);
                }
            }

            
            {
                a = GADFotoAdBanner.this;
                super();
            }
        });
    }


}
