// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

// Referenced classes of package com.google.android.gms.internal:
//            en

public final class hl
    implements android.os.Parcelable.Creator
{

    public hl()
    {
    }

    static void a(es.a a1, Parcel parcel, int i)
    {
        int j = c.a(parcel, 20293);
        c.b(parcel, 1, a1.a);
        c.b(parcel, 2, a1.a());
        c.a(parcel, 3, a1.b());
        c.b(parcel, 4, a1.c());
        c.a(parcel, 5, a1.d());
        c.a(parcel, 6, a1.e(), false);
        c.b(parcel, 7, a1.f());
        c.a(parcel, 8, a1.h(), false);
        if (a1.k == null)
        {
            a1 = null;
        } else
        {
            a1 = com.google.android.gms.internal.en.a(a1.k);
        }
        c.a(parcel, 9, a1, i, false);
        c.b(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        en en1 = null;
        int i = 0;
        int i1 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        String s = null;
        String s1 = null;
        boolean flag = false;
        int j = 0;
        boolean flag1 = false;
        int k = 0;
        int l = 0;
        do
        {
            if (parcel.dataPosition() < i1)
            {
                int j1 = parcel.readInt();
                switch (0xffff & j1)
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, j1);
                    break;

                case 1: // '\001'
                    l = com.google.android.gms.common.internal.safeparcel.a.e(parcel, j1);
                    break;

                case 2: // '\002'
                    k = com.google.android.gms.common.internal.safeparcel.a.e(parcel, j1);
                    break;

                case 3: // '\003'
                    flag1 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, j1);
                    break;

                case 4: // '\004'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, j1);
                    break;

                case 5: // '\005'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, j1);
                    break;

                case 6: // '\006'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, j1);
                    break;

                case 7: // '\007'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, j1);
                    break;

                case 8: // '\b'
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, j1);
                    break;

                case 9: // '\t'
                    en1 = (en)com.google.android.gms.common.internal.safeparcel.a.a(parcel, j1, en.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(i1).toString(), parcel);
            } else
            {
                return new es.a(l, k, flag1, j, flag, s1, i, s, en1);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new es.a[i];
    }
}
