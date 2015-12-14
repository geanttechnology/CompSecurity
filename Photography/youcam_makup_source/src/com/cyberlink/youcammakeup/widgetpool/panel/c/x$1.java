// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.os.Handler;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.camera.CameraCtrl;
import com.cyberlink.youcammakeup.kernelctrl.LiveDemoConfigHelper;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            x, r, u

class c
    implements Runnable
{

    int a;
    int b;
    int c;
    final Handler d;
    final x e;

    public void run()
    {
        if (c == 0)
        {
            int i = c;
            int j = a % b;
            a = a + 1;
            Runnable runnable = new Runnable(i, j) {

                final int a;
                final int b;
                final x._cls1 c;

                public void run()
                {
                    x.b(c.e).a(LiveDemoConfigHelper.h().i());
                    x.b(c.e).b(a);
                    String s = x.a(c.e).c(b);
                    x.b(c.e).b(s);
                }

            
            {
                c = x._cls1.this;
                a = i;
                b = j;
                super();
            }
            };
            x.a(e, x.a(e).b(j).g());
            Globals.d(runnable);
            c = c + 1;
        } else
        {
            Globals.d(new Runnable(c) {

                final int a;
                final x._cls1 b;

                public void run()
                {
                    x.b(b.e).a(LiveDemoConfigHelper.h().i());
                    x.b(b.e).b(a);
                }

            
            {
                b = x._cls1.this;
                a = i;
                super();
            }
            });
            c = c + 1;
        }
        c = c % LiveDemoConfigHelper.h().i();
        d.postDelayed(this, 1000L);
    }

    _cls2.a(x x1, Handler handler)
    {
        e = x1;
        d = handler;
        super();
        a = 0;
        b = x.a(e).getCount();
        c = 0;
    }
}
