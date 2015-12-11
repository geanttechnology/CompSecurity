// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Parcel;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.gs;

public class aal
    implements android.os.Parcelable.Creator
{

    public aal()
    {
    }

    public static void a(fh fh1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, fh1.a);
        rq.a(parcel, 2, fh1.b, false);
        rq.a(parcel, 3, fh1.c, i, false);
        rq.a(parcel, 4, fh1.d, i, false);
        rq.a(parcel, 5, fh1.e, false);
        rq.a(parcel, 6, fh1.f, i, false);
        rq.a(parcel, 7, fh1.g, i, false);
        rq.a(parcel, 8, fh1.h, false);
        rq.a(parcel, 9, fh1.i, false);
        rq.a(parcel, 10, fh1.j, false);
        rq.a(parcel, 11, fh1.k, i, false);
        rq.a(parcel, 12, fh1.l, false);
        rq.a(parcel, 13, fh1.m);
        rq.a(parcel, 14, fh1.n, false);
        rq.a(parcel, 15, fh1.o, false);
        rq.a(parcel, 16, fh1.p);
        rq.a(parcel, j);
    }

    public fh a(Parcel parcel)
    {
        int k = ro.b(parcel);
        int j = 0;
        android.os.Bundle bundle2 = null;
        av av1 = null;
        ay ay1 = null;
        String s3 = null;
        ApplicationInfo applicationinfo = null;
        PackageInfo packageinfo = null;
        String s2 = null;
        String s1 = null;
        String s = null;
        gs gs1 = null;
        android.os.Bundle bundle1 = null;
        int i = 0;
        java.util.ArrayList arraylist = null;
        android.os.Bundle bundle = null;
        boolean flag = false;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = ro.a(parcel);
                switch (ro.a(l))
                {
                default:
                    ro.b(parcel, l);
                    break;

                case 1: // '\001'
                    j = ro.f(parcel, l);
                    break;

                case 2: // '\002'
                    bundle2 = ro.m(parcel, l);
                    break;

                case 3: // '\003'
                    av1 = (av)ro.a(parcel, l, av.CREATOR);
                    break;

                case 4: // '\004'
                    ay1 = (ay)ro.a(parcel, l, ay.CREATOR);
                    break;

                case 5: // '\005'
                    s3 = ro.k(parcel, l);
                    break;

                case 6: // '\006'
                    applicationinfo = (ApplicationInfo)ro.a(parcel, l, ApplicationInfo.CREATOR);
                    break;

                case 7: // '\007'
                    packageinfo = (PackageInfo)ro.a(parcel, l, PackageInfo.CREATOR);
                    break;

                case 8: // '\b'
                    s2 = ro.k(parcel, l);
                    break;

                case 9: // '\t'
                    s1 = ro.k(parcel, l);
                    break;

                case 10: // '\n'
                    s = ro.k(parcel, l);
                    break;

                case 11: // '\013'
                    gs1 = (gs)ro.a(parcel, l, gs.CREATOR);
                    break;

                case 12: // '\f'
                    bundle1 = ro.m(parcel, l);
                    break;

                case 13: // '\r'
                    i = ro.f(parcel, l);
                    break;

                case 14: // '\016'
                    arraylist = ro.p(parcel, l);
                    break;

                case 15: // '\017'
                    bundle = ro.m(parcel, l);
                    break;

                case 16: // '\020'
                    flag = ro.c(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new fh(j, bundle2, av1, ay1, s3, applicationinfo, packageinfo, s2, s1, s, gs1, bundle1, i, arraylist, bundle, flag);
            }
        } while (true);
    }

    public fh[] a(int i)
    {
        return new fh[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }
}
