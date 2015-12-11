// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            hl, gt, gm, kr

public abstract class gs
{

    public gs()
    {
    }

    public static gs a(gm gm, byte abyte0[])
    {
        int i = abyte0.length;
        if (abyte0 == null)
        {
            throw new NullPointerException("content == null");
        } else
        {
            hl.a(abyte0.length, 0L, i);
            return new gt(gm, i, abyte0, 0);
        }
    }

    public abstract gm a();

    public abstract void a(kr kr);

    public long b()
    {
        return -1L;
    }
}
