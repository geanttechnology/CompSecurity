// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;


// Referenced classes of package com.google.android.gms.analytics.internal:
//            n, x

public final class b
    implements Runnable
{

    final String a;
    final Runnable b;
    final n c;

    public final void run()
    {
        c.a.a(a);
        if (b != null)
        {
            b.run();
        }
    }

    public (n n1, String s, Runnable runnable)
    {
        c = n1;
        a = s;
        b = runnable;
        super();
    }
}
