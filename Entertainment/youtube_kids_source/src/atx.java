// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.auth.AccountChangeEvent;
import com.google.android.gms.auth.AccountChangeEventsResponse;

public final class atx
    implements android.os.Parcelable.Creator
{

    public atx()
    {
    }

    public static AccountChangeEventsResponse a(Parcel parcel)
    {
        int j = a.a(parcel);
        int i = 0;
        java.util.ArrayList arraylist = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = parcel.readInt();
                switch (0xffff & k)
                {
                default:
                    a.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = a.d(parcel, k);
                    break;

                case 2: // '\002'
                    arraylist = a.b(parcel, k, AccountChangeEvent.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new l((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new AccountChangeEventsResponse(i, arraylist);
            }
        } while (true);
    }

    public static void a(AccountChangeEventsResponse accountchangeeventsresponse, Parcel parcel)
    {
        int i = a.g(parcel, 20293);
        a.c(parcel, 1, accountchangeeventsresponse.a);
        a.b(parcel, 2, accountchangeeventsresponse.b, false);
        a.h(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new AccountChangeEventsResponse[i];
    }
}
