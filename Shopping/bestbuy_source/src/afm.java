// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.nu;
import com.google.android.gms.internal.oa;
import com.google.android.gms.internal.oe;

public class afm
    implements android.os.Parcelable.Creator
{

    public afm()
    {
    }

    public static void a(nu nu1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.b(parcel, 1, nu1.b, false);
        rq.a(parcel, 1000, nu1.a);
        rq.a(parcel, 2, nu1.a(), false);
        rq.a(parcel, 3, nu1.b());
        rq.b(parcel, 4, nu1.c, false);
        rq.a(parcel, 6, nu1.d, false);
        rq.a(parcel, i);
    }

    public nu a(Parcel parcel)
    {
        boolean flag = false;
        java.util.ArrayList arraylist = null;
        int j = ro.b(parcel);
        java.util.ArrayList arraylist1 = null;
        String s = null;
        java.util.ArrayList arraylist2 = null;
        int i = 0;
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
                    arraylist2 = ro.c(parcel, k, oa.CREATOR);
                    break;

                case 1000: 
                    i = ro.f(parcel, k);
                    break;

                case 2: // '\002'
                    s = ro.k(parcel, k);
                    break;

                case 3: // '\003'
                    flag = ro.c(parcel, k);
                    break;

                case 4: // '\004'
                    arraylist1 = ro.c(parcel, k, oe.CREATOR);
                    break;

                case 6: // '\006'
                    arraylist = ro.p(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new nu(i, arraylist2, s, flag, arraylist1, arraylist);
            }
        } while (true);
    }

    public nu[] a(int i)
    {
        return new nu[i];
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
