// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

// Referenced classes of package com.google.android.gms.internal:
//            ey, ev

public final class hp
    implements android.os.Parcelable.Creator
{

    public hp()
    {
    }

    static void a(ey ey1, Parcel parcel, int i)
    {
        int j;
        j = c.a(parcel, 20293);
        c.b(parcel, 1, ey1.a);
        Parcel parcel1 = ey1.a();
        if (parcel1 != null)
        {
            int k = c.a(parcel, 2);
            parcel.appendFrom(parcel1, 0, parcel1.dataSize());
            c.b(parcel, k);
        }
        ey1.b;
        JVM INSTR tableswitch 0 2: default 80
    //                   0 107
    //                   1 124
    //                   2 132;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalStateException((new StringBuilder("Invalid creation type: ")).append(ey1.b).toString());
_L2:
        ey1 = null;
_L6:
        c.a(parcel, 3, ey1, i, false);
        c.b(parcel, j);
        return;
_L3:
        ey1 = ey1.c;
        continue; /* Loop/switch isn't completed */
_L4:
        ey1 = ey1.c;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final Object createFromParcel(Parcel parcel)
    {
        ev ev1 = null;
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
                    ev1 = (ev)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, ev.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new ey(i, parcel1, ev1);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new ey[i];
    }
}
