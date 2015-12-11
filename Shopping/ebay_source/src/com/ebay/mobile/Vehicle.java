// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.ArrayList;

public class Vehicle extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Vehicle createFromParcel(Parcel parcel)
        {
            return (Vehicle)DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/Vehicle);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Vehicle[] newArray(int i)
        {
            return new Vehicle[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public ArrayList attributes;
    public String name;

    public Vehicle()
    {
        attributes = new ArrayList();
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof Vehicle))
        {
            if (TextUtils.equals(name, ((Vehicle) (obj = (Vehicle)obj)).name) && attributes.equals(((Vehicle) (obj)).attributes))
            {
                return true;
            }
        }
        return false;
    }

    public String getFullName()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < attributes.size(); i++)
        {
            stringbuilder.append(((NameValue)attributes.get(i)).getValue()).append(" ");
        }

        return stringbuilder.toString();
    }

    public String getName()
    {
        String s = name;
        Object obj = s;
        if (TextUtils.isEmpty(s))
        {
            obj = new StringBuilder();
            for (int i = 0; i < 3; i++)
            {
                if (i < attributes.size())
                {
                    ((StringBuilder) (obj)).append(((NameValue)attributes.get(i)).getValue()).append(" ");
                }
            }

            obj = ((StringBuilder) (obj)).toString();
        }
        return ((String) (obj));
    }

}
