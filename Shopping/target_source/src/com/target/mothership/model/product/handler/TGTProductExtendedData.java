// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.common.product.g;
import com.target.mothership.model.product.interfaces.ProductExtendedData;
import com.target.mothership.util.k;

public class TGTProductExtendedData
    implements ProductExtendedData
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductExtendedData a(Parcel parcel)
        {
            return new TGTProductExtendedData(parcel);
        }

        public TGTProductExtendedData[] a(int i)
        {
            return new TGTProductExtendedData[i];
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
    private String mKey;
    private String mValue;

    public TGTProductExtendedData()
    {
    }

    private TGTProductExtendedData(Parcel parcel)
    {
        mKey = parcel.readString();
        mValue = parcel.readString();
    }


    public g a()
    {
        if (mKey.equals(g.DIMENSION_ID.toString()))
        {
            return g.DIMENSION_ID;
        }
        if (mKey.equals(g.ENDECA_ID.toString()))
        {
            return g.ENDECA_ID;
        }
        if (mKey.equals(g.CATEGORY_ID.toString()))
        {
            return g.CATEGORY_ID;
        }
        if (mKey.equals(g.URL.toString()))
        {
            return g.URL;
        } else
        {
            return g.UNKNOWN;
        }
    }

    public void a(String s)
    {
        mKey = s;
    }

    public String b()
    {
        return mValue;
    }

    public void b(String s)
    {
        mValue = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof TGTProductExtendedData))
            {
                return false;
            }
            obj = (TGTProductExtendedData)obj;
            if (!k.a(mKey, ((TGTProductExtendedData) (obj)).mKey) || !k.a(mValue, ((TGTProductExtendedData) (obj)).mValue))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (mKey != null)
        {
            i = mKey.hashCode();
        } else
        {
            i = 0;
        }
        if (mValue != null)
        {
            j = mValue.hashCode();
        }
        return i * 31 + j;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mKey);
        parcel.writeString(mValue);
    }

}
