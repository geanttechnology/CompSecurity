// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.data;

import android.os.Parcel;

// Referenced classes of package com.groupon.models.search.data:
//            FacetValue

public class RangedFacetValue extends FacetValue
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RangedFacetValue createFromParcel(Parcel parcel)
        {
            return new RangedFacetValue(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public RangedFacetValue[] newArray(int i)
        {
            return new RangedFacetValue[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public float max;
    public float min;

    public RangedFacetValue()
    {
    }

    public RangedFacetValue(Parcel parcel)
    {
        super(parcel);
        min = parcel.readFloat();
        max = parcel.readFloat();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(min);
        parcel.writeFloat(max);
    }

}
