// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            bm, bj, cu

public class bl
    implements android.os.Parcelable.Creator
{

    public bl()
    {
    }

    static void a(bm bm1, Parcel parcel, int i)
    {
        int k = b.o(parcel);
        b.c(parcel, 1, bm1.versionCode);
        b.a(parcel, 2, bm1.gG, i, false);
        b.a(parcel, 3, bm1.aa(), false);
        b.a(parcel, 4, bm1.ab(), false);
        b.a(parcel, 5, bm1.ac(), false);
        b.a(parcel, 6, bm1.ad(), false);
        b.a(parcel, 7, bm1.gL, false);
        b.a(parcel, 8, bm1.gM);
        b.a(parcel, 9, bm1.gN, false);
        b.a(parcel, 10, bm1.ae(), false);
        b.c(parcel, 11, bm1.orientation);
        b.c(parcel, 12, bm1.gP);
        b.a(parcel, 13, bm1.go, false);
        b.a(parcel, 14, bm1.ej, i, false);
        b.D(parcel, k);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return e(parcel);
    }

    public bm e(Parcel parcel)
    {
        int i1 = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int l = 0;
        bj bj1 = null;
        android.os.IBinder ibinder4 = null;
        android.os.IBinder ibinder3 = null;
        android.os.IBinder ibinder2 = null;
        android.os.IBinder ibinder1 = null;
        String s2 = null;
        boolean flag = false;
        String s1 = null;
        android.os.IBinder ibinder = null;
        int k = 0;
        int i = 0;
        String s = null;
        cu cu1 = null;
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
                    l = com.google.android.gms.common.internal.safeparcel.a.g(parcel, j1);
                    break;

                case 2: // '\002'
                    bj1 = (bj)com.google.android.gms.common.internal.safeparcel.a.a(parcel, j1, bj.CREATOR);
                    break;

                case 3: // '\003'
                    ibinder4 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, j1);
                    break;

                case 4: // '\004'
                    ibinder3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, j1);
                    break;

                case 5: // '\005'
                    ibinder2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, j1);
                    break;

                case 6: // '\006'
                    ibinder1 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, j1);
                    break;

                case 7: // '\007'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, j1);
                    break;

                case 8: // '\b'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, j1);
                    break;

                case 9: // '\t'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, j1);
                    break;

                case 10: // '\n'
                    ibinder = com.google.android.gms.common.internal.safeparcel.a.n(parcel, j1);
                    break;

                case 11: // '\013'
                    k = com.google.android.gms.common.internal.safeparcel.a.g(parcel, j1);
                    break;

                case 12: // '\f'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, j1);
                    break;

                case 13: // '\r'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, j1);
                    break;

                case 14: // '\016'
                    cu1 = (cu)com.google.android.gms.common.internal.safeparcel.a.a(parcel, j1, cu.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(i1).toString(), parcel);
            } else
            {
                return new bm(l, bj1, ibinder4, ibinder3, ibinder2, ibinder1, s2, flag, s1, ibinder, k, i, s, cu1);
            }
        } while (true);
    }

    public bm[] j(int i)
    {
        return new bm[i];
    }

    public Object[] newArray(int i)
    {
        return j(i);
    }
}
