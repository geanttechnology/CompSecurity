// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.common.product.CatEntryId;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.util.k;

public class TGTProduct
    implements Product
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProduct a(Parcel parcel)
        {
            return new TGTProduct(parcel);
        }

        public TGTProduct[] a(int i)
        {
            return new TGTProduct[i];
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
    private Tcin mParentTcin;
    private Tcin mTcin;
    private String mTitle;

    public TGTProduct()
    {
    }

    public TGTProduct(Parcel parcel)
    {
        mTcin = (Tcin)parcel.readParcelable(com/target/mothership/common/product/Tcin.getClassLoader());
        mDpci = (Dpci)parcel.readParcelable(com/target/mothership/common/product/Dpci.getClassLoader());
        mCatEntryId = (CatEntryId)parcel.readParcelable(com/target/mothership/common/product/CatEntryId.getClassLoader());
        mTitle = parcel.readString();
        mParentTcin = (Tcin)parcel.readParcelable(com/target/mothership/common/product/Tcin.getClassLoader());
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

    public void b(Tcin tcin)
    {
        mParentTcin = tcin;
    }

    public int describeContents()
    {
        return 0;
    }

    public e e()
    {
        return k.a(mDpci);
    }

    public e f()
    {
        return k.a(mCatEntryId);
    }

    public String g()
    {
        return mTitle;
    }

    public e h()
    {
        return k.a(mParentTcin);
    }

    public Tcin k_()
    {
        return mTcin;
    }

    public void l(String s)
    {
        mTitle = s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mTcin, i);
        parcel.writeParcelable(mDpci, i);
        parcel.writeParcelable(mCatEntryId, i);
        parcel.writeString(mTitle);
        parcel.writeParcelable(mParentTcin, i);
    }

}
