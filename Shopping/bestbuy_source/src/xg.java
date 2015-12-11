// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.do;
import com.google.android.gms.internal.dr;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.y;

public class xg
    implements android.os.Parcelable.Creator
{

    public xg()
    {
    }

    public static void a(dr dr1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, dr1.a);
        rq.a(parcel, 2, dr1.b, i, false);
        rq.a(parcel, 3, dr1.a(), false);
        rq.a(parcel, 4, dr1.b(), false);
        rq.a(parcel, 5, dr1.c(), false);
        rq.a(parcel, 6, dr1.d(), false);
        rq.a(parcel, 7, dr1.g, false);
        rq.a(parcel, 8, dr1.h);
        rq.a(parcel, 9, dr1.i, false);
        rq.a(parcel, 10, dr1.f(), false);
        rq.a(parcel, 11, dr1.k);
        rq.a(parcel, 12, dr1.l);
        rq.a(parcel, 13, dr1.m, false);
        rq.a(parcel, 14, dr1.n, i, false);
        rq.a(parcel, 15, dr1.e(), false);
        rq.a(parcel, 17, dr1.q, i, false);
        rq.a(parcel, 16, dr1.p, false);
        rq.a(parcel, j);
    }

    public dr a(Parcel parcel)
    {
        int l = ro.b(parcel);
        int k = 0;
        do do1 = null;
        android.os.IBinder ibinder5 = null;
        android.os.IBinder ibinder4 = null;
        android.os.IBinder ibinder3 = null;
        android.os.IBinder ibinder2 = null;
        String s3 = null;
        boolean flag = false;
        String s2 = null;
        android.os.IBinder ibinder1 = null;
        int j = 0;
        int i = 0;
        String s1 = null;
        gs gs1 = null;
        android.os.IBinder ibinder = null;
        String s = null;
        y y1 = null;
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
                    do1 = (do)ro.a(parcel, i1, do.CREATOR);
                    break;

                case 3: // '\003'
                    ibinder5 = ro.l(parcel, i1);
                    break;

                case 4: // '\004'
                    ibinder4 = ro.l(parcel, i1);
                    break;

                case 5: // '\005'
                    ibinder3 = ro.l(parcel, i1);
                    break;

                case 6: // '\006'
                    ibinder2 = ro.l(parcel, i1);
                    break;

                case 7: // '\007'
                    s3 = ro.k(parcel, i1);
                    break;

                case 8: // '\b'
                    flag = ro.c(parcel, i1);
                    break;

                case 9: // '\t'
                    s2 = ro.k(parcel, i1);
                    break;

                case 10: // '\n'
                    ibinder1 = ro.l(parcel, i1);
                    break;

                case 11: // '\013'
                    j = ro.f(parcel, i1);
                    break;

                case 12: // '\f'
                    i = ro.f(parcel, i1);
                    break;

                case 13: // '\r'
                    s1 = ro.k(parcel, i1);
                    break;

                case 14: // '\016'
                    gs1 = (gs)ro.a(parcel, i1, gs.CREATOR);
                    break;

                case 15: // '\017'
                    ibinder = ro.l(parcel, i1);
                    break;

                case 17: // '\021'
                    y1 = (y)ro.a(parcel, i1, y.CREATOR);
                    break;

                case 16: // '\020'
                    s = ro.k(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new dr(k, do1, ibinder5, ibinder4, ibinder3, ibinder2, s3, flag, s2, ibinder1, j, i, s1, gs1, ibinder, s, y1);
            }
        } while (true);
    }

    public dr[] a(int i)
    {
        return new dr[i];
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
