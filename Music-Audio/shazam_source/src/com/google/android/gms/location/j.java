// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.location:
//            GestureRequest

public final class j
    implements android.os.Parcelable.Creator
{

    public j()
    {
    }

    public static GestureRequest a(Parcel parcel)
    {
        int l = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        ArrayList arraylist = null;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int k = parcel.readInt();
                switch (0xffff & k)
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    int i1 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, k);
                    int j1 = parcel.dataPosition();
                    if (i1 == 0)
                    {
                        arraylist = null;
                    } else
                    {
                        arraylist = new ArrayList();
                        int k1 = parcel.readInt();
                        for (k = 0; k < k1; k++)
                        {
                            arraylist.add(Integer.valueOf(parcel.readInt()));
                        }

                        parcel.setDataPosition(j1 + i1);
                    }
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
            } else
            {
                return new GestureRequest(i, arraylist);
            }
        } while (true);
    }

    static void a(GestureRequest gesturerequest, Parcel parcel)
    {
        int k = b.a(parcel, 20293);
        List list = gesturerequest.b;
        if (list != null)
        {
            int l = b.a(parcel, 1);
            int i1 = list.size();
            parcel.writeInt(i1);
            for (int i = 0; i < i1; i++)
            {
                parcel.writeInt(((Integer)list.get(i)).intValue());
            }

            b.b(parcel, l);
        }
        b.b(parcel, 1000, gesturerequest.a);
        b.b(parcel, k);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new GestureRequest[i];
    }
}
