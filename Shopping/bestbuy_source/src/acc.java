// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.gs;

public class acc
    implements android.os.Parcelable.Creator
{

    public acc()
    {
    }

    public static void a(gs gs1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, gs1.a);
        rq.a(parcel, 2, gs1.b, false);
        rq.a(parcel, 3, gs1.c);
        rq.a(parcel, 4, gs1.d);
        rq.a(parcel, 5, gs1.e);
        rq.a(parcel, i);
    }

    public gs a(Parcel parcel)
    {
        boolean flag = false;
        int l = ro.b(parcel);
        String s = null;
        int i = 0;
        int j = 0;
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
                    s = ro.k(parcel, i1);
                    break;

                case 3: // '\003'
                    j = ro.f(parcel, i1);
                    break;

                case 4: // '\004'
                    i = ro.f(parcel, i1);
                    break;

                case 5: // '\005'
                    flag = ro.c(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new gs(k, s, j, i, flag);
            }
        } while (true);
    }

    public gs[] a(int i)
    {
        return new gs[i];
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
