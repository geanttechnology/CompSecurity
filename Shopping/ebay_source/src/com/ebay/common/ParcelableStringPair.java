// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableStringPair
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ParcelableStringPair createFromParcel(Parcel parcel)
        {
            return new ParcelableStringPair(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ParcelableStringPair[] newArray(int i)
        {
            return new ParcelableStringPair[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String m_a;
    public String m_b;

    private ParcelableStringPair(Parcel parcel)
    {
        String s = parcel.readString();
        if (s.equals("null"))
        {
            m_a = null;
        } else
        {
            m_a = s;
        }
        parcel = parcel.readString();
        if (parcel.equals("null"))
        {
            m_b = null;
            return;
        } else
        {
            m_b = parcel;
            return;
        }
    }


    public ParcelableStringPair(String s, String s1)
    {
        m_a = s;
        m_b = s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (m_a == null)
        {
            parcel.writeString("null");
        } else
        {
            parcel.writeString(m_a);
        }
        if (m_b == null)
        {
            parcel.writeString("null");
            return;
        } else
        {
            parcel.writeString(m_b);
            return;
        }
    }

}
