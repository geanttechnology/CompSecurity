// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.google.android.gms.common.internal:
//            a

public final class BinderWrapper
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new a();
    private IBinder a;

    public BinderWrapper()
    {
        a = null;
    }

    public BinderWrapper(IBinder ibinder)
    {
        a = null;
        a = ibinder;
    }

    private BinderWrapper(Parcel parcel)
    {
        a = null;
        a = parcel.readStrongBinder();
    }

    BinderWrapper(Parcel parcel, byte byte0)
    {
        this(parcel);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeStrongBinder(a);
    }

}
