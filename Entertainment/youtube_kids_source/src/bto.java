// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;

public final class bto
    implements Parcelable, bvz
{

    public static final android.os.Parcelable.Creator CREATOR = new btp();
    private final dxw a;

    bto(Parcel parcel)
    {
        this((dxw)a.b(parcel, new dxw()));
    }

    public bto(dxw dxw1)
    {
        a = (dxw)b.a(dxw1);
    }

    public final byte[] a()
    {
        return a.a;
    }

    public final bvz b()
    {
        return null;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        a.a(parcel, a);
    }

}
