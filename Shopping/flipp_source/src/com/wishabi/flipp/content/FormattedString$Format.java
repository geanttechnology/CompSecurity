// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.wishabi.flipp.content:
//            aa, ab

public class <init>
    implements Parcelable
{

    public static final android.os.dString.Format.c CREATOR = new aa();
    final int a;
    final int b;
    final float c;

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(a - 1);
        parcel.writeInt(b);
        parcel.writeFloat(c);
    }


    public (int i)
    {
        this(i, (byte)0);
    }

    private <init>(int i, byte byte0)
    {
        byte0 = i;
        if (i == 0)
        {
            byte0 = ab.a;
        }
        a = byte0;
        b = -1;
        c = -1F;
    }

    private c(Parcel parcel)
    {
        a = ab.a()[parcel.readInt()];
        b = parcel.readInt();
        c = parcel.readFloat();
    }

    c(Parcel parcel, byte byte0)
    {
        this(parcel);
    }
}
