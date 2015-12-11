// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.views;


// Referenced classes of package com.offerup.android.views:
//            f

final class h
    implements f
{

    private int a[];

    private h()
    {
    }

    h(byte byte0)
    {
        this();
    }

    public final int a(int i)
    {
        return a[i % a.length];
    }

    final transient void a(int ai[])
    {
        a = ai;
    }
}
