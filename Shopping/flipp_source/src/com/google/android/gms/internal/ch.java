// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.a.d;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

// Referenced classes of package com.google.android.gms.internal:
//            bm, bj, cu

public final class ch
    implements android.os.Parcelable.Creator
{

    public ch()
    {
    }

    static void a(bm bm1, Parcel parcel, int i)
    {
        int j = c.a(parcel, 20293);
        c.b(parcel, 1, bm1.a);
        c.a(parcel, 2, bm1.b, i, false);
        c.a(parcel, 3, d.a(bm1.c).asBinder());
        c.a(parcel, 4, d.a(bm1.d).asBinder());
        c.a(parcel, 5, d.a(bm1.e).asBinder());
        c.a(parcel, 6, d.a(bm1.f).asBinder());
        c.a(parcel, 7, bm1.g, false);
        c.a(parcel, 8, bm1.h);
        c.a(parcel, 9, bm1.i, false);
        c.a(parcel, 10, d.a(bm1.j).asBinder());
        c.b(parcel, 11, bm1.k);
        c.b(parcel, 12, bm1.l);
        c.a(parcel, 13, bm1.m, false);
        c.a(parcel, 14, bm1.n, i, false);
        c.b(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int l = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int k = 0;
        bj bj1 = null;
        android.os.IBinder ibinder4 = null;
        android.os.IBinder ibinder3 = null;
        android.os.IBinder ibinder2 = null;
        android.os.IBinder ibinder1 = null;
        String s2 = null;
        boolean flag = false;
        String s1 = null;
        android.os.IBinder ibinder = null;
        int j = 0;
        int i = 0;
        String s = null;
        cu cu1 = null;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = parcel.readInt();
                switch (0xffff & i1)
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, i1);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;

                case 2: // '\002'
                    bj1 = (bj)com.google.android.gms.common.internal.safeparcel.a.a(parcel, i1, bj.CREATOR);
                    break;

                case 3: // '\003'
                    ibinder4 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, i1);
                    break;

                case 4: // '\004'
                    ibinder3 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, i1);
                    break;

                case 5: // '\005'
                    ibinder2 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, i1);
                    break;

                case 6: // '\006'
                    ibinder1 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, i1);
                    break;

                case 7: // '\007'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, i1);
                    break;

                case 8: // '\b'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, i1);
                    break;

                case 9: // '\t'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, i1);
                    break;

                case 10: // '\n'
                    ibinder = com.google.android.gms.common.internal.safeparcel.a.l(parcel, i1);
                    break;

                case 11: // '\013'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;

                case 12: // '\f'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;

                case 13: // '\r'
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, i1);
                    break;

                case 14: // '\016'
                    cu1 = (cu)com.google.android.gms.common.internal.safeparcel.a.a(parcel, i1, cu.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
            } else
            {
                return new bm(k, bj1, ibinder4, ibinder3, ibinder2, ibinder1, s2, flag, s1, ibinder, j, i, s, cu1);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new bm[i];
    }
}
