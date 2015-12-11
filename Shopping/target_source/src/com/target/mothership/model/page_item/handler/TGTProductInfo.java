// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item.handler;

import android.os.Parcel;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.page_item.interfaces.ProductInfo;

class TGTProductInfo
    implements ProductInfo
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductInfo a(Parcel parcel)
        {
            return new TGTProductInfo(parcel);
        }

        public TGTProductInfo[] a(int i)
        {
            return new TGTProductInfo[i];
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
    private Tcin mParentTcin;
    private Tcin mTcin;

    public TGTProductInfo()
    {
    }

    private TGTProductInfo(Parcel parcel)
    {
        mParentTcin = (Tcin)parcel.readParcelable(com/target/mothership/common/product/Tcin.getClassLoader());
        mTcin = (Tcin)parcel.readParcelable(com/target/mothership/common/product/Tcin.getClassLoader());
    }


    public void a(Tcin tcin)
    {
        mParentTcin = tcin;
    }

    public void b(Tcin tcin)
    {
        mTcin = tcin;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mParentTcin, i);
        parcel.writeParcelable(mTcin, i);
    }

}
