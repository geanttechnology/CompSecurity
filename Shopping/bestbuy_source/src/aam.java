// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.fj;

public class aam
    implements android.os.Parcelable.Creator
{

    public aam()
    {
    }

    public static void a(fj fj1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, fj1.a);
        rq.a(parcel, 2, fj1.b, false);
        rq.a(parcel, 3, fj1.c, false);
        rq.a(parcel, 4, fj1.d, false);
        rq.a(parcel, 5, fj1.e);
        rq.a(parcel, 6, fj1.f, false);
        rq.a(parcel, 7, fj1.g);
        rq.a(parcel, 8, fj1.h);
        rq.a(parcel, 9, fj1.i);
        rq.a(parcel, 10, fj1.j, false);
        rq.a(parcel, 11, fj1.k);
        rq.a(parcel, 12, fj1.l);
        rq.a(parcel, 13, fj1.m, false);
        rq.a(parcel, 14, fj1.n);
        rq.a(parcel, 15, fj1.o, false);
        rq.a(parcel, 19, fj1.q, false);
        rq.a(parcel, 18, fj1.p);
        rq.a(parcel, 21, fj1.r, false);
        rq.a(parcel, 23, fj1.t);
        rq.a(parcel, 22, fj1.s);
        rq.a(parcel, 25, fj1.v);
        rq.a(parcel, 24, fj1.u);
        rq.a(parcel, i);
    }

    public fj a(Parcel parcel)
    {
        int l = ro.b(parcel);
        int k = 0;
        String s5 = null;
        String s4 = null;
        java.util.ArrayList arraylist2 = null;
        int j = 0;
        java.util.ArrayList arraylist1 = null;
        long l4 = 0L;
        boolean flag5 = false;
        long l3 = 0L;
        java.util.ArrayList arraylist = null;
        long l2 = 0L;
        int i = 0;
        String s3 = null;
        long l1 = 0L;
        String s2 = null;
        boolean flag4 = false;
        String s1 = null;
        String s = null;
        boolean flag3 = false;
        boolean flag2 = false;
        boolean flag1 = false;
        boolean flag = false;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = ro.a(parcel);
                switch (ro.a(i1))
                {
                case 16: // '\020'
                case 17: // '\021'
                case 20: // '\024'
                default:
                    ro.b(parcel, i1);
                    break;

                case 1: // '\001'
                    k = ro.f(parcel, i1);
                    break;

                case 2: // '\002'
                    s5 = ro.k(parcel, i1);
                    break;

                case 3: // '\003'
                    s4 = ro.k(parcel, i1);
                    break;

                case 4: // '\004'
                    arraylist2 = ro.p(parcel, i1);
                    break;

                case 5: // '\005'
                    j = ro.f(parcel, i1);
                    break;

                case 6: // '\006'
                    arraylist1 = ro.p(parcel, i1);
                    break;

                case 7: // '\007'
                    l4 = ro.h(parcel, i1);
                    break;

                case 8: // '\b'
                    flag5 = ro.c(parcel, i1);
                    break;

                case 9: // '\t'
                    l3 = ro.h(parcel, i1);
                    break;

                case 10: // '\n'
                    arraylist = ro.p(parcel, i1);
                    break;

                case 11: // '\013'
                    l2 = ro.h(parcel, i1);
                    break;

                case 12: // '\f'
                    i = ro.f(parcel, i1);
                    break;

                case 13: // '\r'
                    s3 = ro.k(parcel, i1);
                    break;

                case 14: // '\016'
                    l1 = ro.h(parcel, i1);
                    break;

                case 15: // '\017'
                    s2 = ro.k(parcel, i1);
                    break;

                case 19: // '\023'
                    s1 = ro.k(parcel, i1);
                    break;

                case 18: // '\022'
                    flag4 = ro.c(parcel, i1);
                    break;

                case 21: // '\025'
                    s = ro.k(parcel, i1);
                    break;

                case 23: // '\027'
                    flag2 = ro.c(parcel, i1);
                    break;

                case 22: // '\026'
                    flag3 = ro.c(parcel, i1);
                    break;

                case 25: // '\031'
                    flag = ro.c(parcel, i1);
                    break;

                case 24: // '\030'
                    flag1 = ro.c(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new fj(k, s5, s4, arraylist2, j, arraylist1, l4, flag5, l3, arraylist, l2, i, s3, l1, s2, flag4, s1, s, flag3, flag2, flag1, flag);
            }
        } while (true);
    }

    public fj[] a(int i)
    {
        return new fj[i];
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
