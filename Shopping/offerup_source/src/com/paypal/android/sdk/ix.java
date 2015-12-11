// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            kv, iw, lj, kq

final class ix extends kv
{

    private iw a;

    ix(iw iw1, lj lj)
    {
        a = iw1;
        super(lj);
    }

    public final long a(kq kq, long l)
    {
        if (iw.a(a) != 0)
        {
            if ((l = super.a(kq, Math.min(l, iw.a(a)))) != -1L)
            {
                iw.a(a, (int)((long)iw.a(a) - l));
                return l;
            }
        }
        return -1L;
    }
}
