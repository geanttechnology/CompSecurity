// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import java.util.Collections;

final class btw
    implements android.os.Parcelable.Creator
{

    btw()
    {
    }

    private static btv a(Parcel parcel)
    {
        try
        {
            parcel = new btv((amw)a.b(parcel, new amw()));
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            return new btv("", Collections.emptySet());
        }
        return parcel;
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new btv[i];
    }
}
