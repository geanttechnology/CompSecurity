// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;

// Referenced classes of package com.a.b:
//            at, ba, av, h

final class as
{

    final HandlerThread a = new HandlerThread("Picasso-Stats", 10);
    final h b;
    final Handler c;
    long d;
    long e;
    long f;
    long g;
    long h;
    long i;
    int j;
    int k;

    as(h h1)
    {
        b = h1;
        a.start();
        c = new at(a.getLooper(), this);
    }

    final void a()
    {
        c.sendEmptyMessage(0);
    }

    final void a(Bitmap bitmap, int l)
    {
        int i1 = ba.a(bitmap);
        c.sendMessage(c.obtainMessage(l, i1, 0));
    }

    final av b()
    {
        this;
        JVM INSTR monitorenter ;
        av av1 = new av(b.b(), b.a(), d, e, f, g, h, i, j, k, System.currentTimeMillis());
        this;
        JVM INSTR monitorexit ;
        return av1;
        Exception exception;
        exception;
        throw exception;
    }
}
