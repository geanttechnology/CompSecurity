// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.client.metrics:
//            DataPoint, DataPointType

public class DataPointEnvelope
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

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

    };
    private DataPoint dataPoint;

    DataPointEnvelope(DataPoint datapoint)
    {
        dataPoint = datapoint;
    }

    public static List convertFromEnvelopes(List list)
    {
        int j = list.size();
        ArrayList arraylist = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            arraylist.add(((DataPointEnvelope)list.get(i)).toDataPoint());
        }

        return arraylist;
    }

    public static List convertToEnvelopes(List list)
    {
        int j = list.size();
        ArrayList arraylist = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            arraylist.add(new DataPointEnvelope((DataPoint)list.get(i)));
        }

        return arraylist;
    }

    public int describeContents()
    {
        return 1;
    }

    public DataPoint toDataPoint()
    {
        DataPoint datapoint = dataPoint;
        dataPoint = null;
        return datapoint;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(dataPoint.getName());
        parcel.writeString(dataPoint.getValue());
        parcel.writeInt(dataPoint.getSamples());
        parcel.writeInt(dataPoint.getType().ordinal());
    }

}
