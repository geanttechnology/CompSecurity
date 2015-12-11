// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            cn

public abstract class cm
{

    private final Runnable ep = new Runnable() {

        final cm iy;

        public final void run()
        {
            cm.a(iy, Thread.currentThread());
            iy.ai();
        }

            
            {
                iy = cm.this;
                super();
            }
    };
    private volatile Thread ix;

    public cm()
    {
    }

    static Thread a(cm cm1, Thread thread)
    {
        cm1.ix = thread;
        return thread;
    }

    public abstract void ai();

    public final void cancel()
    {
        onStop();
        if (ix != null)
        {
            ix.interrupt();
        }
    }

    public abstract void onStop();

    public final void start()
    {
        cn.execute(ep);
    }
}
