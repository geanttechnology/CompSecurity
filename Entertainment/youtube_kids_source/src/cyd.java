// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

final class cyd
    implements android.os.Parcelable.Creator
{

    cyd()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return new cyc(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new cyc[i];
    }
}
