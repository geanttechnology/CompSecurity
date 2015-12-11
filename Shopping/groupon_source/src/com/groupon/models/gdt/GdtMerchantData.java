// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.gdt;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.groupon.models.gdt:
//            GdtFeatures

public class GdtMerchantData
    implements Parcelable
{
    private static class GdtMerchantDataCreator
        implements android.os.Parcelable.Creator
    {

        public GdtMerchantData createFromParcel(Parcel parcel)
        {
            return new GdtMerchantData(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public GdtMerchantData[] newArray(int i)
        {
            return new GdtMerchantData[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        private GdtMerchantDataCreator()
        {
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new GdtMerchantDataCreator();
    public GdtFeatures gdtFeatures;
    public String merchantId;

    public GdtMerchantData()
    {
    }

    private GdtMerchantData(Parcel parcel)
    {
        merchantId = parcel.readString();
        gdtFeatures = (GdtFeatures)parcel.readParcelable(com/groupon/models/gdt/GdtFeatures.getClassLoader());
    }


    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(merchantId);
        parcel.writeParcelable(gdtFeatures, i);
    }

}
