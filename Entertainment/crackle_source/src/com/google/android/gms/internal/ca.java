// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            bz, v, x, cu

public class ca
    implements android.os.Parcelable.Creator
{

    public ca()
    {
    }

    static void a(bz bz1, Parcel parcel, int i)
    {
        int j = b.o(parcel);
        b.c(parcel, 1, bz1.versionCode);
        b.a(parcel, 2, bz1.hq, false);
        b.a(parcel, 3, bz1.hr, i, false);
        b.a(parcel, 4, bz1.em, i, false);
        b.a(parcel, 5, bz1.adUnitId, false);
        b.a(parcel, 6, bz1.applicationInfo, i, false);
        b.a(parcel, 7, bz1.hs, i, false);
        b.a(parcel, 8, bz1.ht, false);
        b.a(parcel, 9, bz1.hu, false);
        b.a(parcel, 10, bz1.hv, false);
        b.a(parcel, 11, bz1.ej, i, false);
        b.D(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return f(parcel);
    }

    public bz f(Parcel parcel)
    {
        cu cu1 = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
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
                int l = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 2: // '\002'
                    bundle = com.google.android.gms.common.internal.safeparcel.a.o(parcel, l);
                    break;

                case 3: // '\003'
                    v1 = (v)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, v.CREATOR);
                    break;

                case 4: // '\004'
                    x1 = (x)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, x.CREATOR);
                    break;

                case 5: // '\005'
                    s3 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 6: // '\006'
                    applicationinfo = (ApplicationInfo)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, ApplicationInfo.CREATOR);
                    break;

                case 7: // '\007'
                    packageinfo = (PackageInfo)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, PackageInfo.CREATOR);
                    break;

                case 8: // '\b'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 9: // '\t'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 10: // '\n'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 11: // '\013'
                    cu1 = (cu)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, cu.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new bz(i, bundle, v1, x1, s3, applicationinfo, packageinfo, s2, s1, s, cu1);
            }
        } while (true);
    }

    public bz[] k(int i)
    {
        return new bz[i];
    }

    public Object[] newArray(int i)
    {
        return k(i);
    }
}
