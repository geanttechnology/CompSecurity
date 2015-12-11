// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

// Referenced classes of package com.google.android.gms.internal:
//            x

public final class ky
    implements android.os.Parcelable.Creator
{

    public ky()
    {
    }

    public static x a(Parcel parcel)
    {
        x ax[] = null;
        int i = 0;
        int j1 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int j = 0;
        boolean flag = false;
        int k = 0;
        int l = 0;
        String s = null;
        int i1 = 0;
        do
        {
            if (parcel.dataPosition() < j1)
            {
                int k1 = parcel.readInt();
                switch (0xffff & k1)
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k1);
                    break;

                case 1: // '\001'
                    i1 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, k1);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, k1);
                    break;

                case 3: // '\003'
                    l = com.google.android.gms.common.internal.safeparcel.a.e(parcel, k1);
                    break;

                case 4: // '\004'
                    k = com.google.android.gms.common.internal.safeparcel.a.e(parcel, k1);
                    break;

                case 5: // '\005'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, k1);
                    break;

                case 6: // '\006'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, k1);
                    break;

                case 7: // '\007'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, k1);
                    break;

                case 8: // '\b'
                    ax = (x[])com.google.android.gms.common.internal.safeparcel.a.b(parcel, k1, x.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j1)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(j1).toString(), parcel);
            } else
            {
                return new x(i1, s, l, k, flag, j, i, ax);
            }
        } while (true);
    }

    static void a(x x1, Parcel parcel, int i)
    {
        int j = c.a(parcel, 20293);
        c.b(parcel, 1, x1.a);
        c.a(parcel, 2, x1.b, false);
        c.b(parcel, 3, x1.c);
        c.b(parcel, 4, x1.d);
        c.a(parcel, 5, x1.e);
        c.b(parcel, 6, x1.f);
        c.b(parcel, 7, x1.g);
        c.a(parcel, 8, x1.h, i);
        c.b(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new x[i];
    }
}
