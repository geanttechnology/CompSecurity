// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.params;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.list.interfaces.ListItem;

public class NowShoppingProdParams
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public NowShoppingProdParams a(Parcel parcel)
        {
            return new NowShoppingProdParams(parcel);
        }

        public NowShoppingProdParams[] a(int i)
        {
            return new NowShoppingProdParams[i];
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
    private String mDpci;
    private Integer mRequestedQuantity;
    private String mSearchTerm;
    private String mTcin;

    private NowShoppingProdParams(Parcel parcel)
    {
        mTcin = parcel.readString();
        mDpci = parcel.readString();
        mSearchTerm = parcel.readString();
        mRequestedQuantity = Integer.valueOf(parcel.readInt());
    }


    public NowShoppingProdParams(ListItem listitem)
    {
        mRequestedQuantity = Integer.valueOf(listitem.getDesiredQuantity());
        String s;
        if (listitem.getTcin().b())
        {
            s = ((Tcin)listitem.getTcin().c()).b();
        } else
        {
            s = null;
        }
        mTcin = s;
        mDpci = null;
        mSearchTerm = listitem.getTitle();
    }

    public Integer a()
    {
        return mRequestedQuantity;
    }

    public String b()
    {
        return mTcin;
    }

    public String c()
    {
        return mDpci;
    }

    public String d()
    {
        return mSearchTerm;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mTcin);
        parcel.writeString(mDpci);
        parcel.writeString(mSearchTerm);
        parcel.writeInt(mRequestedQuantity.intValue());
    }

}
