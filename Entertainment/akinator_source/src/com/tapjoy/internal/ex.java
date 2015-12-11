// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            es

final class ex extends Thread
{

    private Runnable a;

    public ex(Runnable runnable)
    {
        a = null;
        a = runnable;
    }

    public final es a()
    {
        if (a instanceof es)
        {
            return (es)a;
        } else
        {
            return null;
        }
    }

    public final void interrupt()
    {
        if (a instanceof es)
        {
            ((es)a).c();
        }
        super.interrupt();
    }

    public final void run()
    {
        a.run();
    }
}
