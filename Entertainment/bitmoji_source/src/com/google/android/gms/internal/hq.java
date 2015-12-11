// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            hp

public class hq
    implements android.os.Parcelable.Creator
{

    public hq()
    {
    }

    static void a(hp hp1, Parcel parcel, int i)
    {
        i = b.p(parcel);
        b.c(parcel, 1, hp1.wj);
        b.a(parcel, 2, hp1.gt(), false);
        b.a(parcel, 3, hp1.getTag(), false);
        b.D(parcel, i);
    }

    public hp ax(Parcel parcel)
    {
        String s1 = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.o(parcel);
        int i = 0;
        String s = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.S(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;

                case 3: // '\003'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new hp(i, s, s1);
            }
        } while (true);
    }

    public hp[] br(int i)
    {
        return new hp[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return ax(parcel);
    }

    public Object[] newArray(int i)
    {
        return br(i);
    }
}
