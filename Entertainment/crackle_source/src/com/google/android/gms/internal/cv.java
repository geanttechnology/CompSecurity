// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            cu

public class cv
    implements android.os.Parcelable.Creator
{

    public cv()
    {
    }

    static void a(cu cu1, Parcel parcel, int i)
    {
        i = b.o(parcel);
        b.c(parcel, 1, cu1.versionCode);
        b.a(parcel, 2, cu1.iJ, false);
        b.c(parcel, 3, cu1.iK);
        b.c(parcel, 4, cu1.iL);
        b.a(parcel, 5, cu1.iM);
        b.D(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return h(parcel);
    }

    public cu h(Parcel parcel)
    {
        boolean flag = false;
        int l = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        String s = null;
        int i = 0;
        int j = 0;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(i1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, i1);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i1);
                    break;

                case 3: // '\003'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    break;

                case 4: // '\004'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    break;

                case 5: // '\005'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new cu(k, s, j, i, flag);
            }
        } while (true);
    }

    public Object[] newArray(int i)
    {
        return o(i);
    }

    public cu[] o(int i)
    {
        return new cu[i];
    }
}
