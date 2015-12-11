// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class ItemCurrency
    implements Parcelable, Cloneable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ItemCurrency createFromParcel(Parcel parcel)
        {
            return new ItemCurrency(parcel.readString(), parcel.readString());
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ItemCurrency[] newArray(int i)
        {
            return new ItemCurrency[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String code;
    public String value;

    public ItemCurrency()
    {
        code = null;
        value = null;
    }

    public ItemCurrency(String s, String s1)
    {
        code = s;
        value = s1;
    }

    public static boolean isEmpty(ItemCurrency itemcurrency)
    {
        return itemcurrency == null || TextUtils.isEmpty(itemcurrency.code) || TextUtils.isEmpty(itemcurrency.value);
    }

    public ItemCurrency clone()
    {
        ItemCurrency itemcurrency;
        try
        {
            itemcurrency = (ItemCurrency)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            return null;
        }
        return itemcurrency;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof ItemCurrency))
        {
            obj = (ItemCurrency)obj;
            if ((code != null ? code.equals(((ItemCurrency) (obj)).code) : ((ItemCurrency) (obj)).code == null) && (value != null ? value.equals(((ItemCurrency) (obj)).value) : ((ItemCurrency) (obj)).value == null))
            {
                return true;
            }
        }
        return false;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ItemCurrency: ").append(code).append(' ').append(value).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(code);
        parcel.writeString(value);
    }

}
