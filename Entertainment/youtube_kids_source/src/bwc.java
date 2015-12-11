// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

final class bwc
    implements android.os.Parcelable.Creator
{

    bwc()
    {
    }

    private static bwb a(Parcel parcel)
    {
        try
        {
            parcel = new bwb((dla)a.b(parcel, new dla()), parcel.readString(), parcel.readLong());
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            throw new IllegalArgumentException(parcel);
        }
        return parcel;
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new bwb[i];
    }
}
