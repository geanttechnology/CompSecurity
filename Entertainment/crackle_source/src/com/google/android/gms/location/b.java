// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;

// Referenced classes of package com.google.android.gms.location:
//            a

public class b
    implements android.os.Parcelable.Creator
{

    public b()
    {
    }

    static void a(com.google.android.gms.location.a a1, Parcel parcel, int i)
    {
        int j = com.google.android.gms.common.internal.safeparcel.b.o(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, a1.dB(), i, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1000, a1.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.b.D(parcel, j);
    }

    public com.google.android.gms.location.a[] aN(int i)
    {
        return new com.google.android.gms.location.a[i];
    }

    public com.google.android.gms.location.a ae(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int i = 0;
        PendingIntent pendingintent = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    pendingintent = (PendingIntent)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, PendingIntent.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new com.google.android.gms.location.a(i, pendingintent);
            }
        } while (true);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return ae(parcel);
    }

    public Object[] newArray(int i)
    {
        return aN(i);
    }
}
