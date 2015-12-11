// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

final class cdx
    implements android.os.Parcelable.Creator
{

    cdx()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return new cdw(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new cdw[i];
    }
}
