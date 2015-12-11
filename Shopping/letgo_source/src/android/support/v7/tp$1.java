// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;

// Referenced classes of package android.support.v7:
//            tp

class a
    implements Runnable
{

    final Context a;
    final tp b;

    public void run()
    {
        synchronized (tp.a(b))
        {
            tp.a(b, b.c(a));
            tp.a(b).notifyAll();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    (tp tp1, Context context)
    {
        b = tp1;
        a = context;
        super();
    }
}
