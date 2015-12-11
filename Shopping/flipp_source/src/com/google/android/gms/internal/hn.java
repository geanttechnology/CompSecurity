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
//            ev

public final class hn
    implements android.os.Parcelable.Creator
{

    public hn()
    {
    }

    static void a(ev ev1, Parcel parcel)
    {
        int i = c.a(parcel, 20293);
        c.b(parcel, 1, ev1.a);
        ArrayList arraylist = new ArrayList();
        String s;
        for (Iterator iterator = ev1.b.keySet().iterator(); iterator.hasNext(); arraylist.add(new ev.a(s, (HashMap)ev1.b.get(s))))
        {
            s = (String)iterator.next();
        }

        c.b(parcel, 2, arraylist, false);
        c.a(parcel, 3, ev1.c, false);
        c.b(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        String s = null;
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
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.c(parcel, k, ev.a.CREATOR);
                    break;

                case 3: // '\003'
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new ev(i, arraylist, s);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new ev[i];
    }
}
