// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad.handler;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.f.h;
import com.google.a.a.e;
import com.target.mothership.common.weeklyad.c;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingVariation;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingVariationItem;
import com.target.mothership.util.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class TGTWeeklyAdListingVariation
    implements Parcelable, WeeklyAdListingVariation
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTWeeklyAdListingVariation a(Parcel parcel)
        {
            return new TGTWeeklyAdListingVariation(parcel);
        }

        public TGTWeeklyAdListingVariation[] a(int i)
        {
            return new TGTWeeklyAdListingVariation[i];
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
    private LinkedHashMap mAllItems;
    private List mColorList;
    private List mSizeList;
    private c mType;

    public TGTWeeklyAdListingVariation()
    {
        mAllItems = new LinkedHashMap();
    }

    private TGTWeeklyAdListingVariation(Parcel parcel)
    {
        mAllItems = new LinkedHashMap();
        mAllItems = new LinkedHashMap();
        int l = parcel.readInt();
        for (int i = 0; i < l; i++)
        {
            h h1 = new h(parcel.readString(), parcel.readString());
            mAllItems.put(h1, (WeeklyAdListingVariationItem)parcel.readParcelable(com/target/mothership/model/weeklyad/interfaces/WeeklyAdListingVariationItem.getClassLoader()));
        }

        mColorList = new ArrayList();
        parcel.readStringList(mColorList);
        mSizeList = new ArrayList();
        parcel.readStringList(mSizeList);
        int j = parcel.readInt();
        if (j == -1)
        {
            parcel = null;
        } else
        {
            parcel = c.values()[j];
        }
        mType = parcel;
    }


    public c a()
    {
        return mType;
    }

    public WeeklyAdListingVariationItem a(String s)
    {
        return a(s, null);
    }

    public WeeklyAdListingVariationItem a(String s, String s1)
    {
        return (WeeklyAdListingVariationItem)mAllItems.get(new h(s, s1));
    }

    public void a(c c1)
    {
        mType = c1;
    }

    public void a(WeeklyAdListingVariationItem weeklyadlistingvariationitem)
    {
        mAllItems.put(new h(weeklyadlistingvariationitem.b().d(), weeklyadlistingvariationitem.c().d()), weeklyadlistingvariationitem);
    }

    public void a(List list)
    {
        mColorList = list;
    }

    public WeeklyAdListingVariationItem b(String s)
    {
        return a(null, s);
    }

    public List b()
    {
        return k.a(mColorList);
    }

    public void b(List list)
    {
        mSizeList = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(mAllItems.size());
        java.util.Map.Entry entry;
        for (Iterator iterator = mAllItems.entrySet().iterator(); iterator.hasNext(); parcel.writeParcelable((Parcelable)entry.getValue(), i))
        {
            entry = (java.util.Map.Entry)iterator.next();
            parcel.writeString((String)((h)entry.getKey()).a);
            parcel.writeString((String)((h)entry.getKey()).b);
        }

        parcel.writeStringList(mColorList);
        parcel.writeStringList(mSizeList);
        if (mType == null)
        {
            i = -1;
        } else
        {
            i = mType.ordinal();
        }
        parcel.writeInt(i);
    }

}
