// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.params;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.f.a;
import com.google.a.a.e;
import com.target.mothership.common.page_item.d;
import com.target.mothership.common.product.EndecaId;
import com.target.mothership.common.store.StoreIdentifier;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PageItemParams
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PageItemParams a(Parcel parcel)
        {
            return new PageItemParams(parcel);
        }

        public PageItemParams[] a(int i)
        {
            return new PageItemParams[i];
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
    private a mAdditionalParameters;
    private EndecaId mCategory;
    private d mLocationType;
    private StoreIdentifier mStoreIdentifier;

    public PageItemParams()
    {
        mAdditionalParameters = new a();
    }

    private PageItemParams(Parcel parcel)
    {
        mAdditionalParameters = new a();
        mAdditionalParameters = new a();
        int k = parcel.readInt();
        for (int i = 0; i < k; i++)
        {
            mAdditionalParameters.put(parcel.readString(), parcel.readString());
        }

        mStoreIdentifier = (StoreIdentifier)parcel.readParcelable(com/target/mothership/common/store/StoreIdentifier.getClassLoader());
        int j = parcel.readInt();
        d d1;
        if (j == -1)
        {
            d1 = null;
        } else
        {
            d1 = com.target.mothership.common.page_item.d.values()[j];
        }
        mLocationType = d1;
        mCategory = (EndecaId)parcel.readParcelable(com/target/mothership/common/product/EndecaId.getClassLoader());
    }


    public Map a()
    {
        return mAdditionalParameters;
    }

    public void a(d d1)
    {
        mLocationType = d1;
    }

    public void a(EndecaId endecaid)
    {
        mCategory = endecaid;
    }

    public void a(StoreIdentifier storeidentifier)
    {
        mStoreIdentifier = storeidentifier;
    }

    public void a(Map map)
    {
        mAdditionalParameters.clear();
        mAdditionalParameters.putAll(map);
        mAdditionalParameters.remove("storeId");
        mAdditionalParameters.remove("where");
    }

    public e b()
    {
        return e.c(mLocationType);
    }

    public e c()
    {
        return e.c(mStoreIdentifier);
    }

    public e d()
    {
        return e.c(mCategory);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(mAdditionalParameters.size());
        java.util.Map.Entry entry;
        for (Iterator iterator = mAdditionalParameters.entrySet().iterator(); iterator.hasNext(); parcel.writeString((String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
            parcel.writeString((String)entry.getKey());
        }

        parcel.writeParcelable(mStoreIdentifier, i);
        int j;
        if (mLocationType == null)
        {
            j = -1;
        } else
        {
            j = mLocationType.ordinal();
        }
        parcel.writeInt(j);
        parcel.writeParcelable(mCategory, i);
    }

}
