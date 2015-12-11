// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

final class btp
    implements android.os.Parcelable.Creator
{

    btp()
    {
    }

    private static bto a(Parcel parcel)
    {
        try
        {
            parcel = new bto(parcel);
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            return null;
        }
        return parcel;
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new bto[i];
    }
}
