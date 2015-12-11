// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.oe;

public class aft
    implements android.os.Parcelable.Creator
{

    public aft()
    {
    }

    public static void a(oe oe1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, oe1.e, false);
        rq.a(parcel, 1000, oe1.d);
        rq.a(parcel, 2, oe1.f);
        rq.a(parcel, i);
    }

    public oe a(Parcel parcel)
    {
        int j = 0;
        int k = ro.b(parcel);
        String s = null;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = ro.a(parcel);
                switch (ro.a(l))
                {
                default:
                    ro.b(parcel, l);
                    break;

                case 1: // '\001'
                    s = ro.k(parcel, l);
                    break;

                case 1000: 
                    i = ro.f(parcel, l);
                    break;

                case 2: // '\002'
                    j = ro.f(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new oe(i, s, j);
            }
        } while (true);
    }

    public oe[] a(int i)
    {
        return new oe[i];
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
