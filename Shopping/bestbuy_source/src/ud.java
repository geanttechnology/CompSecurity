// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.bj;

public class ud
    implements android.os.Parcelable.Creator
{

    public ud()
    {
    }

    public static void a(bj bj1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, bj1.a);
        rq.a(parcel, 2, bj1.b);
        rq.a(parcel, 3, bj1.c);
        rq.a(parcel, 4, bj1.d);
        rq.a(parcel, 5, bj1.e);
        rq.a(parcel, 6, bj1.f);
        rq.a(parcel, 7, bj1.g);
        rq.a(parcel, 8, bj1.h);
        rq.a(parcel, 9, bj1.i);
        rq.a(parcel, 10, bj1.j, false);
        rq.a(parcel, 11, bj1.k);
        rq.a(parcel, 12, bj1.l, false);
        rq.a(parcel, 13, bj1.m);
        rq.a(parcel, 14, bj1.n);
        rq.a(parcel, 15, bj1.o, false);
        rq.a(parcel, i);
    }

    public bj a(Parcel parcel)
    {
        int i3 = ro.b(parcel);
        int l2 = 0;
        int k2 = 0;
        int j2 = 0;
        int i2 = 0;
        int l1 = 0;
        int k1 = 0;
        int j1 = 0;
        int i1 = 0;
        int l = 0;
        String s2 = null;
        int k = 0;
        String s1 = null;
        int j = 0;
        int i = 0;
        String s = null;
        do
        {
            if (parcel.dataPosition() < i3)
            {
                int j3 = ro.a(parcel);
                switch (ro.a(j3))
                {
                default:
                    ro.b(parcel, j3);
                    break;

                case 1: // '\001'
                    l2 = ro.f(parcel, j3);
                    break;

                case 2: // '\002'
                    k2 = ro.f(parcel, j3);
                    break;

                case 3: // '\003'
                    j2 = ro.f(parcel, j3);
                    break;

                case 4: // '\004'
                    i2 = ro.f(parcel, j3);
                    break;

                case 5: // '\005'
                    l1 = ro.f(parcel, j3);
                    break;

                case 6: // '\006'
                    k1 = ro.f(parcel, j3);
                    break;

                case 7: // '\007'
                    j1 = ro.f(parcel, j3);
                    break;

                case 8: // '\b'
                    i1 = ro.f(parcel, j3);
                    break;

                case 9: // '\t'
                    l = ro.f(parcel, j3);
                    break;

                case 10: // '\n'
                    s2 = ro.k(parcel, j3);
                    break;

                case 11: // '\013'
                    k = ro.f(parcel, j3);
                    break;

                case 12: // '\f'
                    s1 = ro.k(parcel, j3);
                    break;

                case 13: // '\r'
                    j = ro.f(parcel, j3);
                    break;

                case 14: // '\016'
                    i = ro.f(parcel, j3);
                    break;

                case 15: // '\017'
                    s = ro.k(parcel, j3);
                    break;
                }
            } else
            if (parcel.dataPosition() != i3)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(i3).toString(), parcel);
            } else
            {
                return new bj(l2, k2, j2, i2, l1, k1, j1, i1, l, s2, k, s1, j, i, s);
            }
        } while (true);
    }

    public bj[] a(int i)
    {
        return new bj[i];
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
