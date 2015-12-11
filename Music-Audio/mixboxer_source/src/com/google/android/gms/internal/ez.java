// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            ey, ev

public class ez
    implements android.os.Parcelable.Creator
{

    public ez()
    {
    }

    static void a(ey ey1, Parcel parcel, int i)
    {
        int j = b.o(parcel);
        b.c(parcel, 1, ey1.getVersionCode());
        b.a(parcel, 2, ey1.cB(), false);
        b.a(parcel, 3, ey1.cC(), i, false);
        b.D(parcel, j);
    }

    public ey[] V(int i)
    {
        return new ey[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return x(parcel);
    }

    public Object[] newArray(int i)
    {
        return V(i);
    }

    public ey x(Parcel parcel)
    {
        ev ev1 = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int i = 0;
        Parcel parcel1 = null;
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
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 2: // '\002'
                    parcel1 = com.google.android.gms.common.internal.safeparcel.a.z(parcel, k);
                    break;

                case 3: // '\003'
                    ev1 = (ev)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, ev.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new ey(i, parcel1, ev1);
            }
        } while (true);
    }
}
