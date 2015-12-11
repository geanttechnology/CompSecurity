// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.ebay.mobile.ads.NativeAdLoader;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.formats.NativeAd;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.home.cards:
//            NativeAdsViewModel

public class NativeAdsViewHolder extends ViewHolder
{
    static final class NativeAdListener extends AdListener
    {

        private final WeakReference viewHolderReference;

        public void onAdFailedToLoad(int i)
        {
            NativeAdsViewHolder nativeadsviewholder = (NativeAdsViewHolder)viewHolderReference.get();
            if (nativeadsviewholder == null)
            {
                return;
            } else
            {
                nativeadsviewholder.removeAd();
                return;
            }
        }

        public void onAdLoaded()
        {
            NativeAdsViewHolder nativeadsviewholder = (NativeAdsViewHolder)viewHolderReference.get();
            if (nativeadsviewholder == null)
            {
                return;
            } else
            {
                nativeadsviewholder.removeAd();
                nativeadsviewholder.bind(nativeadsviewholder.access$000);
                return;
            }
        }

        public void onAdOpened()
        {
            NativeAdsViewHolder nativeadsviewholder = (NativeAdsViewHolder)viewHolderReference.get();
            if (nativeadsviewholder != null && nativeadsviewholder.access$000 != null)
            {
                ViewModel viewmodel = nativeadsviewholder.access$000;
                com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener = viewmodel.listener;
                if (onclicklistener != null)
                {
                    onclicklistener.onClick(nativeadsviewholder.itemView, viewmodel);
                    return;
                }
            }
        }

        NativeAdListener(NativeAdsViewHolder nativeadsviewholder)
        {
            viewHolderReference = new WeakReference(nativeadsviewholder);
        }
    }


    private final FrameLayout adContainer;
    private AdListener adListener;
    private NativeAd currentNativeAd;
    private CardView homeAdCardView;
    private int parentViewWidth;

    public NativeAdsViewHolder(View view)
    {
        super(view);
        homeAdCardView = null;
        currentNativeAd = null;
        parentViewWidth = 0;
        adContainer = (FrameLayout)view.findViewById(0x7f100283);
    }

    private void addNativeAdView()
    {
        if (homeAdCardView == null && (model instanceof NativeAdsViewModel))
        {
            currentNativeAd = ((NativeAdsViewModel)model).getNativeAd();
            if (currentNativeAd != null)
            {
                Object obj = itemView.getContext();
                homeAdCardView = (CardView)((LayoutInflater)((Context) (obj)).getSystemService("layout_inflater")).inflate(0x7f03017d, adContainer, false);
                obj = NativeAdLoader.getAdView(((Context) (obj)), parentViewWidth, homeAdCardView, currentNativeAd);
                if (obj != null)
                {
                    homeAdCardView.addView(((View) (obj)));
                    adContainer.addView(homeAdCardView);
                    obj = new TrackingData("RTMImpression", TrackingType.PAGE_IMPRESSION);
                    ((TrackingData) (obj)).addKeyValuePair("adid", ((NativeAdsViewModel)model).getAdID());
                    ((TrackingData) (obj)).send(itemView.getContext(), null);
                    return;
                } else
                {
                    homeAdCardView = null;
                    return;
                }
            }
        }
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (viewmodel instanceof NativeAdsViewModel)
        {
            if (adListener == null)
            {
                adListener = new NativeAdListener(this);
            }
            viewmodel = (NativeAdsViewModel)viewmodel;
            viewmodel.setListener(adListener);
            if (viewmodel.hasContentChanged(currentNativeAd))
            {
                removeAd();
            }
        }
        if (adContainer.getWidth() == 0)
        {
            return;
        } else
        {
            addNativeAdView();
            return;
        }
    }

    public void doInitialViewAdd(int i)
    {
        parentViewWidth = i;
        if (model != null && homeAdCardView == null)
        {
            addNativeAdView();
        }
    }

    protected void removeAd()
    {
        if (homeAdCardView != null)
        {
            adContainer.removeView(homeAdCardView);
            homeAdCardView = null;
        }
        currentNativeAd = null;
    }



}
