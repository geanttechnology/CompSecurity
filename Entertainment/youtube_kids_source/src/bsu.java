// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

final class bsu
    implements android.os.Parcelable.Creator
{

    bsu()
    {
    }

    private static bst a(Parcel parcel)
    {
        try
        {
            parcel = new bst((amt)a.b(parcel, new amt()));
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            return new bst();
        }
        return parcel;
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new bst[i];
    }
}
