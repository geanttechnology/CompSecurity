// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.y;

public class ahq
    implements android.os.Parcelable.Creator
{

    public ahq()
    {
    }

    public static void a(y y1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, y1.a);
        rq.a(parcel, 2, y1.b);
        rq.a(parcel, 3, y1.c);
        rq.a(parcel, i);
    }

    public y a(Parcel parcel)
    {
        boolean flag1 = false;
        int j = ro.b(parcel);
        boolean flag = false;
        int i = 0;
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
                    flag = ro.c(parcel, k);
                    break;

                case 3: // '\003'
                    flag1 = ro.c(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new y(i, flag, flag1);
            }
        } while (true);
    }

    public y[] a(int i)
    {
        return new y[i];
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
