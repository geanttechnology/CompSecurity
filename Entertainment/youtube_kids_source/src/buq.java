// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

final class buq
    implements android.os.Parcelable.Creator
{

    buq()
    {
    }

    private static bup a(Parcel parcel)
    {
        try
        {
            parcel = new bup((amx)a.b(parcel, new amx()));
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            return bup.a;
        }
        return parcel;
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new bup[i];
    }
}
