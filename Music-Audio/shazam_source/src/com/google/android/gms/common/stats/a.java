// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.stats;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.common.stats:
//            ConnectionEvent

public final class a
    implements android.os.Parcelable.Creator
{

    public a()
    {
    }

    static void a(ConnectionEvent connectionevent, Parcel parcel)
    {
        int i = b.a(parcel, 20293);
        b.b(parcel, 1, connectionevent.a);
        b.a(parcel, 2, connectionevent.b);
        b.a(parcel, 4, connectionevent.d, false);
        b.a(parcel, 5, connectionevent.e, false);
        b.a(parcel, 6, connectionevent.f, false);
        b.a(parcel, 7, connectionevent.g, false);
        b.a(parcel, 8, connectionevent.h, false);
        b.a(parcel, 10, connectionevent.j);
        b.a(parcel, 11, connectionevent.k);
        b.b(parcel, 12, connectionevent.c);
        b.a(parcel, 13, connectionevent.i, false);
        b.b(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int k = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int j = 0;
        long l3 = 0L;
        int i = 0;
        String s5 = null;
        String s4 = null;
        String s3 = null;
        String s2 = null;
        String s1 = null;
        String s = null;
        long l2 = 0L;
        long l1 = 0L;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = parcel.readInt();
                switch (0xffff & l)
                {
                case 3: // '\003'
                case 9: // '\t'
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, l);
                    break;

                case 2: // '\002'
                    l3 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, l);
                    break;

                case 4: // '\004'
                    s5 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    break;

                case 5: // '\005'
                    s4 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    break;

                case 6: // '\006'
                    s3 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    break;

                case 7: // '\007'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    break;

                case 8: // '\b'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    break;

                case 10: // '\n'
                    l2 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, l);
                    break;

                case 11: // '\013'
                    l1 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, l);
                    break;

                case 12: // '\f'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, l);
                    break;

                case 13: // '\r'
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new ConnectionEvent(j, l3, i, s5, s4, s3, s2, s1, s, l2, l1);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new ConnectionEvent[i];
    }
}
