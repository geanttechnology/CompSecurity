// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.a;

import android.os.Handler;
import android.widget.SeekBar;
import com.cyberlink.youcammakeup.clflurry.YMKApplyEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.n;
import com.cyberlink.youcammakeup.d;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.j;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.a;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.a:
//            a

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        a.a.e();
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/a/a$5

/* anonymous class */
    class a._cls5
        implements a
    {

        final long a;
        final Handler b;
        final com.cyberlink.youcammakeup.widgetpool.panel.a.a c;

        public void a(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskCancelType taskcanceltype, String s, Object obj)
        {
            b.post(new a._cls5._cls2());
        }

        public void a(com.cyberlink.youcammakeup.kernelctrl.viewengine.q q1, Object obj)
        {
            Object obj1;
            Object obj2;
            obj = StatusManager.j().f(a);
            obj1 = MotionControlHelper.e().M();
            List list = j.a().g();
            if (obj == null)
            {
                obj = new com.cyberlink.youcammakeup.kernelctrl.status.a(a, c.c.m.b, c.c.m.c, c.c.m.d, j.a(c.c.m.i), list, ((ar)list.get(c.c.m.j)).c.b(), ((ar)list.get(c.c.m.j)).c.c(), c.c.m.j, null, ((v) (obj1)), "");
            }
            obj2 = StatusManager.j().s();
            if (((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).f() == null)
            {
                obj1 = new i();
            } else
            {
                obj1 = new i(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).f().g());
            }
            if (obj1 == null) goto _L2; else goto _L1
_L1:
            if (obj2 != BeautyMode.o) goto _L4; else goto _L3
_L3:
            com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.r));
            ((i) (obj1)).a(com.cyberlink.youcammakeup.widgetpool.panel.a.a.h(c).getProgress());
            obj2 = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.p);
            ((YMKApplyEvent) (obj2)).g(String.valueOf(com.cyberlink.youcammakeup.widgetpool.panel.a.a.h(c).getProgress()));
            com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj2)).e());
_L6:
            ((i) (obj1)).a(false);
            StatusManager.j().a(((i) (obj1)));
_L2:
            obj2 = MotionControlHelper.e().M();
            ((v) (obj2)).a(((i) (obj1)));
            obj = new com.cyberlink.youcammakeup.kernelctrl.status.a(a, q1.a().b(), q1.a().c(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).d, j.a(c.c.m.i), list, ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).a(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).b(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).e, ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).c(), ((v) (obj2)), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).g());
            StatusManager.j().a(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)), q1.a(), new a._cls5._cls1());
            return;
_L4:
            if (obj2 == BeautyMode.p)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.q));
                ((i) (obj1)).b(com.cyberlink.youcammakeup.widgetpool.panel.a.a.h(c).getProgress());
                obj2 = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.o);
                ((YMKApplyEvent) (obj2)).g(String.valueOf(com.cyberlink.youcammakeup.widgetpool.panel.a.a.h(c).getProgress()));
                com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj2)).e());
            } else
            if (obj2 == BeautyMode.c)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.i));
                ((i) (obj1)).c(com.cyberlink.youcammakeup.widgetpool.panel.a.a.h(c).getProgress());
                obj2 = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.i);
                ((YMKApplyEvent) (obj2)).g(String.valueOf(com.cyberlink.youcammakeup.widgetpool.panel.a.a.h(c).getProgress()));
                com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj2)).e());
            } else
            if (obj2 == BeautyMode.d)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.b));
                ((i) (obj1)).d(com.cyberlink.youcammakeup.widgetpool.panel.a.a.h(c).getProgress());
                obj2 = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.b);
                ((YMKApplyEvent) (obj2)).g(String.valueOf(com.cyberlink.youcammakeup.widgetpool.panel.a.a.h(c).getProgress()));
                com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj2)).e());
            } else
            if (obj2 == BeautyMode.g)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.f));
                ((i) (obj1)).e(com.cyberlink.youcammakeup.widgetpool.panel.a.a.h(c).getProgress());
                obj2 = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.f);
                ((YMKApplyEvent) (obj2)).g(String.valueOf(com.cyberlink.youcammakeup.widgetpool.panel.a.a.h(c).getProgress()));
                com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj2)).e());
            } else
            if (obj2 == BeautyMode.u)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.u));
                ((i) (obj1)).h(com.cyberlink.youcammakeup.widgetpool.panel.a.a.h(c).getProgress());
                obj2 = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.r);
                ((YMKApplyEvent) (obj2)).g(String.valueOf(com.cyberlink.youcammakeup.widgetpool.panel.a.a.h(c).getProgress()));
                com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj2)).e());
            } else
            if (obj2 == BeautyMode.f)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.g));
                ((i) (obj1)).f(com.cyberlink.youcammakeup.widgetpool.panel.a.a.h(c).getProgress());
                obj2 = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.g);
                ((YMKApplyEvent) (obj2)).g(String.valueOf(com.cyberlink.youcammakeup.widgetpool.panel.a.a.h(c).getProgress()));
                com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj2)).e());
            } else
            if (obj2 == BeautyMode.h)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.e));
                ((i) (obj1)).g(com.cyberlink.youcammakeup.widgetpool.panel.a.a.h(c).getProgress());
                obj2 = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.e);
                ((YMKApplyEvent) (obj2)).g(String.valueOf(com.cyberlink.youcammakeup.widgetpool.panel.a.a.h(c).getProgress()));
                com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj2)).e());
            } else
            if (obj2 == BeautyMode.w)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.w));
                ((i) (obj1)).i(com.cyberlink.youcammakeup.widgetpool.panel.a.a.h(c).getProgress());
                YMKApplyEvent ymkapplyevent = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.u);
                ymkapplyevent.g(String.valueOf(com.cyberlink.youcammakeup.widgetpool.panel.a.a.h(c).getProgress()));
                com.cyberlink.youcammakeup.clflurry.b.a(ymkapplyevent.e());
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        public void a(String s, Object obj)
        {
            b.post(new a._cls5._cls3(this));
        }

            
            {
                c = a1;
                a = l;
                b = handler;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/a/a$5$1

/* anonymous class */
        class a._cls5._cls1
            implements d
        {

            final a._cls5 b;

            public void a()
            {
                b.c.e();
            }

            public void b()
            {
                b.c.e();
            }

            public void c()
            {
                b.c.e();
            }

                    
                    {
                        b = a._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/a/a$5$2

/* anonymous class */
        class a._cls5._cls2
            implements Runnable
        {

            final a._cls5 a;

            public void run()
            {
                a.c.e();
            }

                    
                    {
                        a = a._cls5.this;
                        super();
                    }
        }

    }

}
