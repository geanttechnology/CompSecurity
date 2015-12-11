// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

final class aej
    implements android.os.Parcelable.Creator
{

    aej()
    {
    }

    public final aei createFromParcel(Parcel parcel)
    {
        return new aei(parcel);
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final aei[] newArray(int i)
    {
        return new aei[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }
}
