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
import com.target.mothership.common.weeklyad.ProductSlug;
import com.target.mothership.common.weeklyad.a;
import com.target.mothership.common.weeklyad.b;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingCollectionItem;
import com.target.mothership.util.k;
import com.target.mothership.util.p;

class TGTWeeklyAdListingCollectionItem
    implements Parcelable, WeeklyAdListingCollectionItem
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTWeeklyAdListingCollectionItem a(Parcel parcel)
        {
            return new TGTWeeklyAdListingCollectionItem(parcel);
        }

        public TGTWeeklyAdListingCollectionItem[] a(int i)
        {
            return new TGTWeeklyAdListingCollectionItem[i];
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
    private CatEntryId mCatEntryId;
    private Dpci mDpci;
    private String mEyebrow;
    private String mImageUrl;
    private boolean mPickupInStore;
    private String mPrice;
    private String mPriceLabel;
    private b mPriceMessage;
    private ProductSlug mProductSlug;
    private a mPurchasingChannel;
    private Tcin mTcin;
    private String mTitle;

    public TGTWeeklyAdListingCollectionItem()
    {
    }

    private TGTWeeklyAdListingCollectionItem(Parcel parcel)
    {
        Object obj1 = null;
        super();
        mPrice = parcel.readString();
        mPriceLabel = parcel.readString();
        int i = parcel.readInt();
        Object obj;
        boolean flag;
        if (i == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.weeklyad.b.values()[i];
        }
        mPriceMessage = ((b) (obj));
        i = parcel.readInt();
        if (i == -1)
        {
            obj = obj1;
        } else
        {
            obj = com.target.mothership.common.weeklyad.a.values()[i];
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
        mTitle = parcel.readString();
        mTcin = (Tcin)parcel.readParcelable(com/target/mothership/common/product/Tcin.getClassLoader());
        mDpci = (Dpci)parcel.readParcelable(com/target/mothership/common/product/Dpci.getClassLoader());
        mCatEntryId = (CatEntryId)parcel.readParcelable(com/target/mothership/common/product/CatEntryId.getClassLoader());
        mImageUrl = parcel.readString();
        mProductSlug = (ProductSlug)parcel.readParcelable(com/target/mothership/common/weeklyad/ProductSlug.getClassLoader());
        mEyebrow = parcel.readString();
    }


    public String a()
    {
        return mTitle;
    }

    public String a(int i)
    {
        return p.a(mImageUrl, i);
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

    public void a(String s)
    {
        mPrice = s;
    }

    public void a(boolean flag)
    {
        mPickupInStore = flag;
    }

    public String b()
    {
        return mPrice;
    }

    public void b(String s)
    {
        mPriceLabel = s;
    }

    public ProductSlug c()
    {
        return mProductSlug;
    }

    public void c(String s)
    {
        mTitle = s;
    }

    public e d()
    {
        return k.a(mTcin);
    }

    public void d(String s)
    {
        mImageUrl = s;
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
        mEyebrow = s;
    }

    public String f()
    {
        return mEyebrow;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        byte byte1 = -1;
        parcel.writeString(mPrice);
        parcel.writeString(mPriceLabel);
        byte byte0;
        int j;
        if (mPriceMessage == null)
        {
            j = -1;
        } else
        {
            j = mPriceMessage.ordinal();
        }
        parcel.writeInt(j);
        if (mPurchasingChannel == null)
        {
            j = byte1;
        } else
        {
            j = mPurchasingChannel.ordinal();
        }
        parcel.writeInt(j);
        if (mPickupInStore)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeString(mTitle);
        parcel.writeParcelable(mTcin, i);
        parcel.writeParcelable(mDpci, i);
        parcel.writeParcelable(mCatEntryId, i);
        parcel.writeString(mImageUrl);
        parcel.writeParcelable(mProductSlug, i);
        parcel.writeString(mEyebrow);
    }

}
