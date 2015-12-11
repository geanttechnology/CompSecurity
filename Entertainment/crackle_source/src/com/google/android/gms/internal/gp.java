// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            go

public class gp
    implements android.os.Parcelable.Creator
{

    public gp()
    {
    }

    static void a(go go1, Parcel parcel, int i)
    {
        i = b.o(parcel);
        b.a(parcel, 1, go1.getRequestId(), false);
        b.c(parcel, 1000, go1.getVersionCode());
        b.a(parcel, 2, go1.getExpirationTime());
        b.a(parcel, 3, go1.dK());
        b.a(parcel, 4, go1.getLatitude());
        b.a(parcel, 5, go1.getLongitude());
        b.a(parcel, 6, go1.dL());
        b.c(parcel, 7, go1.dM());
        b.c(parcel, 8, go1.getNotificationResponsiveness());
        b.c(parcel, 9, go1.dN());
        b.D(parcel, i);
    }

    public go[] aX(int i)
    {
        return new go[i];
    }

    public go ai(Parcel parcel)
    {
        int i1 = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int l = 0;
        String s = null;
        int k = 0;
        short word0 = 0;
        double d1 = 0.0D;
        double d = 0.0D;
        float f = 0.0F;
        long l1 = 0L;
        int j = 0;
        int i = -1;
        do
        {
            if (parcel.dataPosition() < i1)
            {
                int j1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(j1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, j1);
                    break;

                case 1: // '\001'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, j1);
                    break;

                case 1000: 
                    l = com.google.android.gms.common.internal.safeparcel.a.g(parcel, j1);
                    break;

                case 2: // '\002'
                    l1 = com.google.android.gms.common.internal.safeparcel.a.h(parcel, j1);
                    break;

                case 3: // '\003'
                    word0 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, j1);
                    break;

                case 4: // '\004'
                    d1 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, j1);
                    break;

                case 5: // '\005'
                    d = com.google.android.gms.common.internal.safeparcel.a.k(parcel, j1);
                    break;

                case 6: // '\006'
                    f = com.google.android.gms.common.internal.safeparcel.a.j(parcel, j1);
                    break;

                case 7: // '\007'
                    k = com.google.android.gms.common.internal.safeparcel.a.g(parcel, j1);
                    break;

                case 8: // '\b'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, j1);
                    break;

                case 9: // '\t'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, j1);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(i1).toString(), parcel);
            } else
            {
                return new go(l, s, k, word0, d1, d, f, l1, j, i);
            }
        } while (true);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return ai(parcel);
    }

    public Object[] newArray(int i)
    {
        return aX(i);
    }
}
