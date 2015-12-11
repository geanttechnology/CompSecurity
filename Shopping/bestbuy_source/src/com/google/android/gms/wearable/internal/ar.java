// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import auy;
import auz;
import avr;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ar
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new avr();
    public final int a;
    public final auy b;

    public ar(int i, IBinder ibinder)
    {
        a = i;
        if (ibinder != null)
        {
            b = auz.a(ibinder);
            return;
        } else
        {
            b = null;
            return;
        }
    }

    public ar(auy auy1)
    {
        a = 1;
        b = auy1;
    }

    public IBinder a()
    {
        if (b == null)
        {
            return null;
        } else
        {
            return b.asBinder();
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        avr.a(this, parcel, i);
    }

}
