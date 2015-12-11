// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.internal.c;

public class aob
    implements android.os.Parcelable.Creator
{

    public aob()
    {
    }

    public static void a(c c1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, c1.a());
        rq.a(parcel, 2, c1.b());
        rq.a(parcel, 3, c1.c(), false);
        rq.a(parcel, i);
    }

    public c a(Parcel parcel)
    {
        int j = 0;
        int k = ro.b(parcel);
        android.os.Bundle bundle = null;
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
                    bundle = ro.m(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new c(i, j, bundle);
            }
        } while (true);
    }

    public c[] a(int i)
    {
        return new c[i];
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
