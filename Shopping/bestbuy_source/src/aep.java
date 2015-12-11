// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.nd;

public class aep
    implements android.os.Parcelable.Creator
{

    public aep()
    {
    }

    public static void a(nd nd1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, nd1.a);
        rq.a(parcel, 1000, nd1.a());
        rq.a(parcel, 2, nd1.b, false);
        rq.a(parcel, i);
    }

    public nd a(Parcel parcel)
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
                    j = ro.f(parcel, l);
                    break;

                case 1000: 
                    i = ro.f(parcel, l);
                    break;

                case 2: // '\002'
                    s = ro.k(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new nd(i, j, s);
            }
        } while (true);
    }

    public nd[] a(int i)
    {
        return new nd[i];
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
