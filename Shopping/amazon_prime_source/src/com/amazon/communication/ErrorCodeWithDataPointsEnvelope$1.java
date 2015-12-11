// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import android.os.Parcel;
import com.amazon.client.metrics.DataPointEnvelope;
import java.util.ArrayList;

// Referenced classes of package com.amazon.communication:
//            ErrorCodeWithDataPointsEnvelope, ErrorCodeWithDataPoints

static final class 
    implements android.os.ntsEnvelope._cls1
{

    public ErrorCodeWithDataPointsEnvelope createFromParcel(Parcel parcel)
    {
        int i = parcel.readInt();
        ArrayList arraylist = new ArrayList();
        parcel.readList(arraylist, com/amazon/client/metrics/DataPointEnvelope.getClassLoader());
        return new ErrorCodeWithDataPointsEnvelope(new ErrorCodeWithDataPoints(i, arraylist));
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public ErrorCodeWithDataPointsEnvelope[] newArray(int i)
    {
        return new ErrorCodeWithDataPointsEnvelope[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
