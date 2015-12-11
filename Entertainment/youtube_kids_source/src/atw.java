// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.auth.AccountChangeEventsRequest;

public final class atw
    implements android.os.Parcelable.Creator
{

    public atw()
    {
    }

    public static AccountChangeEventsRequest a(Parcel parcel)
    {
        int j = 0;
        int k = a.a(parcel);
        String s = null;
        int i = 0;
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
                    i = a.d(parcel, i1);
                    break;

                case 2: // '\002'
                    j = a.d(parcel, i1);
                    break;

                case 3: // '\003'
                    s = a.e(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new l((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new AccountChangeEventsRequest(i, j, s);
            }
        } while (true);
    }

    public static void a(AccountChangeEventsRequest accountchangeeventsrequest, Parcel parcel)
    {
        int i = a.g(parcel, 20293);
        a.c(parcel, 1, accountchangeeventsrequest.a);
        a.c(parcel, 2, accountchangeeventsrequest.b);
        a.a(parcel, 3, accountchangeeventsrequest.c, false);
        a.h(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new AccountChangeEventsRequest[i];
    }
}
