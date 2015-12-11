// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.data.ItemCurrency;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class DealsItem
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public DealsItem createFromParcel(Parcel parcel)
        {
            String s;
            String s1;
            String s2;
            String s3;
            ItemCurrency itemcurrency;
            String s4;
            String s5;
            String s6;
            int i;
            int j;
            int k;
            int l;
            long l1;
            i = parcel.readInt();
            if (i != 0)
            {
                break MISSING_BLOCK_LABEL_172;
            }
            l1 = parcel.readLong();
            s = parcel.readString();
            s1 = parcel.readString();
            s2 = parcel.readString();
            s3 = parcel.readString();
            itemcurrency = (ItemCurrency)parcel.readParcelable(com/ebay/nautilus/domain/data/ItemCurrency.getClassLoader());
            j = parcel.readInt();
            s4 = parcel.readString();
            s5 = parcel.readString();
            k = parcel.readInt();
            s6 = parcel.readString();
            l = parcel.readInt();
            if (l >= 0) goto _L2; else goto _L1
_L1:
            Object obj = null;
_L4:
            return new DealsItem(l1, s, s1, s2, s3, itemcurrency, j, s4, s5, k, ((List) (obj)), s6);
_L2:
            ArrayList arraylist = new ArrayList(l);
            i = 0;
            do
            {
                obj = arraylist;
                if (i >= l)
                {
                    break;
                }
                arraylist.add(createFromParcel(parcel));
                i++;
            } while (true);
            if (true) goto _L4; else goto _L3
_L3:
            parcel = parcel.readString();
            boolean flag;
            if (i == 2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return new DealsItem(parcel, flag);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public DealsItem[] newArray(int i)
        {
            return new DealsItem[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final int TYPE_CATEGORY = 1;
    public static final int TYPE_DEAL = 0;
    public static final int TYPE_HEADER = 2;
    public final String deal;
    public final String energyRating;
    public final long id;
    public final String imageUrl;
    public final List msku;
    public final ItemCurrency orp;
    public final String orps;
    public final String price;
    public final int savingsRate;
    public final String shipping;
    public final int shippingColor;
    public final String title;
    public final int type;

    public DealsItem(long l, String s, String s1, String s2, String s3, ItemCurrency itemcurrency, 
            int i, String s4, String s5, int j, List list, String s6)
    {
        type = 0;
        id = l;
        title = s;
        imageUrl = s1;
        deal = s2;
        price = s3;
        orp = itemcurrency;
        savingsRate = i;
        orps = s4;
        shipping = s5;
        shippingColor = j;
        msku = list;
        energyRating = s6;
    }

    public DealsItem(String s, boolean flag)
    {
        int i;
        if (flag)
        {
            i = 2;
        } else
        {
            i = 1;
        }
        type = i;
        id = 0L;
        title = s;
        imageUrl = null;
        deal = null;
        price = null;
        orp = null;
        savingsRate = 0;
        orps = null;
        shipping = null;
        shippingColor = 0;
        msku = null;
        energyRating = null;
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return title;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(type);
        if (type == 0)
        {
            parcel.writeLong(id);
            parcel.writeString(title);
            parcel.writeString(imageUrl);
            parcel.writeString(deal);
            parcel.writeString(price);
            parcel.writeParcelable(orp, i);
            parcel.writeString(orps);
            parcel.writeInt(savingsRate);
            parcel.writeString(shipping);
            parcel.writeInt(shippingColor);
            parcel.writeString(energyRating);
            int j;
            if (msku == null)
            {
                j = -1;
            } else
            {
                j = msku.size();
            }
            parcel.writeInt(j);
            if (j > 0)
            {
                for (Iterator iterator = msku.iterator(); iterator.hasNext(); ((DealsItem)iterator.next()).writeToParcel(parcel, i)) { }
            }
        } else
        {
            parcel.writeString(title);
        }
    }

}
