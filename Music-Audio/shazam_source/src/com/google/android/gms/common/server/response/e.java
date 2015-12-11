// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.common.server.response:
//            FieldMappingDictionary, SafeParcelResponse

public final class e
    implements android.os.Parcelable.Creator
{

    public e()
    {
    }

    public static SafeParcelResponse a(Parcel parcel)
    {
        FieldMappingDictionary fieldmappingdictionary = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int i = 0;
        Parcel parcel1 = null;
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

                case 2: // '\002'
                    parcel1 = com.google.android.gms.common.internal.safeparcel.a.s(parcel, k);
                    break;

                case 3: // '\003'
                    fieldmappingdictionary = (FieldMappingDictionary)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, FieldMappingDictionary.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new SafeParcelResponse(i, parcel1, fieldmappingdictionary);
            }
        } while (true);
    }

    static void a(SafeParcelResponse safeparcelresponse, Parcel parcel, int i)
    {
        int j;
        j = b.a(parcel, 20293);
        b.b(parcel, 1, safeparcelresponse.a);
        Parcel parcel1 = safeparcelresponse.a();
        if (parcel1 != null)
        {
            int k = b.a(parcel, 2);
            parcel.appendFrom(parcel1, 0, parcel1.dataSize());
            b.b(parcel, k);
        }
        safeparcelresponse.b;
        JVM INSTR tableswitch 0 2: default 80
    //                   0 107
    //                   1 124
    //                   2 132;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalStateException((new StringBuilder("Invalid creation type: ")).append(safeparcelresponse.b).toString());
_L2:
        safeparcelresponse = null;
_L6:
        b.a(parcel, 3, safeparcelresponse, i, false);
        b.b(parcel, j);
        return;
_L3:
        safeparcelresponse = safeparcelresponse.c;
        continue; /* Loop/switch isn't completed */
_L4:
        safeparcelresponse = safeparcelresponse.c;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new SafeParcelResponse[i];
    }
}
