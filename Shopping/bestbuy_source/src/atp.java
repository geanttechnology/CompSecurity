// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wallet.wobs.n;

public class atp
    implements android.os.Parcelable.Creator
{

    public atp()
    {
    }

    public static void a(n n1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, n1.a());
        rq.a(parcel, 2, n1.a, false);
        rq.a(parcel, 3, n1.b, false);
        rq.a(parcel, i);
    }

    public n a(Parcel parcel)
    {
        String s1 = null;
        int j = ro.b(parcel);
        int i = 0;
        String s = null;
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
                    s = ro.k(parcel, k);
                    break;

                case 3: // '\003'
                    s1 = ro.k(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new n(i, s, s1);
            }
        } while (true);
    }

    public n[] a(int i)
    {
        return new n[i];
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
