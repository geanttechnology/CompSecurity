// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.bj;

public class ti
    implements android.os.Parcelable.Creator
{

    public ti()
    {
    }

    public static void a(av av1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, av1.a);
        rq.a(parcel, 2, av1.b);
        rq.a(parcel, 3, av1.c, false);
        rq.a(parcel, 4, av1.d);
        rq.a(parcel, 5, av1.e, false);
        rq.a(parcel, 6, av1.f);
        rq.a(parcel, 7, av1.g);
        rq.a(parcel, 8, av1.h);
        rq.a(parcel, 9, av1.i, false);
        rq.a(parcel, 10, av1.j, i, false);
        rq.a(parcel, 11, av1.k, i, false);
        rq.a(parcel, 12, av1.l, false);
        rq.a(parcel, 13, av1.m, false);
        rq.a(parcel, j);
    }

    public av a(Parcel parcel)
    {
        int l = ro.b(parcel);
        int k = 0;
        long l1 = 0L;
        android.os.Bundle bundle1 = null;
        int j = 0;
        java.util.ArrayList arraylist = null;
        boolean flag1 = false;
        int i = 0;
        boolean flag = false;
        String s1 = null;
        bj bj1 = null;
        Location location = null;
        String s = null;
        android.os.Bundle bundle = null;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = ro.a(parcel);
                switch (ro.a(i1))
                {
                default:
                    ro.b(parcel, i1);
                    break;

                case 1: // '\001'
                    k = ro.f(parcel, i1);
                    break;

                case 2: // '\002'
                    l1 = ro.h(parcel, i1);
                    break;

                case 3: // '\003'
                    bundle1 = ro.m(parcel, i1);
                    break;

                case 4: // '\004'
                    j = ro.f(parcel, i1);
                    break;

                case 5: // '\005'
                    arraylist = ro.p(parcel, i1);
                    break;

                case 6: // '\006'
                    flag1 = ro.c(parcel, i1);
                    break;

                case 7: // '\007'
                    i = ro.f(parcel, i1);
                    break;

                case 8: // '\b'
                    flag = ro.c(parcel, i1);
                    break;

                case 9: // '\t'
                    s1 = ro.k(parcel, i1);
                    break;

                case 10: // '\n'
                    bj1 = (bj)ro.a(parcel, i1, bj.CREATOR);
                    break;

                case 11: // '\013'
                    location = (Location)ro.a(parcel, i1, Location.CREATOR);
                    break;

                case 12: // '\f'
                    s = ro.k(parcel, i1);
                    break;

                case 13: // '\r'
                    bundle = ro.m(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new av(k, l1, bundle1, j, arraylist, flag1, i, flag, s1, bj1, location, s, bundle);
            }
        } while (true);
    }

    public av[] a(int i)
    {
        return new av[i];
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
