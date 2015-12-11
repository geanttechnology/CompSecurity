// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

// Referenced classes of package com.google.android.gms.internal:
//            en, ep

public final class hg
    implements android.os.Parcelable.Creator
{

    public hg()
    {
    }

    static void a(en en1, Parcel parcel, int i)
    {
        int j = c.a(parcel, 20293);
        c.b(parcel, 1, en1.a);
        c.a(parcel, 2, en1.b, i, false);
        c.b(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int i = 0;
        ep ep1 = null;
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
                    ep1 = (ep)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, ep.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new en(i, ep1);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new en[i];
    }
}
