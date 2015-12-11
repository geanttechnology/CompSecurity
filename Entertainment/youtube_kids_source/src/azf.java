// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.ig;

public final class azf
    implements android.os.Parcelable.Creator
{

    public azf()
    {
    }

    public static void a(ig ig1, Parcel parcel)
    {
        int i = a.g(parcel, 20293);
        a.c(parcel, 1, ig1.a);
        a.a(parcel, 2, ig1.b, false);
        a.h(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int j = a.a(parcel);
        int i = 0;
        String s = null;
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
                    s = a.e(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new l((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new ig(i, s);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new ig[i];
    }
}
