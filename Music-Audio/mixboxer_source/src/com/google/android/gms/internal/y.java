// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            x

public class y
    implements android.os.Parcelable.Creator
{

    public y()
    {
    }

    static void a(x x1, Parcel parcel, int i)
    {
        int j = com.google.android.gms.common.internal.safeparcel.b.o(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, x1.versionCode);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, x1.eF, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 3, x1.height);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 4, x1.heightPixels);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, x1.eG);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 6, x1.width);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 7, x1.widthPixels);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, x1.eH, i, false);
        com.google.android.gms.common.internal.safeparcel.b.D(parcel, j);
    }

    public x b(Parcel parcel)
    {
        x ax[] = null;
        int i = 0;
        int j1 = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
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
                int k1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(k1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k1);
                    break;

                case 1: // '\001'
                    i1 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k1);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k1);
                    break;

                case 3: // '\003'
                    l = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k1);
                    break;

                case 4: // '\004'
                    k = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k1);
                    break;

                case 5: // '\005'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, k1);
                    break;

                case 6: // '\006'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k1);
                    break;

                case 7: // '\007'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k1);
                    break;

                case 8: // '\b'
                    ax = (x[])com.google.android.gms.common.internal.safeparcel.a.b(parcel, k1, x.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j1)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j1).toString(), parcel);
            } else
            {
                return new x(i1, s, l, k, flag, j, i, ax);
            }
        } while (true);
    }

    public x[] c(int i)
    {
        return new x[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return b(parcel);
    }

    public Object[] newArray(int i)
    {
        return c(i);
    }
}
