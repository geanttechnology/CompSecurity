// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.location.e;

public class aij
    implements android.os.Parcelable.Creator
{

    public aij()
    {
    }

    public static void a(e e1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, e1.a);
        rq.a(parcel, 1000, e1.a());
        rq.a(parcel, 2, e1.b);
        rq.a(parcel, 3, e1.c);
        rq.a(parcel, i);
    }

    public e a(Parcel parcel)
    {
        int i = 1;
        int l = ro.b(parcel);
        int k = 0;
        long l1 = 0L;
        int j = 1;
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
                    k = ro.f(parcel, i1);
                    break;

                case 2: // '\002'
                    i = ro.f(parcel, i1);
                    break;

                case 3: // '\003'
                    l1 = ro.h(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new e(k, j, i, l1);
            }
        } while (true);
    }

    public e[] a(int i)
    {
        return new e[i];
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
