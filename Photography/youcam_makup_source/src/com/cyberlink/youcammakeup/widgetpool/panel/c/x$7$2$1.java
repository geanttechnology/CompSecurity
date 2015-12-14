// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.app.Activity;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.j;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.common.e;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            x

class a
    implements android.view.lickListener
{

    final a a;

    public void onClick(View view)
    {
        com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(a.a.a).a(a.a.a, a.a.a, a.a.a.getId());
    }

    ask.bn(ask.bn bn)
    {
        a = bn;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/c/x$7

/* anonymous class */
    class x._cls7
        implements j
    {

        final int a;
        final e b;
        final Activity c;
        final x d;

        public void a(a a1)
        {
            int i = Math.min(100, af.a(a1));
            if (a == ((Integer)b.getTag()).intValue())
            {
                c.runOnUiThread(new x._cls7._cls3(i));
            }
        }

        public void a(bn bn1)
        {
            if (a == ((Integer)b.getTag()).intValue())
            {
                c.runOnUiThread(new x._cls7._cls2(this));
            }
        }

        public volatile void a(Object obj)
        {
            a((Void)obj);
        }

        public void a(Void void1)
        {
            if (a == ((Integer)b.getTag()).intValue())
            {
                c.runOnUiThread(new x._cls7._cls1());
            }
        }

        public void b(Object obj)
        {
            a((bn)obj);
        }

        public void b(Void void1)
        {
        }

        public void c(Object obj)
        {
            b((Void)obj);
        }

        public void d(Object obj)
        {
            a((a)obj);
        }

            
            {
                d = x1;
                a = i;
                b = e1;
                c = activity;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/c/x$7$1

/* anonymous class */
        class x._cls7._cls1
            implements Runnable
        {

            final x._cls7 a;

            public void run()
            {
                a.b.a(true, true);
                com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a.d, a.a, false);
            }

                    
                    {
                        a = x._cls7.this;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/c/x$7$3

/* anonymous class */
        class x._cls7._cls3
            implements Runnable
        {

            final int a;
            final x._cls7 b;

            public void run()
            {
                b.b.setProgress(a);
            }

                    
                    {
                        b = x._cls7.this;
                        a = i;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/c/x$7$2

/* anonymous class */
    class x._cls7._cls2
        implements Runnable
    {

        final x._cls7 a;

        public void run()
        {
            a.b.a(true, false);
            String s = a.c.getString(0x7f070534);
            Globals.d().i().a(a.c, null, new x._cls7._cls2._cls1(this), null, s);
        }

            
            {
                a = _pcls7;
                super();
            }
    }

}
