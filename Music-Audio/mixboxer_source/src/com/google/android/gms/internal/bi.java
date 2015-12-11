// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            bj

public class bi
    implements android.os.Parcelable.Creator
{

    public bi()
    {
    }

    static void a(bj bj1, Parcel parcel, int j)
    {
        j = b.o(parcel);
        b.c(parcel, 1, bj1.versionCode);
        b.a(parcel, 2, bj1.gn, false);
        b.a(parcel, 3, bj1.go, false);
        b.a(parcel, 4, bj1.mimeType, false);
        b.a(parcel, 5, bj1.packageName, false);
        b.a(parcel, 6, bj1.gp, false);
        b.a(parcel, 7, bj1.gq, false);
        b.a(parcel, 8, bj1.gr, false);
        b.D(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return d(parcel);
    }

    public bj d(Parcel parcel)
    {
        String s = null;
        int k = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int j = 0;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        String s5 = null;
        String s6 = null;
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
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 2: // '\002'
                    s6 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 3: // '\003'
                    s5 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 4: // '\004'
                    s4 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 5: // '\005'
                    s3 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 6: // '\006'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 7: // '\007'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 8: // '\b'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new bj(j, s6, s5, s4, s3, s2, s1, s);
            }
        } while (true);
    }

    public bj[] i(int j)
    {
        return new bj[j];
    }

    public Object[] newArray(int j)
    {
        return i(j);
    }
}
