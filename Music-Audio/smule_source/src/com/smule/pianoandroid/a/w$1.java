// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.a;

import android.os.Handler;

// Referenced classes of package com.smule.pianoandroid.a:
//            w

final class b
    implements Runnable
{

    final Runnable a;
    final Runnable b;

    public void run()
    {
        a.run();
        if (b != null)
        {
            w.b().post(b);
        }
    }

    (Runnable runnable, Runnable runnable1)
    {
        a = runnable;
        b = runnable1;
        super();
    }
}
