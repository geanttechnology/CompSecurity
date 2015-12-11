// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.internal.t;

public class awv
    implements android.os.Parcelable.Creator
{

    public awv()
    {
    }

    public static void a(t t1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, t1.a);
        rq.a(parcel, 2, t1.b);
        rq.a(parcel, 3, t1.c, i, false);
        rq.a(parcel, j);
    }

    public t a(Parcel parcel)
    {
        int j = 0;
        int k = ro.b(parcel);
        c ac[] = null;
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
                    ac = (c[])ro.b(parcel, l, c.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new t(i, j, ac);
            }
        } while (true);
    }

    public t[] a(int i)
    {
        return new t[i];
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
