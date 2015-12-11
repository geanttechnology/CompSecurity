// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.auth.AccountChangeEvent;

public final class atv
    implements android.os.Parcelable.Creator
{

    public atv()
    {
    }

    public static void a(AccountChangeEvent accountchangeevent, Parcel parcel)
    {
        int i = a.g(parcel, 20293);
        a.c(parcel, 1, accountchangeevent.a);
        long l1 = accountchangeevent.b;
        a.b(parcel, 2, 8);
        parcel.writeLong(l1);
        a.a(parcel, 3, accountchangeevent.c, false);
        a.c(parcel, 4, accountchangeevent.d);
        a.c(parcel, 5, accountchangeevent.e);
        a.a(parcel, 6, accountchangeevent.f, false);
        a.h(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        String s = null;
        int i = 0;
        int i1 = a.a(parcel);
        long l1 = 0L;
        int j = 0;
        String s1 = null;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < i1)
            {
                int j1 = parcel.readInt();
                switch (0xffff & j1)
                {
                default:
                    a.b(parcel, j1);
                    break;

                case 1: // '\001'
                    k = a.d(parcel, j1);
                    break;

                case 2: // '\002'
                    a.a(parcel, j1, 8);
                    l1 = parcel.readLong();
                    break;

                case 3: // '\003'
                    s1 = a.e(parcel, j1);
                    break;

                case 4: // '\004'
                    j = a.d(parcel, j1);
                    break;

                case 5: // '\005'
                    i = a.d(parcel, j1);
                    break;

                case 6: // '\006'
                    s = a.e(parcel, j1);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new l((new StringBuilder("Overread allowed size end=")).append(i1).toString(), parcel);
            } else
            {
                return new AccountChangeEvent(k, l1, s1, j, i, s);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new AccountChangeEvent[i];
    }
}
