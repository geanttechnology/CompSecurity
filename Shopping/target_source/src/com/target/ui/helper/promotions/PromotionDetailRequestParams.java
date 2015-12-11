// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.promotions;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.store.StoreIdentifier;

public class PromotionDetailRequestParams
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PromotionDetailRequestParams a(Parcel parcel)
        {
            return new PromotionDetailRequestParams(parcel);
        }

        public PromotionDetailRequestParams[] a(int i)
        {
            return new PromotionDetailRequestParams[i];
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
    private final String mGenericProduct;
    private final StoreIdentifier mStoreIdentifier;
    private final Tcin mTcin;

    protected PromotionDetailRequestParams(Parcel parcel)
    {
        mStoreIdentifier = (StoreIdentifier)parcel.readParcelable(com/target/mothership/common/store/StoreIdentifier.getClassLoader());
        mGenericProduct = parcel.readString();
        mTcin = (Tcin)parcel.readParcelable(com/target/mothership/common/product/Tcin.getClassLoader());
    }

    public PromotionDetailRequestParams(StoreIdentifier storeidentifier, Tcin tcin)
    {
        this(storeidentifier, null, tcin);
    }

    public PromotionDetailRequestParams(StoreIdentifier storeidentifier, String s)
    {
        this(storeidentifier, s, null);
    }

    private PromotionDetailRequestParams(StoreIdentifier storeidentifier, String s, Tcin tcin)
    {
        mStoreIdentifier = storeidentifier;
        mGenericProduct = s;
        mTcin = tcin;
    }

    public StoreIdentifier a()
    {
        return mStoreIdentifier;
    }

    public e b()
    {
        return e.c(mGenericProduct);
    }

    public e c()
    {
        return e.c(mTcin);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mStoreIdentifier, i);
        parcel.writeString(mGenericProduct);
        parcel.writeParcelable(mTcin, i);
    }

}
