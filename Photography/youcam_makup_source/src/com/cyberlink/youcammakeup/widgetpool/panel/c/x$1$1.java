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

class b
    implements Runnable
{

    final int a;
    final int b;
    final c c;

    public void run()
    {
        x.b(c.c).a(LiveDemoConfigHelper.h().i());
        x.b(c.c).b(a);
        String s = x.a(c.c).c(b);
        x.b(c.c).b(s);
    }

    ount(ount ount, int i, int j)
    {
        c = ount;
        a = i;
        b = j;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/c/x$1

/* anonymous class */
    class x._cls1
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
                x._cls1._cls1 _lcls1 = new x._cls1._cls1(this, i, j);
                x.a(e, x.a(e).b(j).g());
                Globals.d(_lcls1);
                c = c + 1;
            } else
            {
                Globals.d(new x._cls1._cls2(c));
                c = c + 1;
            }
            c = c % LiveDemoConfigHelper.h().i();
            d.postDelayed(this, 1000L);
        }

            
            {
                e = x1;
                d = handler;
                super();
                a = 0;
                b = x.a(e).getCount();
                c = 0;
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/c/x$1$2

/* anonymous class */
        class x._cls1._cls2
            implements Runnable
        {

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
        }

    }

}
