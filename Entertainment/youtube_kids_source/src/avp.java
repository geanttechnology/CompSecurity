// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.cast.LaunchOptions;

public final class avp
    implements android.os.Parcelable.Creator
{

    public avp()
    {
    }

    public static void a(LaunchOptions launchoptions, Parcel parcel)
    {
        int i = a.g(parcel, 20293);
        a.c(parcel, 1, launchoptions.a);
        a.a(parcel, 2, launchoptions.b);
        a.a(parcel, 3, launchoptions.c, false);
        a.h(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        boolean flag = false;
        int j = a.a(parcel);
        String s = null;
        int i = 0;
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
                    flag = a.c(parcel, k);
                    break;

                case 3: // '\003'
                    s = a.e(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new l((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new LaunchOptions(i, flag, s);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new LaunchOptions[i];
    }
}
