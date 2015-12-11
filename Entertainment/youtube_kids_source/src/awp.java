// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public final class awp
    implements android.os.Parcelable.Creator
{

    public awp()
    {
    }

    public static void a(Status status, Parcel parcel, int i)
    {
        int j = a.g(parcel, 20293);
        a.c(parcel, 1, status.e);
        a.c(parcel, 1000, status.d);
        a.a(parcel, 2, status.f, false);
        a.a(parcel, 3, status.g, i, false);
        a.h(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        PendingIntent pendingintent = null;
        int k = a.a(parcel);
        int j = 0;
        int i = 0;
        String s = null;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int i1 = parcel.readInt();
                switch (0xffff & i1)
                {
                default:
                    a.b(parcel, i1);
                    break;

                case 1: // '\001'
                    j = a.d(parcel, i1);
                    break;

                case 1000: 
                    i = a.d(parcel, i1);
                    break;

                case 2: // '\002'
                    s = a.e(parcel, i1);
                    break;

                case 3: // '\003'
                    pendingintent = (PendingIntent)a.a(parcel, i1, PendingIntent.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new l((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new Status(i, j, s, pendingintent);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new Status[i];
    }
}
