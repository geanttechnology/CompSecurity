// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class OfferUpBoolean
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public boolean value;

    public OfferUpBoolean()
    {
        this(0);
    }

    public OfferUpBoolean(int i)
    {
        boolean flag = false;
        super();
        value = false;
        if (i != 0)
        {
            flag = true;
        }
        value = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (value)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final OfferUpBoolean createFromParcel(Parcel parcel)
        {
            boolean flag = true;
            OfferUpBoolean offerupboolean = new OfferUpBoolean();
            if (parcel.readInt() != 1)
            {
                flag = false;
            }
            offerupboolean.value = flag;
            return offerupboolean;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final OfferUpBoolean[] newArray(int i)
        {
            return new OfferUpBoolean[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
