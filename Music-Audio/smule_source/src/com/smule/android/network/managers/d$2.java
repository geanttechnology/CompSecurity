// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;


// Referenced classes of package com.smule.android.network.managers:
//            d

class b
    implements Runnable
{

    final int a;
    final Runnable b;
    final d c;

    public void run()
    {
        d.a(c, a);
        if (b != null)
        {
            b.run();
        }
    }

    (d d1, int i, Runnable runnable)
    {
        c = d1;
        a = i;
        b = runnable;
        super();
    }
}
