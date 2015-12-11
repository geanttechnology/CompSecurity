// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wearable.internal.ap;
import com.google.android.gms.wearable.internal.m;

public class avq
    implements android.os.Parcelable.Creator
{

    public avq()
    {
    }

    public static void a(ap ap1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, ap1.a);
        rq.a(parcel, 2, ap1.b);
        rq.a(parcel, 3, ap1.c, i, false);
        rq.a(parcel, j);
    }

    public ap a(Parcel parcel)
    {
        int j = 0;
        int k = ro.b(parcel);
        m m1 = null;
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
                    i = ro.f(parcel, l);
                    break;

                case 2: // '\002'
                    j = ro.f(parcel, l);
                    break;

                case 3: // '\003'
                    m1 = (m)ro.a(parcel, l, m.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new ap(i, j, m1);
            }
        } while (true);
    }

    public ap[] a(int i)
    {
        return new ap[i];
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
