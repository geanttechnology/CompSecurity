// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.location:
//            f

public class g
    implements android.os.Parcelable.Creator
{

    public g()
    {
    }

    static void a(f f1, Parcel parcel, int i)
    {
        int j = b.o(parcel);
        b.a(parcel, 1, f1.dB(), i, false);
        b.c(parcel, 1000, f1.getVersionCode());
        b.a(parcel, 2, f1.dC(), false);
        b.D(parcel, j);
    }

    public f[] aT(int i)
    {
        return new f[i];
    }

    public f ag(Parcel parcel)
    {
        String s = null;
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

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new f(i, pendingintent, s);
            }
        } while (true);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return ag(parcel);
    }

    public Object[] newArray(int i)
    {
        return aT(i);
    }
}
