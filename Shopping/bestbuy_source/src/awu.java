// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.internal.r;

public class awu
    implements android.os.Parcelable.Creator
{

    public awu()
    {
    }

    public static void a(r r1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, r1.a);
        rq.a(parcel, 2, r1.b);
        rq.a(parcel, 3, r1.c, i, false);
        rq.a(parcel, j);
    }

    public r a(Parcel parcel)
    {
        int j = 0;
        int k = ro.b(parcel);
        c c1 = null;
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
                    c1 = (c)ro.a(parcel, l, c.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new r(i, j, c1);
            }
        } while (true);
    }

    public r[] a(int i)
    {
        return new r[i];
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
