// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.smule.android.network.core.t;
import com.smule.android.network.models.PerformanceV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetConnectedPerformancesResponse extends t
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public GetConnectedPerformancesResponse a(Parcel parcel)
        {
            return new GetConnectedPerformancesResponse(parcel);
        }

        public GetConnectedPerformancesResponse[] a(int i)
        {
            return new GetConnectedPerformancesResponse[i];
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
    public List performanceIcons;

    public GetConnectedPerformancesResponse()
    {
        performanceIcons = new ArrayList();
    }

    public GetConnectedPerformancesResponse(Parcel parcel)
    {
        performanceIcons = new ArrayList();
        performanceIcons = parcel.readArrayList(com/smule/android/network/response/GetConnectedPerformancesResponse.getClassLoader());
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        StringBuilder stringbuilder1 = stringbuilder.append("status=");
        Object obj;
        if (a())
        {
            obj = "ok";
        } else
        {
            obj = "fail";
        }
        stringbuilder1.append(((String) (obj))).append(' ');
        stringbuilder.append("performanceIcons=[");
        obj = performanceIcons.iterator();
        for (boolean flag = true; ((Iterator) (obj)).hasNext(); flag = false)
        {
            PerformanceV2 performancev2 = (PerformanceV2)((Iterator) (obj)).next();
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(performancev2.toString());
        }

        stringbuilder.append(']');
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeList(performanceIcons);
    }

}
