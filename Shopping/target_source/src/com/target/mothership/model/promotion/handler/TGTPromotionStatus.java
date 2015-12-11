// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.promotion.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.promotion.interfaces.PromotionStatus;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class TGTPromotionStatus
    implements Parcelable, PromotionStatus
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTPromotionStatus a(Parcel parcel)
        {
            return new TGTPromotionStatus(parcel);
        }

        public TGTPromotionStatus[] a(int i)
        {
            return new TGTPromotionStatus[i];
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
    private Set mGenericProductsWithPromotions;
    private Set mTcinsWithPromotions;

    public TGTPromotionStatus()
    {
        mTcinsWithPromotions = new HashSet();
        mGenericProductsWithPromotions = new HashSet();
    }

    private TGTPromotionStatus(Parcel parcel)
    {
        mTcinsWithPromotions = new HashSet();
        mGenericProductsWithPromotions = new HashSet();
        mTcinsWithPromotions = new HashSet();
        ArrayList arraylist = new ArrayList();
        parcel.readStringList(arraylist);
        mTcinsWithPromotions.addAll(arraylist);
        mGenericProductsWithPromotions = new HashSet();
        arraylist = new ArrayList();
        parcel.readStringList(arraylist);
        mGenericProductsWithPromotions.addAll(arraylist);
    }


    public Set a()
    {
        return mTcinsWithPromotions;
    }

    public boolean a(Tcin tcin)
    {
        return mTcinsWithPromotions.contains(tcin.b());
    }

    public boolean a(String s)
    {
        return mGenericProductsWithPromotions.contains(s);
    }

    public Set b()
    {
        return mGenericProductsWithPromotions;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(mTcinsWithPromotions);
        parcel.writeStringList(arraylist);
        arraylist = new ArrayList();
        arraylist.addAll(mGenericProductsWithPromotions);
        parcel.writeStringList(arraylist);
    }

}
