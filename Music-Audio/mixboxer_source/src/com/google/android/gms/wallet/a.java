// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.wallet:
//            Address

public class a
    implements android.os.Parcelable.Creator
{

    public a()
    {
    }

    static void a(Address address, Parcel parcel, int i)
    {
        i = b.o(parcel);
        b.c(parcel, 1, address.getVersionCode());
        b.a(parcel, 2, address.name, false);
        b.a(parcel, 3, address.Ga, false);
        b.a(parcel, 4, address.Gb, false);
        b.a(parcel, 5, address.Gc, false);
        b.a(parcel, 6, address.id, false);
        b.a(parcel, 7, address.Gd, false);
        b.a(parcel, 8, address.Ge, false);
        b.a(parcel, 9, address.Gf, false);
        b.a(parcel, 10, address.Gg, false);
        b.a(parcel, 11, address.Gh);
        b.a(parcel, 12, address.Gi, false);
        b.D(parcel, i);
    }

    public Address aE(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int i = 0;
        String s9 = null;
        String s8 = null;
        String s7 = null;
        String s6 = null;
        String s5 = null;
        String s4 = null;
        String s3 = null;
        String s2 = null;
        String s1 = null;
        boolean flag = false;
        String s = null;
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
                    s9 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;

                case 3: // '\003'
                    s8 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;

                case 4: // '\004'
                    s7 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;

                case 5: // '\005'
                    s6 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;

                case 6: // '\006'
                    s5 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;

                case 7: // '\007'
                    s4 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;

                case 8: // '\b'
                    s3 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;

                case 9: // '\t'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;

                case 10: // '\n'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;

                case 11: // '\013'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, k);
                    break;

                case 12: // '\f'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new Address(i, s9, s8, s7, s6, s5, s4, s3, s2, s1, flag, s);
            }
        } while (true);
    }

    public Address[] bw(int i)
    {
        return new Address[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return aE(parcel);
    }

    public Object[] newArray(int i)
    {
        return bw(i);
    }
}
