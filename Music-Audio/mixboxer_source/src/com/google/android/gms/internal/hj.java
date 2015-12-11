// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            hi

public class hj
    implements android.os.Parcelable.Creator
{

    public hj()
    {
    }

    static void a(hi hi1, Parcel parcel, int i)
    {
        i = b.o(parcel);
        b.a(parcel, 1, hi1.Bn, false);
        b.c(parcel, 1000, hi1.versionCode);
        b.a(parcel, 2, hi1.Bo, false);
        b.D(parcel, i);
    }

    public hi aq(Parcel parcel)
    {
        String s1 = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int i = 0;
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
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 2: // '\002'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new hi(i, s, s1);
            }
        } while (true);
    }

    public hi[] bg(int i)
    {
        return new hi[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return aq(parcel);
    }

    public Object[] newArray(int i)
    {
        return bg(i);
    }
}
