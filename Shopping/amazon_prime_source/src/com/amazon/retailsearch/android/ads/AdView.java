// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdSize;
import com.amazon.device.ads.AdTargetingOptions;
import com.amazon.device.ads.AmazonOOActionCode;
import com.amazon.device.ads.AmazonOOAdEvent;
import com.amazon.device.ads.AmazonOOAdLayout;
import com.amazon.device.ads.AmazonOOAdListener;
import com.amazon.device.ads.AmazonOOAdResponse;
import com.amazon.device.ads.DefaultAdListener;
import java.util.Iterator;
import java.util.Set;

public class AdView extends LinearLayout
    implements AmazonOOAdListener
{
    public static interface AdViewListener
    {

        public abstract void onAdFailedToLoad(AdView adview);

        public abstract void onAdLoaded(AdView adview);
    }


    private static final int MAX_PHONE_DISPLAY_WIDTH = 414;
    private static final int PHONE_AD_HEIGHT = 50;
    private static final int PHONE_AD_WIDTH = 320;
    private static final int TABLET_AD_HEIGHT = 90;
    private static final int TABLET_AD_WIDTH = 970;
    private AmazonOOAdLayout adLayout;
    private AdSize adSize;
    private AdViewListener adViewListener;
    private Set asins;
    private final DefaultAdListener defaultAdListener = new DefaultAdListener();
    private int orientation;
    private final ListView parent;

    public AdView(Context context, ListView listview)
    {
        super(context);
        orientation = 0;
        setOrientation(1);
        parent = listview;
    }

    private void determineAdSize()
    {
        if (isTablet())
        {
            adSize = new AdSize(970, 90);
            return;
        } else
        {
            adSize = new AdSize(320, 50);
            return;
        }
    }

    private int determineParentWidth()
    {
        return parent.getWidth() - parent.getListPaddingLeft() - parent.getListPaddingRight();
    }

    private String getAsinString()
    {
        if (asins == null || asins.isEmpty())
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        String s = "";
        boolean flag = false;
        Iterator iterator = asins.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            stringbuilder.append(s).append(s1);
            if (!flag)
            {
                s = ",";
                flag = true;
            }
        } while (true);
        return stringbuilder.toString();
    }

    private boolean isTablet()
    {
        return (getContext().getResources().getConfiguration().screenLayout & 0xf) >= 3;
    }

    private void loadAdLayout()
    {
        String s = getAsinString();
        AdTargetingOptions adtargetingoptions = new AdTargetingOptions();
        if (s != null)
        {
            adtargetingoptions.setAdvancedOption("asins", s);
        }
        adtargetingoptions.setAdvancedOption("pt", "search");
        adtargetingoptions.setAdvancedOption("slot", "btf");
        adLayout.loadAd(adtargetingoptions);
    }

    public int getOrientation()
    {
        return orientation;
    }

    public void init(Set set)
    {
        if (adLayout != null)
        {
            adLayout.destroy();
            removeAllViews();
        }
        asins = set;
        int j = determineParentWidth();
        if (j <= 0)
        {
            if (adViewListener != null)
            {
                adViewListener.onAdFailedToLoad(this);
            }
            return;
        }
        set = new View(getContext());
        set.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.mobile_ad_padding_top)));
        addView(set);
        set = new RelativeLayout(getContext());
        set.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        addView(set);
        determineAdSize();
        adLayout = new AmazonOOAdLayout((Activity)getContext(), adSize);
        int i = j;
        if (adSize.getWidth() == 320)
        {
            adLayout.setMaxWidth(414);
            i = Math.min(getContext().getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.mobile_ad_max_phone_width), j);
        }
        double d = (double)i / (double)adSize.getWidth();
        Object obj = new android.widget.RelativeLayout.LayoutParams(i, (int)Math.ceil((double)adSize.getHeight() * d));
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(14);
        adLayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        adLayout.setListener(this);
        orientation = getContext().getResources().getConfiguration().orientation;
        adLayout.setId(3841);
        set.addView(adLayout);
        loadAdLayout();
        obj = new TextView(getContext());
        ((TextView) (obj)).setText(com.amazon.retailsearch.R.string.advertisement_text);
        ((TextView) (obj)).setTextSize(0, getContext().getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.pc_text_6px));
        j = 0;
        if (parent.getListPaddingRight() == 0)
        {
            j = getContext().getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.mobile_ad_text_padding_right);
        }
        ((TextView) (obj)).setPadding(0, 0, j, getContext().getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.mobile_ad_padding_bottom));
        ((TextView) (obj)).setGravity(5);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(i, -2);
        layoutparams.addRule(13);
        layoutparams.addRule(3, adLayout.getId());
        ((TextView) (obj)).setLayoutParams(layoutparams);
        set.addView(((View) (obj)));
    }

    public void loadAd()
    {
        if (adLayout != null && getContext().getResources().getConfiguration().orientation == orientation)
        {
            loadAdLayout();
            return;
        } else
        {
            init(asins);
            return;
        }
    }

    public void onAdCollapsed(Ad ad)
    {
        defaultAdListener.onAdCollapsed(ad);
    }

    public void onAdDismissed(Ad ad)
    {
        defaultAdListener.onAdDismissed(ad);
    }

    public void onAdEvent(AmazonOOAdEvent amazonooadevent)
    {
    }

    public void onAdExpanded(Ad ad)
    {
        defaultAdListener.onAdExpanded(ad);
    }

    public void onAdFailedToLoad(Ad ad, AdError aderror)
    {
        if (adViewListener != null)
        {
            adViewListener.onAdFailedToLoad(this);
            return;
        } else
        {
            defaultAdListener.onAdFailedToLoad(ad, aderror);
            return;
        }
    }

    public void onAdLoaded(Ad ad, AdProperties adproperties)
    {
        if (adViewListener != null)
        {
            adViewListener.onAdLoaded(this);
        } else
        {
            defaultAdListener.onAdLoaded(ad, adproperties);
        }
        adLayout.requestLayout();
    }

    public AmazonOOActionCode onAdReceived(Ad ad, AmazonOOAdResponse amazonooadresponse)
    {
        return null;
    }

    public void onSpecialUrlClicked(Ad ad, String s)
    {
    }

    public void setListener(AdViewListener adviewlistener)
    {
        adViewListener = adviewlistener;
    }
}
