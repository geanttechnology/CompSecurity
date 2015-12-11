// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.experimentation.Experiments;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdUtil
{

    public static final AdSize AD_SIZE_INVALID = new AdSize(0, 0);
    public static final AdSize ORDERED_AD_SIZES_LAND[] = {
        new AdSize(364, 97), new AdSize(471, 126), new AdSize(513, 137), new AdSize(578, 154), new AdSize(654, 175), new AdSize(696, 186), new AdSize(752, 201)
    };
    public static final AdSize ORDERED_AD_SIZES_PORT[] = {
        new AdSize(300, 113), new AdSize(340, 128), new AdSize(380, 143), new AdSize(480, 180), new AdSize(540, 203), new AdSize(640, 171), new AdSize(740, 198)
    };
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logDfpAds = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("eBayDfpAds", 3, "Log eBay DoubleClick For Publishers Ads requests");
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logDfpAdsSizes = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("eBayDfpAdsSizes", 3, "Log eBay DoubleClick For Publishers Ads sizes");

    public AdUtil()
    {
    }

    public static Pair adsEnabledForShopSubChannel(boolean flag, String s, EbayContext ebaycontext)
    {
        Object obj1 = null;
        Boolean boolean2 = Boolean.FALSE;
        Object obj = DeviceConfiguration.getAsync();
        Boolean boolean1;
        if (flag)
        {
            flag = ((DeviceConfiguration) (obj)).get(com.ebay.mobile.dcs.Dcs.Ads.B.hpShow20223);
        } else
        {
            flag = ((DeviceConfiguration) (obj)).get(com.ebay.mobile.dcs.Dcs.Ads.B.hpShow20255);
        }
        boolean1 = boolean2;
        obj = obj1;
        if (flag)
        {
            boolean1 = boolean2;
            obj = obj1;
            if (!TextUtils.equals(ChannelEnum.DEALS.name(), s))
            {
                boolean1 = boolean2;
                obj = obj1;
                if (!TextUtils.equals("ALLCATEGORIES", s))
                {
                    obj = Experiments.getAdsTreatment(MyApp.getPrefs().getCurrentSite(), ebaycontext);
                    boolean1 = Boolean.valueOf(com.ebay.mobile.experimentation.Experiments.AdsExperimentDefinition.isActive(((com.ebay.nautilus.domain.net.api.experimentation.Treatment) (obj)), com.ebay.mobile.experimentation.Experiments.AdsExperimentDefinition.AdsPageSource.AdsOnHp));
                }
            }
        }
        return new Pair(boolean1, obj);
    }

    public static int getAdContentWidthDp(Context context, View view)
    {
        int i = 0;
        if (view != null)
        {
            float f = context.getResources().getDisplayMetrics().density;
            i = (int)((float)view.getWidth() / f);
        }
        if (logDfpAds.isLoggable)
        {
            logDfpAds.log((new StringBuilder()).append("getAdContentWidthDp width=").append(i).toString());
        }
        return i;
    }

    public static AdSize getAdSize(Context context, View view)
    {
        AdSize aadsize[];
        int i;
        int j;
        com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo = null;
        DisplayMetrics displaymetrics = context.getResources().getDisplayMetrics();
        StringBuilder stringbuilder;
        boolean flag;
        int k;
        if (displaymetrics.heightPixels > displaymetrics.widthPixels)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            aadsize = ORDERED_AD_SIZES_PORT;
        } else
        {
            aadsize = ORDERED_AD_SIZES_LAND;
        }
        j = getAdContentWidthDp(context, view);
        view = loginfo;
        if (j <= 0) goto _L2; else goto _L1
_L1:
        context = AD_SIZE_INVALID;
        k = aadsize.length;
        i = 0;
_L7:
        view = context;
        if (i >= k) goto _L2; else goto _L3
_L3:
        view = aadsize[i];
        if (view.getWidth() <= j) goto _L5; else goto _L4
_L4:
        view = context;
_L2:
        if (logDfpAds.isLoggable)
        {
            loginfo = logDfpAds;
            stringbuilder = (new StringBuilder()).append("Using ");
            if (flag)
            {
                context = "Portrait";
            } else
            {
                context = "Landscape";
            }
            loginfo.log(stringbuilder.append(context).append(" Ad size definitions.").toString());
            if (view != null)
            {
                break; /* Loop/switch isn't completed */
            }
            logDfpAds.log("getAdSize():  Content width is unknown at this time.");
        }
        return view;
_L5:
        context = view;
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        if (view == AD_SIZE_INVALID)
        {
            logDfpAds.log((new StringBuilder()).append("Content width is too narrow for Ad display.  Need ").append(aadsize[0].getWidth()).append("dp, have ").append(j).append("dp.").toString());
            return view;
        } else
        {
            logDfpAds.log((new StringBuilder()).append("Using AdSize ").append(view).append(" for Content width ").append(j).append("dp.").toString());
            return view;
        }
    }

    public static String getAdUnitId(com.ebay.common.rtm.RtmContent.Ad ad)
    {
label0:
        {
            Object obj = null;
            String s = obj;
            if (ad != null)
            {
                s = obj;
                if (!TextUtils.isEmpty(ad.adUnitId))
                {
                    if (!ad.adUnitId.startsWith("/"))
                    {
                        break label0;
                    }
                    s = ad.adUnitId;
                }
            }
            return s;
        }
        return (new StringBuilder()).append("/").append(ad.adUnitId).toString();
    }

    public static com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder getConfiguredAdRequestBuilder(com.ebay.common.rtm.RtmContent.Ad ad)
    {
        com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder builder = new com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder();
        if (ad != null)
        {
            if (!TextUtils.isEmpty(ad.ppid))
            {
                builder.setPublisherProvidedId(ad.ppid);
            }
            if (ad.parameters != null && !ad.parameters.isEmpty())
            {
                Bundle bundle = new Bundle();
                com.ebay.common.rtm.RtmContent.Parameter parameter;
                for (ad = ad.parameters.iterator(); ad.hasNext(); bundle.putString(parameter.key, parameter.value))
                {
                    parameter = (com.ebay.common.rtm.RtmContent.Parameter)ad.next();
                }

                builder.addNetworkExtras(new AdMobExtras(bundle));
                if (logDfpAds.isLoggable)
                {
                    logDfpAds.log((new StringBuilder()).append("DFP Ad parameters: ").append(bundle).toString());
                    return builder;
                }
            }
        }
        return builder;
    }

    public static void logAdContentSize(Context context, View view)
    {
        if (logDfpAdsSizes.isLoggable)
        {
            context = context.getResources();
            float f = context.getDisplayMetrics().density;
            float f1 = context.getDimensionPixelSize(0x7f090025);
            logDfpAdsSizes.log((new StringBuilder()).append("side margin (pixels): ").append(f1).toString());
            int i = (int)(f1 / f);
            logDfpAdsSizes.log((new StringBuilder()).append("side margin (dip): ").append(i).toString());
            if (view != null)
            {
                int j = view.getWidth();
                logDfpAdsSizes.log((new StringBuilder()).append("content width (pixels): ").append(j).toString());
                j = (int)((float)j / f);
                logDfpAdsSizes.log((new StringBuilder()).append("content width (dip): ").append(j).toString());
            }
        }
    }

    public static void logDeviceDisplayAttributes(Context context)
    {
        if (!logDfpAdsSizes.isLoggable) goto _L2; else goto _L1
_L1:
        float f;
        DisplayMetrics displaymetrics;
        int i;
        context = context.getResources();
        displaymetrics = context.getDisplayMetrics();
        f = displaymetrics.density;
        i = context.getConfiguration().screenLayout;
        displaymetrics.densityDpi;
        JVM INSTR lookupswitch 6: default 96
    //                   120: 322
    //                   160: 329
    //                   213: 336
    //                   240: 315
    //                   320: 343
    //                   480: 350;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L3:
        context = "?????";
_L16:
        i & 0xf;
        JVM INSTR tableswitch 0 4: default 140
    //                   0 357
    //                   1 364
    //                   2 371
    //                   3 378
    //                   4 385;
           goto _L10 _L11 _L12 _L13 _L14 _L15
_L10:
        String s = "?????";
_L17:
        logDfpAdsSizes.log((new StringBuilder()).append("display dpi: ").append(context).toString());
        logDfpAdsSizes.log((new StringBuilder()).append("display dpi multiplier: ").append(f).toString());
        logDfpAdsSizes.log((new StringBuilder()).append("display size (pixels): ").append(displaymetrics.widthPixels).append("x").append(displaymetrics.heightPixels).toString());
        logDfpAdsSizes.log((new StringBuilder()).append("display size (dip): ").append((int)((float)displaymetrics.widthPixels / f)).append("x").append((int)((float)displaymetrics.heightPixels / f)).toString());
        logDfpAdsSizes.log((new StringBuilder()).append("display screen layout: ").append(s).toString());
_L2:
        return;
_L7:
        context = "hdpi";
          goto _L16
_L4:
        context = "ldpi";
          goto _L16
_L5:
        context = "mdpi";
          goto _L16
_L6:
        context = "tvdpi";
          goto _L16
_L8:
        context = "xhdpi";
          goto _L16
_L9:
        context = "xxhdpi";
          goto _L16
_L11:
        s = "undefined";
          goto _L17
_L12:
        s = "small";
          goto _L17
_L13:
        s = "normal";
          goto _L17
_L14:
        s = "large";
          goto _L17
_L15:
        s = "xlarge";
          goto _L17
    }

    private static void populateImageAdView(View view, com.ebay.common.rtm.RtmContent.Ad ad)
    {
        RemoteImageView remoteimageview = (RemoteImageView)view.findViewById(0x7f100576);
        TextView textview = (TextView)view.findViewById(0x7f100577);
        TextView textview1 = (TextView)view.findViewById(0x7f10057a);
        TextView textview2 = (TextView)view.findViewById(0x7f100579);
        TextView textview3 = (TextView)view.findViewById(0x7f10057b);
        if (ad.thumbnailURL != null)
        {
            remoteimageview.setRemoteImageUrl(ad.thumbnailURL.toExternalForm());
        }
        textview.setText(ad.title);
        textview1.setText(ad.formattedPriceString);
        if (!TextUtils.isEmpty(ad.formattedStrikethroughPrice))
        {
            textview2.setPaintFlags(textview2.getPaintFlags() | 0x10);
            textview2.setVisibility(0);
            textview2.setText(ad.formattedStrikethroughPrice);
        }
        textview3.setText(ad.retailerName);
        view.setTag(ad);
    }

    private static void populateTextAdView(View view, com.ebay.common.rtm.RtmContent.Ad ad)
    {
        TextView textview = (TextView)view.findViewById(0x7f100577);
        TextView textview1 = (TextView)view.findViewById(0x7f10061a);
        TextView textview2 = (TextView)view.findViewById(0x7f10061b);
        textview.setText(ad.title);
        textview1.setText(ad.externalLinkName);
        textview2.setText(ad.subTitle);
        view.setTag(ad);
    }

    public static void renderAds(View view, List list, boolean flag, android.view.View.OnClickListener onclicklistener, int i, int j, int k)
    {
        TableLayout tablelayout = (TableLayout)view.findViewById(0x7f100563);
        tablelayout.removeAllViews();
        LayoutInflater layoutinflater = LayoutInflater.from(view.getContext());
        int i1 = list.size();
        int j1 = Math.min(i1, i);
        if (i1 != j)
        {
            i = (int)Math.ceil((double)j / (double)k);
        } else
        {
            i = (int)Math.ceil((double)j / (double)j1);
        }
        k = 0;
        for (j = 0; j < i; j++)
        {
            LinearLayout linearlayout = (LinearLayout)layoutinflater.inflate(0x7f0301ca, (ViewGroup)view, false);
            int l = 0;
            while (l < j1) 
            {
                Object obj;
                if (k < i1)
                {
                    obj = (com.ebay.common.rtm.RtmContent.Ad)list.get(k);
                } else
                {
                    obj = (com.ebay.common.rtm.RtmContent.Ad)list.get(0);
                }
                if (flag)
                {
                    View view1 = layoutinflater.inflate(0x7f0301d5, linearlayout, false);
                    populateImageAdView(view1, ((com.ebay.common.rtm.RtmContent.Ad) (obj)));
                    obj = view1;
                } else
                {
                    View view2 = layoutinflater.inflate(0x7f0301ed, linearlayout, false);
                    populateTextAdView(view2, ((com.ebay.common.rtm.RtmContent.Ad) (obj)));
                    obj = view2;
                }
                if (k < i1)
                {
                    ((View) (obj)).setOnClickListener(onclicklistener);
                } else
                {
                    ((View) (obj)).setVisibility(4);
                }
                linearlayout.addView(((View) (obj)));
                k++;
                l++;
            }
            tablelayout.addView(linearlayout);
        }

        view.setVisibility(0);
    }

}
