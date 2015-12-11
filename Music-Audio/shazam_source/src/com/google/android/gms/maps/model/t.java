// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.a.i;

// Referenced classes of package com.google.android.gms.maps.model:
//            TileOverlayOptions

public final class t
    implements android.os.Parcelable.Creator
{

    public t()
    {
    }

    public static TileOverlayOptions a(Parcel parcel)
    {
        boolean flag1 = false;
        int k = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        android.os.IBinder ibinder = null;
        float f = 0.0F;
        boolean flag = true;
        int j = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = parcel.readInt();
                switch (0xffff & l)
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, l);
                    break;

                case 2: // '\002'
                    ibinder = com.google.android.gms.common.internal.safeparcel.a.l(parcel, l);
                    break;

                case 3: // '\003'
                    flag1 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l);
                    break;

                case 4: // '\004'
                    f = com.google.android.gms.common.internal.safeparcel.a.h(parcel, l);
                    break;

                case 5: // '\005'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new TileOverlayOptions(j, ibinder, flag1, f, flag);
            }
        } while (true);
    }

    static void a(TileOverlayOptions tileoverlayoptions, Parcel parcel)
    {
        int j = b.a(parcel, 20293);
        b.b(parcel, 1, tileoverlayoptions.a);
        b.a(parcel, 2, tileoverlayoptions.b.asBinder());
        b.a(parcel, 3, tileoverlayoptions.c);
        b.a(parcel, 4, tileoverlayoptions.d);
        b.a(parcel, 5, tileoverlayoptions.e);
        b.b(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int j)
    {
        return new TileOverlayOptions[j];
    }
}
