// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            ep

public final class hh
    implements android.os.Parcelable.Creator
{

    public hh()
    {
    }

    static void a(ep ep1, Parcel parcel)
    {
        int i = c.a(parcel, 20293);
        c.b(parcel, 1, ep1.a);
        ArrayList arraylist = new ArrayList();
        String s;
        for (Iterator iterator = ep1.b.keySet().iterator(); iterator.hasNext(); arraylist.add(new ep.a(s, ((Integer)ep1.b.get(s)).intValue())))
        {
            s = (String)iterator.next();
        }

        c.b(parcel, 2, arraylist, false);
        c.b(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int i = 0;
        ArrayList arraylist = null;
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
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.c(parcel, k, ep.a.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new ep(i, arraylist);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new ep[i];
    }
}
