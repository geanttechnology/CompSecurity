// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wallet.wobs.f;
import com.google.android.gms.wallet.wobs.g;
import com.google.android.gms.wallet.wobs.l;

public class atm
    implements android.os.Parcelable.Creator
{

    public atm()
    {
    }

    public static void a(f f1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, f1.a());
        rq.a(parcel, 2, f1.a, false);
        rq.a(parcel, 3, f1.b, i, false);
        rq.a(parcel, 4, f1.c, false);
        rq.a(parcel, 5, f1.d, i, false);
        rq.a(parcel, j);
    }

    public f a(Parcel parcel)
    {
        l l1 = null;
        int j = ro.b(parcel);
        int i = 0;
        String s = null;
        g g1 = null;
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
                    g1 = (g)ro.a(parcel, k, g.CREATOR);
                    break;

                case 4: // '\004'
                    s = ro.k(parcel, k);
                    break;

                case 5: // '\005'
                    l1 = (l)ro.a(parcel, k, l.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new f(i, s1, g1, s, l1);
            }
        } while (true);
    }

    public f[] a(int i)
    {
        return new f[i];
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
