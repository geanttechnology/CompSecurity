// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.wishabi.flipp.content:
//            ac

public class b
    implements Parcelable
{

    public static final android.os.tedString.Part.b CREATOR = new ac();
    final String a;
    final t b[];

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(a);
        parcel.writeTypedArray(b, i);
    }


    private t(Parcel parcel)
    {
        a = parcel.readString();
        b = (t[])parcel.createTypedArray(t.CREATOR);
    }

    t.CREATOR(Parcel parcel, byte byte0)
    {
        this(parcel);
    }

    public transient t(String s, t at[])
    {
        a = s;
        b = at;
    }
}
