// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;


// Referenced classes of package com.google.android.gms.d:
//            gl

public abstract class gi
{

    public final Runnable i = new Runnable() {

        final gi a;

        public final void run()
        {
            a.j = Thread.currentThread();
            a.a();
        }

            
            {
                a = gi.this;
                super();
            }
    };
    volatile Thread j;

    public gi()
    {
    }

    public abstract void a();

    public abstract void b();

    public final void e()
    {
        gl.a(1, i);
    }

    public final void f()
    {
        b();
        if (j != null)
        {
            j.interrupt();
        }
    }
}
