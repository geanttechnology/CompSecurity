// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.weekly_ad;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.common.weeklyad.StoreSlug;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdHomepage;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdPage;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdPromotion;
import java.util.ArrayList;
import java.util.List;

public class WeeklyAdHomepageData
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public WeeklyAdHomepageData a(Parcel parcel)
        {
            return new WeeklyAdHomepageData(parcel);
        }

        public WeeklyAdHomepageData[] a(int i)
        {
            return new WeeklyAdHomepageData[i];
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
    private PromotionRequest mPromotionRequest;
    private StoreIdentifier mStoreIdentifier;
    private StoreSlug mStoreSlug;
    private StoreSummary mStoreSummary;
    private WeeklyAdHomepage mWeeklyAdHomepage;
    private List mWeeklyAdPages;
    private WeeklyAdPromotion mWeeklyAdPromotion;

    private WeeklyAdHomepageData(Parcel parcel)
    {
        mPromotionRequest = (PromotionRequest)parcel.readParcelable(com/target/mothership/common/weeklyad/PromotionRequest.getClassLoader());
        mStoreIdentifier = (StoreIdentifier)parcel.readParcelable(com/target/mothership/common/store/StoreIdentifier.getClassLoader());
        mStoreSlug = (StoreSlug)parcel.readParcelable(com/target/mothership/common/weeklyad/StoreSlug.getClassLoader());
        mStoreSummary = (StoreSummary)parcel.readParcelable(com/target/mothership/model/store/interfaces/StoreSummary.getClassLoader());
        mWeeklyAdHomepage = (WeeklyAdHomepage)parcel.readParcelable(com/target/mothership/model/weeklyad/interfaces/WeeklyAdHomepage.getClassLoader());
        mWeeklyAdPages = new ArrayList();
        parcel.readList(mWeeklyAdPages, com/target/mothership/model/weeklyad/interfaces/WeeklyAdPage.getClassLoader());
        mWeeklyAdPromotion = (WeeklyAdPromotion)parcel.readParcelable(com/target/mothership/model/weeklyad/interfaces/WeeklyAdPromotion.getClassLoader());
    }


    public WeeklyAdHomepageData(WeeklyAdHomepage weeklyadhomepage, WeeklyAdPromotion weeklyadpromotion, PromotionRequest promotionrequest, List list, StoreIdentifier storeidentifier, StoreSlug storeslug, StoreSummary storesummary)
    {
        mWeeklyAdHomepage = weeklyadhomepage;
        mWeeklyAdPromotion = weeklyadpromotion;
        mPromotionRequest = promotionrequest;
        mWeeklyAdPages = list;
        mStoreIdentifier = storeidentifier;
        mStoreSlug = storeslug;
        mStoreSummary = storesummary;
    }

    public PromotionRequest a()
    {
        return mPromotionRequest;
    }

    public StoreIdentifier b()
    {
        return mStoreIdentifier;
    }

    public StoreSlug c()
    {
        return mStoreSlug;
    }

    public e d()
    {
        return com.google.a.a.e.c(mStoreSummary);
    }

    public int describeContents()
    {
        return 0;
    }

    public WeeklyAdHomepage e()
    {
        return mWeeklyAdHomepage;
    }

    public List f()
    {
        return mWeeklyAdPages;
    }

    public WeeklyAdPromotion g()
    {
        return mWeeklyAdPromotion;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mPromotionRequest, i);
        parcel.writeParcelable(mStoreIdentifier, i);
        parcel.writeParcelable(mStoreSlug, i);
        parcel.writeParcelable(mStoreSummary, i);
        parcel.writeParcelable(mWeeklyAdHomepage, i);
        parcel.writeList(mWeeklyAdPages);
        parcel.writeParcelable(mWeeklyAdPromotion, i);
    }

}
