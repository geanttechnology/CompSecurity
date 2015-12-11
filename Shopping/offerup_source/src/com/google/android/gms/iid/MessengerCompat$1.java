// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.iid;

import android.os.Parcel;

// Referenced classes of package com.google.android.gms.iid:
//            MessengerCompat

final class 
    implements android.os.
{

    public final Object createFromParcel(Parcel parcel)
    {
        return zzey(parcel);
    }

    public final Object[] newArray(int i)
    {
        return zzgJ(i);
    }

    public final MessengerCompat zzey(Parcel parcel)
    {
        parcel = parcel.readStrongBinder();
        if (parcel != null)
        {
            return new MessengerCompat(parcel);
        } else
        {
            return null;
        }
    }

    public final MessengerCompat[] zzgJ(int i)
    {
        return new MessengerCompat[i];
    }

    ()
    {
    }
}
