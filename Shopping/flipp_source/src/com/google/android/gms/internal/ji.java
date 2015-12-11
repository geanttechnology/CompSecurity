// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

// Referenced classes of package com.google.android.gms.internal:
//            hd, hb

public final class ji
    implements android.os.Parcelable.Creator
{

    public ji()
    {
    }

    public static hb a(Parcel parcel)
    {
        float af[] = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int i = 0;
        long l = 0L;
        hd ahd[] = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = parcel.readInt();
                switch (0xffff & k)
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    ahd = (hd[])com.google.android.gms.common.internal.safeparcel.a.b(parcel, k, hd.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, k);
                    break;

                case 2: // '\002'
                    af = com.google.android.gms.common.internal.safeparcel.a.o(parcel, k);
                    break;

                case 3: // '\003'
                    l = com.google.android.gms.common.internal.safeparcel.a.f(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new hb(i, ahd, af, l);
            }
        } while (true);
    }

    static void a(hb hb1, Parcel parcel, int i)
    {
        int j = c.a(parcel, 20293);
        c.a(parcel, 1, hb1.b, i);
        c.b(parcel, 1000, hb1.a);
        float af[] = hb1.c;
        if (af != null)
        {
            i = c.a(parcel, 2);
            parcel.writeFloatArray(af);
            c.b(parcel, i);
        }
        c.a(parcel, 3, hb1.d);
        c.b(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new hb[i];
    }
}
