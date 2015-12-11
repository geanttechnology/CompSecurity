// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mobileads;

import android.net.Uri;
import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AmazonOOActionCode;
import com.amazon.device.ads.AmazonOOAdListener;
import com.amazon.device.ads.AmazonOOAdResponse;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.mash.nav.AmazonNavManager;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.mobileads:
//            MobileAdsLayout

class val.adListener
    implements AmazonOOAdListener
{

    final MobileAdsLayout this$0;
    final AmazonOOAdListener val$adListener;

    public void onAdCollapsed(Ad ad)
    {
        if (val$adListener != null)
        {
            val$adListener.onAdCollapsed(ad);
        }
    }

    public void onAdDismissed(Ad ad)
    {
        if (val$adListener != null)
        {
            val$adListener.onAdDismissed(ad);
        }
    }

    public void onAdExpanded(Ad ad)
    {
        if (val$adListener != null)
        {
            val$adListener.onAdExpanded(ad);
        }
    }

    public void onAdFailedToLoad(Ad ad, AdError aderror)
    {
        if (val$adListener != null)
        {
            val$adListener.onAdFailedToLoad(ad, aderror);
        }
        MobileAdsLayout.access$200(MobileAdsLayout.this, MobileAdsLayout.access$100(MobileAdsLayout.this));
        MobileAdsLayout.access$400(MobileAdsLayout.this, MobileAdsLayout.access$300(MobileAdsLayout.this));
    }

    public void onAdLoaded(Ad ad, AdProperties adproperties)
    {
        if (val$adListener != null)
        {
            val$adListener.onAdLoaded(ad, adproperties);
        }
        MobileAdsLayout.access$200(MobileAdsLayout.this, MobileAdsLayout.access$300(MobileAdsLayout.this));
        MobileAdsLayout.access$400(MobileAdsLayout.this, MobileAdsLayout.access$100(MobileAdsLayout.this));
    }

    public AmazonOOActionCode onAdReceived(Ad ad, AmazonOOAdResponse amazonooadresponse)
    {
        if (val$adListener != null)
        {
            return val$adListener.onAdReceived(ad, amazonooadresponse);
        } else
        {
            return AmazonOOActionCode.DISPLAY;
        }
    }

    public void onSpecialUrlClicked(Ad ad, String s)
    {
        ad = Uri.parse(s);
        if ("amazonmobile".equals(ad.getScheme()) && "shopping".equals(ad.getAuthority()))
        {
            if (Util.isEmpty(ad.getQueryParameter("clickstream-tag")))
            {
                ad.buildUpon().QueryParameter("clickstream-tag", ClickStreamTag.ORIGIN_MOBILEADS.getTag()).getTag();
            }
            (new AmazonNavManager()).navigate(s, getContext());
        }
    }

    ()
    {
        this$0 = final_mobileadslayout;
        val$adListener = AmazonOOAdListener.this;
        super();
    }
}
