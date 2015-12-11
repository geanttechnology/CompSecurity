// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public class qv
    implements android.os.Parcelable.Creator
{

    public qv()
    {
    }

    public static void a(Status status, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, status.f());
        rq.a(parcel, 1000, status.d());
        rq.a(parcel, 2, status.c(), false);
        rq.a(parcel, 3, status.a(), i, false);
        rq.a(parcel, j);
    }

    public Status a(Parcel parcel)
    {
        PendingIntent pendingintent = null;
        int j = 0;
        int k = ro.b(parcel);
        String s = null;
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
                    j = ro.f(parcel, l);
                    break;

                case 1000: 
                    i = ro.f(parcel, l);
                    break;

                case 2: // '\002'
                    s = ro.k(parcel, l);
                    break;

                case 3: // '\003'
                    pendingintent = (PendingIntent)ro.a(parcel, l, PendingIntent.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new Status(i, j, s, pendingintent);
            }
        } while (true);
    }

    public Status[] a(int i)
    {
        return new Status[i];
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
