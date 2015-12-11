// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.c;

import android.os.Handler;
import android.os.SystemClock;

// Referenced classes of package com.facebook.c:
//            g, a, b

private static final class a extends g
{

    final Handler a;
    final Runnable b = new Runnable() {

        final a.b a;

        public final void run()
        {
            if (!a.c || a.e == null)
            {
                return;
            } else
            {
                long l = SystemClock.uptimeMillis();
                a.e.a(l - a.d);
                a.a.post(a.b);
                return;
            }
        }

            
            {
                a = a.b.this;
                super();
            }
    };
    boolean c;
    long d;

    public final void a()
    {
        if (c)
        {
            return;
        } else
        {
            c = true;
            d = SystemClock.uptimeMillis();
            a.removeCallbacks(b);
            a.post(b);
            return;
        }
    }

    public final void b()
    {
        c = false;
        a.removeCallbacks(b);
    }

    public nit>(Handler handler)
    {
        a = handler;
    }
}
