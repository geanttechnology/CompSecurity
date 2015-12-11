// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.internal.il;

public final class azp
    implements android.os.Parcelable.Creator
{

    public azp()
    {
    }

    public static void a(il il1, Parcel parcel, int i)
    {
        int j = a.g(parcel, 20293);
        a.c(parcel, 1, il1.a);
        double d = il1.b;
        a.b(parcel, 2, 8);
        parcel.writeDouble(d);
        a.a(parcel, 3, il1.c);
        a.c(parcel, 4, il1.d);
        a.a(parcel, 5, il1.e, i, false);
        a.c(parcel, 6, il1.f);
        a.h(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int i = 0;
        int i1 = a.a(parcel);
        double d = 0.0D;
        ApplicationMetadata applicationmetadata = null;
        int j = 0;
        boolean flag = false;
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
                    d = parcel.readDouble();
                    break;

                case 3: // '\003'
                    flag = a.c(parcel, j1);
                    break;

                case 4: // '\004'
                    j = a.d(parcel, j1);
                    break;

                case 5: // '\005'
                    applicationmetadata = (ApplicationMetadata)a.a(parcel, j1, ApplicationMetadata.CREATOR);
                    break;

                case 6: // '\006'
                    i = a.d(parcel, j1);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new l((new StringBuilder("Overread allowed size end=")).append(i1).toString(), parcel);
            } else
            {
                return new il(k, d, flag, j, applicationmetadata, i);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new il[i];
    }
}
