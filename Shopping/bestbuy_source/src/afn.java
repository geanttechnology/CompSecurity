// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.nw;

public class afn
    implements android.os.Parcelable.Creator
{

    public afn()
    {
    }

    public static void a(nw nw1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, nw1.a);
        rq.a(parcel, 2, nw1.a(), false);
        rq.a(parcel, 3, nw1.b(), false);
        rq.a(parcel, 4, nw1.c(), false);
        rq.a(parcel, i);
    }

    public nw a(Parcel parcel)
    {
        String s2 = null;
        int j = ro.b(parcel);
        int i = 0;
        String s1 = null;
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
                    s2 = ro.k(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new nw(i, s, s1, s2);
            }
        } while (true);
    }

    public nw[] a(int i)
    {
        return new nw[i];
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
