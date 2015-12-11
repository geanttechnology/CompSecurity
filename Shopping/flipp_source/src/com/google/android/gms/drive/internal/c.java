// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.drive.internal:
//            CreateContentsRequest

public final class c
    implements android.os.Parcelable.Creator
{

    public c()
    {
    }

    static void a(CreateContentsRequest createcontentsrequest, Parcel parcel)
    {
        int i = com.google.android.gms.common.internal.safeparcel.c.a(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, 1, createcontentsrequest.a);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int i = 0;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = parcel.readInt();
                switch (0xffff & k)
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new CreateContentsRequest(i);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new CreateContentsRequest[i];
    }
}
