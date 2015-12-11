// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.gdt;

import android.os.Parcel;
import android.os.Parcelable;

public class GdtFeatures
    implements Parcelable
{
    private static class GdtFeaturesCreator
        implements android.os.Parcelable.Creator
    {

        public GdtFeatures createFromParcel(Parcel parcel)
        {
            return new GdtFeatures(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public GdtFeatures[] newArray(int i)
        {
            return new GdtFeatures[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        private GdtFeaturesCreator()
        {
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new GdtFeaturesCreator();
    public boolean offersDelivery;
    public boolean offersTakeout;

    public GdtFeatures()
    {
    }

    private GdtFeatures(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        offersDelivery = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        offersTakeout = flag;
    }


    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        byte byte0;
        if (offersDelivery)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (offersTakeout)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
    }

}
