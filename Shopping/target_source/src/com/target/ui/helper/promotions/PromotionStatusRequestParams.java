// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.promotions;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.store.StoreIdentifier;
import java.util.ArrayList;
import java.util.List;

public class PromotionStatusRequestParams
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PromotionStatusRequestParams a(Parcel parcel)
        {
            return new PromotionStatusRequestParams(parcel);
        }

        public PromotionStatusRequestParams[] a(int i)
        {
            return new PromotionStatusRequestParams[i];
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
    private final List mGenericProducts;
    private final StoreIdentifier mStoreIdentifier;
    private final List mTcins;

    protected PromotionStatusRequestParams(Parcel parcel)
    {
        mStoreIdentifier = (StoreIdentifier)parcel.readParcelable(com/target/mothership/common/store/StoreIdentifier.getClassLoader());
        mGenericProducts = new ArrayList();
        parcel.readList(mGenericProducts, java/lang/String.getClassLoader());
        mTcins = new ArrayList();
        parcel.readList(mTcins, com/target/mothership/common/product/Tcin.getClassLoader());
    }

    public PromotionStatusRequestParams(StoreIdentifier storeidentifier, List list, List list1)
    {
        mStoreIdentifier = storeidentifier;
        mTcins = list;
        mGenericProducts = list1;
    }

    public StoreIdentifier a()
    {
        return mStoreIdentifier;
    }

    public List b()
    {
        return mTcins;
    }

    public List c()
    {
        return mGenericProducts;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mStoreIdentifier, i);
        parcel.writeList(mGenericProducts);
        parcel.writeList(mTcins);
    }

}
