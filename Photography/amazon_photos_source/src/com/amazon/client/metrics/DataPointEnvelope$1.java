// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import android.os.Parcel;

// Referenced classes of package com.amazon.client.metrics:
//            DataPointEnvelope, DataPoint, DataPointType

static final class 
    implements android.os.ointEnvelope._cls1
{

    public DataPointEnvelope createFromParcel(Parcel parcel)
    {
        return new DataPointEnvelope(new DataPoint(parcel.readString(), parcel.readString(), parcel.readInt(), DataPointType.fromInt(parcel.readInt())));
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public DataPointEnvelope[] newArray(int i)
    {
        return new DataPointEnvelope[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
