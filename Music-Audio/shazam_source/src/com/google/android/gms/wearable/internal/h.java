// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            GetAllCapabilitiesResponse, CapabilityInfoParcelable

public final class h
    implements android.os.Parcelable.Creator
{

    public h()
    {
    }

    static void a(GetAllCapabilitiesResponse getallcapabilitiesresponse, Parcel parcel)
    {
        int i = b.a(parcel, 20293);
        b.b(parcel, 1, getallcapabilitiesresponse.a);
        b.b(parcel, 2, getallcapabilitiesresponse.b);
        b.a(parcel, 3, getallcapabilitiesresponse.c, false);
        b.b(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int j = 0;
        int k = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        java.util.ArrayList arraylist = null;
        int i = 0;
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
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, l);
                    break;

                case 2: // '\002'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, l);
                    break;

                case 3: // '\003'
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l, CapabilityInfoParcelable.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new GetAllCapabilitiesResponse(i, j, arraylist);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new GetAllCapabilitiesResponse[i];
    }
}
