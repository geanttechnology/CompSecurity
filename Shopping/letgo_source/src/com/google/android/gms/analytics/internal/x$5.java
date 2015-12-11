// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;


// Referenced classes of package com.google.android.gms.analytics.internal:
//            x, ai

class b
    implements Runnable
{

    final ai a;
    final long b;
    final x c;

    public void run()
    {
        c.a(a, b);
    }

    (x x1, ai ai, long l)
    {
        c = x1;
        a = ai;
        b = l;
        super();
    }
}
