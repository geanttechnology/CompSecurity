// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            gt, gx

public class gu
    implements android.os.Parcelable.Creator
{

    public gu()
    {
    }

    static void a(gt gt1, Parcel parcel, int i)
    {
        i = b.o(parcel);
        b.c(parcel, 1, gt1.dO());
        b.c(parcel, 1000, gt1.kg);
        b.b(parcel, 2, gt1.yg, false);
        b.a(parcel, 3, gt1.dP(), false);
        b.a(parcel, 4, gt1.dQ(), false);
        b.a(parcel, 5, gt1.dR());
        b.D(parcel, i);
    }

    public gt[] aY(int i)
    {
        return new gt[i];
    }

    public gt aj(Parcel parcel)
    {
        String s = null;
        boolean flag = false;
        int k = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        String s1 = null;
        java.util.ArrayList arraylist = null;
        int i = 0;
        int j = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 1000: 
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 2: // '\002'
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l, gx.CREATOR);
                    break;

                case 3: // '\003'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 4: // '\004'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 5: // '\005'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new gt(j, i, arraylist, s1, s, flag);
            }
        } while (true);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return aj(parcel);
    }

    public Object[] newArray(int i)
    {
        return aY(i);
    }
}
