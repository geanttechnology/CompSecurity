// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.plus.internal:
//            PlusCommonExtras

public class f
    implements android.os.Parcelable.Creator
{

    public f()
    {
    }

    static void a(PlusCommonExtras pluscommonextras, Parcel parcel, int i)
    {
        i = b.p(parcel);
        b.a(parcel, 1, pluscommonextras.ho(), false);
        b.c(parcel, 1000, pluscommonextras.getVersionCode());
        b.a(parcel, 2, pluscommonextras.hp(), false);
        b.D(parcel, i);
    }

    public PlusCommonExtras aE(Parcel parcel)
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
                return new PlusCommonExtras(i, s, s1);
            }
        } while (true);
    }

    public PlusCommonExtras[] bB(int i)
    {
        return new PlusCommonExtras[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return aE(parcel);
    }

    public Object[] newArray(int i)
    {
        return bB(i);
    }
}
