// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.ns;
import com.google.android.gms.internal.nu;

public class afl
    implements android.os.Parcelable.Creator
{

    public afl()
    {
    }

    public static void a(ns ns1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, ns1.b());
        rq.a(parcel, 1000, ns1.a());
        rq.a(parcel, 2, ns1.c());
        rq.a(parcel, 3, ns1.d(), i, false);
        rq.a(parcel, j);
    }

    public ns a(Parcel parcel)
    {
        int j = 0;
        int l = ro.b(parcel);
        int k = -1;
        nu nu1 = null;
        int i = 0;
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
                    j = ro.f(parcel, i1);
                    break;

                case 1000: 
                    i = ro.f(parcel, i1);
                    break;

                case 2: // '\002'
                    k = ro.f(parcel, i1);
                    break;

                case 3: // '\003'
                    nu1 = (nu)ro.a(parcel, i1, nu.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new ns(i, j, k, nu1);
            }
        } while (true);
    }

    public ns[] a(int i)
    {
        return new ns[i];
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
