// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

final class ctp
    implements android.os.Parcelable.Creator
{

    ctp()
    {
    }

    private static cto a(Parcel parcel)
    {
        try
        {
            parcel = (ams)a.b(parcel, new ams());
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            return null;
        }
        if (parcel == null)
        {
            return null;
        }
        parcel = new cto(parcel);
        return parcel;
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new cto[i];
    }
}
