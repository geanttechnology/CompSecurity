// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;

public class atq
    implements android.os.Parcelable.Creator
{

    public atq()
    {
    }

    public static void a(p p1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, p1.a());
        rq.a(parcel, 2, p1.a, false);
        rq.a(parcel, 3, p1.b, false);
        rq.a(parcel, 4, p1.c, i, false);
        rq.a(parcel, 5, p1.d, i, false);
        rq.a(parcel, 6, p1.e, i, false);
        rq.a(parcel, j);
    }

    public p a(Parcel parcel)
    {
        n n1 = null;
        int j = ro.b(parcel);
        int i = 0;
        n n2 = null;
        l l1 = null;
        String s = null;
        String s1 = null;
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
                    s1 = ro.k(parcel, k);
                    break;

                case 3: // '\003'
                    s = ro.k(parcel, k);
                    break;

                case 4: // '\004'
                    l1 = (l)ro.a(parcel, k, l.CREATOR);
                    break;

                case 5: // '\005'
                    n2 = (n)ro.a(parcel, k, n.CREATOR);
                    break;

                case 6: // '\006'
                    n1 = (n)ro.a(parcel, k, n.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new p(i, s1, s, l1, n2, n1);
            }
        } while (true);
    }

    public p[] a(int i)
    {
        return new p[i];
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
