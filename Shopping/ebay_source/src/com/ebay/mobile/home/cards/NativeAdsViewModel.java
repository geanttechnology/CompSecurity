// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.MyApp;
import com.ebay.mobile.ads.NativeAdLoader;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.util.AdUtil;
import com.ebay.nautilus.domain.data.UnifiedStream.KeyValue;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.formats.NativeAd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NativeAdsViewModel extends ViewModel
{
    static final class NativeAdListenerProxy extends AdListener
    {

        private final NativeAdLoader adLoader;
        private final WeakReference viewModelReference;

        public void onAdFailedToLoad(int i)
        {
            NativeAdsViewModel nativeadsviewmodel = (NativeAdsViewModel)viewModelReference.get();
            if (nativeadsviewmodel != null)
            {
                nativeadsviewmodel.adLoadFailed = true;
                if (nativeadsviewmodel.adListener != null)
                {
                    nativeadsviewmodel.adListener.onAdFailedToLoad(i);
                }
                if (AdUtil.logDfpAds.isLoggable)
                {
                    AdUtil.logDfpAds.logAsWarning(String.format("DFP onAdFailedToLoad:  %s", new Object[] {
                        Integer.valueOf(i)
                    }));
                    return;
                }
            }
        }

        public void onAdLoaded()
        {
            NativeAdsViewModel nativeadsviewmodel = (NativeAdsViewModel)viewModelReference.get();
            if (nativeadsviewmodel != null)
            {
                if (adLoader != null)
                {
                    nativeadsviewmodel.nativeAd = adLoader.getNativeAd();
                }
                if (nativeadsviewmodel.adListener != null)
                {
                    nativeadsviewmodel.adListener.onAdLoaded();
                }
                if (AdUtil.logDfpAds.isLoggable)
                {
                    AdUtil.logDfpAds.log("DFP onAdLoaded");
                    return;
                }
            }
        }

        public void onAdOpened()
        {
            NativeAdsViewModel nativeadsviewmodel;
            for (nativeadsviewmodel = (NativeAdsViewModel)viewModelReference.get(); nativeadsviewmodel == null || nativeadsviewmodel.adListener == null;)
            {
                return;
            }

            nativeadsviewmodel.adListener.onAdOpened();
        }

        NativeAdListenerProxy(NativeAdsViewModel nativeadsviewmodel, NativeAdLoader nativeadloader)
        {
            viewModelReference = new WeakReference(nativeadsviewmodel);
            adLoader = nativeadloader;
        }
    }


    private String adID;
    protected AdListener adListener;
    protected boolean adLoadFailed;
    protected NativeAd nativeAd;

    public NativeAdsViewModel(int i, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup contentgroup, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        nativeAd = null;
        adListener = null;
        adLoadFailed = false;
        adID = null;
        onclicklistener = getRtmContentAd(contentgroup);
        if (onclicklistener != null)
        {
            contentgroup = AdUtil.getConfiguredAdRequestBuilder(onclicklistener);
            onclicklistener = new NativeAdLoader(onclicklistener);
            onclicklistener.loadAd(MyApp.getApp().getApplicationContext(), contentgroup.build(), new NativeAdListenerProxy(this, onclicklistener));
        }
    }

    private com.ebay.common.rtm.RtmContent.Ad getRtmContentAd(com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup contentgroup)
    {
        Object obj = null;
        com.ebay.common.rtm.RtmContent.Ad ad = obj;
        if (contentgroup != null)
        {
            ad = obj;
            if (contentgroup.contents != null)
            {
                ad = obj;
                if (!contentgroup.contents.isEmpty())
                {
                    ad = null;
                    com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm rtm = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)contentgroup.contents.get(0)).rtm;
                    contentgroup = ad;
                    if (rtm != null)
                    {
                        contentgroup = ad;
                        if (rtm.adsCampaign != null)
                        {
                            contentgroup = ad;
                            if (rtm.adsCampaign.ads != null)
                            {
                                contentgroup = ad;
                                if (!rtm.adsCampaign.ads.isEmpty())
                                {
                                    contentgroup = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmAd)rtm.adsCampaign.ads.get(0);
                                }
                            }
                        }
                    }
                    ad = obj;
                    if (contentgroup != null)
                    {
                        ad = obj;
                        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmAd) (contentgroup)).details != null)
                        {
                            ad = obj;
                            if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmAd) (contentgroup)).details.googleDfpCampaign != null)
                            {
                                Object obj1 = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmAd) (contentgroup)).details.googleDfpCampaign;
                                ad = new com.ebay.common.rtm.RtmContent.Ad();
                                ad.adUnitId = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmAd.Details.GoogleDfpCampaign) (obj1)).adUnitId;
                                ad.ppid = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmAd.Details.GoogleDfpCampaign) (obj1)).ppid;
                                ad.adSizeHeight = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmAd.Details.GoogleDfpCampaign) (obj1)).adSizeHeight;
                                ad.adSizeWidth = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmAd.Details.GoogleDfpCampaign) (obj1)).adSizeWidth;
                                if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmAd.Details.GoogleDfpCampaign) (obj1)).parameters != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmAd.Details.GoogleDfpCampaign) (obj1)).parameters.parameters != null)
                                {
                                    contentgroup = new ArrayList(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmAd.Details.GoogleDfpCampaign) (obj1)).parameters.parameters.size());
                                    com.ebay.common.rtm.RtmContent.Parameter parameter;
                                    for (obj1 = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmAd.Details.GoogleDfpCampaign) (obj1)).parameters.parameters.iterator(); ((Iterator) (obj1)).hasNext(); contentgroup.add(parameter))
                                    {
                                        KeyValue keyvalue = (KeyValue)((Iterator) (obj1)).next();
                                        parameter = new com.ebay.common.rtm.RtmContent.Parameter();
                                        parameter.key = keyvalue.key;
                                        parameter.value = keyvalue.value;
                                    }

                                    ad.parameters = contentgroup;
                                }
                                adID = AdUtil.getAdUnitId(ad);
                            }
                        }
                    }
                }
            }
        }
        return ad;
    }

    public String getAdID()
    {
        return adID;
    }

    public NativeAd getNativeAd()
    {
        return nativeAd;
    }

    public boolean hasContentChanged(NativeAd nativead)
    {
        return nativeAd != null && nativeAd != nativead || adLoadFailed;
    }

    public void setListener(AdListener adlistener)
    {
        adListener = adlistener;
    }
}
