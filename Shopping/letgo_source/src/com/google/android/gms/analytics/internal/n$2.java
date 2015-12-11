// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;


// Referenced classes of package com.google.android.gms.analytics.internal:
//            n, x

class b
    implements Runnable
{

    final String a;
    final Runnable b;
    final n c;

    public void run()
    {
        n.a(c).a(a);
        if (b != null)
        {
            b.run();
        }
    }

    (n n1, String s, Runnable runnable)
    {
        c = n1;
        a = s;
        b = runnable;
        super();
    }
}
