// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.shop;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.common.params.PageItemParams;

public class ShopOverrides
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ShopOverrides a(Parcel parcel)
        {
            return new ShopOverrides(parcel);
        }

        public ShopOverrides[] a(int i)
        {
            return new ShopOverrides[i];
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
    private PageItemParams mPageItemParams;
    private com.target.ui.fragment.shop.ShopHomeFragment.b mShopTab;

    private ShopOverrides(Parcel parcel)
    {
        mShopTab = com.target.ui.fragment.shop.ShopHomeFragment.b.FEATURED;
        mPageItemParams = (PageItemParams)parcel.readParcelable(com/target/mothership/common/params/PageItemParams.getClassLoader());
        int i = parcel.readInt();
        if (i == -1)
        {
            parcel = com.target.ui.fragment.shop.ShopHomeFragment.b.FEATURED;
        } else
        {
            parcel = com.target.ui.fragment.shop.ShopHomeFragment.b.values()[i];
        }
        mShopTab = parcel;
    }


    public ShopOverrides(PageItemParams pageitemparams, com.target.ui.fragment.shop.ShopHomeFragment.b b1)
    {
        mShopTab = com.target.ui.fragment.shop.ShopHomeFragment.b.FEATURED;
        mPageItemParams = pageitemparams;
        mShopTab = b1;
    }

    public PageItemParams a()
    {
        return mPageItemParams;
    }

    public com.target.ui.fragment.shop.ShopHomeFragment.b b()
    {
        return mShopTab;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mPageItemParams, i);
        if (mShopTab == null)
        {
            i = -1;
        } else
        {
            i = mShopTab.ordinal();
        }
        parcel.writeInt(i);
    }

}
