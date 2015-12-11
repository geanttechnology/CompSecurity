// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.ay;

public class tk
    implements android.os.Parcelable.Creator
{

    public tk()
    {
    }

    public static void a(ay ay1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, ay1.a);
        rq.a(parcel, 2, ay1.b, false);
        rq.a(parcel, 3, ay1.c);
        rq.a(parcel, 4, ay1.d);
        rq.a(parcel, 5, ay1.e);
        rq.a(parcel, 6, ay1.f);
        rq.a(parcel, 7, ay1.g);
        rq.a(parcel, 8, ay1.h, i, false);
        rq.a(parcel, j);
    }

    public ay a(Parcel parcel)
    {
        ay aay[] = null;
        int i = 0;
        int j1 = ro.b(parcel);
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
                int k1 = ro.a(parcel);
                switch (ro.a(k1))
                {
                default:
                    ro.b(parcel, k1);
                    break;

                case 1: // '\001'
                    i1 = ro.f(parcel, k1);
                    break;

                case 2: // '\002'
                    s = ro.k(parcel, k1);
                    break;

                case 3: // '\003'
                    l = ro.f(parcel, k1);
                    break;

                case 4: // '\004'
                    k = ro.f(parcel, k1);
                    break;

                case 5: // '\005'
                    flag = ro.c(parcel, k1);
                    break;

                case 6: // '\006'
                    j = ro.f(parcel, k1);
                    break;

                case 7: // '\007'
                    i = ro.f(parcel, k1);
                    break;

                case 8: // '\b'
                    aay = (ay[])ro.b(parcel, k1, ay.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j1)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j1).toString(), parcel);
            } else
            {
                return new ay(i1, s, l, k, flag, j, i, aay);
            }
        } while (true);
    }

    public ay[] a(int i)
    {
        return new ay[i];
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
