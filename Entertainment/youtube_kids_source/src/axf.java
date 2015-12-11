// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

public final class axf
    implements android.os.Parcelable.Creator
{

    public axf()
    {
    }

    public static void a(com.google.android.gms.common.internal.ClientSettings.ParcelableClientSettings parcelableclientsettings, Parcel parcel)
    {
        int i = a.g(parcel, 20293);
        a.a(parcel, 1, parcelableclientsettings.b, false);
        a.c(parcel, 1000, parcelableclientsettings.a);
        a.a(parcel, 2, parcelableclientsettings.a(), false);
        a.c(parcel, 3, parcelableclientsettings.c);
        a.a(parcel, 4, parcelableclientsettings.d, false);
        a.h(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int i = 0;
        String s = null;
        int k = a.a(parcel);
        java.util.ArrayList arraylist = null;
        String s1 = null;
        int j = 0;
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
                    s1 = a.e(parcel, i1);
                    break;

                case 1000: 
                    j = a.d(parcel, i1);
                    break;

                case 2: // '\002'
                    arraylist = a.f(parcel, i1);
                    break;

                case 3: // '\003'
                    i = a.d(parcel, i1);
                    break;

                case 4: // '\004'
                    s = a.e(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new l((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new com.google.android.gms.common.internal.ClientSettings.ParcelableClientSettings(j, s1, arraylist, i, s);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new com.google.android.gms.common.internal.ClientSettings.ParcelableClientSettings[i];
    }
}
