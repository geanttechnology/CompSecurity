// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;


// Referenced classes of package com.google.android.gms.d:
//            iv, kq

public final class bz
    implements iv
{

    private int a;
    private int b;
    private final int c;
    private final float d;

    public bz()
    {
        this((byte)0);
    }

    private bz(byte byte0)
    {
        a = 2500;
        c = 1;
        d = 1.0F;
    }

    public final int a()
    {
        return a;
    }

    public final void a(kq kq)
    {
        b = b + 1;
        a = (int)((float)a + (float)a * d);
        boolean flag;
        if (b <= c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw kq;
        } else
        {
            return;
        }
    }

    public final int b()
    {
        return b;
    }
}
