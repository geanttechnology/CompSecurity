// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.wallet:
//            LineItem

public class f
    implements android.os.Parcelable.Creator
{

    public f()
    {
    }

    static void a(LineItem lineitem, Parcel parcel, int i)
    {
        i = b.o(parcel);
        b.c(parcel, 1, lineitem.getVersionCode());
        b.a(parcel, 2, lineitem.description, false);
        b.a(parcel, 3, lineitem.Gw, false);
        b.a(parcel, 4, lineitem.Gx, false);
        b.a(parcel, 5, lineitem.Gj, false);
        b.c(parcel, 6, lineitem.Gy);
        b.a(parcel, 7, lineitem.Gk, false);
        b.D(parcel, i);
    }

    public LineItem aJ(Parcel parcel)
    {
        int i = 0;
        String s = null;
        int k = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        int j = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 2: // '\002'
                    s4 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 3: // '\003'
                    s3 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 4: // '\004'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 5: // '\005'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 6: // '\006'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 7: // '\007'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new LineItem(j, s4, s3, s2, s1, i, s);
            }
        } while (true);
    }

    public LineItem[] bB(int i)
    {
        return new LineItem[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return aJ(parcel);
    }

    public Object[] newArray(int i)
    {
        return bB(i);
    }
}
