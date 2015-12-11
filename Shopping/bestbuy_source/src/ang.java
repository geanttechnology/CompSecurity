// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Point;
import android.os.Parcel;
import com.google.android.gms.maps.internal.y;

public class ang
    implements android.os.Parcelable.Creator
{

    public ang()
    {
    }

    public static void a(y y1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, y1.a());
        rq.a(parcel, 2, y1.b(), i, false);
        rq.a(parcel, j);
    }

    public y a(Parcel parcel)
    {
        int j = ro.b(parcel);
        int i = 0;
        Point point = null;
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
                    point = (Point)ro.a(parcel, k, Point.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new y(i, point);
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
