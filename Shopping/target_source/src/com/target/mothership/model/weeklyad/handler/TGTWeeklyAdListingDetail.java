// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.common.product.CatEntryId;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.product.Upc;
import com.target.mothership.common.weeklyad.ProductSlug;
import com.target.mothership.common.weeklyad.a;
import com.target.mothership.common.weeklyad.b;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingCollectionItem;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingDetail;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingPromotion;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingVariation;
import com.target.mothership.util.k;
import com.target.mothership.util.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TGTWeeklyAdListingDetail
    implements Parcelable, WeeklyAdListingDetail
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTWeeklyAdListingDetail a(Parcel parcel)
        {
            return new TGTWeeklyAdListingDetail(parcel);
        }

        public TGTWeeklyAdListingDetail[] a(int l)
        {
            return new TGTWeeklyAdListingDetail[l];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int l)
        {
            return a(l);
        }

    };
    private List mCarouselImages;
    private CatEntryId mCatEntryId;
    private List mCollectionItems;
    private String mDisplayPrice;
    private Dpci mDpci;
    private String mEyebrow;
    private String mFinePrint;
    private String mImageUrl;
    private List mItemDetails;
    private String mOfferDescription;
    private boolean mPickupInStore;
    private String mPriceLabel;
    private b mPriceMessage;
    private String mProductDescription;
    private ProductSlug mProductSlug;
    private List mPromotions;
    private a mPurchasingChannel;
    private String mReturnPolicy;
    private Tcin mTcin;
    private String mTitle;
    private Upc mUpc;
    private WeeklyAdListingVariation mVariations;

    public TGTWeeklyAdListingDetail()
    {
    }

    private TGTWeeklyAdListingDetail(Parcel parcel)
    {
        Object obj1 = null;
        super();
        mTitle = parcel.readString();
        mProductSlug = (ProductSlug)parcel.readParcelable(com/target/mothership/common/weeklyad/ProductSlug.getClassLoader());
        mTcin = (Tcin)parcel.readParcelable(com/target/mothership/common/product/Tcin.getClassLoader());
        mDpci = (Dpci)parcel.readParcelable(com/target/mothership/common/product/Dpci.getClassLoader());
        mCatEntryId = (CatEntryId)parcel.readParcelable(com/target/mothership/common/product/CatEntryId.getClassLoader());
        mUpc = (Upc)parcel.readParcelable(com/target/mothership/common/product/Upc.getClassLoader());
        mDisplayPrice = parcel.readString();
        mPriceLabel = parcel.readString();
        int l = parcel.readInt();
        Object obj;
        boolean flag;
        if (l == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.weeklyad.b.values()[l];
        }
        mPriceMessage = ((b) (obj));
        l = parcel.readInt();
        if (l == -1)
        {
            obj = obj1;
        } else
        {
            obj = com.target.mothership.common.weeklyad.a.values()[l];
        }
        mPurchasingChannel = ((a) (obj));
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mPickupInStore = flag;
        mOfferDescription = parcel.readString();
        mProductDescription = parcel.readString();
        mFinePrint = parcel.readString();
        mImageUrl = parcel.readString();
        mCarouselImages = new ArrayList();
        parcel.readStringList(mCarouselImages);
        mItemDetails = new ArrayList();
        parcel.readStringList(mItemDetails);
        mPromotions = new ArrayList();
        parcel.readList(mPromotions, com/target/mothership/model/weeklyad/interfaces/WeeklyAdListingPromotion.getClassLoader());
        mReturnPolicy = parcel.readString();
        mVariations = (WeeklyAdListingVariation)parcel.readParcelable(com/target/mothership/model/weeklyad/interfaces/WeeklyAdListingVariation.getClassLoader());
        mCollectionItems = new ArrayList();
        parcel.readList(mCollectionItems, com/target/mothership/model/weeklyad/interfaces/WeeklyAdListingCollectionItem.getClassLoader());
        mEyebrow = parcel.readString();
    }


    public String a()
    {
        return mTitle;
    }

    public String a(int l)
    {
        return p.a(mImageUrl, l);
    }

    public void a(CatEntryId catentryid)
    {
        mCatEntryId = catentryid;
    }

    public void a(Dpci dpci)
    {
        mDpci = dpci;
    }

    public void a(Tcin tcin)
    {
        mTcin = tcin;
    }

    public void a(Upc upc)
    {
        mUpc = upc;
    }

    public void a(ProductSlug productslug)
    {
        mProductSlug = productslug;
    }

    public void a(a a1)
    {
        mPurchasingChannel = a1;
    }

    public void a(b b1)
    {
        mPriceMessage = b1;
    }

    public void a(WeeklyAdListingVariation weeklyadlistingvariation)
    {
        mVariations = weeklyadlistingvariation;
    }

    public void a(String s)
    {
        mTitle = s;
    }

    public void a(List list)
    {
        mCarouselImages = list;
    }

    public void a(boolean flag)
    {
        mPickupInStore = flag;
    }

    public String b()
    {
        return mDisplayPrice;
    }

    public List b(int l)
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = mCarouselImages.iterator(); iterator.hasNext(); arraylist.add(p.a((String)iterator.next(), l))) { }
        return arraylist;
    }

    public void b(String s)
    {
        mDisplayPrice = s;
    }

    public void b(List list)
    {
        mItemDetails = list;
    }

    public ProductSlug c()
    {
        return mProductSlug;
    }

    public void c(String s)
    {
        mPriceLabel = s;
    }

    public void c(List list)
    {
        mPromotions = list;
    }

    public e d()
    {
        return com.target.mothership.util.k.a(mTcin);
    }

    public void d(String s)
    {
        mOfferDescription = s;
    }

    public void d(List list)
    {
        mCollectionItems = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public String e()
    {
        return mImageUrl;
    }

    public void e(String s)
    {
        mProductDescription = s;
    }

    public String f()
    {
        return mEyebrow;
    }

    public void f(String s)
    {
        mFinePrint = s;
    }

    public e g()
    {
        return com.target.mothership.util.k.a(mOfferDescription);
    }

    public void g(String s)
    {
        mImageUrl = s;
    }

    public e h()
    {
        return com.target.mothership.util.k.a(mFinePrint);
    }

    public void h(String s)
    {
        mReturnPolicy = s;
    }

    public List i()
    {
        return mPromotions;
    }

    public void i(String s)
    {
        mEyebrow = s;
    }

    public e j()
    {
        return com.target.mothership.util.k.a(mVariations);
    }

    public List k()
    {
        return mCollectionItems;
    }

    public void writeToParcel(Parcel parcel, int l)
    {
        byte byte1 = -1;
        parcel.writeString(mTitle);
        parcel.writeParcelable(mProductSlug, l);
        parcel.writeParcelable(mTcin, l);
        parcel.writeParcelable(mDpci, l);
        parcel.writeParcelable(mCatEntryId, l);
        parcel.writeParcelable(mUpc, l);
        parcel.writeString(mDisplayPrice);
        parcel.writeString(mPriceLabel);
        byte byte0;
        if (mPriceMessage == null)
        {
            l = -1;
        } else
        {
            l = mPriceMessage.ordinal();
        }
        parcel.writeInt(l);
        if (mPurchasingChannel == null)
        {
            l = byte1;
        } else
        {
            l = mPurchasingChannel.ordinal();
        }
        parcel.writeInt(l);
        if (mPickupInStore)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeString(mOfferDescription);
        parcel.writeString(mProductDescription);
        parcel.writeString(mFinePrint);
        parcel.writeString(mImageUrl);
        parcel.writeStringList(mCarouselImages);
        parcel.writeStringList(mItemDetails);
        parcel.writeList(mPromotions);
        parcel.writeString(mReturnPolicy);
        parcel.writeParcelable(mVariations, 0);
        parcel.writeList(mCollectionItems);
        parcel.writeString(mEyebrow);
    }

}
