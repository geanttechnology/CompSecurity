// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.weekly_ad;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingBase;
import com.target.ui.fragment.product.pdp.ProductDetailsPageFragment;
import com.target.ui.fragment.product.pdp.presenter.ProductDetailsPagePresenter;
import com.target.ui.fragment.weekly_ad.presenter.WeeklyAdPdpPresenter;
import com.target.ui.helper.product.ProductVariationModelHelper;
import com.target.ui.helper.product.g;
import com.target.ui.helper.product.h;
import com.target.ui.helper.q.a;
import com.target.ui.service.provider.DefaultStringResourceProvider;
import com.target.ui.service.provider.f;
import com.target.ui.service.provider.i;

public class WeeklyAdPdpFragment extends ProductDetailsPageFragment
{

    private static final String PROMOTION_REQUEST_ARG = "promotionRequestArg";
    public static final String TAG = com/target/ui/fragment/weekly_ad/WeeklyAdPdpFragment.getSimpleName();
    private static final String WEEKLY_AD_LISTING_ARG = "weeklyAdListingArg";

    public WeeklyAdPdpFragment()
    {
    }

    private WeeklyAdListingBase F()
    {
        return (WeeklyAdListingBase)getArguments().getParcelable("weeklyAdListingArg");
    }

    private PromotionRequest G()
    {
        return (PromotionRequest)getArguments().getParcelable("promotionRequestArg");
    }

    public static WeeklyAdPdpFragment a(WeeklyAdListingBase weeklyadlistingbase, PromotionRequest promotionrequest, Store store)
    {
        WeeklyAdPdpFragment weeklyadpdpfragment = new WeeklyAdPdpFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("storeArg", store);
        bundle.putParcelable("productIdentifierArg", (Parcelable)weeklyadlistingbase.d().c());
        bundle.putParcelable("weeklyAdListingArg", weeklyadlistingbase);
        bundle.putParcelable("promotionRequestArg", promotionrequest);
        weeklyadpdpfragment.setArguments(bundle);
        return weeklyadpdpfragment;
    }

    protected ProductDetailsPagePresenter D()
    {
        return new WeeklyAdPdpPresenter(F(), G(), new a(), new g(), new h(), new com.target.ui.helper.g.a(), new com.target.ui.helper.e.a(), new ProductVariationModelHelper(getActivity()), new com.target.ui.service.provider.e(), new i(), new DefaultStringResourceProvider(getActivity()), E(), com.target.ui.j.a.c(), new f(), C());
    }

}
