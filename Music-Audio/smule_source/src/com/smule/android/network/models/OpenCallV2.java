// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;

// Referenced classes of package com.smule.android.network.models:
//            PerformanceV2

public class OpenCallV2
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public OpenCallV2 a(Parcel parcel)
        {
            return new OpenCallV2(parcel);
        }

        public OpenCallV2[] a(int i)
        {
            return new OpenCallV2[i];
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
    private static final String a = com/smule/android/network/models/OpenCallV2.getName();
    public File backgroundTrackFileAbsolutePath;
    public long expireAt;
    public boolean isClosed;
    public boolean isPrivate;
    public int numJoins;
    public String opencallKey;
    private PerformanceV2 performance;
    private PerformanceV2 performanceIcon;
    public String type;

    public OpenCallV2()
    {
    }

    public OpenCallV2(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        opencallKey = parcel.readString();
        type = parcel.readString();
        boolean flag;
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isPrivate = flag;
        if (parcel.readInt() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isClosed = flag;
        expireAt = parcel.readLong();
        numJoins = parcel.readInt();
        performance = (PerformanceV2)parcel.readParcelable(com/smule/android/network/models/PerformanceV2.getClassLoader());
        performanceIcon = (PerformanceV2)parcel.readParcelable(com/smule/android/network/models/PerformanceV2.getClassLoader());
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        String s;
        if (opencallKey == null)
        {
            s = "";
        } else
        {
            s = opencallKey;
        }
        parcel.writeString(s);
        if (type == null)
        {
            s = "";
        } else
        {
            s = type;
        }
        parcel.writeString(s);
        if (isPrivate)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (isClosed)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeLong(expireAt);
        parcel.writeInt(numJoins);
        parcel.writeParcelable(performance, 0);
        parcel.writeParcelable(performanceIcon, 0);
    }

}
