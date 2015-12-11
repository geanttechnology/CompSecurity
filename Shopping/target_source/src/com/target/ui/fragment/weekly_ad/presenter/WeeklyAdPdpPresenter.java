// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.weekly_ad.presenter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingBase;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingDetail;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingVariationItem;
import com.target.mothership.services.x;
import com.target.ui.fragment.product.pdp.a.b;
import com.target.ui.fragment.product.pdp.presenter.ProductDetailsPagePresenter;
import com.target.ui.helper.product.ProductVariationModelHelper;
import com.target.ui.helper.product.g;
import com.target.ui.helper.product.h;
import com.target.ui.helper.q.a;
import com.target.ui.service.provider.l;
import com.target.ui.service.provider.m;
import com.target.ui.service.provider.p;
import com.target.ui.service.provider.s;
import com.target.ui.util.q;

public class WeeklyAdPdpPresenter extends ProductDetailsPagePresenter
    implements com.target.ui.helper.q.a.b
{
    public static class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState a(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public SavedState[] a(int i)
            {
                return new SavedState[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        WeeklyAdListingDetail listingDetail;
        String overriddenPrice;
        Parcelable superSavedState;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeParcelable(listingDetail, 0);
            parcel.writeString(overriddenPrice);
            parcel.writeParcelable(superSavedState, 0);
        }


        public SavedState()
        {
        }

        protected SavedState(Parcel parcel)
        {
            listingDetail = (WeeklyAdListingDetail)parcel.readParcelable(com/target/mothership/model/weeklyad/interfaces/WeeklyAdListingDetail.getClassLoader());
            overriddenPrice = parcel.readString();
            superSavedState = parcel.readParcelable(com/target/ui/fragment/product/pdp/presenter/ProductDetailsPagePresenter.getClassLoader());
        }
    }


    private final String TAG = com/target/ui/fragment/weekly_ad/presenter/WeeklyAdPdpPresenter.getSimpleName();
    private PromotionRequest mPromotionRequest;
    private WeeklyAdListingDetail mSavedListingDetail;
    private ProductVariationModelHelper mVariationModelHelper;
    private a mWeeklyAdDataHelper;
    private WeeklyAdListingBase mWeeklyAdListing;

    public WeeklyAdPdpPresenter(WeeklyAdListingBase weeklyadlistingbase, PromotionRequest promotionrequest, a a1, g g, h h, com.target.ui.helper.g.a a2, com.target.ui.helper.e.a a3, 
            ProductVariationModelHelper productvariationmodelhelper, l l, p p1, s s, com.target.ui.fragment.product.pdp.presenter.b b1, com.target.ui.fragment.product.pdp.presenter.a.a a4, m m1, 
            Parcelable parcelable)
    {
        super(g, h, a2, a3, productvariationmodelhelper, l, p1, s, b1, a4, m1, parcelable);
        mWeeklyAdListing = weeklyadlistingbase;
        mPromotionRequest = promotionrequest;
        mWeeklyAdDataHelper = a1;
        mVariationModelHelper = productvariationmodelhelper;
    }

    private void p()
    {
        mWeeklyAdDataHelper.a(mWeeklyAdListing, mPromotionRequest, this);
    }

    public void a(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        parcelable.listingDetail = mSavedListingDetail;
        super.a(((SavedState) (parcelable)).superSavedState);
    }

    protected void a(ProductDetails productdetails, RelevantStoreSummary relevantstoresummary, boolean flag)
    {
        String s = mWeeklyAdListing.b();
        Object obj = s;
        if (productdetails.D().b())
        {
            obj = mVariationModelHelper;
            WeeklyAdListingVariationItem weeklyadlistingvariationitem = ProductVariationModelHelper.a(mSavedListingDetail, productdetails);
            obj = s;
            if (weeklyadlistingvariationitem != null)
            {
                obj = weeklyadlistingvariationitem.a();
            }
        }
        a(productdetails, relevantstoresummary, ((String) (obj)), flag);
    }

    public void a(WeeklyAdListingDetail weeklyadlistingdetail)
    {
        mSavedListingDetail = weeklyadlistingdetail;
    }

    public void a(b b1)
    {
        super.a(b1);
        p();
    }

    public volatile void a(Object obj)
    {
        a((b)obj);
    }

    public void a_(x x)
    {
        q.a(TAG, "Error retrieving weekly ad listing detail");
    }

    public Parcelable m()
    {
        SavedState savedstate = new SavedState();
        savedstate.listingDetail = mSavedListingDetail;
        savedstate.superSavedState = super.m();
        return savedstate;
    }

    public void v_()
    {
        super.v_();
        mVariationModelHelper = null;
        mPromotionRequest = null;
        mWeeklyAdListing = null;
        mWeeklyAdDataHelper = null;
        mVariationModelHelper = null;
    }

    public void z_()
    {
        super.z_();
        mWeeklyAdDataHelper.a();
    }
}
