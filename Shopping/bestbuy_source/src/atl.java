// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wallet.wobs.g;

public class atl
    implements android.os.Parcelable.Creator
{

    public atl()
    {
    }

    public static void a(g g1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, g1.a());
        rq.a(parcel, 2, g1.a);
        rq.a(parcel, 3, g1.b, false);
        rq.a(parcel, 4, g1.c);
        rq.a(parcel, 5, g1.d, false);
        rq.a(parcel, 6, g1.e);
        rq.a(parcel, 7, g1.f);
        rq.a(parcel, i);
    }

    public g a(Parcel parcel)
    {
        String s = null;
        int j = 0;
        int l = ro.b(parcel);
        double d = 0.0D;
        long l1 = 0L;
        int i = -1;
        String s1 = null;
        int k = 0;
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
                    j = ro.f(parcel, i1);
                    break;

                case 3: // '\003'
                    s1 = ro.k(parcel, i1);
                    break;

                case 4: // '\004'
                    d = ro.j(parcel, i1);
                    break;

                case 5: // '\005'
                    s = ro.k(parcel, i1);
                    break;

                case 6: // '\006'
                    l1 = ro.h(parcel, i1);
                    break;

                case 7: // '\007'
                    i = ro.f(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new g(k, j, s1, d, s, l1, i);
            }
        } while (true);
    }

    public g[] a(int i)
    {
        return new g[i];
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
