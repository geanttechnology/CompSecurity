// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

final class bva
    implements android.os.Parcelable.Creator
{

    bva()
    {
    }

    private static buz a(Parcel parcel)
    {
        try
        {
            parcel = new buz(parcel);
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            throw new RuntimeException("Failed to parse VastAd's annotations parcel", parcel);
        }
        return parcel;
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new buz[i];
    }
}
