// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.pointinside.products.BaseProduct;
import com.pointinside.products.LookupResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LookupResultParcelable extends LookupResult
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public LookupResultParcelable a(Parcel parcel)
        {
            return new LookupResultParcelable(parcel);
        }

        public LookupResultParcelable[] a(int i)
        {
            return new LookupResultParcelable[i];
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

    public LookupResultParcelable()
    {
    }

    private LookupResultParcelable(Parcel parcel)
    {
        product = (BaseProduct)parcel.readParcelable(com/pointinside/products/BaseProduct.getClassLoader());
        int i = parcel.readInt();
        if (i == -1)
        {
            parcel = null;
        } else
        {
            parcel = com.pointinside.products.LookupResult.LookupStatus.values()[i];
        }
        lookupStatus = parcel;
    }


    public LookupResultParcelable(LookupResult lookupresult)
    {
        product = lookupresult.product;
        lookupStatus = lookupresult.lookupStatus;
    }

    public static List a(List list)
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(new LookupResultParcelable((LookupResult)list.next()))) { }
        return arraylist;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(product, 0);
        if (lookupStatus == null)
        {
            i = -1;
        } else
        {
            i = lookupStatus.ordinal();
        }
        parcel.writeInt(i);
    }

}
