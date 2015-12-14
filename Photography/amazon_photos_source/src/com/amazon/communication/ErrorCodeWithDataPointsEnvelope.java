// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.client.metrics.DataPointEnvelope;
import java.util.ArrayList;

// Referenced classes of package com.amazon.communication:
//            ErrorCodeWithDataPoints

public class ErrorCodeWithDataPointsEnvelope
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

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

    };
    private ErrorCodeWithDataPoints mErrorCodeWithDataPoints;

    public ErrorCodeWithDataPointsEnvelope(ErrorCodeWithDataPoints errorcodewithdatapoints)
    {
        mErrorCodeWithDataPoints = errorcodewithdatapoints;
    }

    public int describeContents()
    {
        return 1;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(mErrorCodeWithDataPoints.getCode());
        parcel.writeList(mErrorCodeWithDataPoints.getDataPoints());
    }

}
