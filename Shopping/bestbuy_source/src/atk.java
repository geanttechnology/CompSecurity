// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wallet.wobs.b;
import com.google.android.gms.wallet.wobs.d;

public class atk
    implements android.os.Parcelable.Creator
{

    public atk()
    {
    }

    public static void a(d d1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, d1.a());
        rq.a(parcel, 2, d1.a, false);
        rq.a(parcel, 3, d1.b, false);
        rq.b(parcel, 4, d1.c, false);
        rq.a(parcel, i);
    }

    public d a(Parcel parcel)
    {
        String s1 = null;
        int j = ro.b(parcel);
        int i = 0;
        java.util.ArrayList arraylist = aed.a();
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

                case 4: // '\004'
                    arraylist = ro.c(parcel, k, b.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new d(i, s, s1, arraylist);
            }
        } while (true);
    }

    public d[] a(int i)
    {
        return new d[i];
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
