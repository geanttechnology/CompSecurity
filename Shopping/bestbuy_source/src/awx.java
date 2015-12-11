// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wearable.internal.m;
import com.google.android.gms.wearable.internal.x;

public class awx
    implements android.os.Parcelable.Creator
{

    public awx()
    {
    }

    public static void a(x x1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, x1.a);
        rq.a(parcel, 2, x1.b);
        rq.a(parcel, 3, x1.c, i, false);
        rq.a(parcel, j);
    }

    public x a(Parcel parcel)
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
                return new x(i, j, m1);
            }
        } while (true);
    }

    public x[] a(int i)
    {
        return new x[i];
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
