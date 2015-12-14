// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.app.Activity;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.j;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.utility.as;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.LooksGridItem;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            MakeupLooksBottomToolbar

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        a.a.a(Boolean.valueOf(true));
        a.a.a(true, true);
        MakeupLooksBottomToolbar.c(a.a, a.a.intValue());
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/MakeupLooksBottomToolbar$2

/* anonymous class */
    class MakeupLooksBottomToolbar._cls2
        implements j
    {

        final Activity a;
        final as b;
        final LooksGridItem c;
        final Integer d;
        final MakeupLooksBottomToolbar e;

        public void a(a a1)
        {
            int i = Math.min(100, af.a(a1));
            a.runOnUiThread(new MakeupLooksBottomToolbar._cls2._cls3(i));
        }

        public void a(bn bn1)
        {
            if (d == (Integer)c.getTag())
            {
                a.runOnUiThread(new MakeupLooksBottomToolbar._cls2._cls2());
            }
        }

        public volatile void a(Object obj)
        {
            a((Void)obj);
        }

        public void a(Void void1)
        {
            a.runOnUiThread(new MakeupLooksBottomToolbar._cls2._cls1(this));
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
                e = makeuplooksbottomtoolbar;
                a = activity;
                b = as1;
                c = looksgriditem;
                d = integer;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/MakeupLooksBottomToolbar$2$2

/* anonymous class */
        class MakeupLooksBottomToolbar._cls2._cls2
            implements Runnable
        {

            final MakeupLooksBottomToolbar._cls2 a;

            public void run()
            {
                a.c.a(true, false);
                String s = a.a.getString(0x7f070534);
                Globals.d().i().a(a.a, null, new MakeupLooksBottomToolbar._cls2._cls2._cls1(this), null, s);
            }

                    
                    {
                        a = MakeupLooksBottomToolbar._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/MakeupLooksBottomToolbar$2$2$1

/* anonymous class */
        class MakeupLooksBottomToolbar._cls2._cls2._cls1
            implements android.view.View.OnClickListener
        {

            final MakeupLooksBottomToolbar._cls2._cls2 a;

            public void onClick(View view)
            {
                MakeupLooksBottomToolbar.c(a.a.e).a(a.a.c, a.a.d.intValue(), a.a.c.getId());
            }

                    
                    {
                        a = _pcls2;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/MakeupLooksBottomToolbar$2$3

/* anonymous class */
        class MakeupLooksBottomToolbar._cls2._cls3
            implements Runnable
        {

            final int a;
            final MakeupLooksBottomToolbar._cls2 b;

            public void run()
            {
                b.c.setProgress(a);
            }

                    
                    {
                        b = MakeupLooksBottomToolbar._cls2.this;
                        a = i;
                        super();
                    }
        }

    }

}
