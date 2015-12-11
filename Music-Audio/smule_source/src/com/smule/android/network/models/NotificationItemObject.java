// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.smule.android.network.models:
//            PerformanceV2

public class NotificationItemObject
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public NotificationItemObject a(Parcel parcel)
        {
            return new NotificationItemObject(parcel);
        }

        public NotificationItemObject[] a(int i)
        {
            return new NotificationItemObject[i];
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
    public PerformanceV2 performanceIcon;

    public NotificationItemObject()
    {
    }

    private NotificationItemObject(Parcel parcel)
    {
        performanceIcon = (PerformanceV2)parcel.readParcelable(com/smule/android/network/models/PerformanceV2.getClassLoader());
    }


    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("NotificationItemObject{performanceIcon=").append(performanceIcon).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(performanceIcon, 0);
    }

}
