// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.util.concurrent.BlockingQueue;

// Referenced classes of package com.google.android.gms.d:
//            ba, hx

final class a
    implements Runnable
{

    final hx a;
    final ba b;

    public final void run()
    {
        try
        {
            ba.a(b).put(a);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
    }

    (ba ba1, hx hx)
    {
        b = ba1;
        a = hx;
        super();
    }
}
