// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.common.view.ViewModel;
import com.google.android.gms.ads.AdListener;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.home.cards:
//            NativeAdsViewHolder

static final class viewHolderReference extends AdListener
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
            nativeadsviewholder.bind(NativeAdsViewHolder.access$200(nativeadsviewholder));
            return;
        }
    }

    public void onAdOpened()
    {
        NativeAdsViewHolder nativeadsviewholder = (NativeAdsViewHolder)viewHolderReference.get();
        if (nativeadsviewholder != null && NativeAdsViewHolder.access$000(nativeadsviewholder) != null)
        {
            ViewModel viewmodel = NativeAdsViewHolder.access$100(nativeadsviewholder);
            com.ebay.mobile.common.view.iewHolderReference iewholderreference = viewmodel.listener;
            if (iewholderreference != null)
            {
                iewholderreference.iewHolderReference(nativeadsviewholder.itemView, viewmodel);
                return;
            }
        }
    }

    (NativeAdsViewHolder nativeadsviewholder)
    {
        viewHolderReference = new WeakReference(nativeadsviewholder);
    }
}
