// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.Parcel;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.a;

// Referenced classes of package com.google.android.gms.cast:
//            CastDevice

public class b
    implements android.os.Parcelable.Creator
{

    public b()
    {
    }

    static void a(CastDevice castdevice, Parcel parcel, int i)
    {
        i = com.google.android.gms.common.internal.safeparcel.b.o(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, castdevice.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, castdevice.getDeviceId(), false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, castdevice.kA, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, castdevice.getFriendlyName(), false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, castdevice.getModelName(), false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, castdevice.getDeviceVersion(), false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 7, castdevice.getServicePort());
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 8, castdevice.getIcons(), false);
        com.google.android.gms.common.internal.safeparcel.b.D(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return j(parcel);
    }

    public CastDevice j(Parcel parcel)
    {
        int i = 0;
        java.util.ArrayList arraylist = null;
        int l = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        String s5 = null;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(i1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, i1);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    break;

                case 2: // '\002'
                    s5 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i1);
                    break;

                case 3: // '\003'
                    s4 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i1);
                    break;

                case 4: // '\004'
                    s3 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i1);
                    break;

                case 5: // '\005'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i1);
                    break;

                case 6: // '\006'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i1);
                    break;

                case 7: // '\007'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    break;

                case 8: // '\b'
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.c(parcel, i1, WebImage.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new CastDevice(k, s5, s4, s3, s2, s1, i, arraylist);
            }
        } while (true);
    }

    public Object[] newArray(int i)
    {
        return s(i);
    }

    public CastDevice[] s(int i)
    {
        return new CastDevice[i];
    }
}
