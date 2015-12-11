// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

// Referenced classes of package com.google.android.gms.internal:
//            v, x, cu, bz

public final class dm
    implements android.os.Parcelable.Creator
{

    public dm()
    {
    }

    public static bz a(Parcel parcel)
    {
        cu cu1 = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int i = 0;
        String s = null;
        String s1 = null;
        String s2 = null;
        PackageInfo packageinfo = null;
        ApplicationInfo applicationinfo = null;
        String s3 = null;
        x x1 = null;
        v v1 = null;
        android.os.Bundle bundle = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = parcel.readInt();
                switch (0xffff & k)
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, k);
                    break;

                case 2: // '\002'
                    bundle = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;

                case 3: // '\003'
                    v1 = (v)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, v.CREATOR);
                    break;

                case 4: // '\004'
                    x1 = (x)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, x.CREATOR);
                    break;

                case 5: // '\005'
                    s3 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, k);
                    break;

                case 6: // '\006'
                    applicationinfo = (ApplicationInfo)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, ApplicationInfo.CREATOR);
                    break;

                case 7: // '\007'
                    packageinfo = (PackageInfo)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, PackageInfo.CREATOR);
                    break;

                case 8: // '\b'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, k);
                    break;

                case 9: // '\t'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, k);
                    break;

                case 10: // '\n'
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, k);
                    break;

                case 11: // '\013'
                    cu1 = (cu)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, cu.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new bz(i, bundle, v1, x1, s3, applicationinfo, packageinfo, s2, s1, s, cu1);
            }
        } while (true);
    }

    static void a(bz bz1, Parcel parcel, int i)
    {
        int j = c.a(parcel, 20293);
        c.b(parcel, 1, bz1.a);
        c.a(parcel, 2, bz1.b);
        c.a(parcel, 3, bz1.c, i, false);
        c.a(parcel, 4, bz1.d, i, false);
        c.a(parcel, 5, bz1.e, false);
        c.a(parcel, 6, bz1.f, i, false);
        c.a(parcel, 7, bz1.g, i, false);
        c.a(parcel, 8, bz1.h, false);
        c.a(parcel, 9, bz1.i, false);
        c.a(parcel, 10, bz1.j, false);
        c.a(parcel, 11, bz1.k, i, false);
        c.b(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new bz[i];
    }
}
