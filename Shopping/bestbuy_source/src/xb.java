// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.do;

public class xb
    implements android.os.Parcelable.Creator
{

    public xb()
    {
    }

    public static void a(do do1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, do1.a);
        rq.a(parcel, 2, do1.b, false);
        rq.a(parcel, 3, do1.c, false);
        rq.a(parcel, 4, do1.d, false);
        rq.a(parcel, 5, do1.e, false);
        rq.a(parcel, 6, do1.f, false);
        rq.a(parcel, 7, do1.g, false);
        rq.a(parcel, 8, do1.h, false);
        rq.a(parcel, i);
    }

    public do a(Parcel parcel)
    {
        String s = null;
        int j = ro.b(parcel);
        int i = 0;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        String s5 = null;
        String s6 = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = ro.a(parcel);
                switch (ro.a(k))
                {
                default:
                    ro.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = ro.f(parcel, k);
                    break;

                case 2: // '\002'
                    s6 = ro.k(parcel, k);
                    break;

                case 3: // '\003'
                    s5 = ro.k(parcel, k);
                    break;

                case 4: // '\004'
                    s4 = ro.k(parcel, k);
                    break;

                case 5: // '\005'
                    s3 = ro.k(parcel, k);
                    break;

                case 6: // '\006'
                    s2 = ro.k(parcel, k);
                    break;

                case 7: // '\007'
                    s1 = ro.k(parcel, k);
                    break;

                case 8: // '\b'
                    s = ro.k(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new do(i, s6, s5, s4, s3, s2, s1, s);
            }
        } while (true);
    }

    public do[] a(int i)
    {
        return new do[i];
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
