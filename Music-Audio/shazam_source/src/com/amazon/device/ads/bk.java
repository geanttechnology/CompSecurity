// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.graphics.Rect;

// Referenced classes of package com.amazon.device.ads:
//            p, bj, o, c

final class bk extends p
{

    final bj a;

    public bk(bj bj)
    {
        super(bj);
        a = bj;
    }

    protected final volatile o a()
    {
        return a;
    }

    public final void a(c c, Rect rect)
    {
        a(new Runnable(c, rect) {

            final c a;
            final Rect b;
            final bk c;

            public final void run()
            {
                c.a.e();
            }

            
            {
                c = bk.this;
                a = c1;
                b = rect;
                super();
            }
        });
    }

    public final void d(c c)
    {
        a(new Runnable(c) {

            final c a;
            final bk b;

            public final void run()
            {
                b.a.f();
            }

            
            {
                b = bk.this;
                a = c;
                super();
            }
        });
    }
}
