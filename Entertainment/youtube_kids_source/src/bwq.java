// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

final class bwq
    implements android.os.Parcelable.Creator
{

    bwq()
    {
    }

    private static bwp a(Parcel parcel)
    {
        try
        {
            parcel = new bwp((dts)a.b(parcel, new dts()));
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            return new bwp();
        }
        return parcel;
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new bwp[i];
    }
}
