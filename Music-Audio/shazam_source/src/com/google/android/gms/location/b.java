// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;

// Referenced classes of package com.google.android.gms.location:
//            DetectedActivity

public final class b
    implements android.os.Parcelable.Creator
{

    public b()
    {
    }

    static void a(DetectedActivity detectedactivity, Parcel parcel)
    {
        int i = com.google.android.gms.common.internal.safeparcel.b.a(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 1, detectedactivity.c);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 1000, detectedactivity.b);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 2, detectedactivity.d);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int k = 0;
        int l = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int j = 0;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = parcel.readInt();
                switch (0xffff & i1)
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, i1);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;

                case 2: // '\002'
                    k = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
            } else
            {
                return new DetectedActivity(i, j, k);
            }
        } while (true);
    }

    public final volatile Object[] newArray(int i)
    {
        return new DetectedActivity[i];
    }
}
