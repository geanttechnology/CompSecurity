// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;

// Referenced classes of package com.google.android.gms.playlog.internal:
//            PlayLoggerContext

public class b
    implements android.os.Parcelable.Creator
{

    public b()
    {
    }

    static void a(PlayLoggerContext playloggercontext, Parcel parcel, int i)
    {
        i = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, playloggercontext.a);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, playloggercontext.b, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, playloggercontext.c);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, playloggercontext.d);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, playloggercontext.e, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, playloggercontext.f, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, playloggercontext.g);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, playloggercontext.h, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, playloggercontext.i);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, i);
    }

    public PlayLoggerContext a(Parcel parcel)
    {
        String s = null;
        boolean flag = false;
        int l = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        boolean flag1 = true;
        String s1 = null;
        String s2 = null;
        int i = 0;
        int j = 0;
        String s3 = null;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.a(i1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, i1);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.a.f(parcel, i1);
                    break;

                case 2: // '\002'
                    s3 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i1);
                    break;

                case 3: // '\003'
                    j = com.google.android.gms.common.internal.safeparcel.a.f(parcel, i1);
                    break;

                case 4: // '\004'
                    i = com.google.android.gms.common.internal.safeparcel.a.f(parcel, i1);
                    break;

                case 5: // '\005'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i1);
                    break;

                case 6: // '\006'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i1);
                    break;

                case 7: // '\007'
                    flag1 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, i1);
                    break;

                case 8: // '\b'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i1);
                    break;

                case 9: // '\t'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new PlayLoggerContext(k, s3, j, i, s2, s1, flag1, s, flag);
            }
        } while (true);
    }

    public PlayLoggerContext[] a(int i)
    {
        return new PlayLoggerContext[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }
}
