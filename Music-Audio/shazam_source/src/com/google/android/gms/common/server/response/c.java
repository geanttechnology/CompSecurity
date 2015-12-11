// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.server.response:
//            FieldMappingDictionary

public final class c
    implements android.os.Parcelable.Creator
{

    public c()
    {
    }

    static void a(FieldMappingDictionary fieldmappingdictionary, Parcel parcel)
    {
        int i = b.a(parcel, 20293);
        b.b(parcel, 1, fieldmappingdictionary.a);
        ArrayList arraylist = new ArrayList();
        String s;
        for (Iterator iterator = fieldmappingdictionary.b.keySet().iterator(); iterator.hasNext(); arraylist.add(new FieldMappingDictionary.Entry(s, (Map)fieldmappingdictionary.b.get(s))))
        {
            s = (String)iterator.next();
        }

        b.a(parcel, 2, arraylist, false);
        b.a(parcel, 3, fieldmappingdictionary.c, false);
        b.b(parcel, i);
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
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.c(parcel, k, FieldMappingDictionary.Entry.CREATOR);
                    break;

                case 3: // '\003'
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new FieldMappingDictionary(i, arraylist, s);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new FieldMappingDictionary[i];
    }
}
