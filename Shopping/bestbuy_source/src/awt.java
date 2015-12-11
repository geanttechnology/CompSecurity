// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wearable.internal.p;

public class awt
    implements android.os.Parcelable.Creator
{

    public awt()
    {
    }

    public static void a(p p1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, p1.a);
        rq.a(parcel, 2, p1.b);
        rq.a(parcel, 3, p1.c);
        rq.a(parcel, i);
    }

    public p a(Parcel parcel)
    {
        int k = 0;
        int l = ro.b(parcel);
        int j = 0;
        int i = 0;
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
                    i = ro.f(parcel, i1);
                    break;

                case 2: // '\002'
                    j = ro.f(parcel, i1);
                    break;

                case 3: // '\003'
                    k = ro.f(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new p(i, j, k);
            }
        } while (true);
    }

    public p[] a(int i)
    {
        return new p[i];
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
