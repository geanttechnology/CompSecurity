// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.oa;

public class afr
    implements android.os.Parcelable.Creator
{

    public afr()
    {
    }

    public static void a(oa oa1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, oa1.bx, false);
        rq.a(parcel, 1000, oa1.bw);
        rq.a(parcel, i);
    }

    public oa a(Parcel parcel)
    {
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
                    s = ro.k(parcel, k);
                    break;

                case 1000: 
                    i = ro.f(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new oa(i, s);
            }
        } while (true);
    }

    public oa[] a(int i)
    {
        return new oa[i];
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
