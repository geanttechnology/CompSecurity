// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import auy;
import auz;
import awd;
import awe;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class b
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new awe();
    public final int a;
    public final auy b;
    public final IntentFilter c[];

    public b(int i, IBinder ibinder, IntentFilter aintentfilter[])
    {
        a = i;
        if (ibinder != null)
        {
            b = auz.a(ibinder);
        } else
        {
            b = null;
        }
        c = aintentfilter;
    }

    public b(awd awd1)
    {
        a = 1;
        b = awd1;
        c = awd1.b();
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
        awe.a(this, parcel, i);
    }

}
