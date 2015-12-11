// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.images.WebImage;
import java.util.Collections;

public final class avo
    implements android.os.Parcelable.Creator
{

    public avo()
    {
    }

    public static void a(CastDevice castdevice, Parcel parcel)
    {
        int i = a.g(parcel, 20293);
        a.c(parcel, 1, castdevice.a);
        a.a(parcel, 2, castdevice.b, false);
        a.a(parcel, 3, castdevice.c, false);
        a.a(parcel, 4, castdevice.d, false);
        a.a(parcel, 5, castdevice.e, false);
        a.a(parcel, 6, castdevice.f, false);
        a.c(parcel, 7, castdevice.g);
        a.b(parcel, 8, Collections.unmodifiableList(castdevice.h), false);
        a.c(parcel, 9, castdevice.i);
        a.c(parcel, 10, castdevice.j);
        a.h(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int i = 0;
        java.util.ArrayList arraylist = null;
        int j1 = a.a(parcel);
        int j = 0;
        int k = 0;
        String s = null;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        int i1 = 0;
        do
        {
            if (parcel.dataPosition() < j1)
            {
                int k1 = parcel.readInt();
                switch (0xffff & k1)
                {
                default:
                    a.b(parcel, k1);
                    break;

                case 1: // '\001'
                    i1 = a.d(parcel, k1);
                    break;

                case 2: // '\002'
                    s4 = a.e(parcel, k1);
                    break;

                case 3: // '\003'
                    s3 = a.e(parcel, k1);
                    break;

                case 4: // '\004'
                    s2 = a.e(parcel, k1);
                    break;

                case 5: // '\005'
                    s1 = a.e(parcel, k1);
                    break;

                case 6: // '\006'
                    s = a.e(parcel, k1);
                    break;

                case 7: // '\007'
                    k = a.d(parcel, k1);
                    break;

                case 8: // '\b'
                    arraylist = a.b(parcel, k1, WebImage.CREATOR);
                    break;

                case 9: // '\t'
                    j = a.d(parcel, k1);
                    break;

                case 10: // '\n'
                    i = a.d(parcel, k1);
                    break;
                }
            } else
            if (parcel.dataPosition() != j1)
            {
                throw new l((new StringBuilder("Overread allowed size end=")).append(j1).toString(), parcel);
            } else
            {
                return new CastDevice(i1, s4, s3, s2, s1, s, k, arraylist, j, i);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new CastDevice[i];
    }
}
