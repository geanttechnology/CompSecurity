// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.nq;
import com.google.android.gms.internal.oa;

public class afk
    implements android.os.Parcelable.Creator
{

    public afk()
    {
    }

    public static void a(nq nq1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, nq1.a());
        rq.a(parcel, 1000, nq1.a);
        rq.b(parcel, 2, nq1.c, false);
        rq.a(parcel, i);
    }

    public nq a(Parcel parcel)
    {
        boolean flag = false;
        int j = ro.b(parcel);
        java.util.ArrayList arraylist = null;
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
                    flag = ro.c(parcel, k);
                    break;

                case 1000: 
                    i = ro.f(parcel, k);
                    break;

                case 2: // '\002'
                    arraylist = ro.c(parcel, k, oa.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new nq(i, flag, arraylist);
            }
        } while (true);
    }

    public nq[] a(int i)
    {
        return new nq[i];
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
