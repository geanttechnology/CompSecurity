// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

// Referenced classes of package com.google.android.gms.internal:
//            ai

public final class s
    implements android.os.Parcelable.Creator
{

    public s()
    {
    }

    static void a(ai ai1, Parcel parcel)
    {
        int i = c.a(parcel, 20293);
        c.b(parcel, 1, ai1.a);
        c.b(parcel, 2, ai1.b);
        c.b(parcel, 3, ai1.c);
        c.b(parcel, 4, ai1.d);
        c.b(parcel, 5, ai1.e);
        c.b(parcel, 6, ai1.f);
        c.b(parcel, 7, ai1.g);
        c.b(parcel, 8, ai1.h);
        c.b(parcel, 9, ai1.i);
        c.a(parcel, 10, ai1.j, false);
        c.b(parcel, 11, ai1.k);
        c.a(parcel, 12, ai1.l, false);
        c.b(parcel, 13, ai1.m);
        c.b(parcel, 14, ai1.n);
        c.a(parcel, 15, ai1.o, false);
        c.b(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int i3 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int l2 = 0;
        int k2 = 0;
        int j2 = 0;
        int i2 = 0;
        int l1 = 0;
        int k1 = 0;
        int j1 = 0;
        int i1 = 0;
        int l = 0;
        String s3 = null;
        int k = 0;
        String s2 = null;
        int j = 0;
        int i = 0;
        String s1 = null;
        do
        {
            if (parcel.dataPosition() < i3)
            {
                int j3 = parcel.readInt();
                switch (0xffff & j3)
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, j3);
                    break;

                case 1: // '\001'
                    l2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, j3);
                    break;

                case 2: // '\002'
                    k2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, j3);
                    break;

                case 3: // '\003'
                    j2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, j3);
                    break;

                case 4: // '\004'
                    i2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, j3);
                    break;

                case 5: // '\005'
                    l1 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, j3);
                    break;

                case 6: // '\006'
                    k1 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, j3);
                    break;

                case 7: // '\007'
                    j1 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, j3);
                    break;

                case 8: // '\b'
                    i1 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, j3);
                    break;

                case 9: // '\t'
                    l = com.google.android.gms.common.internal.safeparcel.a.e(parcel, j3);
                    break;

                case 10: // '\n'
                    s3 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, j3);
                    break;

                case 11: // '\013'
                    k = com.google.android.gms.common.internal.safeparcel.a.e(parcel, j3);
                    break;

                case 12: // '\f'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, j3);
                    break;

                case 13: // '\r'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, j3);
                    break;

                case 14: // '\016'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, j3);
                    break;

                case 15: // '\017'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, j3);
                    break;
                }
            } else
            if (parcel.dataPosition() != i3)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(i3).toString(), parcel);
            } else
            {
                return new ai(l2, k2, j2, i2, l1, k1, j1, i1, l, s3, k, s2, j, i, s1);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new ai[i];
    }
}
